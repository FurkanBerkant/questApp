package com.example.questapp.controllers;

import com.example.questapp.model.Comment;
import com.example.questapp.model.dto.CommentCreateRequest;
import com.example.questapp.model.dto.CommentResponse;
import com.example.questapp.repository.CommentRepository;
import com.example.questapp.service.abstracts.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
@AllArgsConstructor
public class CommentController {
    private CommentService commentService;

    @GetMapping
    public ResponseEntity<List<CommentResponse>> getAllComments(@RequestParam Optional<Long> userId,
                                                                @RequestParam Optional<Long> postId){
        return new ResponseEntity<>(commentService.getAllCommentWithParam(userId,postId), HttpStatus.OK);
    }
    @GetMapping("/{commentId}")
    public ResponseEntity<Comment> getOneComment(@PathVariable Long commentId){
        return new ResponseEntity<>(commentService.getOneComment(commentId),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody CommentCreateRequest commentCreateRequest){
        return new ResponseEntity<>(commentService.createComment(commentCreateRequest),HttpStatus.CREATED);
    }
    @PutMapping("/{commentId}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long commentId,@RequestBody CommentCreateRequest commentCreateRequest){
        return new ResponseEntity<>(commentService.updateComment(commentId,commentCreateRequest),HttpStatus.OK);
    }
    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId){
        commentService.deleteComment(commentId);;
        return new ResponseEntity<>(HttpStatus.OK) ;
    }




}
