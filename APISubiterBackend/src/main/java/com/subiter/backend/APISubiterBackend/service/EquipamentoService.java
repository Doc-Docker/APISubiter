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
    private EquipamentoSerieService equipamentoSerie;

	public Equipamento save(Equipamento equipamento) {

		if(!equipamentoSerie.equipamentoSerieExiste(equipamento.getEquipamentoSerie().getId())) {
        EquipamentoSerie novoEquipamentoSerie = new EquipamentoSerie();
        novoEquipamentoSerie.setId(equipamento.getEquipamentoSerie().getId());
        novoEquipamentoSerie.presPersist();
        equipamentoSerie.save(novoEquipamentoSerie);  
        EquipamentoSerie equipamentoSerieNovo = equipamentoSerie.getUserById(equipamento.getEquipamentoSerie().getId());
        equipamento.setEquipamentoSerie(equipamentoSerieNovo);
		return equipamentoRepository.save(equipamento);
		}
		Equipamento equipamentoNovo = equipamentoRepository.findById(-1)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "O numero de serie informado já foi cadastrado."));
return equipamentoNovo;
	}

	public List<Equipamento> fidAll() {

		return equipamentoRepository.findAll();
	}

	public Equipamento getEquipamnetoById(Integer id) {

		return equipamentoRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Equipamento não encontrado."));
	}

	public Equipamento updateEquipamentoById(Integer id, Equipamento equipamento) {
		Equipamento equipamento_N = this.getEquipamnetoById(id);

		equipamento_N.setDescricao(equipamento.getDescricao());
		equipamento_N.setFabricante(equipamento.getFabricante());
		equipamento_N.setNomeEquipamento(equipamento.getNomeEquipamento());

		return equipamentoRepository.save(equipamento_N);
	}

	public void deleteEquipamentoById(Integer id) {

		equipamentoRepository.deleteById(id);
	}
}
