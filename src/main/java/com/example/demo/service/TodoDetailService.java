package com.example.demo.service;


import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.TodoDetail;
import com.example.demo.model.TodoList;
import com.example.demo.repository.TodoDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoDetailService {
    @Autowired
    TodoDetailRepository todoDetailRepository;

    public TodoDetail saveTodo(TodoDetail todoDetail){
        return todoDetailRepository.save(todoDetail);
    }

    public TodoDetail updateTodoDetail(TodoDetail todoDetail, long id){
        // check
        TodoDetail existedTodoDetail = todoDetailRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("TodoDetail", "id", id)
        );
        existedTodoDetail.setContent(todoDetail.getContent());
        todoDetailRepository.save(existedTodoDetail);
        return existedTodoDetail;
    }

    public void deleteTodoDetail(long id){
        // check
        TodoDetail existedTodoDetail = todoDetailRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("TodoDetail", "id", id)
        );
        todoDetailRepository.deleteById(id);
    }
}
