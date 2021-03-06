package com.project.questDemo.controllers;


import com.project.questDemo.business.abstracts.LikeService;
import com.project.questDemo.entities.Dto.LikeRequest;
import com.project.questDemo.entities.Dto.LikeResponse;
import com.project.questDemo.entities.concretes.Like;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/like")
public class LikeControllers {

    @Autowired
    private LikeService likeService;

    @GetMapping("/getAll")
    public ResponseEntity<List<LikeResponse>> getAll(@RequestParam Optional<Integer> likeId){
        return ResponseEntity.ok(likeService.getAll(likeId));
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody LikeRequest likeRequest){
        return ResponseEntity.ok(likeService.add(likeRequest));
    }
    @GetMapping("/{likeId}")
    public Like getOneLike (@PathVariable int likeId){
        return likeService.getOneLikeById(likeId);
    }
    @PutMapping("/{likeId}")
    public Like updateOneLike(@PathVariable int likeId,
                              @RequestBody Like newLike)
    {
        return likeService.updateOneLike(likeId,newLike);
    }
    @DeleteMapping("/{likeId}")
    public void deleteOneUser(@PathVariable int likeId) {
        likeService.deleteById(likeId);
    }
}
