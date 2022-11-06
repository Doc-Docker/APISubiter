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
public class EquipamentoSerieService {

    @Autowired
    private EquipamentoSerieRepository equipamentoSerieRepository;
    
    @Autowired
    private EquipamentoRepository equipamentoRepository;

    public EquipamentoSerie save(EquipamentoSerie equipamentoSerie) {
    	
        return equipamentoSerieRepository.save(equipamentoSerie);

    }

    public List<EquipamentoSerie> getAllEquipamentoSerie() {

        return equipamentoSerieRepository.findAll();
    }

    public EquipamentoSerie getUserById(String id) {

        return equipamentoSerieRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Equipamneto não encontrado."));
    }
    
    public boolean equipamentoSerieExiste(String id) {

         if(equipamentoSerieRepository.findById(id).isPresent()) {
        	 return true;
         }
          return false;      
    }
    
    
    public void upDateEquipamentoSerie(String id, EquipamentoSerie novoEquipamentoSerie) {
    	EquipamentoSerie equipamentoSerie = equipamentoSerieRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Equipamneto não encontrado."));
    	Equipamento novoEquipamento = equipamentoRepository.getById(novoEquipamentoSerie.getEquipamento().getId());
    	
    	equipamentoSerie.setDisponibilidade(novoEquipamentoSerie.getDisponibilidade());
    	equipamentoSerie.setEquipamento(novoEquipamento);
    	equipamentoSerie.setInstalacaos(novoEquipamentoSerie.getInstalacaos());
    	
    	equipamentoSerieRepository.save(equipamentoSerie);
    }
    
    public void delete(String id) {
    	EquipamentoSerie equipamentoSerie = equipamentoSerieRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Equipamento Serie não foi encontrado."));
    	
    	equipamentoSerieRepository.delete(equipamentoSerie);
    }
}
