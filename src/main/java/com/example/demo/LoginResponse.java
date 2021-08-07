package com.example.demo;


import com.example.demo.model.User;
import lombok.Data;

@Data
public class LoginResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private long id;
    private String username;
    public LoginResponse(String accessToken,long id, String username) {
        this.accessToken = accessToken;
        this.username = username;
        this.id=id;
    }
}
