package com.subiter.backend.APISubiterBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.subiter.backend.APISubiterBackend.model.entity.Servico;
import com.subiter.backend.APISubiterBackend.model.repository.ServicoRepository;
import java.util.List;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;
    
    public Servico save (Servico servico){

        return servicoRepository.save(servico);
    }

    public List<Servico> getAllServices (){
        
        return servicoRepository.findAll();
    }
    
    public Servico getServiceById(Integer id){

        return servicoRepository.findById(id).orElseThrow(()->
        new ResponseStatusException(HttpStatus.NOT_FOUND, "Serviço não encontrado."));
    }
}
