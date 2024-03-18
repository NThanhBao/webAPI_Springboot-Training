package com.example.demo.repositories;

import com.example.demo.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.entity.Posts;

import java.util.Optional;

/**
 * Repository interface for Product entity.
 */
@Repository
public interface PostsRepo extends JpaRepository<Posts, Long> {

}