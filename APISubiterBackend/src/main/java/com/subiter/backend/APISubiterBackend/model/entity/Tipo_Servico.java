package com.subiter.backend.APISubiterBackend.model.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tipo_Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 254)
    @NotEmpty(message = "O Tipo de Serviço é obrigatório")
    private String tipo_Servico_Nome;

    @Column(nullable = false, length = 254)
    @NotEmpty(message = "Descrição do Serviço é obrigatório")
    private String tipo_Servico_Descricao;

}
