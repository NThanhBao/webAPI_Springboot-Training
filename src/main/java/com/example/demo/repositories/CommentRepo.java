package com.example.demo.repositories;

import com.example.demo.model.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentRepo extends JpaRepository<Posts, Long> {

}