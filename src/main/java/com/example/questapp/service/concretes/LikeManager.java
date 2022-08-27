package com.example.questapp.service.concretes;

import com.example.questapp.config.dtoConverter.DtoConverter;
import com.example.questapp.config.dtoConverter.DtoConverterService;
import com.example.questapp.model.Like;
import com.example.questapp.model.Post;
import com.example.questapp.model.User;
import com.example.questapp.model.dto.LikeCreateRequest;
import com.example.questapp.model.dto.LikeResponse;
import com.example.questapp.repository.LikeRepository;
import com.example.questapp.service.abstracts.LikeService;
import com.example.questapp.service.abstracts.PostService;
import com.example.questapp.service.abstracts.UserService;
import lombok.AllArgsConstructor;
import lombok.experimental.StandardException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LikeManager implements LikeService {
    private LikeRepository likeRepository;
    private UserService userService;
    private PostService postService;
    private DtoConverterService dtoConverterService;
    @Override
    public List<LikeResponse> getAllLikesWithParam(Optional<Long> userId, Optional<Long> postId) {
        List<Like> list;
        if(userId.isPresent() && postId.isPresent()) {
            list = likeRepository.findByUserIdAndPostId(userId.get(), postId.get());
        }else if(userId.isPresent()) {
            list = likeRepository.findByUserId(userId.get());
        }else if(postId.isPresent()) {
            list = likeRepository.findByPostId(postId.get());
        }else
            list = likeRepository.findAll();
        return dtoConverterService.dtoConverter(list,LikeResponse.class);//Kontrol Edilecek
    }

    @Override
    public Like createOneLike(LikeCreateRequest request) {
        User user = userService.getOneUserById(request.getUserId());
        Post post = postService.getOnePostById(request.getPostId());
        if(user != null && post != null) {
            Like likeToSave = new Like();
            likeToSave.setId(request.getId());
            likeToSave.setPost(post);
            likeToSave.setUser(user);
            return likeRepository.save(likeToSave);
        }else
            return null;
    }

    @Override
    public Like getOneLikeById(Long likeId) {
        return likeRepository.findById(likeId).orElse(null);

    }

    @Override
    public void deleteOneLikeById(Long likeId) {
        likeRepository.deleteById(likeId);

    }
}
