package com.subiter.backend.APISubiterBackend.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subiter.backend.APISubiterBackend.model.entity.EquipamentoEntity;

import com.subiter.backend.APISubiterBackend.service.EquipamentoService;

@RestController
@RequestMapping("/api/equipamento")
public class EquipamentoController {

	@Autowired
	private EquipamentoService equipamentoService;

	@GetMapping
	public List<EquipamentoEntity> getAllEquipamentoSerie() {

		return equipamentoService.getAllEquipamentoSerie();

	}

	@PostMapping
	// @ResponseStatus(HttpStatus.CREATED)
	public EquipamentoEntity sava(@RequestBody EquipamentoEntity equipamento) {
		return equipamentoService.save(equipamento);

	}

	@GetMapping("/{id}")
	public EquipamentoEntity getByIdEquipamentoSerie(@PathVariable Integer id) {

		return equipamentoService.getUserById(id);

	}

}
