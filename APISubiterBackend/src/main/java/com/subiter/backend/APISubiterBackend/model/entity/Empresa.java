package com.subiter.backend.APISubiterBackend.model.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CNPJ(message = "CNPJ inválido")
    @NotEmpty(message = "O campo CNPJ é obrigatório")
    private String cnpj;

    @Column(nullable = false, length = 150)
    @NotEmpty(message = "O Campo nome é obrigatório")
    private String name;

    @Column(nullable = false, length = 60)
    @NotEmpty(message = "O Campo endereço é obrigatório")
    private String endereco;

    @Column(nullable = false, length = 30)
    @NotEmpty(message = "O Campo contato é obrigatório")
    private String contato;
    
}
