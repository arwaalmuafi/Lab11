package com.example.blogsystem.Service;

import com.example.blogsystem.ApiResponse.ApiException;
import com.example.blogsystem.Model.Post;
import com.example.blogsystem.Repository.PostRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }


    public void addPost(Integer id, Post post) {
        boolean isExisting=postRepository.existsById(id);
        if(isExisting){
            throw new ApiException("post is already added");
        }
        postRepository.save(post);
    }

    public void updatePost(Integer postId, Post post) {
        Post existingPost = postRepository.findPostByPostId(postId);
        if (existingPost == null) {
            throw new ApiException("Post not found");
        }

        existingPost.setCategoryId(post.getCategoryId());
        existingPost.setTitle(post.getTitle());
        existingPost.setContent(post.getContent());
        existingPost.setUserId(post.getUserId());
        existingPost.setPublishDate(post.getPublishDate());
        postRepository.save(existingPost);
    }

    public void deletePost(Integer postId) {
        Post post = postRepository.findPostByPostId(postId);
        if (post == null) {
            throw new ApiException("Post not found");
        }
        postRepository.delete(post);
    }


    //6
    public Post findPostById(Integer postId) {
        Post post = postRepository.findPostByPostId(postId);
        if (post == null) {
            throw new ApiException("Post not found");
        }
        return post;
    }


    //7
    public List<Post> findPostsByCategoryId(Integer categoryId) {
        List<Post> posts = postRepository.findPostByCategoryId(categoryId);
        if (posts==null) {
            throw new ApiException("No posts found for the given category");
        }
        return posts;
    }

    //8
    public Post findPostsByTitle(String title) {
        Post posts = postRepository.findPostByTitle(title);
        if (posts==null) {
            throw new ApiException("No posts found with the given title");
        }
        return posts;
    }


    //9
    public List<Post> findAllPostsByUserId(Integer userId) {
        List<Post> posts = postRepository.findAllByUserId(userId);
        if (posts==null) {
            throw new ApiException("No posts found for the given user");
        }
        return posts;
    }
}