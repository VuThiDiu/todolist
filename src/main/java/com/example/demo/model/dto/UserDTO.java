package com.example.demo.model.dto;


import com.example.demo.model.TodoDetail;
import com.example.demo.model.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserDTO {
    private long id;
    private String username;
    private String password;
    private List<TodoDetailDTO> todoDTO = new ArrayList<>();


    public static UserDTO from (User user){
        UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setTodoDTO(user.getTodolist().stream().map(TodoDetailDTO::from).collect(Collectors.toList()));
        return userDTO;

    }
}
