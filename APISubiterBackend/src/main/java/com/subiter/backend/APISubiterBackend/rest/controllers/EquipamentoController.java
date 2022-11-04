package com.subiter.backend.APISubiterBackend.rest.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.subiter.backend.APISubiterBackend.config.View;
import com.subiter.backend.APISubiterBackend.model.entity.Equipamento;
import com.subiter.backend.APISubiterBackend.service.EquipamentoService;


@RestController
@RequestMapping("/api/equipamentos")
public class EquipamentoController {

    @Autowired
    private EquipamentoService equipamentoService;


    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @JsonView(View.EquipamentoView.class)
    public Equipamento saveEquipamento(@RequestBody @Valid Equipamento equipamento) {

        return equipamentoService.save(equipamento);
    }


    @PreAuthorize("hasAnyRole('ADMIN', 'SUPORTE')")
    @GetMapping
    @JsonView(View.EquipamentoView.class)
    public List<Equipamento> getAllEquipamentos() {

        return equipamentoService.fidAll();
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPORTE')")
    @GetMapping("/{id}")
    @JsonView(View.EquipamentoView.class)
    public Equipamento getByEquipamentoId(@PathVariable Integer id) {

        return equipamentoService.getEquipamnetoById(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/{id}")
    @JsonView(View.EquipamentoView.class)
    public Equipamento dupdateEquipamentoById(@PathVariable Integer id, @RequestBody Equipamento equipamento){

        return equipamentoService.updateEquipamentoById(id, equipamento);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/{id}")
    @JsonView(View.EquipamentoView.class)
    public void deleteEquipamentoById(@PathVariable Integer id){

        equipamentoService.deleteEquipamentoById(id);
    }

}
