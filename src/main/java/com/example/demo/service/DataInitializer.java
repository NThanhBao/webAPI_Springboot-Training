package com.example.demo.service;

import com.example.demo.model.entity.Role;
import com.example.demo.model.entity.Role.RoleType;
import com.example.demo.model.entity.Users;
import com.example.demo.repositories.RoleRepo;
import com.example.demo.repositories.UserDao;
import com.example.demo.service.serviceImpl.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {


    private final RoleRepo roleRepository;
    private final UserDao userDao;
    private final BCryptPasswordEncoder bcryptEncoder;

    @Autowired
    public DataInitializer(RoleRepo roleRepository, UserDao userDao, BCryptPasswordEncoder bcryptEncoder) {
        this.roleRepository = roleRepository;
        this.userDao = userDao;
        this.bcryptEncoder = bcryptEncoder;
    }

    @PostConstruct
    public void initializeData() {
        initializeRoles();
        createAdminUser();
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
    private void createAdminUser() {
        // Kiểm tra xem người dùng "admin" đã tồn tại hay chưa
        String adminUsername = "admin";
        if (userDao.findByUsername(adminUsername) == null) {
            // Lấy vai trò "admin" từ cơ sở dữ liệu
            Role adminRole = roleRepository.findByRoleName(Role.RoleType.ROLE_ADMIN);
            if (adminRole == null) {
                throw new RuntimeException("khong the tao tai khoan admin vi 'Role admin' chua duoc khoi tao. ");
            }
            // Tạo người dùng mới có vai trò "admin" và idRole là 1
            Users adminUser = new Users();
            adminUser.setUsername(adminUsername);
            adminUser.setPassword(bcryptEncoder.encode("admin")); // Thay đổi thành mật khẩu thực tế
            adminUser.setRole(adminRole);
            userDao.save(adminUser);
        }
    }
}
