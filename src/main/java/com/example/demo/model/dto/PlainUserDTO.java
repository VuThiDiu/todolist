package com.example.demo.model.dto;


import com.example.demo.model.User;
import lombok.Data;

@Data
public class PlainUserDTO {
    private long id;
    private String username;

    public static PlainUserDTO from (User user){
        PlainUserDTO plainDTO = new PlainUserDTO();
        plainDTO.setId(user.getId());
        plainDTO.setUsername(user.getUsername());
        return plainDTO;
    }
}
