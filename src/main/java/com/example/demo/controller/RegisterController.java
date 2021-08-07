package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {

    @Autowired
    UserService userService;

    // oke
    @PostMapping("/register")
    public User Register(@RequestBody User user){
        String userName = user.getUsername();
        if(userName!=null && userName.length()>0){
            userService.createNewUser(user);
        }
        return user;
    }
}
