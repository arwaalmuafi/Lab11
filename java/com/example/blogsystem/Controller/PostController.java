package com.example.blogsystem.Controller;

import com.example.blogsystem.ApiResponse.ApiResponse;
import com.example.blogsystem.Model.Post;
import com.example.blogsystem.Service.PostService;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/v1/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/get")
    public ResponseEntity getAllPosts() {
        return ResponseEntity.status(200).body(postService.getAllPosts());
    }

    @PostMapping("/add/{id}")
    public ResponseEntity addPost(@PathVariable Integer id, @RequestBody @Valid Post post, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        postService.addPost(id, post);
        return ResponseEntity.status(200).body(new ApiResponse("Post added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updatePost(@PathVariable Integer id, @RequestBody @Valid Post post, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        postService.updatePost(id, post);
        return ResponseEntity.status(200).body(new ApiResponse("Post updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
        return ResponseEntity.status(200).body(new ApiResponse("Post deleted"));
    }

    @GetMapping("/get/post-id/{id}")
    public ResponseEntity getPostById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(postService.findPostById(id));
    }

    @GetMapping("/get/category-id/{id}")
    public ResponseEntity getPostsByCategoryId(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(postService.findPostsByCategoryId(id));
    }

    @GetMapping("/get/title/{title}")
    public ResponseEntity getPostsByTitle(@PathVariable String title) {
        return ResponseEntity.status(200).body(postService.findPostsByTitle(title));
    }

    @GetMapping("/get/user-id/{userId}")
    public ResponseEntity getPostsByUserId(@PathVariable Integer userId) {
        return ResponseEntity.status(200).body(postService.findAllPostsByUserId(userId));
    }
}
