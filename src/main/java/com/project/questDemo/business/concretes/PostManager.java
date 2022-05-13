package com.project.questDemo.business.concretes;

import com.project.questDemo.business.abstracts.PostService;
import com.project.questDemo.config.dtoConverter.DtoConverterService;
import com.project.questDemo.dataAccess.PostDao;
import com.project.questDemo.dataAccess.UserDao;
import com.project.questDemo.entities.Dto.PostRequest;
import com.project.questDemo.entities.concretes.Post;
import com.project.questDemo.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostManager implements PostService {
    @Autowired
    private PostDao postDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private DtoConverterService dtoConverterService;
    @Override
    public List<Post> getAll(Optional<Integer> userId) {
        if (userId.isPresent()){
            return postDao.findByUserId(userId.get());
        }
        System.out.println("Post'lar Listelendi");
        return postDao.findAll();
    }

    @Override
    public Post add(PostRequest postRequest) {
        System.out.println("eklendi");

        return postDao.save((Post) dtoConverterService.dtoClassConverter(postRequest,Post.class));
    }

    @Override
    public Post getOnePostById(int postId) {
        return postDao.findById(postId);
    }

    @Override
    public Post updateOnePostById(int postId, PostRequest updatePost) {

        Optional<Post> post = Optional.ofNullable(postDao.findById(postId));
        if(post.isPresent()) {
            Post toUpdate = post.get();
            toUpdate.setText(updatePost.getText());
            toUpdate.setTitle(updatePost.getTitle());
            postDao.save(toUpdate);
            return toUpdate;
        }
        return null;
    }

    @Override
    public void deleteById(int postId) {
        postDao.deleteById(postId);
    }
}
