
package com.subiter.backend.APISubiterBackend.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "EQUIPAMENTO_SERIE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class EquipamentoSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "serie_equipamento")
    private String numeroSerie;

    @Column(name = "serie_disponivel")
    private Integer disponibilidade;

    @Column(name = "serie_data_entrada")
    private LocalDate dataEntrada= LocalDate.now(); 

    @Column(name = "serie_codigo_equipamento")
    private Integer codigoEquipamento;
}
