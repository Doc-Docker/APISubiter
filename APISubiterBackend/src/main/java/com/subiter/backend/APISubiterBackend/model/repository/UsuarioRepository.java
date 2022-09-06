package com.subiter.backend.APISubiterBackend.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.subiter.backend.APISubiterBackend.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
}
