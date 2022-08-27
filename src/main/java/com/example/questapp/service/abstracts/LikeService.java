package com.example.questapp.service.abstracts;

import com.example.questapp.model.Like;
import com.example.questapp.model.dto.LikeCreateRequest;
import com.example.questapp.model.dto.LikeResponse;

import java.util.List;
import java.util.Optional;

public interface LikeService {
    List<LikeResponse> getAllLikesWithParam(Optional<Long> userId, Optional<Long> postId);

    Like createOneLike(LikeCreateRequest request);

    Like getOneLikeById(Long likeId);

    void deleteOneLikeById(Long likeId);
}
