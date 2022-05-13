package com.project.questDemo.business.concretes;

import com.project.questDemo.business.abstracts.LikeService;
import com.project.questDemo.config.dtoConverter.DtoConverterService;
import com.project.questDemo.dataAccess.LikeDao;
import com.project.questDemo.entities.Dto.LikeRequest;
import com.project.questDemo.entities.Dto.LikeResponse;
import com.project.questDemo.entities.concretes.Like;
import com.project.questDemo.entities.concretes.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeManager implements LikeService {

    @Autowired
    private LikeDao likeDao;

    @Autowired
    private DtoConverterService dtoConverterService;

    @Override
    public List<LikeResponse> getAll(Optional<Integer> likeId) {
        if (likeId.isPresent()){
            return dtoConverterService.dtoConverter(likeDao.findByUserId(likeId.get()),LikeResponse.class);
        }
        System.out.println("like'lar Listelendi");
        return dtoConverterService.dtoConverter(likeDao.findAll(),LikeResponse.class);
    }

    @Override
    public Like add(LikeRequest likeRequest) {
        return likeDao.save((Like) dtoConverterService.dtoClassConverter(likeRequest, Like.class));
    }

    @Override
    public Like getOneLikeById(int id) {
        return likeDao.findById(id);
    }

    @Override
    public Like updateOneLike(int likeId, Like newLike) {
        Optional<Like> like= Optional.ofNullable(likeDao.findById(likeId));
        if (like.isPresent()) {
            Like foundUser = like.get();
            foundUser.setUser(newLike.getUser());
            foundUser.setPost(newLike.getPost());
            likeDao.save(foundUser);
            return foundUser;
        } else
            return null;
    }

    @Override
    public void deleteById(int likeId) {

        likeDao.deleteById(likeId);
    }
}
