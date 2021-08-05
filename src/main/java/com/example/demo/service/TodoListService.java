package com.example.demo.service;


import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.TodoList;
import com.example.demo.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListService {
    @Autowired
    TodoListRepository todoListRepository;

    public TodoList saveTodoList(TodoList todoList){
        return todoListRepository.save(todoList);
    }
    public TodoList  updateTodoList(TodoList todoList, long id){
        // check
        TodoList existedTodoList = todoListRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("TodoList", "id", id)
        );
        existedTodoList.setTimetodo(todoList.getTimetodo());
        todoListRepository.save(existedTodoList);
        return existedTodoList;
    }
    public void deleteTodoList(long id){
        // check
        TodoList existedTodoList = todoListRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("TodoList", "id", id)
        );
        todoListRepository.delete(existedTodoList);
    }
    public List<TodoList> getAllTodoList(){
        return todoListRepository.getAllTodolist();
    }

    public TodoList  getTodoListById(long id){
        // check
        TodoList existedTodoList = todoListRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("TodoList", "id", id)
        );
        return existedTodoList;
    }
    

}
