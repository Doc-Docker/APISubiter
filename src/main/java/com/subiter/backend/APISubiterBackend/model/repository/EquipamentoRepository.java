package com.subiter.backend.APISubiterBackend.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.subiter.backend.APISubiterBackend.model.entity.EquipamentoEntity;
import com.subiter.backend.APISubiterBackend.model.entity.EquipamentoSerie;

public interface EquipamentoRepository extends JpaRepository<EquipamentoEntity, Integer> {


}
