package com.subiter.backend.APISubiterBackend.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPORTE')")
    @GetMapping
    @JsonView(View.EmpresaView.class)
    public List<Empresa> getAllEnterprises(){

        return empresaService.getAllEnterprises();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @JsonView(View.EmpresaView.class)
    public Empresa saveEnterprise(@RequestBody @Valid Empresa empresa){

        return empresaService.save(empresa);  
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPORTE')")
    @GetMapping("/{id}")
    @JsonView(View.EmpresaView.class)
    public Empresa getEnterpriseById(@PathVariable Integer id){

        return empresaService.getEnterpriseById(id);
    }
    
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/{id}")
    @JsonView(View.EmpresaView.class)
    public Empresa updateEmpresaById(@PathVariable Integer id, @RequestBody Empresa empresa){

        return empresaService.updateEmpresaById(id, empresa);
    }
    
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/{id}")
    @JsonView(View.EmpresaView.class)
    public void deleteEmpresaById(@PathVariable Integer id){

    	empresaService.deleteEmpresaById(id);
    }
    
}
