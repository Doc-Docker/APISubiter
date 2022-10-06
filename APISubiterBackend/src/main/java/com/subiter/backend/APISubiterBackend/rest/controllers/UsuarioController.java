package com.subiter.backend.APISubiterBackend.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonView;
import com.subiter.backend.APISubiterBackend.config.View;
import com.subiter.backend.APISubiterBackend.model.entity.Usuario;
import com.subiter.backend.APISubiterBackend.service.UsuarioService;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @JsonView(View.UsuarioView.class)
    @GetMapping
    public List<Usuario> getAllUsers(Boolean status){

        return usuarioService.getUsuarioById(status);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @JsonView(View.UsuarioView.class)
    public Usuario saveUser(@RequestBody @Valid Usuario usuario){

        return usuarioService.save(usuario);  
    }

    @GetMapping("/{id}")
    @JsonView({View.UsuarioView.class})
    public Usuario getUserById(@PathVariable Integer id){

        return usuarioService.getUserById(id);
    }
    
    @PatchMapping("/arquivar/{id}/{status}")
    public void arquivaUsuarioById(@PathVariable Integer id, @PathVariable("status") Boolean status){

        usuarioService.arquivaUsuarioById(id, status);
    }

}
