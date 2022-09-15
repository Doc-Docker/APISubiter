package com.subiter.backend.APISubiterBackend.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.subiter.backend.APISubiterBackend.model.entity.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer>{
    
}