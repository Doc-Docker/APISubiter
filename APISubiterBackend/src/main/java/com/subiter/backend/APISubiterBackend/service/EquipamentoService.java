package com.subiter.backend.APISubiterBackend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.subiter.backend.APISubiterBackend.model.entity.Equipamento;
import com.subiter.backend.APISubiterBackend.model.entity.EquipamentoSerie;
import com.subiter.backend.APISubiterBackend.model.repository.EquipamentoRepository;
import com.subiter.backend.APISubiterBackend.model.repository.EquipamentoSerieRepository;

@Service
public class EquipamentoService {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @Autowired
    private EquipamentoSerieRepository equipamentoSerieRepository;

    public Equipamento save(Equipamento equipamento) {
        equipamento.setId(null);

        EquipamentoSerie equipamentoSerie = new EquipamentoSerie();

        equipamentoSerie.setId(null);

        equipamentoSerie.setDisponibilidade(true);

        equipamentoSerieRepository.save(equipamentoSerie);

        equipamento.setEquipamentoSerie(equipamentoSerie);

        return equipamentoRepository.save(equipamento);
    }

    public List<Equipamento> fidAll() {

        return equipamentoRepository.findAll();
    }

    public Equipamento getEquipamnetoById(Integer id) {
        
        return equipamentoRepository.findById(id).orElseThrow(() -> 
        new ResponseStatusException(HttpStatus.NOT_FOUND, "Equipamento não encontrado."));
    }

    public Equipamento updateEquipamentoById(Integer id, Equipamento equipamento){
    	Equipamento equipamento_N = this.getServiceById(id);
    
        equipamento_N.setDescricao(equipamento.getDescricao);
        equipamento_N.setFabricante(equipamento.getFabricante);
        equipamento_N.setNome(equipamento.getNomeEquipamento);

    	return EquipamentoRepository.save(equipamento_N);
    }

    public void deleteEquipamentoById(Integer id){

        equipamentoRepository.deleteById(id);
    }
}

