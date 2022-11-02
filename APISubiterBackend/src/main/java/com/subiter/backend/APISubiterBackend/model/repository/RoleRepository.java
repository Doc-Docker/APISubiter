package com.subiter.backend.APISubiterBackend.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.subiter.backend.APISubiterBackend.model.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}