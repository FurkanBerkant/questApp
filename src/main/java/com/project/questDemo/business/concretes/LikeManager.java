package com.project.questDemo.business.concretes;

import com.project.questDemo.business.abstracts.LikeService;
import com.project.questDemo.dataAccess.LikeDao;
import com.project.questDemo.entities.concretes.Like;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeManager implements LikeService {

    @Autowired
    private LikeDao likeDao;


    @Override
    public List<Like> getAll(Optional<Integer> likeId) {
        if (likeId.isPresent()){
            return likeDao.findByUserId(likeId.get());
        }
        System.out.println("like'lar Listelendi");
        return likeDao.findAll();
    }

    @Override
    public Like add(Like like) {
        return likeDao.save(like);
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
