package com.subiter.backend.APISubiterBackend.model.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.subiter.backend.APISubiterBackend.config.View;

import java.io.Serializable;
import java.util.List;

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
    @JsonView({View.UsuarioView.class, View.ChamadoView.class, View.EmpresaView.class})
    private Integer id;

    @Column(name = "nome_usuario",nullable = false, length = 150)
    @NotEmpty(message = "O Campo nome é obrigatório")
    @JsonView({View.UsuarioView.class, View.ChamadoView.class, View.EmpresaView.class})
    private String name;

    // private String tipo_user;
    @Column(unique = true)
    private String email;

    @JsonManagedReference
    @OneToOne(mappedBy = "usuario")
    private ApplicationUser applicationUser;

    // private String senha_usuario;

    @JoinColumn(name="codigo_empresa")
    @ManyToOne()
    @JsonView({View.UsuarioView.class})
    private Empresa empresa;

    @OneToMany(mappedBy = "usuarioChamado", cascade = CascadeType.ALL)
    @JsonView({View.UsuarioView.class})
    private List<Chamado> chamados;
    
}
