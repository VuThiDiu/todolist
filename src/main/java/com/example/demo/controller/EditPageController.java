package com.example.demo.controller;


import com.example.demo.model.TodoDetail;
import com.example.demo.model.dto.TodoDetailDTO;
import com.example.demo.service.TodoDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EditPageController {
    @Autowired
    TodoDetailService todoDetailService;

    @GetMapping("/todolist/{id}")
    public String getTodoByID(@PathVariable("id")  long id, Model model){
        TodoDetail todoDetail =  todoDetailService.getTodoListByID(id);
        TodoDetailDTO todoDetailDTO = TodoDetailDTO.from(todoDetail);
        model.addAttribute( "todoDetail",todoDetailDTO);
        return "todolist";

    }
}
