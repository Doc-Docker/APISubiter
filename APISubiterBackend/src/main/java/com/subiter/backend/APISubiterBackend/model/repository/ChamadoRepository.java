package com.subiter.backend.APISubiterBackend.model.repository;

import com.subiter.backend.APISubiterBackend.model.entity.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {
    
}
