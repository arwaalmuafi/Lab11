package com.example.blogsystem.Repository;

import com.example.blogsystem.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {

    Post findPostByPostId(Integer postId);
    List<Post> findPostByCategoryId(Integer categoryId );
    Post findPostByTitle(String title);
    List<Post> findAllByUserId(Integer userId);
}
