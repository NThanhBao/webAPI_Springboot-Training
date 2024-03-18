package com.example.demo.service.serviceImpl;

import com.example.demo.model.DTO.PostDTO;
import com.example.demo.model.entity.Posts;
import com.example.demo.model.entity.Role;
import com.example.demo.model.entity.Users;
import com.example.demo.repositories.PostsRepo;
import com.example.demo.repositories.UserDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostsService {

    private final PostsRepo postRepository;
    private final UserDao userDao;


    @Autowired
    public PostsService(PostsRepo postRepository, UserDao userDao) {
        this.postRepository = postRepository;
        this.userDao = userDao;
    }

    // Service
    public PostDTO savePost(PostDTO postDTO) {



//        Users role = userDao.findById(postDTO.getUserId()).orElse(null);
//        // Kiểm tra xem userId có tồn tại trong cơ sở dữ liệu của người dùng không
//        Optional<Users> userOptional = userDao.findById(userId);
//        if (userOptional.isEmpty()) {
//            throw new RuntimeException("User not found.");
//        }

        // Tạo đối tượng Post từ PostDTO
        Posts post = new Posts();
        BeanUtils.copyProperties(postDTO, post);

        // Lưu bài viết vào cơ sở dữ liệu
        Posts savedPost = postRepository.save(post);

        // Tạo DTO của bài viết đã được lưu
        PostDTO savedPostDTO = new PostDTO();
        BeanUtils.copyProperties(savedPost, savedPostDTO);
        post.setId(post.getId());
        return savedPostDTO;

    }

    public List<PostDTO> getAllPosts() {
        List<Posts> posts = postRepository.findAll();
        return posts.stream()
                .map(post -> {
                    PostDTO postDTO = new PostDTO();
                    BeanUtils.copyProperties(post, postDTO);
                    return postDTO;
                })
                .collect(Collectors.toList());
    }

    public Optional<PostDTO> getPostById(Long id) {
        Optional<Posts> postOptional = postRepository.findById(id);
        return postOptional.map(post -> {
            PostDTO postDTO = new PostDTO();
            BeanUtils.copyProperties(post, postDTO);
            return Optional.of(postDTO);
        }).orElse(Optional.empty());
    }

    public PostDTO updatePost(Long id, PostDTO updatedPostDTO) {
        Optional<Posts> existingPostOptional = postRepository.findById(id);
        if (existingPostOptional.isPresent()) {
            Posts existingPost = existingPostOptional.get();
            BeanUtils.copyProperties(updatedPostDTO, existingPost);
            Posts updatedPost = postRepository.save(existingPost);
            PostDTO updatedPostResponse = new PostDTO();
            BeanUtils.copyProperties(updatedPost, updatedPostResponse);
            return updatedPostResponse;
        } else {
            throw new RuntimeException("Post not found");
        }
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
