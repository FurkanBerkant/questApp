package com.example.questapp.controllers;

import com.example.questapp.model.User;
import com.example.questapp.model.dto.UserRequest;
import com.example.questapp.security.JwtTokenProvider;
import com.example.questapp.service.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;
    private UserService userService;

    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public String login(@RequestBody UserRequest loginRequest){
        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken
                (loginRequest.getUserName(),loginRequest.getPassword());
    Authentication authentication=authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken= jwtTokenProvider.generateJwtToken(authentication);
        return "Bearer "+jwtToken;
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRequest registerRequest){
        if (userService.getOneUserByUserName(registerRequest.getUserName())!=null){

            return new ResponseEntity<>("Username already in use.", HttpStatus.BAD_REQUEST);
        }
        User user=new User();
        user.setUserName(registerRequest.getUserName());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        userService.add(user);
        return new ResponseEntity<>("User succesfully registered",HttpStatus.OK);
    }
}
