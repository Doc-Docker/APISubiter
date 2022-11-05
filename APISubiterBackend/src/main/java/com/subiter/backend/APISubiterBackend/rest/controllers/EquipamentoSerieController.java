package com.subiter.backend.APISubiterBackend.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPORTE')")
    @GetMapping
    @JsonView(View.EquipamentoSerieView.class)
    public List<EquipamentoSerie> getAllEquipamentoSerie() {

        return equipamentoSerieService.getAllEquipamentoSerie();

    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @JsonView(View.EquipamentoSerieView.class)
    public EquipamentoSerie sava(@RequestBody EquipamentoSerie equipamentoSerie) {
        return equipamentoSerieService.save(equipamentoSerie);

    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPORTE')")
    @GetMapping("/{id}")
    @JsonView(View.EquipamentoSerieView.class)
    public EquipamentoSerie getByIdEquipamentoSerie(@PathVariable Integer id) {

        return equipamentoSerieService.getUserById(id);

    }

}