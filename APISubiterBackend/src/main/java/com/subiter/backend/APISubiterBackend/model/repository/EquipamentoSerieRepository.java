package com.subiter.backend.APISubiterBackend.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.subiter.backend.APISubiterBackend.model.entity.EquipamentoSerie;

@Repository
public interface EquipamentoSerieRepository extends JpaRepository<EquipamentoSerie, String>{
	
	public List<EquipamentoSerie> findByDisponibilidade(Boolean valor);

}