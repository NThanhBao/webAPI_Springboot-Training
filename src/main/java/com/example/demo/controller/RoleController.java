package com.example.demo.controller;

import com.example.demo.model.entity.Role;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
    // Endpoint để thêm role mới
    @PostMapping
    public ResponseEntity<Role> addRole(@RequestBody Map<String, String> requestData) {
        // Lấy role_id từ JSON gửi từ Postman
        String roleId = requestData.get("role_id");

        // Kiểm tra xem role_id có tồn tại không
        if (roleId == null) {
            return ResponseEntity.badRequest().body(null); // Trả về bad request nếu role_id là null
        }

        // Tạo một đối tượng Role từ role_id
        Role role = new Role();
        role.setId(Long.parseLong(roleId));

        // Lưu role vào cơ sở dữ liệu
        Role savedRole = roleService.save(role);

        // Trả về response với role đã lưu
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRole);
    }

    @GetMapping("/{roleName}")
    public ResponseEntity<Role> getRoleByName(@PathVariable String roleName) {
        Role role = roleService.findByRoleName(roleName);
        if (role != null) {
            return ResponseEntity.ok(role);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Các phương thức khác cho việc quản lý các yêu cầu liên quan đến Role có thể được thêm ở đây

}
