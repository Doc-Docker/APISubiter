package com.subiter.backend.APISubiterBackend.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.subiter.backend.APISubiterBackend.model.entity.TipoServico;
import com.subiter.backend.APISubiterBackend.service.TipoServicoService;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tipo-servico")
public class TipoServicoController {

    @Autowired
    private TipoServicoService tipoServicoService;

    @GetMapping
    public List<TipoServico> getAllServicos(){

        return tipoServicoService.getAllServicos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TipoServico saveServico(@RequestBody @Valid TipoServico tipoServico){

        return tipoServicoService.save(tipoServico);
    }

    @GetMapping("/{id}")
    public TipoServico getServicoById(@PathVariable Integer id){

        return tipoServicoService.getServicoById(id);
    }
    
}
