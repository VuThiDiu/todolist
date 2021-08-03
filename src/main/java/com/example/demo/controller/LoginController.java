package com.example.demo.controller;


import com.example.demo.JwtTokenProvider;
import com.example.demo.LoginRequest;
import com.example.demo.LoginResponse;
import com.example.demo.model.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;


    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @PostMapping("/abc")
    public LoginResponse authenticateUser(@RequestBody LoginRequest loginRequest){
        // xac thuc usernam va password
        Authentication authentication = authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(
                  loginRequest.getUserName(),
                  loginRequest.getPassword()
          )
                // Neu khong xay ra exeption thi tuc la thong tin hop le

        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // tra ve jwt cho nguoi dung
        String jwt = jwtTokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        return new LoginResponse(jwt);
    }


}
