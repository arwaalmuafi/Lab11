package com.example.blogsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @NotNull(message = "Category ID cannot be null")
    @Column
    private Integer categoryId;

    @NotNull(message = "Title cannot be null")
    @Size(min = 5, message = "Title must be between 5 and 100 characters")
    @Column
    private String title;

    @NotNull(message = "Content cannot be null")
    @Size(min = 10, message = "Content must be at least 10 characters long")
    @Column
    private String content;

    @NotNull(message = "User ID cannot be null")
    @Column
    private Integer userId;

    @NotNull(message = "Publish date cannot be null")
    @Column
    private LocalDate publishDate;

    public Post() {
    }
    public Post(Integer categoryId, String title, String content, Integer userId, LocalDate publishDate) {
        this.categoryId = categoryId;
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.publishDate = publishDate;
    }
    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }
}
