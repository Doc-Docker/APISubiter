package com.subiter.backend.APISubiterBackend.model.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.subiter.backend.APISubiterBackend.model.entity.Equipamento;

@Repository
public interface EquipamentoRepository extends JpaRepository<Equipamento, Integer> {
    
    List<Equipamento> findByStatus(Boolean statusEquipamento);

}