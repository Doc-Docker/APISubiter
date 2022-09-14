package com.subiter.backend.APISubiterBackend.model.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "TIPO_SERVICO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_servico_codigo")
    private Integer id;

    @Column(name = "tipo_servico_nome", nullable = false, length = 20)
    @NotEmpty(message = "O nome do serviço é obrigatório")
    private String nome;

    @Column(name = "tipo_servico_descricao", nullable = false, length = 40)
    private String descricao;

    @OneToOne(mappedBy = "tipoServico")
    @JsonIgnore
    private Servico servico;

}
