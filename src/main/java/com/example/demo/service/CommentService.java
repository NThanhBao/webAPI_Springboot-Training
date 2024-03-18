package com.example.demo.service;

import com.example.demo.model.DTO.CommentDTO;

import java.util.List;

public interface CommentService {

    CommentDTO createComment(CommentDTO commentDTO);

    CommentDTO findById(Long id);

    List<CommentDTO> findAll();

    CommentDTO updateComment(Long id, CommentDTO commentDTO);

    void deleteById(Long id);
}
