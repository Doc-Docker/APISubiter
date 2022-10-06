package com.subiter.backend.APISubiterBackend.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.subiter.backend.APISubiterBackend.model.entity.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer>{
    
    List<Servico> findByStatus(Boolean statusServico);
    
}