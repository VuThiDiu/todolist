package com.example.demo.service;


import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.TodoDetail;
import com.example.demo.repository.TodoDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class TodoDetailService {
    @Autowired
    TodoDetailRepository todoDetailRepository;
    // save
    public TodoDetail saveTodo(TodoDetail todoDetail){
        return todoDetailRepository.save(todoDetail);
    }
    // update
    public TodoDetail updateTodoDetail(TodoDetail todoDetail, long id){
        // check
        TodoDetail existedTodoDetail = todoDetailRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("TodoDetail", "id", id)
        );
        existedTodoDetail.setContent(todoDetail.getContent());
        existedTodoDetail.setStatus(todoDetail.getStatus());
        todoDetailRepository.save(existedTodoDetail);
        return existedTodoDetail;
    }
    // delete
    public void deleteTodoDetail(long id){
        // check
        TodoDetail existedTodoDetail = todoDetailRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("TodoDetail", "id", id)
        );
        todoDetailRepository.deleteById(id);
    }
    // getall of it
    public List<TodoDetail> getAllTodoList(long accountID){
        return todoDetailRepository.getTodoListOfAccount(accountID);
    }

    // get by id
    public TodoDetail getTodoListByID(long id){
        TodoDetail existedTodoDetail = todoDetailRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("TodoDetail", "id", id)
        );
        return existedTodoDetail;
    }


}
