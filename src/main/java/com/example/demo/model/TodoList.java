package com.example.demo.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "todoList")
public class TodoList {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Date timeTodo;


    @OneToMany(mappedBy = "todoList", cascade = CascadeType.ALL)
    private List<TodoDetail>  todoDetails;



}
