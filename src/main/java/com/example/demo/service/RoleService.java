package com.example.demo.service;

import com.example.demo.model.entity.Role;

public interface RoleService {
    Role save(Role role);
    Role findByRoleName(String roleName);
//    Role findById(Long id); // Thêm phương thức findById
}
