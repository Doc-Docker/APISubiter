package com.subiter.backend.APISubiterBackend.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 254)
    @NotEmpty(message = "O Campo nome é obrigatório");
    private String Servico_Descricao;

    @Column(nullable = false, length = 10)
    @NotEmpty(message = "Data de Inclusão é obrigatória");
    private DateTime Servico_Data_Inclusao;

    @Column(nullable = false, length = 10)
    @NotEmpty(message = "Data de Agendamento é obrigatória");
    private DateTime Servico_Data_Agendamento;

    @Column(nullable = false, length = 10)
    //@NotEmpty(message = "Data de Finalização obrigatória");
    private DateTime Servico_Data_Finalizacao;
}
