package com.subiter.backend.APISubiterBackend.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.DeleteMapping;
=======
import org.springframework.security.access.prepost.PreAuthorize;
>>>>>>> c6489e70723ce36bab766eae8ae5c5b7d288b8d5
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonView;
import com.subiter.backend.APISubiterBackend.config.View;
import com.subiter.backend.APISubiterBackend.model.entity.EquipamentoSerie;
import com.subiter.backend.APISubiterBackend.service.EquipamentoSerieService;

@RestController
@RequestMapping("/api/equipamento-serie")
public class EquipamentoSerieController {

	@Autowired
	private EquipamentoSerieService equipamentoSerieService;

<<<<<<< HEAD
	@GetMapping
	@JsonView(View.EquipamentoSerieView.class)
	public List<EquipamentoSerie> getAllEquipamentoSerie() {
=======
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPORTE')")
    @GetMapping
    @JsonView(View.EquipamentoSerieView.class)
    public List<EquipamentoSerie> getAllEquipamentoSerie() {
>>>>>>> c6489e70723ce36bab766eae8ae5c5b7d288b8d5

		return equipamentoSerieService.getAllEquipamentoSerie();

	}

<<<<<<< HEAD
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@JsonView(View.EquipamentoSerieView.class)
	public EquipamentoSerie sava(@RequestBody EquipamentoSerie equipamentoSerie) {
		return equipamentoSerieService.save(equipamentoSerie);
=======
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @JsonView(View.EquipamentoSerieView.class)
    public EquipamentoSerie sava(@RequestBody EquipamentoSerie equipamentoSerie) {
        return equipamentoSerieService.save(equipamentoSerie);
>>>>>>> c6489e70723ce36bab766eae8ae5c5b7d288b8d5

	}

<<<<<<< HEAD
	@GetMapping("/{id}")
	@JsonView(View.EquipamentoSerieView.class)
	public EquipamentoSerie getByIdEquipamentoSerie(@PathVariable String id) {
=======
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPORTE')")
    @GetMapping("/{id}")
    @JsonView(View.EquipamentoSerieView.class)
    public EquipamentoSerie getByIdEquipamentoSerie(@PathVariable Integer id) {
>>>>>>> c6489e70723ce36bab766eae8ae5c5b7d288b8d5

		return equipamentoSerieService.getUserById(id);

	}
   
	@DeleteMapping("/{id}")
	@JsonView(View.EquipamentoSerieView.class)
	public void delete(@RequestBody String id) {
		System.out.println(id);
		 equipamentoSerieService.delete(id);
	}

}