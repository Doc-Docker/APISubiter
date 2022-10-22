package com.subiter.backend.APISubiterBackend.rest.controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.subiter.backend.APISubiterBackend.model.dto.ApplicationUserDTO;
import com.subiter.backend.APISubiterBackend.model.entity.ApplicationUser;
import com.subiter.backend.APISubiterBackend.model.entity.Role;
import com.subiter.backend.APISubiterBackend.service.ApplicationUserService;
import com.subiter.backend.APISubiterBackend.service.UsuarioService;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.net.URI;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping()
@RequiredArgsConstructor
public class ApplicationUserController {

    @Autowired
    private ApplicationUserService applicationUserService;

    @PreAuthorize("hasAnyRole('ADMIN', 'CLIENT')")
    @GetMapping("/users")
    public ResponseEntity<List<ApplicationUserDTO>> getApplicationUsers(){
        return ResponseEntity.ok().body(applicationUserService.getApplicationUsers());
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'CLIENT')")
    @GetMapping("/users/{id}")
    public ResponseEntity<ApplicationUser> getApplicationUserById(@PathVariable Integer id){
        ApplicationUser applicationUser = applicationUserService.getApplicationUserById(id);
        return ResponseEntity.ok().body(applicationUser);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/auth/user/admin")
    public ResponseEntity<ApplicationUserDTO> saveApplicationUserAsAdmin(@RequestBody ApplicationUser applicationUser){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/auth/user/save").toUriString());
        applicationUserService.saveApplicationUserAsAdmin(applicationUser);
        return ResponseEntity.created(uri).build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteApplicationUserAdmin(@PathVariable Integer id){
        applicationUserService.delete(id);
        return ResponseEntity.noContent().build();
    }

    /*@PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(applicationUserService.saveRole(role));
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form){
        applicationUserService.addRoleToApplicationUser(form.getEmail(), form.getRoleName());
        return ResponseEntity.ok().build();
    }*/

    @GetMapping("/auth/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
            try {
                String refresh_token = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refresh_token);
                String email = decodedJWT.getSubject();
                ApplicationUser applicationUser = applicationUserService.getApplicationUser(email);
                String access_token = JWT.create()
                        .withSubject(applicationUser.getEmail())
                        .withExpiresAt(new Date(System.currentTimeMillis()+ 10 * 60 * 1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", Collections.singletonList(applicationUser.getRole().getName()))
                        .sign(algorithm);
                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", access_token);
                tokens.put("refresh_token", refresh_token);
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            }catch(Exception e){
                log.error("Error logging in: {}", e.getMessage());
                response.setHeader("error", e.getMessage());
                response.setStatus(FORBIDDEN.value());
                //response.sendError(FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("error_message", e.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        }else {
            throw new RuntimeException("Refresh token is missing!");
        }
    }

}

@Data
class RoleToUserForm{
    private String email;
    private String roleName;
}
