package com.example.demo.model.dto;


import com.example.demo.model.TodoDetail;
import com.example.demo.model.User;
import lombok.Data;

import java.sql.Date;
import java.util.Objects;

@Data
public class TodoDetailDTO {

    private long id;
    private PlainUserDTO user;
    private  String content;
    private Date timecreated;
    private String level;
    public static TodoDetailDTO from (TodoDetail todoDetail){
        TodoDetailDTO todoDetailDTO = new TodoDetailDTO();
        todoDetailDTO.setId(todoDetail.getId());
        todoDetailDTO.setContent(todoDetail.getContent());
        todoDetailDTO.setTimecreated(todoDetail.getTimecreated());
        todoDetailDTO.setLevel(todoDetail.getLevel());
        if(Objects.nonNull(todoDetail.getUser())){
            todoDetailDTO.setUser(PlainUserDTO.from(todoDetail.getUser()));
        }
        return todoDetailDTO;

    }
}
