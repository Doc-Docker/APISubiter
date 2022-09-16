package com.subiter.backend.APISubiterBackend.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.subiter.backend.APISubiterBackend.model.dto.ServicoDto;
import com.subiter.backend.APISubiterBackend.model.dto.ServicoForm;
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
    public List<ServicoDto> getAllSdervices(){

        return servicoService.getAllServices();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Servico saveService(@RequestBody ServicoForm servicoForm){

        return servicoService.save(servicoForm);
    }

    @GetMapping("/{id}")
    public Servico getServiceById(@PathVariable Integer id){

        return servicoService.getServiceById(id);
    }
    
    @DeleteMapping("/{id}")
    public void deleteServiceById(@PathVariable Integer id){

        servicoService.deleteServiceById(id);
    }
    
    @PutMapping("/{id}")
    public Servico dupdateServiceById(@PathVariable Integer id, @RequestBody ServicoForm servicoForm){

        return servicoService.updateServiceById(id, servicoForm);
    }

}
