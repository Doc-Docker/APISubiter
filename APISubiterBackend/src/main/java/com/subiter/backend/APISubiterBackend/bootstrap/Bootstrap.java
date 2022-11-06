package com.subiter.backend.APISubiterBackend.bootstrap;

import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

import com.subiter.backend.APISubiterBackend.model.entity.ApplicationUser;
import com.subiter.backend.APISubiterBackend.model.entity.Empresa;
import com.subiter.backend.APISubiterBackend.model.entity.Role;
import com.subiter.backend.APISubiterBackend.model.repository.RoleRepository;
import com.subiter.backend.APISubiterBackend.service.ApplicationUserService;
import com.subiter.backend.APISubiterBackend.service.EmpresaService;

@Component
@NoArgsConstructor
public class Bootstrap implements CommandLineRunner {

    @Autowired
    public RoleRepository roleRepository;

    @Autowired
    EmpresaService empresaService;

    @Autowired
    public ApplicationUserService applicationUserService;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("FUNCIONANDO");
        System.out.println("FUNCIONANDO");
        System.out.println("FUNCIONANDO");
        System.out.println("FUNCIONANDO");
        System.out.println("FUNCIONANDO");

        // Role roleAdmin = new Role(null, "ROLE_ADMIN");
        // Role roleClient = new Role(null, "ROLE_CLIENT");
        // Role roleSuporte = new Role(null, "ROLE_SUPORTE");

        // roleRepository.saveAll(Arrays.asList(roleClient, roleAdmin, roleSuporte));

        // ApplicationUser applicationUser = new ApplicationUser(null, "admin@gmail.com", null, "admin", new Role());

        // applicationUserService.saveApplicationUserAsAdmin(applicationUser);

        // Empresa empresa = new Empresa();
        // empresa.setCnpj("44999681000119");
        // empresa.setName("Subter");
        // empresa.setEndereco("Rua olinda");
        // empresa.setContato("33223342");

        // empresaService.save(empresa);
    }
}