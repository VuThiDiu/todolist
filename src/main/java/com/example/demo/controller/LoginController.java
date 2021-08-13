package com.example.demo.controller;


import com.example.demo.JwtTokenProvider;
import com.example.demo.LoginRequest;
import com.example.demo.LoginResponse;
import com.example.demo.model.CustomUserDetails;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.awt.*;
import java.util.Optional;
import java.util.function.LongFunction;
@Controller
public class LoginController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    UserService userService;
    @GetMapping(value = {"/login", "/", ""})
    public String getLoginForm(){
        return "login";
    }
    // ok nef

    @ResponseBody
    @PostMapping(value = "/authen", produces = "application/json")
    public LoginResponse authentication(User user){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );
        User user1 = (User) userService.getUserByUserName(user.getUsername());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // tra ve jwt cho nguoi dung
        String jwt = jwtTokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        return new LoginResponse(jwt,  user1.getId(),user1.getUsername());
    }

}

