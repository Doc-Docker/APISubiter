package com.subiter.backend.APISubiterBackend.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonView;
import com.subiter.backend.APISubiterBackend.config.View;
import com.subiter.backend.APISubiterBackend.model.entity.Empresa;
import com.subiter.backend.APISubiterBackend.service.EmpresaService;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public List<Empresa> getAllEnterprises(Boolean status){

        return empresaService.getAllEnterprises(status);
    }
    @JsonView(View.EmpresaView.class)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Empresa saveEnterprise(@RequestBody @Valid Empresa empresa){

        return empresaService.save(empresa);  
    }

    @GetMapping("/{id}")
    @JsonView(View.EmpresaView.class)
    public Empresa getEnterpriseById(@PathVariable Integer id){

        return empresaService.getEnterpriseById(id);
    }
    
    @PutMapping("{id}")
    public Empresa updateEmpresaById(@PathVariable Integer id, @RequestBody Empresa empresa){

        return empresaService.updateEmpresaById(id, empresa);
    }
    
    @PatchMapping("/arquivar/{id}/{status}")
    public void arquivaEmpresaById(@PathVariable Integer id, @PathVariable("status") Boolean status){

    	empresaService.arquivaEmpresaById(id, status);
    }
    
}
