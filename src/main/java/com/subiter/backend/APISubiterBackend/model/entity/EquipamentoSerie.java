package com.subiter.backend.APISubiterBackend.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="EQUIPAMENTO_SERIE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class EquipamentoSerie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column(name="serie_equipamento")
	private String numeroSerie;

	@Column(name="serie_disponivel")
	private Integer disponibilidade;

	@Column(name="serie_data_entrada")
	private Date dataEntrada;
	
	// @OneToMany(cascade = CascadeType.ALL)
	// @JoinColumn(name = "codigo_equipamento")
	@Column(name="serie_codigo_equipamento")
 	// private Equipamento codigoEquipamento;
	private Integer codigoEquipamento;
}
