package com.subiter.backend.APISubiterBackend.model.dto;

import java.util.List;

public class ServicoDto {
	private Integer id;
	
	private String tipoServico;
	
	private String descricao;
	
	private String empresaServico;
	
	private Integer idEmpresaServico;
	


	public ServicoDto(Integer id, String tipo_servico, String descricao, String empresa, Integer idEmpresaServico) {
		this.id = id;
		this.tipoServico = tipo_servico;
		this.descricao = descricao;
		this.empresaServico = empresa;
		this.idEmpresaServico = idEmpresaServico;
	}
	
	public Integer getIdEmpresaServico() {
		return idEmpresaServico;
	}

	public void setIdEmpresaServico(Integer idEmpresaServico) {
		this.idEmpresaServico = idEmpresaServico;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}

	public String getEmpresaServico() {
		return empresaServico;
	}

	public void setEmpresaServico(String empresaServico) {
		this.empresaServico = empresaServico;
	}
	
	




	
	

}
