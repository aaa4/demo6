package com.example.demo.controllers;

import com.example.demo.model.UserTwo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {


    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("newUser", new UserTwo());
        return "login";
    }


    @PostMapping("/login")
    public String postMapping(@ModelAttribute UserTwo userTwo){
        System.out.println(userTwo);
        return "start";
    }
}
