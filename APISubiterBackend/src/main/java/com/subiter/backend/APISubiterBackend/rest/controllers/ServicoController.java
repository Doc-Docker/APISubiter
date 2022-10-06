package com.subiter.backend.APISubiterBackend.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonView;
import com.subiter.backend.APISubiterBackend.config.View;
import com.subiter.backend.APISubiterBackend.model.dto.ServicoDto;
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
    @JsonView(View.ServicoView.class)
    public List<Servico> getAllSdervices(Boolean status){

        return servicoService.getAllServices(status);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @JsonView(View.ServicoView.class)
    public Servico saveService(@RequestBody @Valid ServicoDto servicoDto){

        return servicoService.save(servicoDto);
    }

    @GetMapping("/{id}")
    @JsonView(View.ServicoView.class)
    public Servico getServiceById(@PathVariable Integer id){

        return servicoService.getServiceById(id);
    }
    
<<<<<<< HEAD
    @DeleteMapping("/{id}")
    @JsonView(View.ServicoView.class)
    public void deleteServiceById(@PathVariable Integer id){

        servicoService.deleteServiceById(id);
    }
=======
//    @DeleteMapping("/{id}")
//    public void deleteServiceById(@PathVariable Integer id){
//
//        servicoService.deleteServiceById(id);
//    }
>>>>>>> 01858a5e72ed5cbd06882d2bc399f154ac43aef1
    
    @PutMapping("/{id}")
    @JsonView(View.ServicoView.class)
    public Servico updateServiceById(@PathVariable Integer id, @RequestBody ServicoDto servicoForm){

        return servicoService.updateServiceById(id, servicoForm);
    }
    
    @PatchMapping("/arquivar/{id}/{status}")
    public void arquivaServicoById(@PathVariable Integer id, @PathVariable("status") Boolean status){

        servicoService.arquivaServicoById(id, status);
    }

}
