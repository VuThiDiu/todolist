package com.example.demo.controller;


import com.example.demo.JwtTokenProvider;
import com.example.demo.LoginRequest;
import com.example.demo.LoginResponse;
import com.example.demo.model.CustomUserDetails;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;


    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    UserService userService;
    @GetMapping(value = {"/login", "/" })
    public String login(Model model){
        model.addAttribute("user", new User());
        return "login";
    }
    @PostMapping("/authen")
    public LoginResponse authenticateUser(Model model, @Valid @ModelAttribute("user") User user){

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getUsername(),
                            user.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            // tra ve jwt cho nguoi dung
            String jwt = jwtTokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
            LoginResponse loginResponse  = new LoginResponse(jwt);
            return new LoginResponse(jwt);
    }



}
