package com.example.demo.service;

import com.example.demo.model.entity.Role;
import com.example.demo.model.entity.Role.RoleType;
import com.example.demo.repositories.RoleRepo;
import com.example.demo.service.serviceImpl.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final RoleRepo roleRepository;

    @Autowired
    public DataInitializer(RoleRepo roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Bean
    public void initializeData() {
        initializeRoles();
    }

    private void initializeRoles() {
        if (roleRepository.findByRoleName(RoleType.ROLE_ADMIN) == null) {
            Role adminRole = new Role();
            adminRole.setRoleName(RoleType.ROLE_ADMIN);
            roleRepository.save(adminRole);
        }
        if (roleRepository.findByRoleName(RoleType.ROLE_USER) == null) {
            Role userRole = new Role();
            userRole.setRoleName(RoleType.ROLE_USER);
            roleRepository.save(userRole);
        }



    }
}
