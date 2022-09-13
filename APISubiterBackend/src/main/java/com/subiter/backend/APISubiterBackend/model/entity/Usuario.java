package com.subiter.backend.APISubiterBackend.model.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    @NotEmpty(message = "O Campo nome é obrigatório")
    private String name;

    // private String tipo_user;

    // private String senha_usuario;

    // private Integer empresa
    
}
