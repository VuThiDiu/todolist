package com.example.demo.controller;


import com.example.demo.model.TodoDetail;
import com.example.demo.service.TodoDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
public class PageController {

    @Autowired
    TodoDetailService todoDetailService;
    @GetMapping(value = {"/home", "/"})
    public String HomePage(Model model){
        List<TodoDetail> todolist = todoDetailService.getDateTime();
        model.addAttribute("todolist", todolist);
        return "home";
    }
    @GetMapping("/addTodoList")
    public String addTodoList(Model model){
        model.addAttribute("todolist", new TodoDetail());
        return "addTodoList";
    }

    @PostMapping("/addTodoList")
    public String addTodoList(Model model, @ModelAttribute("todolist") TodoDetail todoDetail){
        Date date = new Date();
        if(todoDetail.getContent()!=null & todoDetail.getTime()!=null &&  todoDetail.getLevel()!=null){

            todoDetailService.saveTodo(todoDetail);
        }
        //todoDetail.setTimecreated(instant.getEpochSecond());

        return "redirect:/home";

    }
}
