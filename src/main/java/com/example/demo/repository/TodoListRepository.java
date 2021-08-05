package com.example.demo.repository;


import com.example.demo.model.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Long> {
    @Query(value = "select * from todo_list order by time_todo desc", nativeQuery = true)
    List<TodoList> getAllTodolist();
}
