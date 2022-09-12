package com.subiter.backend.APISubiterBackend.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.subiter.backend.APISubiterBackend.model.entity.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Integer>{
    
}