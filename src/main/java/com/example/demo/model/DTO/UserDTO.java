package com.example.demo.model.DTO;

import java.util.Date;

public class UserDTO {
    private String username;
    private String password;
    private Long roleId;
    private String email;
    private String phone;
    private String adress;
    private String job;
    private Date birthDay;
    private String gender;
    private String lastName;
    private String firstName;


    public Long getRoleId() {
        return roleId;
    }

    public String getUsername() {return username;}

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAdress() {
        return adress;
    }

    public String getJob() {return job;}

    public Date getBirthDay() {return birthDay;}

    public String getFirstName() {return firstName;}

    public String getGender() {return gender;}

    public String getLastName() {return lastName;}


}