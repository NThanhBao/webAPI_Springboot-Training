package com.example.demo.controller;

import com.example.demo.model.DTO.PostDTO;
import com.example.demo.model.entity.Posts;
import com.example.demo.service.serviceImpl.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class PostsController {

    private final PostsService postsService;


    @Autowired
    public PostsController(PostsService productService) {
        this.postsService = productService;
    }

    @PostMapping("/posts")
  //  @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PostDTO> savePost(@RequestBody PostDTO postDTO) {
        PostDTO savedPost = postsService.savePost(postDTO);
        return ResponseEntity.ok(savedPost);
    }
    @GetMapping("/posts")
    public ResponseEntity<List<PostDTO>> getAllPosts() {
        List<PostDTO> posts = postsService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable Long id) {
        return postsService.getPostById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/posts/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PostDTO> updatePost(@PathVariable Long id, @RequestBody PostDTO updatedPostDTO) {
        PostDTO updatedPost = postsService.updatePost(id, updatedPostDTO);
        return ResponseEntity.ok(updatedPost);
    }

    @DeleteMapping("/posts/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deletePost(@PathVariable Long id) {
        postsService.deletePost(id);
        return ResponseEntity.ok("Post deleted successfully");
    }
}