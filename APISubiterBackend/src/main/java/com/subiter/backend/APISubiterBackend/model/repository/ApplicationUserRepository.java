package com.subiter.backend.APISubiterBackend.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.subiter.backend.APISubiterBackend.model.entity.ApplicationUser;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Integer> {
    ApplicationUser findByEmail(String email);
}
