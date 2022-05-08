package com.project.questDemo.business.abstracts;

import com.project.questDemo.entities.concretes.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User add(User user);

    User getOneUserById(int userId);

    User updateOneUser(int userId, User newUser);

    void deleteById(int userId);
}
