package com.example.demo.model.entity;

import org.springframework.data.annotation.Id;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_name")
    private RoleType roleName;

    @OneToMany(mappedBy = "role")
    private Set<Users> users;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public enum RoleType {
        ROLE_ADMIN(1),
        ROLE_USER(2);

        private final int id;

        RoleType(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }
    // Constructors, getters, and setters

    public String getRoleName() {
        return roleName.name();
    }


    public void setRoleName(RoleType roleName) {
        this.roleName = roleName;
    }

}
