package com.example.demo.service.serviceImpl;

import com.example.demo.model.entity.Role;
import com.example.demo.repositories.RoleRepo;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepo roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepo roleRepository) {
        this.roleRepository = roleRepository;
    }
    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }
    @Override
    public Role findByRoleName(String roleName) {
        return roleRepository.findByRoleName(Role.RoleType.valueOf(roleName));
    }


    // Các phương thức khác cần thiết cho nghiệp vụ liên quan đến Role có thể được triển khai ở đây

}
