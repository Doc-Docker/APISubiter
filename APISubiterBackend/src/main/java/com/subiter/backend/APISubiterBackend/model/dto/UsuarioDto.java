package com.subiter.backend.APISubiterBackend.model.dto;

import java.io.Serializable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import com.subiter.backend.APISubiterBackend.model.entity.Empresa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty (message = "Required field" )
    private String name;

    @NotEmpty (message = "Required field" )
    @Email(message = "Invalid email")
    private String email;

    @NotEmpty(message = "Required field")
    private String password;

    private Empresa empresa;

}
