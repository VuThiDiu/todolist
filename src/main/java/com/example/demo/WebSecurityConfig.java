package com.example.demo;


import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// cau hinh va phan quyen
@EnableWebSecurity
@Configuration
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(){
        return new JwtAuthenticationFilter();
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager  authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        // Spring Security dung de ma hoa mat khau nguoi dung
        return new BCryptPasswordEncoder();
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userService) // cung cap userservice cho spring security
                    .passwordEncoder(passwordEncoder()); // cung cap pass cho encoder
        //auth.authenticationProvider(authenticationProvider());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .cors() // ngan chan request  tu mot domain khac
                .and()
                .authorizeRequests()
                .antMatchers("/login", "/register").permitAll()
                // cho phep tat ca moi nguoi co the truy cap cai nay nay
                .anyRequest().authenticated()
//                .and().formLogin().defaultSuccessUrl("/home", true)
               // .and().formLogin().loginPage("/login").loginProcessingUrl("/authen").defaultSuccessUrl("/home", true)
                //.and().formLogin().loginPage("/login").loginProcessingUrl("/login")
//                .and().formLogin().defaultSuccessUrl("/home", true)
//                .and().rememberMe().key("secretKey").tokenValiditySeconds(60*60*24)
        .and()
        .logout().permitAll();; // con lai la phai authen
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        http.csrf().disable();
    }



}
