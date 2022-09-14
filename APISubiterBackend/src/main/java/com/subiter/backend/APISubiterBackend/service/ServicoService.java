package com.subiter.backend.APISubiterBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.subiter.backend.APISubiterBackend.model.entity.Servico;
import com.subiter.backend.APISubiterBackend.model.entity.TipoServico;
import com.subiter.backend.APISubiterBackend.model.repository.ServicoRepository;
import com.subiter.backend.APISubiterBackend.model.repository.TipoServicoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private TipoServicoRepository tipoServicoRepository;
    
    public Servico save (Servico servico){

        servico.setId(null);

        Optional<TipoServico> tipoServico = tipoServicoRepository.findById(servico.getTipoServico().getId());

        servico.setTipoServico(tipoServico.get());
        
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
