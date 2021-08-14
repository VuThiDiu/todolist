package com.example.demo.model;


import com.example.demo.model.dto.PlainUserDTO;
import com.example.demo.model.dto.TodoDetailDTO;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

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
    private String status;
    public static TodoDetail from (TodoDetailDTO todoDetailDTO){
        TodoDetail todoDetail = new TodoDetail();
        todoDetail.setStatus(todoDetailDTO.getStatus());
        todoDetail.setContent(todoDetailDTO.getContent());

        return todoDetail;

    }
}