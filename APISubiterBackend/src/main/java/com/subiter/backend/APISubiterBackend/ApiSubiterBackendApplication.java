package com.subiter.backend.APISubiterBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.subiter.backend.APISubiterBackend.model.repository")
public class ApiSubiterBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiSubiterBackendApplication.class, args);
    }
}
