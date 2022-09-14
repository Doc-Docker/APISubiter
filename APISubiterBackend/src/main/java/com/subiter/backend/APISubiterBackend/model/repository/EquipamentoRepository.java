package com.subiter.backend.APISubiterBackend.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.subiter.backend.APISubiterBackend.model.entity.Equipamento;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Integer> {

}