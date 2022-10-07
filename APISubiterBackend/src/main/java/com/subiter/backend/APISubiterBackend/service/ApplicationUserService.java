package com.subiter.backend.APISubiterBackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.subiter.backend.APISubiterBackend.model.entity.ApplicationUser;
import com.subiter.backend.APISubiterBackend.model.entity.Role;
import com.subiter.backend.APISubiterBackend.model.entity.Usuario;
import com.subiter.backend.APISubiterBackend.model.repository.ApplicationUserRepository;
import com.subiter.backend.APISubiterBackend.model.repository.RoleRepository;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class ApplicationUserService {

    private final ApplicationUserRepository applicationUserRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public ApplicationUser saveApplicationUser(ApplicationUser applicationUser){
        applicationUser.setPassword(passwordEncoder.encode(applicationUser.getPassword()));
        return applicationUserRepository.save(applicationUser);
    }

    public ApplicationUser saveApplicationUserAsUsuario(Usuario usuario, String password){
        ApplicationUser applicationUser = new ApplicationUser(null, usuario.getEmail(), usuario, password, new ArrayList<>());
        applicationUser.setPassword(passwordEncoder.encode(applicationUser.getPassword()));
        Role role = roleRepository.findByName("ROLE_CLIENT");
        applicationUser.getRoles().add(role);
        return applicationUserRepository.save(applicationUser);
    }

    public Role saveRole(Role role){
        return roleRepository.save(role);
    }
    public void addRoleToApplicationUser(String email, String roleName){
        ApplicationUser applicationUser = applicationUserRepository.findByEmail(email);
        Role role = roleRepository.findByName(roleName);
        applicationUser.getRoles().add(role);
    }

    public ApplicationUser getApplicationUser(String email){
        return applicationUserRepository.findByEmail(email);
    }
    
    public List<ApplicationUser> getApplicationUsers(){
        return applicationUserRepository.findAll();
    }
}