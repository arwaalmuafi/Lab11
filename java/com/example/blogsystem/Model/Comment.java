package com.example.blogsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    @NotNull(message = "User ID cannot be null")
    @Column(columnDefinition = "int")
    private Integer userId;

    @NotNull(message = "Post ID cannot be null")
    @Column(columnDefinition = "int ")
    private Integer postId;

    @NotEmpty(message = "Content cannot be empty")
    @Column(columnDefinition = "varchar(20)")
    private String content;

    @NotNull(message = "Comment date cannot be null")
    @Column
    private LocalDate commentDate;


    public Comment() {
    }

    public Comment(Integer userId, Integer postId, String content, LocalDate commentDate) {
        this.userId = userId;
        this.postId = postId;
        this.content = content;
        this.commentDate = commentDate;
    }


    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(LocalDate commentDate) {
        this.commentDate = commentDate;
    }
}
