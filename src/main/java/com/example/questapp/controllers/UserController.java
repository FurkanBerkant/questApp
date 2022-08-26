package com.example.questapp.controllers;
import com.example.questapp.service.abstracts.UserService;
import com.example.questapp.model.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAll(),HttpStatus.OK);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<User> getOneUser(@PathVariable Long userId) {
        return new ResponseEntity<>(userService.getOneUserById(userId),HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<User> add(@RequestBody User user) {
        return new ResponseEntity<>(userService.add(user), HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateOneUser(@PathVariable Long userId,
                              @RequestBody User newUser)
    {
       return new ResponseEntity<>(userService.updateOneUser(userId,newUser),HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable Long userId) {
        userService.deleteById(userId);
    }
}
