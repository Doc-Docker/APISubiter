package com.subiter.backend.APISubiterBackend.model.entity;

import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.subiter.backend.APISubiterBackend.config.View;

@Entity(name = "CHAMADO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Chamado implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_chamado")
    @JsonView({View.ChamadoView.class, View.UsuarioView.class, View.TipoServicoView.class})
    private Integer id;

    @JoinColumn(name="codigo_usuario")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonView({View.ChamadoView.class})
    private Usuario usuarioChamado;
    
    @JsonView({View.ChamadoView.class, View.UsuarioView.class})
    @ManyToOne()
	@JoinColumn(name = "tipo_servico_codigo")
    private TipoServico tipoChamado;

    @Column(name = "criticidade_chamado", nullable = false)
    @NotEmpty(message = "O Campo criticidade é obrigatório")
    @JsonView({View.ChamadoView.class, View.UsuarioView.class})
    private String criticidadeChamado;

    @Column(name = "data_chamado", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonView({View.ChamadoView.class})
    private LocalDate dataChamado;

    @Column(name = "assunto_chamado", nullable = false, length = 120)
    @NotEmpty(message = "O Campo assunto é obrigatório")
    @JsonView({View.ChamadoView.class, View.UsuarioView.class, View.TipoServicoView.class})
    private String assuntoChamado;

    @Column(name = "descricao_chamado", nullable = false, length = 300)
    @NotEmpty(message = "O Campo descrição é obrigatório")
    @JsonView({View.ChamadoView.class, View.UsuarioView.class})
    private String descricaoChamado;

    @Column(name = "situacao_chamado", nullable = false)
    @NotEmpty(message = "O Campo situação é obrigatório")
    @JsonView({View.ChamadoView.class})
    private String situacaoChamado;

    @Column(name = "solucao_chamado", nullable = false)
    @JsonView({View.ChamadoView.class})
    private String solucaoChamado;

    @Column(name = "encerramento_chamado")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonView({View.ChamadoView.class})
    private LocalDate encerramentoChamado;

    @JoinColumn(name="numero_agendamento")
    @OneToOne(cascade = CascadeType.ALL)
    @JsonView({View.ChamadoView.class})
    private Agendamento agendamento;
    
    @PrePersist
    public void presPersist(){
        setDataChamado(LocalDate.now());
    }

}
