package com.subiter.backend.APISubiterBackend.model.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.subiter.backend.APISubiterBackend.config.View;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity(name = "AGENDAMENTO_CHAMADO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Agendamento implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({View.AgendamentoView.class, View.ChamadoView.class})
    @Column(name ="numero_agendamento")
    private Integer id;

    @NotEmpty(message = "O Campo chamado é obrigatório")
    @JsonView({View.AgendamentoView.class})
    @OneToOne(mappedBy = "agendamento")
    private Chamado chamadoAgendamento;

    @Column(name = "datahora_atendimento_agendamento", nullable = false)
    @JsonView({View.AgendamentoView.class})
    private LocalDateTime dataHora;

    @Column(name = "pessoas_atendimento_agendamentoo", length = 100)
    @JsonView({View.AgendamentoView.class})
    private String pessoas;

    @Column(name = "descricao_atendimento_agendamento", length = 300)
    @JsonView({View.AgendamentoView.class, View.ChamadoView.class})
    private String descricao;

    @Column(name = "numero_chamado_agendamento", length = 300)
    @NotEmpty(message = "O Campo chamado é obrigatório")
    @JsonView({View.AgendamentoView.class, View.ChamadoView.class})
    private String localAtendimento;
    
    @PrePersist
    public void presPersist(){
        setDataHora(LocalDateTime.now());
    }

}
