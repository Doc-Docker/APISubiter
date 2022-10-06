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

//    @GetMapping
//    @JsonView(View.EmpresaView.class)
//    public List<Empresa> getAllEnterprises(){
//
//        return empresaService.getAllEnterprises();
//    }
    
    @GetMapping
<<<<<<< HEAD
    @JsonView(View.EmpresaView.class)
    public List<Empresa> getAllEnterprises(Boolean status, Integer id){

        return empresaService.getAllEnterprises(status, id);
    }
    

=======
    public List<Empresa> getAllEnterprises(Boolean status){

        return empresaService.getAllEnterprises(status);
    }
    @JsonView(View.EmpresaView.class)
>>>>>>> 01858a5e72ed5cbd06882d2bc399f154ac43aef1
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @JsonView(View.EmpresaView.class)
    public Empresa saveEnterprise(@RequestBody @Valid Empresa empresa){

        return empresaService.save(empresa);  
    }

    @GetMapping("/{id}")
    @JsonView(View.EmpresaView.class)
    public Empresa getEnterpriseById(@PathVariable Integer id){

        return empresaService.getEnterpriseById(id);
    }
    
<<<<<<< HEAD
    @PutMapping("/{id}")
    @JsonView(View.EmpresaView.class)
=======
    @PutMapping("{id}")
>>>>>>> 01858a5e72ed5cbd06882d2bc399f154ac43aef1
    public Empresa updateEmpresaById(@PathVariable Integer id, @RequestBody Empresa empresa){

        return empresaService.updateEmpresaById(id, empresa);
    }
    
<<<<<<< HEAD
    @DeleteMapping("/{id}")
    @JsonView(View.EmpresaView.class)
    public void deleteEmpresaById(@PathVariable Integer id){
=======
    @PatchMapping("/arquivar/{id}/{status}")
    public void arquivaEmpresaById(@PathVariable Integer id, @PathVariable("status") Boolean status){
>>>>>>> 01858a5e72ed5cbd06882d2bc399f154ac43aef1

    	empresaService.arquivaEmpresaById(id, status);
    }
    
    @PatchMapping("/arquivar/{id}/{status}")
    public void arquivaEmpresaById(@PathVariable Integer id, @PathVariable("status") Boolean status){

        empresaService.arquivaEmpresaById(id, status);
    }
    
}
