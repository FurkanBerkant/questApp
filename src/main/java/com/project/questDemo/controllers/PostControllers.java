package com.project.questDemo.controllers;

import com.project.questDemo.business.abstracts.PostService;
import com.project.questDemo.entities.Dto.PostRequest;
import com.project.questDemo.entities.Dto.PostResponse;
import com.project.questDemo.entities.concretes.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post")
public class PostControllers {
    @Autowired
    private PostService postService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Post>> getAll(@RequestParam Optional<Integer> userId){
        return ResponseEntity.ok(postService.getAll(userId));
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody PostRequest postRequest){
        return ResponseEntity.ok(postService.add(postRequest));
    }
    @GetMapping("/{postId}")
    public Post getOnePost (@PathVariable int postId){
        return postService.getOnePostById(postId);
    }
    @PutMapping("/{postId}")
    public Post updateOneUser(@PathVariable int postId,
                              @RequestBody PostRequest updatePost)
    {
        return postService.updateOnePostById(postId,updatePost);
    }
    @DeleteMapping("/{postId}")
    public void deleteOneUser(@PathVariable int postId) {
        postService.deleteById(postId);
    }
}
