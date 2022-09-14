package com.subiter.backend.APISubiterBackend.model.repository;

import com.subiter.backend.APISubiterBackend.model.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
    
}
