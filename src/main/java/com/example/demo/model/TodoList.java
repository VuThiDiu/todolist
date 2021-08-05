package com.example.demo.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "todolist")
public class TodoList {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

    private Date timetodo;


    @OneToMany(mappedBy = "todolist", cascade = CascadeType.ALL)
    private List<TodoDetail>  tododetails;



}
