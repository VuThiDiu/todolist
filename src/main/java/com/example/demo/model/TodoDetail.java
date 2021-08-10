package com.example.demo.model;


import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Table(name = "tododetail")
@Entity
public class TodoDetail {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

    private  String content;
    private String level;
}