package com.subiter.backend.APISubiterBackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.subiter.backend.APISubiterBackend.model.entity.Agendamento;
import com.subiter.backend.APISubiterBackend.model.entity.Chamado;
import com.subiter.backend.APISubiterBackend.model.entity.EquipamentoSerie;
import com.subiter.backend.APISubiterBackend.model.repository.AgendamentoRepository;
import com.subiter.backend.APISubiterBackend.model.repository.ChamadoRepository;
import com.subiter.backend.APISubiterBackend.model.repository.EquipamentoSerieRepository;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository agendamentoRepository;

	@Autowired
	private ChamadoRepository chamadoRepository;

	@Autowired
	private EquipamentoSerieRepository equipamentoSerieRepository;

	public Agendamento save(Agendamento agendamento) {

		Chamado chamado = chamadoRepository.getById(agendamento.getChamadoAgendamento().getId());

		EquipamentoSerie equipamentoSerie = equipamentoSerieRepository.getById(agendamento.getNumerosSerie().getId());

		equipamentoSerie.setDisponibilidade(false);
		equipamentoSerieRepository.save(equipamentoSerie);

		agendamento.setNumerosSerie(equipamentoSerie);
		agendamento.setChamadoAgendamento(chamado);

		return agendamentoRepository.save(agendamento);

	}

	public List<Agendamento> getAll() {

		return agendamentoRepository.findAll();
	}

	public Agendamento getById(Integer id) {

		return agendamentoRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agendamento não encontrado."));
	}

	public void deleteAgendamentoById(Integer id) {

		agendamentoRepository.deleteById(id);
	}

	public Agendamento upDate(Integer id, Agendamento agendamentoNovo) {

		Agendamento updateAgendamento = agendamentoRepository.getById(id);

		updateAgendamento.setDataHora(agendamentoNovo.getDataHora());
		updateAgendamento.setDescricao(agendamentoNovo.getDescricao());
		updateAgendamento.setLocalAtendimento(agendamentoNovo.getLocalAtendimento());
		updateAgendamento.setPessoas(agendamentoNovo.getPessoas());

		return agendamentoRepository.save(updateAgendamento);

	}

}
