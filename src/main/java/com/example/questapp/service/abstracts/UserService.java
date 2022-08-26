package com.example.questapp.service.abstracts;

import com.example.questapp.model.User;

import java.util.List;


public interface UserService {
    List<User> getAll();
    User add(User user);

    User getOneUserById(Long userId);

    User updateOneUser(Long userId, User newUser);

    void deleteById(Long userId);
}
