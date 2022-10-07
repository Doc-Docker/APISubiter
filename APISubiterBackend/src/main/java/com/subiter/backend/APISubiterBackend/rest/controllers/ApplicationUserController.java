package com.subiter.backend.APISubiterBackend.rest.controllers;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.subiter.backend.APISubiterBackend.model.entity.ApplicationUser;
import com.subiter.backend.APISubiterBackend.model.entity.Role;
import com.subiter.backend.APISubiterBackend.service.ApplicationUserService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class ApplicationUserController {
    
    @Autowired
    private ApplicationUserService applicationUserService;

    @GetMapping("/users")
    public ResponseEntity<List<ApplicationUser>> getApplicationUsers(){
        return ResponseEntity.ok().body(applicationUserService.getApplicationUsers());
    }
    @PostMapping("/user/save")
    public ResponseEntity<ApplicationUser> saveApplicationUser(@RequestBody ApplicationUser applicationUser){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/save").toUriString());
        return ResponseEntity.created(uri).body(applicationUserService.saveApplicationUser(applicationUser));
    }
    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(applicationUserService.saveRole(role));
    }
    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form){
        applicationUserService.addRoleToApplicationUser(form.getEmail(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
}
@Data
class RoleToUserForm{
    private String email;
    private String roleName;
}
