package com.example.questapp.service.concretes;

import com.example.questapp.model.User;
import com.example.questapp.repository.UserRepository;
import com.example.questapp.service.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
    private UserRepository userRepository;
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }
    @Override
    public User getOneUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User updateOneUser(Long userId, User newUser) {
        Optional<User> user = Optional.ofNullable(userRepository.getOneUserById(userId));
        if (user.isPresent()) {
            User foundUser = user.get();
            foundUser.setUserName(newUser.getUserName());
            foundUser.setPassword(newUser.getPassword());
            userRepository.save(foundUser);
            return foundUser;
        } else
            return null;
    }

    @Override
    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User getOneUserByUserName(String user_name) {
        return userRepository.findByUserName(user_name);
    }
}
