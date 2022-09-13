package com.subiter.backend.APISubiterBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.subiter.backend.APISubiterBackend.model.entity.Tipo_Servico;
import com.subiter.backend.APISubiterBackend.model.repository.Tipo_ServicoRepository;
import java.util.List;

@Service
public class Tipo_ServicoService {

    @Autowired
    private Tipo_ServicoRepository tipo_servicoRepository;
    
    public Tipo_Servico save(Tipo_servico tipo_servico){

        return tipo_servicoRepository.save(tipo_servico);
    }

    public List<Tipo_Servico> getAllEnterprises (){
        
        return tipo_servicoRepository.findAll();
    }
    
    public Tipo_Servico getEnterpriseById(Integer id){

        return tipo_servicoRepository.findById(id).orElseThrow(()->
        new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo de serviço não encontrado."));
    }
}
