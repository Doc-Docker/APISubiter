package com.subiter.backend.APISubiterBackend.model.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity(name = "TIPO_SERVICO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tipo_servico_nome", nullable = false, length = 254)
    @NotEmpty(message = "O Tipo de Serviço é obrigatório")
    private String nome;

    @Column(name = "tipo_servico_descricao", nullable = false, length = 254)
    @NotEmpty(message = "Descrição do Serviço é obrigatório")
    private String descricao;

}
