package com.project.questDemo.dataAccess;

import com.project.questDemo.entities.concretes.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeDao extends JpaRepository<Like, Integer> {

    Like findById(int id);

    List<Like> findByUserId(Integer userId);

    List<Like> findByPostId(Integer postId);
}
