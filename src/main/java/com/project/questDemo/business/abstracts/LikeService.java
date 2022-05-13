package com.project.questDemo.business.abstracts;

import com.project.questDemo.entities.Dto.LikeRequest;
import com.project.questDemo.entities.Dto.LikeResponse;
import com.project.questDemo.entities.concretes.Like;

import java.util.List;
import java.util.Optional;

public interface LikeService {
    List<LikeResponse> getAll(Optional<Integer> userId);
    Like add(LikeRequest likeRequest);

    Like getOneLikeById(int id);
    Like updateOneLike(int likeId, Like newLike);

    void deleteById(int likeId);
}
