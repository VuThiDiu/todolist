package com.example.demo.repository;

import com.example.demo.model.TodoDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface TodoDetailRepository extends JpaRepository<TodoDetail, Long> {
    @Query(value = "select * from tododetail where userid= ?1; ", nativeQuery = true)
    List<TodoDetail> getTodoListOfAccount(long accountID);
}
