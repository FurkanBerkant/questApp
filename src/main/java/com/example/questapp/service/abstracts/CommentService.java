package com.example.questapp.service.abstracts;

import com.example.questapp.model.Comment;
import com.example.questapp.model.dto.CommentCreateRequest;
import com.example.questapp.model.dto.CommentResponse;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<CommentResponse> getAllCommentWithParam(Optional<Long> userId, Optional<Long> postId);

    Comment createComment(CommentCreateRequest commentCreateRequest);

    Comment getOneComment(Long commentId);

    Comment updateComment(Long commentId, CommentCreateRequest commentCreateRequest);

    void deleteComment(Long commentId);

}
