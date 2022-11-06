package com.subiter.backend.APISubiterBackend.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;
import com.subiter.backend.APISubiterBackend.config.View;
import com.subiter.backend.APISubiterBackend.model.dto.UsuarioDto;
import com.subiter.backend.APISubiterBackend.model.entity.Usuario;
import com.subiter.backend.APISubiterBackend.service.ApplicationUserService;
import com.subiter.backend.APISubiterBackend.service.UsuarioService;
import javax.validation.Valid;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ApplicationUserService applicationUserService;
    
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPORTE')")
    @JsonView(View.UsuarioView.class)
    @GetMapping
    public List<Usuario> getAllUsers(){

        return usuarioService.getAllUsers();
    }

    @PostMapping("/auth/signup/client")
    @ResponseStatus(HttpStatus.CREATED)
    @JsonView(View.UsuarioView.class)
    public ResponseEntity<Void> saveUserClient(@RequestBody @Valid UsuarioDto usuarioDto){

        Usuario usuario = new Usuario();

        usuario.setName(usuarioDto.getName());

        usuario.setEmpresa(usuarioDto.getEmpresa());

        usuario.setEmail(usuarioDto.getEmail());

        usuario = usuarioService.save(usuario);  

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}").buildAndExpand(usuario.getId()).toUri();
        
        applicationUserService.saveApplicationUserAsUsuario(usuario, usuarioDto.getPassword());

        return ResponseEntity.created(uri).build();
    }

    @PostMapping("/auth/signup/suporte")
    @ResponseStatus(HttpStatus.CREATED)
    @JsonView(View.UsuarioView.class)
    public ResponseEntity<Void> saveUserSuporte(@RequestBody @Valid UsuarioDto usuarioDto){

        Usuario usuario = new Usuario();

        usuario.setName(usuarioDto.getName());

        usuario.setEmpresa(usuarioDto.getEmpresa());

        usuario.setEmail(usuarioDto.getEmail());

        usuario = usuarioService.save(usuario);  

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}").buildAndExpand(usuario.getId()).toUri();
        
        applicationUserService.saveApplicationUserAsSuporte(usuario, usuarioDto.getPassword());

        return ResponseEntity.created(uri).build();
    }

   // @PreAuthorize("hasAnyRole('ADMIN', 'SUPORTE')")
    @GetMapping("/{id}")
    @JsonView({View.UsuarioView.class})
    public Usuario getUserById(@PathVariable Integer id){

        return usuarioService.getUserById(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPORTE', 'CLIENT')")
    @GetMapping("/getUserByEmail/{email}")
    @JsonView({View.UsuarioView.class})
    public Usuario getUserByEmail(@PathVariable String email){

        return usuarioService.getUserByEmail(email);
    }

}
