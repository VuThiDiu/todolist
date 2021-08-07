package com.example.demo.controller;


import com.example.demo.model.TodoDetail;
import com.example.demo.model.dto.TodoDetailDTO;
import com.example.demo.service.TodoDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/todolist")
public class TodoDetailController {
        // get all of the todolist
        @Autowired
        TodoDetailService todoDetailService;
        // tra ve todolist theo id nayf

        @GetMapping("/{id}")
        public ResponseEntity<TodoDetailDTO> getTodoByID(@PathVariable("id")  long id){
                TodoDetail todoDetail =  todoDetailService.getTodoListByID(id);
                return new ResponseEntity<>(TodoDetailDTO.from(todoDetail), HttpStatus.OK);

        }
        // create nayf
        @PostMapping
        public ResponseEntity<TodoDetailDTO> createNewTodo(@RequestBody TodoDetail todoDetail){
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
