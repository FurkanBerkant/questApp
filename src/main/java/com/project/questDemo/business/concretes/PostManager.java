package com.project.questDemo.business.concretes;

import com.project.questDemo.business.abstracts.PostService;
import com.project.questDemo.dataAccess.PostDao;
import com.project.questDemo.entities.Dto.PostRequest;
import com.project.questDemo.entities.concretes.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostManager implements PostService {
    @Autowired
    private PostDao postDao;
    @Override
    public List<Post> getAll(Optional<Integer> userId) {
        if (userId.isPresent()){
            return postDao.findByUserId(userId.get());
        }
        System.out.println("Post'lar Listelendi");
        return postDao.findAll();
    }

    @Override
    public PostRequest add(PostRequest postRequest) {
        System.out.println("eklendi");

        return postDao.save(postRequest);
    }

    @Override
    public Post getOnePostById(int id) {
        return postDao.findById(id);
    }

    @Override
    public Post updateOnePost(int postId, Post newPost) {
        Optional<Post> post = Optional.ofNullable(postDao.findById(postId));
        if (post.isPresent()) {
            Post foundUser = post.get();
            foundUser.setText(newPost.getText());
            foundUser.setTitle(newPost.getTitle());
            postDao.save(foundUser);
            return foundUser;
        } else
            return null;
    }

    @Override
    public void deleteById(int postId) {
        postDao.deleteById(postId);
    }
}
