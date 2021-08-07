package com.example.demo.repository;

import com.example.demo.model.TodoDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TodoDetailRepository extends JpaRepository<TodoDetail, Long> {
    @Query(value = "select DISTINCT(time) from tododetail ;", nativeQuery = true)
    List<TodoDetail> getDaTeTime();
}
