package com.example.demo.controller;

import com.example.demo.model.TodoDetail;
import com.example.demo.model.User;
import com.example.demo.model.dto.TodoDetailDTO;
import com.example.demo.model.dto.UserDTO;
import com.example.demo.service.TodoDetailService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomePage {

    @Autowired
    UserService userService;

    @GetMapping(value = "/home/{id}")
    public String getHome(Model model, @PathVariable("id") long id){
        User user = userService.getUserById(id);
        UserDTO userDTO  =  UserDTO.from(user);
        model.addAttribute("todolist", userDTO.getTodoDTO());
        return "home";
    }
}
