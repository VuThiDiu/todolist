package com.example.demo.controller;


import com.example.demo.model.TodoDetail;
import com.example.demo.model.User;
import com.example.demo.model.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/account/{id}")
    public ResponseEntity<UserDTO> getAlltodoList(@PathVariable("id") long id){
        User user = userService.getUserById(id);
        return new ResponseEntity<>(UserDTO.from(user), HttpStatus.OK);
    }
}
