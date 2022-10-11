package com.subiter.backend.APISubiterBackend.bootstrap;

import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

import com.subiter.backend.APISubiterBackend.model.entity.ApplicationUser;
import com.subiter.backend.APISubiterBackend.model.entity.Role;
import com.subiter.backend.APISubiterBackend.model.repository.RoleRepository;
import com.subiter.backend.APISubiterBackend.service.ApplicationUserService;

@Component
@NoArgsConstructor
public class Bootstrap implements CommandLineRunner {

    @Autowired
    public RoleRepository roleRepository;

    @Autowired
    public ApplicationUserService applicationUserService;
    @Override
    public void run(String... args) throws Exception {

        System.out.println("FUNCIONANDO");
        System.out.println("FUNCIONANDO");
        System.out.println("FUNCIONANDO");
        System.out.println("FUNCIONANDO");
        System.out.println("FUNCIONANDO");

        Role roleAdmin = new Role(null, "ROLE_ADMIN");
		Role roleClient = new Role(null, "ROLE_CLIENT");

		roleRepository.saveAll(Arrays.asList(roleClient, roleAdmin));

        ApplicationUser applicationUser = new ApplicationUser(null, "admin@gmail.com", null, "admin", new ArrayList<>());
        
        applicationUserService.saveApplicationUserAsAdmin(applicationUser);
    }
}