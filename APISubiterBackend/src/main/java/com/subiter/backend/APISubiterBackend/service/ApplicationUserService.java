package com.subiter.backend.APISubiterBackend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.subiter.backend.APISubiterBackend.model.dto.ApplicationUserDTO;
import com.subiter.backend.APISubiterBackend.model.entity.ApplicationUser;
import com.subiter.backend.APISubiterBackend.model.entity.Role;
import com.subiter.backend.APISubiterBackend.model.entity.Usuario;
import com.subiter.backend.APISubiterBackend.model.repository.ApplicationUserRepository;
import com.subiter.backend.APISubiterBackend.model.repository.RoleRepository;
import com.subiter.backend.APISubiterBackend.rest.exception.BadRequestException;
import com.subiter.backend.APISubiterBackend.rest.exception.ForbiddenException;
import com.subiter.backend.APISubiterBackend.rest.exception.NotAuthorizedException;
import com.subiter.backend.APISubiterBackend.rest.exception.ObjectNotFoundException;
import com.subiter.backend.APISubiterBackend.security.SecurityConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class ApplicationUserService{

    @Autowired
    private SecurityConfig securityConfig;

    private final ApplicationUserRepository applicationUserRepository;
    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    public ApplicationUserDTO saveApplicationUserAsAdmin(ApplicationUser applicationUser){
        log.info("{}", applicationUser);
        ApplicationUser applicationUserRegistered = applicationUserRepository.findByEmail(applicationUser.getEmail());
        log.info("{}", applicationUserRegistered);
        if((applicationUserRegistered != null)){
            throw new BadRequestException("Email " + applicationUser.getEmail() + " already registered");
        }
        applicationUser.setPassword(passwordEncoder.encode(applicationUser.getPassword()));
        Role role = roleRepository.findByName("ROLE_ADMIN");
        applicationUser.setRole(role);
        applicationUserRepository.save(applicationUser);
        return new ApplicationUserDTO(applicationUser);
    }

    public ApplicationUser saveApplicationUserAsUsuario(Usuario usuario, String password){
        ApplicationUser applicationUser = new ApplicationUser(null, usuario.getEmail(), usuario, password, new Role());
        applicationUser.setPassword(passwordEncoder.encode(applicationUser.getPassword()));
        Role role = roleRepository.findByName("ROLE_CLIENT");
        applicationUser.setRole(role);
        return applicationUserRepository.save(applicationUser);
    }

    public ApplicationUser saveApplicationUserAsSuporte(Usuario usuario, String password){
        ApplicationUser applicationUser = new ApplicationUser(null, usuario.getEmail(), usuario, password, new Role());
        applicationUser.setPassword(passwordEncoder.encode(applicationUser.getPassword()));
        Role role = roleRepository.findByName("ROLE_SUPORTE");
        applicationUser.setRole(role);
        return applicationUserRepository.save(applicationUser);
    }

    public Role saveRole(Role role){
        return roleRepository.save(role);
    }

    public void addRoleToApplicationUser(String email, String roleName){
        ApplicationUser applicationUser = applicationUserRepository.findByEmail(email);
        Role role = roleRepository.findByName(roleName);
        applicationUser.setRole(role);
    }

    public ApplicationUser getApplicationUser(String email){
        return applicationUserRepository.findByEmail(email);
    }

    public ApplicationUser getApplicationUserById(Integer id){
        String email = (String) securityConfig.authenticated();
        ApplicationUser applicationUser = applicationUserRepository.findByEmail(email);
        if(applicationUser == null || !(id.equals(applicationUser.getId()))){
            throw new ForbiddenException("Access Denied");
        }
        Optional<ApplicationUser> applicationUserOptional = applicationUserRepository.findById(id);
        if (applicationUserOptional.isEmpty()) {
            throw new ObjectNotFoundException("Admin not found! Id: " + id + ", Type: " + email);
        }
        return applicationUserOptional.get();
    }

    public List<ApplicationUserDTO> getApplicationUsers(){
        List<ApplicationUser> applicationUsers = applicationUserRepository.findAll();
        List<ApplicationUserDTO> applicationUserDTOs = applicationUsers.stream().map(applicationUser -> new ApplicationUserDTO(applicationUser)).collect(Collectors.toList());
        return applicationUserDTOs;
    }

    /** DELETE **/
    public void delete(Integer id) {
        String email = (String) securityConfig.authenticated();
        ApplicationUser applicationUser = applicationUserRepository.findByEmail(email);
        if(applicationUser == null || !(id.equals(applicationUser.getId()))){
            throw new ForbiddenException("Access Denied");
        }

        int countAdmin = 0;
        for(int i = 1; i <= applicationUserRepository.findAll().get(applicationUserRepository.findAll().size() - 1).getId(); i ++){
            if(applicationUserRepository.findById(i).isPresent()){
                log.info("User {} is present, email {}", applicationUserRepository.findById(i).get().getId(), applicationUserRepository.findById(i).get().getEmail());
                if(applicationUserRepository.findById(i).get().getRole().getName().contains("ROLE_ADMIN")){
                    countAdmin++;
                }
            }
        }
        log.info("Admins {}", countAdmin);
        if(countAdmin == 1){
            throw new NotAuthorizedException("It is not possible to remove the last admin from the system");
        }

        applicationUserRepository.deleteById(id);
    }

}