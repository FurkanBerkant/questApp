package com.project.questDemo.dataAccess;

import com.project.questDemo.entities.Dto.PostRequest;
import com.project.questDemo.entities.concretes.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostDao extends JpaRepository<Post, Integer> {
    Post findById(int id);

    List<Post> findByUserId(Integer userId);
}
