package com.subiter.backend.APISubiterBackend.model.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity(name = "USUARIO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_usuario")
    private Integer id;

    @Column(name = "nome_usuario",nullable = false, length = 150)
    @NotEmpty(message = "O Campo nome é obrigatório")
    private String name;

    // private String tipo_user;

    // private String senha_usuario;

    @JoinColumn(name="codigo_empresa")
    @ManyToOne()
    private Empresa empresa;
    
}
