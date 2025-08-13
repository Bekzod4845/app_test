package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {



    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/login";
    }


    @GetMapping("/login")
    public String loginPage() {
        return "login"; // templates/login.html
    }
}
