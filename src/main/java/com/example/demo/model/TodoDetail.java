package com.example.demo.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "todoDetail")
@Entity
public class TodoDetail {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "todolist_id")
    private  TodoList todoList;

    private  String content;
}
