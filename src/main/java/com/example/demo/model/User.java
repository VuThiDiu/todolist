package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import javax.swing.*;
import java.util.List;

@Entity
@Table(name="user")
@Data
public class User {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false, unique = true)
    private String username;


    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<TodoDetail> todolist;
}
