package com.subiter.backend.APISubiterBackend.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.subiter.backend.APISubiterBackend.model.entity.Servico;
import com.subiter.backend.APISubiterBackend.service.ServicoService;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/servico")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public List<Servico> getAllSdervices(){

        return servicoService.getAllServices();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Servico saveService(@RequestBody @Valid Servico servico){

        return servicoService.save(servico);
    }

    @GetMapping("/{id}")
    public Servico getServiceById(@PathVariable Integer id){

        return servicoService.getServiceById(id);
    }

}
