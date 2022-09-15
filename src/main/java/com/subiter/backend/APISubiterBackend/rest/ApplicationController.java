package com.subiter.backend.APISubiterBackend.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/subiter")
public class ApplicationController {

    @GetMapping(value = "/teste")
    public String mainTest(){

        return "Servidor rodando com sucesso";

    }
    
}
