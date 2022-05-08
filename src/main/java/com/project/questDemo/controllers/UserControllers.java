package com.project.questDemo.controllers;
import com.project.questDemo.business.abstracts.UserService;
import com.project.questDemo.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserControllers {
    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users= userService.getAll();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/add")
    public User add(@RequestBody User user) {
        return userService.add(user);
    }

    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable int userId) {
        return userService.getOneUserById(userId);
    }

    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable int userId,
                              @RequestBody User newUser)
    {
       return userService.updateOneUser(userId,newUser);
    }

    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable int userId) {
        userService.deleteById(userId);
    }
}
