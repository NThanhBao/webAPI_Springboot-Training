package com.example.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @JsonIgnore
    private String email;

    @Column
    @JsonIgnore
    private String phone;

//    @Column(nullable = false, unique = true)
    @Column(nullable = false)
    private String username;

    @Column
    @JsonIgnore
    private String password;

//    @Column
//    @JsonIgnore
//    private String token;

    @Column
    @JsonIgnore
    private String firstName;

    @Column
    @JsonIgnore
    private String lastName;

    @Column
    @JsonIgnore
    private String gender;

    @Column
    @JsonIgnore
    private Date birthDay;

    @Column
    @JsonIgnore
    private String adress;

    @Column
    @JsonIgnore
    private String job;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

//    public String getTitle() {
//        return getTitle();
//    }

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "role_id", nullable = false)
//    private Role role;



    // Constructors, getters, setters và các phương thức khác
}