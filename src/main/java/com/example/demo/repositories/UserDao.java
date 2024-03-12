package com.example.demo.repositories;

import com.example.demo.model.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserDao extends CrudRepository<Users, Integer> {

    Users findByUsername(String username);
}