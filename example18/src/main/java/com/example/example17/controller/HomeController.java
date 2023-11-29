package com.example.example17.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping(value = {"", "/", "/home"})
    public String home(Model model) {
        model.addAttribute("username", "Jungmin Yoo");
        return "home.html";
    }
}
