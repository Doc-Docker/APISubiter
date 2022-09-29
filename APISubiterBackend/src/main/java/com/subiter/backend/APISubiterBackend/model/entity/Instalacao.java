package com.subiter.backend.APISubiterBackend.model.entity;

import lombok.*;
import javax.persistence.*;

@Entity(name = "INSTALACAO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Instalacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name="codigo_empresa")
    @ManyToOne(fetch = FetchType.LAZY)
    private Empresa empresaInstalacao;

    @JoinColumn(name="serie_equipamento")
    @ManyToOne(fetch = FetchType.LAZY)
    private EquipamentoSerie equipamentoSerieInstalacao;

    @JoinColumn(name="servico_codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    private Servico servicoIntalacao;
    
}
