package com.example.blogsystem.Repository;

import com.example.blogsystem.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Integer> {

    Comment findCommentByCommentId(Integer commentId);

    Comment findCommentByUserId(Integer userId);

    Comment findCommentByPostId(Integer postId);

}
