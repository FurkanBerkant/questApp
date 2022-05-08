package com.project.questDemo.business.concretes;

import com.project.questDemo.business.abstracts.UserService;
import com.project.questDemo.dataAccess.UserDao;
import com.project.questDemo.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserManager implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> getAll() {
        System.out.println("listelendi");
        return userDao.findAll();
    }

    @Override
    public User add(User user) {
        System.out.println("eklendi");
        return userDao.save(user);
    }

    @Override
    public User getOneUserById(int userId) {
        return userDao.findById(userId);
    }

    @Override
    public User updateOneUser(int userId, User newUser) {
        Optional<User> user = Optional.ofNullable(userDao.findById(userId));
        if (user.isPresent()) {
            User foundUser = user.get();
            foundUser.setUser_name(newUser.getUser_name());
            foundUser.setPassword(newUser.getPassword());
            userDao.save(foundUser);
            return foundUser;
        } else
            return null;
    }

    @Override
    public void deleteById(int userId) {
        userDao.deleteById(userId);
    }
}
