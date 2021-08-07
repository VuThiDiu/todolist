package com.example.demo;


import com.example.demo.model.User;
import lombok.Data;

@Data
public class LoginResponse {
    private String accessToken;
    private String tokenType = "Bearer";
//    private User user;
    public LoginResponse(String accessToken) {
        this.accessToken = accessToken;
//        this.user = user;
    }
}
