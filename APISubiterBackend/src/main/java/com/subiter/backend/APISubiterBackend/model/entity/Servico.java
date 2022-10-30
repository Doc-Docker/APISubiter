package com.subiter.backend.APISubiterBackend.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.subiter.backend.APISubiterBackend.config.View;

import lombok.*;
import java.time.LocalDate;
import java.util.List;

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
    @JsonView({View.ServicoView.class, View.EmpresaView.class, View.TipoServicoView.class, View.InstalacaoView.class})
    @Column(name ="servico_codigo")
    private Integer id;

    @ManyToOne()
	@JoinColumn(name = "tipo_servico_codigo")
    @JsonView({View.ServicoView.class, View.EmpresaView.class, View.InstalacaoView.class})
    private TipoServico tipoServico;

    @JoinColumn(name="codigo_empresa")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonView({View.ServicoView.class})
    private Empresa empresaServico;

    @Column(name ="servico_descricao", nullable = false, length = 120)
    @NotEmpty(message = "O Campo nome é obrigatório")
    @JsonView({View.ServicoView.class, View.InstalacaoView.class, View.TipoServicoView.class})
    private String descricao;

    @Column(name ="servico_data_inclusao", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonView({View.ServicoView.class})
    private LocalDate inclusao;

    // @Column(name ="servico_data_agendamento", nullable = false, length = 10)
    // @NotEmpty(message = "Data de Agendamento é obrigatória")
    // @JsonFormat(pattern = "dd/MM/yyyy")
    // private LocalDate agendamento;

    // @Column(name ="servico_data_realizacao", nullable = false, length = 10)
    // @JsonFormat(pattern = "dd/MM/yyyy")
    // private LocalDate realizacao;

    @OneToMany(mappedBy = "servicoIntalacao", cascade = CascadeType.ALL)
    @JsonView({View.ServicoView.class})
    private List<Instalacao> instalacaos;

    @PrePersist
    public void presPersist(){
        setInclusao(LocalDate.now());
    }
}