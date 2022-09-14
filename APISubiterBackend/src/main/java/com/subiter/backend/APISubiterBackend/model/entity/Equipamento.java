package com.subiter.backend.APISubiterBackend.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "EQUIPAMENTO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Equipamento {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_equipamento")
	private Integer id;

	@Column(name = "nome_equipamento", nullable = false, length = 40)
	@NotEmpty(message = "O Campo nome é obrigatório")
	private String nomeEquipamento;

	@Column(name = "descricao_equipamento", length = 60)
	private String descricao;

	@Column(name = "fabricante_equipamento", length = 30)
	private String fabricante;

}
