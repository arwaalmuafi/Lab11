package com.example.blogsystem.Service;

import com.example.blogsystem.ApiResponse.ApiException;
import com.example.blogsystem.Model.Comment;
import com.example.blogsystem.Repository.CommentRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }

    public void updateComment(Integer commentId, Comment comment) {
        Comment oldComment = commentRepository.findCommentByCommentId(commentId);

        if (oldComment == null) {
            throw new ApiException("Comment not found");
        }

        oldComment.setContent(comment.getContent());
        oldComment.setCommentDate(comment.getCommentDate());
        commentRepository.save(oldComment);
    }

    public void deleteComment(Integer commentId) {
        Comment comment = commentRepository.findCommentByCommentId(commentId);
        if (comment == null) {
            throw new ApiException("Comment not found");
        }
        commentRepository.delete(comment);
    }


    //10
    public Comment findCommentByCommentId(Integer commentId) {
        Comment comment = commentRepository.findCommentByCommentId(commentId);
        if (comment == null) {
            throw new ApiException("Comment not found");
        }

        return comment;
    }

    //11
    public Comment findCommentByUserId(Integer userId) {
        Comment comment = commentRepository.findCommentByUserId(userId);
        if (comment == null) {
            throw new ApiException("Comment not found");
        }

        return comment;
    }

    //12
    public Comment findCommentByPostId(Integer postId) {
        Comment comment = commentRepository.findCommentByPostId(postId);
        if (comment == null) {
            throw new ApiException("Comment not found");
        }

        return comment;
    }
}
