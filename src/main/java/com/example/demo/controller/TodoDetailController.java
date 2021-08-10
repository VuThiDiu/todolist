package com.example.demo.controller;


import com.example.demo.model.TodoDetail;
import com.example.demo.model.User;
import com.example.demo.model.dto.TodoDetailDTO;
import com.example.demo.service.TodoDetailService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/todolist")
public class TodoDetailController {
        // get all of the todolist
        @Autowired
        TodoDetailService todoDetailService;
        // tra ve todolist theo id nayf
        UserService userService;
        @GetMapping("/{id}")
        public ResponseEntity<TodoDetailDTO> getTodoByID(@PathVariable("id")  long id){
                TodoDetail todoDetail =  todoDetailService.getTodoListByID(id);
                return new ResponseEntity<>(TodoDetailDTO.from(todoDetail), HttpStatus.OK);

        }
        // create nayf
        @PostMapping("/create/{id}/{content}/{level}")
        public ResponseEntity<TodoDetailDTO> createNewTodo(@PathVariable long id,
                                                        @PathVariable String content,
                                                        @PathVariable String level){
//                return id + " " + content + " " + level;
                TodoDetail todoDetail = new TodoDetail();
                todoDetail.setContent(content);
                todoDetail.setLevel(level);
                User user = new User();
                user.setId(id);
               // User user = userService.getUserById(id);
                todoDetail.setUser(user);
//                System.out.println("create");
                todoDetailService.saveTodo(todoDetail);
                return new ResponseEntity<>(TodoDetailDTO.from(todoDetail), HttpStatus.OK);
        }

        @PutMapping("/{id}")
        public ResponseEntity<TodoDetailDTO>  updateTodoDetail (@PathVariable("id")long id, @RequestBody TodoDetail todoDetail){
               todoDetailService.updateTodoDetail(todoDetail, id);
                return new ResponseEntity<>(TodoDetailDTO.from(todoDetail), HttpStatus.OK);
        }

        // ok
        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteTodoDetail (@PathVariable("id") long id){
                todoDetailService.deleteTodoDetail(id);
                return new ResponseEntity<>("Delete complete", HttpStatus.OK);
        }


}
