package com.subiter.backend.APISubiterBackend.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;
import com.subiter.backend.APISubiterBackend.config.View;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Entity(name = "EQUIPAMENTO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Equipamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_equipamento")
	@JsonView({ View.EquipamentoView.class, View.EquipamentoSerieView.class })
	private Integer id;

	@Column(name = "nome_equipamento", nullable = false, length = 40)
	@NotEmpty(message = "O Campo nome é obrigatório")
	@JsonView({ View.EquipamentoView.class, View.EquipamentoSerieView.class })
	private String nomeEquipamento;

	@Column(name = "descricao_equipamento", length = 60)
	@JsonView({ View.EquipamentoView.class, View.EquipamentoSerieView.class })
	private String descricao;

	@Column(name = "fabricante_equipamento", length = 30)
	@JsonView({ View.EquipamentoView.class, View.EquipamentoSerieView.class })
	private String fabricante;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "serie_equipamento")
	@JsonView({View.EquipamentoView.class})
	private EquipamentoSerie equipamentoSerie;
	
	//private String idEquipamentoSerie;

}
