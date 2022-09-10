package com.subiter.backend.APISubiterBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.subiter.backend.APISubiterBackend.model.entity.EquipamentoEntity;

import com.subiter.backend.APISubiterBackend.model.repository.EquipamentoRepository;

@Service
public class EquipamentoService {

	@Autowired
	private EquipamentoRepository equipamentoRepository;

	public EquipamentoEntity save(EquipamentoEntity equipamento) {
		return equipamentoRepository.save(equipamento);

	}

	public List<EquipamentoEntity> getAllEquipamentoSerie() {

		return equipamentoRepository.findAll();
	}

	public EquipamentoEntity getUserById(Integer id) {

		return equipamentoRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Equipamneto não encontrado."));
	}

}
