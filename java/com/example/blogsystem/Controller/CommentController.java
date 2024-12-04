package com.example.blogsystem.Controller;

import com.example.blogsystem.ApiResponse.ApiResponse;
import com.example.blogsystem.Model.Comment;
import com.example.blogsystem.Service.CommentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/get")
    public ResponseEntity getAllComments() {
        return ResponseEntity.status(200).body(commentService.getAllComments());
    }

    @PostMapping("/add")
    public ResponseEntity addComment(@RequestBody @Valid Comment comment, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        commentService.addComment(comment);
        return ResponseEntity.status(200).body(new ApiResponse("comment is added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateComment(@PathVariable Integer id, @RequestBody @Valid Comment comment, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        commentService.updateComment(id, comment);
        return ResponseEntity.status(200).body(new ApiResponse("comment updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteComment(@PathVariable Integer id) {
        commentService.deleteComment(id);
        return ResponseEntity.status(200).body(new ApiResponse("Comment deleted"));
    }

    @GetMapping("/get/comment-id/{id}")
    public ResponseEntity getCommentById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(commentService.findCommentByCommentId(id));
    }

    @GetMapping("/get/user-id/{userId}")
    public ResponseEntity getCommentByUserId(@PathVariable Integer userId) {
        return ResponseEntity.status(200).body(commentService.findCommentByUserId(userId));
    }

    @GetMapping("/get/post-id/{postId}")
    public ResponseEntity getCommentByPostId(@PathVariable Integer postId) {
        return ResponseEntity.status(200).body(commentService.findCommentByPostId(postId));
    }
}
