package com.subiter.backend.APISubiterBackend.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EquipamentoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nome_equipamento")
	private String nomeEquipamento;
	@Column(name="descricao_equipamento")
	private String descricao;
	@Column(name="fabricante_equipamento")
	private String fabricante;
	
	
	
}
