package com.example.demo.model.DTO;

import com.example.demo.model.entity.Users;

public class UserDTO {
    private String username;
    private String password;
    private Long roleId;


    public Long getRoleId() {
        return roleId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


}
