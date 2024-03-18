package com.example.demo.repositories;

import com.example.demo.model.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserDao extends CrudRepository<Users, Long> {
    Users findByUsername(String username);
//    Optional<Users> findById(Long id);

    Optional<Users> findById(Long id);
}
