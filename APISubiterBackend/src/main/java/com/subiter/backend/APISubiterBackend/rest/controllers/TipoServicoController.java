package com.subiter.backend.APISubiterBackend.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonView;
import com.subiter.backend.APISubiterBackend.config.View;
import com.subiter.backend.APISubiterBackend.model.entity.TipoServico;
import com.subiter.backend.APISubiterBackend.service.TipoServicoService;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tipo-servico")
public class TipoServicoController {

    @Autowired
    private TipoServicoService tipoServicoService;

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPORTE', 'CLIENT')")
    @GetMapping
    @JsonView(View.TipoServicoView.class)
    public List<TipoServico> getAllServicos(){

        return tipoServicoService.getAllServicos();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @JsonView(View.TipoServicoView.class)
    public TipoServico saveServico(@RequestBody @Valid TipoServico tipoServico){

        return tipoServicoService.save(tipoServico);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPORTE')")
    @JsonView(View.TipoServicoView.class)
    @GetMapping("/{id}")
    public TipoServico getServicoById(@PathVariable Integer id){

        return tipoServicoService.getServicoById(id);
    }
    
}
