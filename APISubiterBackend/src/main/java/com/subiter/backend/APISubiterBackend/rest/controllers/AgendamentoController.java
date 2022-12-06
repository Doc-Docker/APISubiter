package com.subiter.backend.APISubiterBackend.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.subiter.backend.APISubiterBackend.config.View;
import com.subiter.backend.APISubiterBackend.model.entity.Agendamento;
import com.subiter.backend.APISubiterBackend.service.AgendamentoService;

@RestController
@RequestMapping("/api/agendamento")
public class AgendamentoController {
     
	@Autowired
	private AgendamentoService agendamnetoSevice;

	@PreAuthorize("hasAnyRole('SUPORTE')")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@JsonView(View.AgendamentoView.class)
	public Agendamento save(@RequestBody Agendamento agendamento) {
         agendamento.presPersist();
		
		return agendamnetoSevice.save(agendamento);
	}

	@PreAuthorize("hasAnyRole('CLIENT', 'SUPORTE')")
	@GetMapping
	@JsonView(View.AgendamentoView.class)
	public List<Agendamento> getAllAgendamento() {

		return agendamnetoSevice.getAll();
	}

	@PreAuthorize("hasAnyRole('CLIENT', 'SUPORTE')")
	@GetMapping("/{id}")
	@JsonView(View.AgendamentoView.class)
	public Agendamento getByIdAgendamento(@PathVariable Integer id) {

		return agendamnetoSevice.getById(id);
	}

	@PreAuthorize("hasAnyRole('SUPORTE')")
	@DeleteMapping("/{id}")
	@JsonView(View.AgendamentoView.class)
	public void deleteAgendamento(@PathVariable Integer id) {

		agendamnetoSevice.deleteAgendamentoById(id);

	}
	
	@PreAuthorize("hasAnyRole('SUPORTE')")
	@PatchMapping("/{id}")
	@JsonView(View.AgendamentoView.class)
	public Agendamento upDateAgendamento(@PathVariable Integer id, @RequestBody Agendamento novoAgendamento) {

		return agendamnetoSevice.upDate(id, novoAgendamento);

	}

}
