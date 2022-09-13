package com.subiter.backend.APISubiterBackend.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.subiter.backend.APISubiterBackend.model.entity.Tipo-Servico;
import com.subiter.backend.APISubiterBackend.service.Tipo-ServicoService;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/Tipo-Servico")
public class Tipo-ServicoController {

    @Autowired
    private Tipo-ServicoService tipo-servicoService;

    @GetMapping
    public List<Tipo-Servico> getAllEnterprises(){

        return tipo-servicoService.getAllEnterprises();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tipo-Servico saveEnterprise(@RequestBody @Valid Tipo-Servico tipo-servico){

        return empresaService.save(tipo-servico);
    }

    @GetMapping("/{id}")
    public Tipo-Servico getEnterpriseById(@PathVariable Integer id){

        return tipo-servicoService.getEnterpriseById(id);
    }
    
}
