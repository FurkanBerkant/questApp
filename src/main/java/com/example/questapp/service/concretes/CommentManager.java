package com.example.questapp.service.concretes;

import com.example.questapp.config.dtoConverter.DtoConverterService;
import com.example.questapp.model.Comment;
import com.example.questapp.model.Post;
import com.example.questapp.model.dto.CommentCreateRequest;
import com.example.questapp.model.dto.CommentResponse;
import com.example.questapp.repository.CommentRepository;
import com.example.questapp.service.abstracts.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class CommentManager implements CommentService {
    private CommentRepository commentRepository;
    private DtoConverterService dtoConverterService;
    @Override
    public List<CommentResponse> getAllCommentWithParam(Optional<Long> userId, Optional<Long> postId) {
        List<Comment> comments;
        if(userId.isPresent() && postId.isPresent()) {
            comments = commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
        }else if(userId.isPresent()) {
            comments = commentRepository.findByUserId(userId.get());
        }else if(postId.isPresent()) {
            comments = commentRepository.findByPostId(postId.get());
        }else
            comments = commentRepository.findAll();
        return dtoConverterService.dtoConverter(comments, CommentResponse.class);
    }

    @Override
    public Comment createComment(CommentCreateRequest commentCreateRequest) {
        return commentRepository.save((Comment) dtoConverterService.
                dtoClassConverter(commentCreateRequest, Comment.class));
    }

    @Override
    public Comment getOneComment(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    @Override
    public Comment updateComment(Long commentId, CommentCreateRequest commentCreateRequest) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (comment.isPresent()) {
            Comment foundPost = comment.get();
            foundPost.setText(commentCreateRequest.getText());
            commentRepository.save(foundPost);
            return foundPost;
        }else {
            return null;
        }
    }

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
