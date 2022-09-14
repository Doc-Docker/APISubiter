package com.subiter.backend.APISubiterBackend.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity(name = "SERVICO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tipo_servico_codigo")
    private TipoServico tipoServico;

    @JoinColumn(name="codigo_empresa")
    @ManyToOne()
    private Empresa empresaServico;

    @Column(name ="servico_descricao", nullable = false, length = 120)
    @NotEmpty(message = "O Campo nome é obrigatório")
    private String descricao;

    @Column(name ="servico_data_inclusao", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate inclusao;

    // @Column(name ="servico_data_agendamento", nullable = false, length = 10)
    // @NotEmpty(message = "Data de Agendamento é obrigatória")
    // @JsonFormat(pattern = "dd/MM/yyyy")
    // private LocalDate agendamento;

    // @Column(name ="servico_data_realizacao", nullable = false, length = 10)
    // @JsonFormat(pattern = "dd/MM/yyyy")
    // private LocalDate realizacao;

    @PrePersist
    public void presPersist(){
        setInclusao(LocalDate.now());
    }
}
