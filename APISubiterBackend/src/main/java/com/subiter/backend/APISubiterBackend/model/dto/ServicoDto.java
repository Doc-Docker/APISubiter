package com.subiter.backend.APISubiterBackend.model.dto;

import java.time.LocalDate;

import com.subiter.backend.APISubiterBackend.model.entity.Empresa;
import com.subiter.backend.APISubiterBackend.model.entity.TipoServico;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServicoDto {
	
    private Integer id;

    private TipoServico tipoServico;

    private Empresa empresaServico;

    private String descricao;
	
    private LocalDate inclusao;
	
}
