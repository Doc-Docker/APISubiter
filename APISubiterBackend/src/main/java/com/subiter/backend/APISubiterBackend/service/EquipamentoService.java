package com.subiter.backend.APISubiterBackend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.subiter.backend.APISubiterBackend.model.entity.Equipamento;
import com.subiter.backend.APISubiterBackend.model.repository.EquipamentoRepository;

@Service
public class EquipamentoService {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    public Equipamento save(Equipamento equipamento) {
        return equipamentoRepository.save(equipamento);

    }

    public List<Equipamento> fidAll() {

        return equipamentoRepository.findAll();

    }

    public Equipamento getEquipamnetoById(Integer id) {
        return equipamentoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Equipamento não encontrado."));
    }

}
