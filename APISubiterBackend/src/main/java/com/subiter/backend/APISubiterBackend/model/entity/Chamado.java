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
    @JsonView({View.ChamadoView.class})
    private Integer id;

    @JoinColumn(name="codigo_usuario")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuarioChamado;

    @Column(name = "tipo_chamado", nullable = false, length = 20)
    @NotEmpty(message = "O Campo tipo é obrigatório")
    @JsonView({View.ChamadoView.class})
    private String tipoChamado;

    @Column(name = "criticidade_chamado", nullable = false)
    @NotEmpty(message = "O Campo tipo é obrigatório")
    @JsonView({View.ChamadoView.class})
    private Character criticidadeChamado;

    @Column(name = "data_chamado", nullable = false)
    @NotEmpty(message = "O Campo data é obrigatório")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonView({View.ChamadoView.class})
    private LocalDate dataChamado;

    @Column(name = "descricao_chamado", nullable = false, length = 300)
    @NotEmpty(message = "O Campo descrição é obrigatório")
    @JsonView({View.ChamadoView.class})
    private String descricaoChamado;

    @Column(name = "situacao_chamado", nullable = false)
    @NotEmpty(message = "O Campo situação é obrigatório")
    @JsonView({View.ChamadoView.class})
    private Character situacaoChamado;

    private String solucaoChamado;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonView({View.ChamadoView.class})
    private LocalDate encerramentoChamado;

    @PrePersist
    public void presPersist(){
        setDataChamado(LocalDate.now());
    }

}
