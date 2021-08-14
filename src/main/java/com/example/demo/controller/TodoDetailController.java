package com.example.demo.controller;


import com.example.demo.model.TodoDetail;
import com.example.demo.model.User;
import com.example.demo.model.dto.TodoDetailDTO;
import com.example.demo.service.TodoDetailService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/todolist")
public class TodoDetailController {
        // get all of the todolist
        @Autowired
        TodoDetailService todoDetailService;
        UserService userService;
//        @GetMapping("/{id}")
//        public ResponseEntity<TodoDetailDTO> getTodoByID(@PathVariable("id")  long id){
//                TodoDetail todoDetail =  todoDetailService.getTodoListByID(id);
//                return new ResponseEntity<>(TodoDetailDTO.from(todoDetail), HttpStatus.OK);
//        }
        @ResponseBody
        @PostMapping(value = "/create", produces = "application/json")
        public TodoDetailDTO createNewTodo( TodoDetailDTO todoDetailDTO){
                TodoDetail todoDetail = TodoDetail.from(todoDetailDTO);
                User user = new User();
                user.setId(todoDetailDTO.getUser().getId());
                todoDetail.setUser(user);
                todoDetailService.saveTodo(todoDetail);
                return todoDetailDTO;
        }
        @ResponseBody
        @PutMapping(value = "/{id}", produces = "application/json")
        public TodoDetailDTO  updateTodoDetail (@PathVariable("id")long id, TodoDetailDTO todoDetailDTO){
                TodoDetail todoDetail = TodoDetail.from(todoDetailDTO);
                User user = new User();
                user.setId(todoDetailDTO.getUser().getId());
                todoDetail.setUser(user);
               todoDetailService.updateTodoDetail(todoDetail, id);
                return todoDetailDTO;
        }

        // ok
        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteTodoDetail (@PathVariable("id") long id){
                todoDetailService.deleteTodoDetail(id);
                return new ResponseEntity<>("Delete complete", HttpStatus.OK);
        }


}
