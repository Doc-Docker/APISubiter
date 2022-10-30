package com.subiter.backend.APISubiterBackend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;
import com.subiter.backend.APISubiterBackend.model.entity.ApplicationUser;
import com.subiter.backend.APISubiterBackend.model.entity.Role;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationUserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty (message = "Required field")
    private String email;

    private Integer usertId;

    private Role role;

    public ApplicationUserDTO (ApplicationUser applicationUser){
        id = applicationUser.getId();
        email = applicationUser.getEmail();
        if(applicationUser.getUsuario() == null){
            usertId = null;
        }else{
            usertId = applicationUser.getUsuario().getId();
        }
        role = applicationUser.getRole();
    }
}