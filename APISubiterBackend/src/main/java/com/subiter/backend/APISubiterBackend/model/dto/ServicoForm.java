package com.subiter.backend.APISubiterBackend.model.dto;

public class ServicoForm {
	    private Integer tipoServico;
	    private Integer empresaServico;
	    private String descricao;
	    

		public Integer getTipoServico() {
			return tipoServico;
		}

		public void setTipoServico(Integer tipoServico) {
			this.tipoServico = tipoServico;
		}

		public Integer getEmpresaServico() {
			return empresaServico;
		}

		public void setEmpresaServico(Integer empresaServico) {
			this.empresaServico = empresaServico;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
	    
	    
	
}
