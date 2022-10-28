package com.subiter.backend.APISubiterBackend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.subiter.backend.APISubiterBackend.model.entity.EquipamentoSerie;

import com.subiter.backend.APISubiterBackend.model.repository.EquipamentoSerieRepository;

@Service
public class EquipamentoSerieService {

    @Autowired
    private EquipamentoSerieRepository equipamentoSerieRepository;

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
}
