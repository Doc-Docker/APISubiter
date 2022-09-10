package com.subiter.backend.APISubiterBackend.rest.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.subiter.backend.APISubiterBackend.model.entity.Equipamento;
import com.subiter.backend.APISubiterBackend.service.EquipamentoService;

@RestController
@RequestMapping("/api/equipamentos")
public class EquipamentoController {

    @Autowired
    private EquipamentoService equipamentoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Equipamento saveEquipamento(@RequestBody @Valid Equipamento equipamento) {

        return equipamentoService.save(equipamento);

    }

    @GetMapping
    public List<Equipamento> getAllEquipamentos() {

        return equipamentoService.fidAll();
    }

    @GetMapping("/{id}")
    public Equipamento getByEquipamentoId(@PathVariable Integer id) {

        return equipamentoService.getEquipamnetoById(id);
    }

}
