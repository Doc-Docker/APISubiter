package com.subiter.backend.APISubiterBackend.service;

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

		System.out.println(chamado.getId());

		if (chamado.getAgendamento() != null) {

			if (chamado.getAgendamento().getId() != 0) {

				return agendamentoRepository.findById(-1)
						.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
								"Esse Chamado já possui um agendamento"));

			}
		}

		List<EquipamentoSerie> equipamentoSerieConten = equipamentoSerieRepository.findByDisponibilidade(true);

		System.out.println(equipamentoSerieConten.size());
		EquipamentoSerie equipamentoSerie = equipamentoSerieRepository.getById(agendamento.getNumerosSerie());

		System.out.println(equipamentoSerie.getDisponibilidade());
		if (equipamentoSerie.getDisponibilidade() == true) {
			equipamentoSerie.setDisponibilidade(false);
			equipamentoSerieRepository.save(equipamentoSerie);

			agendamento.setChamadoAgendamento(chamado);
			return agendamentoRepository.save(agendamento);
		}

		return agendamentoRepository.findById(-1).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Número de Serie não disponível."));

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
