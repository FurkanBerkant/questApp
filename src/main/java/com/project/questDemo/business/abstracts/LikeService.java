package com.project.questDemo.business.abstracts;

import com.project.questDemo.entities.concretes.Like;

import java.util.List;
import java.util.Optional;

public interface LikeService {
    List<Like> getAll(Optional<Integer> userId);
    Like add(Like like);

    Like getOneLikeById(int id);
    Like updateOneLike(int likeId, Like newLike);

    void deleteById(int likeId);
}
