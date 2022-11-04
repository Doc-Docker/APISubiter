package com.subiter.backend.APISubiterBackend.model.entity;

import lombok.*;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonView;
import com.subiter.backend.APISubiterBackend.config.View;

@Entity(name = "TIPO_SERVICO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_servico_codigo")
    @JsonView({View.TipoServicoView.class, View.ServicoView.class, View.ChamadoView.class})
    private Integer id;

    @Column(name = "tipo_servico_nome", nullable = false, length = 20)
    @NotEmpty(message = "O nome do serviço é obrigatório")
    @JsonView({View.TipoServicoView.class, View.ServicoView.class, View.ChamadoView.class})
    private String nome;

    @Column(name = "tipo_servico_descricao", nullable = false, length = 40)
    @JsonView({View.TipoServicoView.class, View.ChamadoView.class})
    private String descricao;

    @OneToMany(mappedBy = "tipoServico" , cascade = CascadeType.ALL)
    @JsonView({View.TipoServicoView.class})
    private List<Servico> servicos;

    @OneToMany(mappedBy = "tipoChamado" , cascade = CascadeType.ALL)
    @JsonView({View.TipoServicoView.class})
    private List<Chamado> chamados;

}
