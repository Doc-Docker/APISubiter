package com.subiter.backend.APISubiterBackend.model.entity;

import lombok.*;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;
import com.subiter.backend.APISubiterBackend.config.View;

@Entity(name = "INSTALACAO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Instalacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({View.InstalacaoView.class})
    private Integer id;

    @JoinColumn(name="codigo_empresa")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonView({View.InstalacaoView.class})
    private Empresa empresaInstalacao;

    @JoinColumn(name="serie_equipamento")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonView({View.InstalacaoView.class})
    private EquipamentoSerie equipamentoSerieInstalacao;

    @JoinColumn(name="servico_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonView({View.InstalacaoView.class})
    private Servico servicoIntalacao;
    
}
