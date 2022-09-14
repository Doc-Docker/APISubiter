package com.subiter.backend.APISubiterBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.subiter.backend.APISubiterBackend.model.entity.TipoServico;
import com.subiter.backend.APISubiterBackend.model.repository.TipoServicoRepository;
import java.util.List;

@Service
public class TipoServicoService {

    @Autowired
    private TipoServicoRepository tipoServicoRepository;
    
    public TipoServico save(TipoServico tipoServico){

        return tipoServicoRepository.save(tipoServico);
    }

    public List<TipoServico> getAllServicos (){
        
        return tipoServicoRepository.findAll();
    }
    
    public TipoServico getServicoById(Integer id){

        return tipoServicoRepository.findById(id).orElseThrow(()->
        new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo de serviço não encontrado."));
    }
}
