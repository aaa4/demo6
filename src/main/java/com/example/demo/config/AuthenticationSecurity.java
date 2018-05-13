package com.example.demo.config;

import com.example.demo.services.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;


public class AuthenticationSecurity extends GlobalAuthenticationConfigurerAdapter {


    @Autowired
    Users users;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(users);
    }
}
