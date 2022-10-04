package com.subiter.backend.APISubiterBackend.model.entity;

import lombok.*;
import java.util.List;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;
import com.fasterxml.jackson.annotation.JsonView;
import com.subiter.backend.APISubiterBackend.config.View;

@Entity(name = "EMPRESA")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Empresa implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_empresa")
    @JsonView({View.EmpresaView.class, View.UsuarioView.class})
    private Integer id;
    
    @Column(name = "empresa_status")
    private Boolean status  = true; 

    @CNPJ(message = "CNPJ inválido")
    @NotEmpty(message = "O campo CNPJ é obrigatório")
    @Column(name = "cnpj_empresa")
    @JsonView({View.EmpresaView.class, View.UsuarioView.class})
    private String cnpj;

    @Column(name = "nome_empresa", nullable = false, length = 150)
    @NotEmpty(message = "O Campo nome é obrigatório")
    @JsonView({View.EmpresaView.class, View.UsuarioView.class})
    private String name;

    @Column(name = "endereco_empresa", nullable = false, length = 60)
    @NotEmpty(message = "O Campo endereço é obrigatório")
    private String endereco;

    @Column(name = "contato_empresa", nullable = false, length = 30)
    @NotEmpty(message = "O Campo contato é obrigatório")
    private String contato;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private List<Usuario> usuario;

    @OneToMany(mappedBy = "empresaServico", cascade = CascadeType.ALL)
    @JsonView({View.EmpresaView.class})
    private List<Servico> servicos;

    @OneToMany(mappedBy = "empresaInstalacao", cascade = CascadeType.ALL)
    @JsonView({View.EmpresaView.class})
    private List<Instalacao> instalacaos;
}
