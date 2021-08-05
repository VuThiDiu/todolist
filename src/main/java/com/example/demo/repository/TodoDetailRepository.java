package com.example.demo.repository;

import com.example.demo.model.TodoDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TodoDetailRepository extends JpaRepository<TodoDetail, Long> {
    
}
