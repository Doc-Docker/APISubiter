package com.subiter.backend.APISubiterBackend.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonView;
import com.subiter.backend.APISubiterBackend.config.View;
import com.subiter.backend.APISubiterBackend.model.entity.Chamado;
import com.subiter.backend.APISubiterBackend.service.ChamadoService;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/chamados")
public class ChamadoController {

    @Autowired
    private ChamadoService chamadoService;

    @GetMapping
    @JsonView(View.ChamadoView.class)
    public List<Chamado> getAllChamados(){

        return chamadoService.getAllChamados();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @JsonView(View.ChamadoView.class)
    public Chamado saveChamado(@RequestBody @Valid Chamado chamado){

        return chamadoService.save(chamado);  
    }

    @GetMapping("/{id}")
    @JsonView(View.ChamadoView.class)
    public Chamado getChamadoById(@PathVariable Integer id){

        return chamadoService.getChamadoById(id);
    }
    
    @PutMapping("/{id}")
    @JsonView(View.ChamadoView.class)
    public Chamado updateEmpresaById(@PathVariable Integer id, @RequestBody Chamado chamado){

        return chamadoService.updateChamadoById(id, chamado);
    }
    
    @DeleteMapping("/{id}")
    @JsonView(View.ChamadoView.class)
    public void deleteChamadoById(@PathVariable Integer id){

    	chamadoService.deleteChamadoById(id);
    }
    
}
