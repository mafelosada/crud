package com.zoo.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
        public String home(Model model) {
            model.addAttribute("title", "ZOO");
            return "index"; // Esto buscará templates/index.html
        }
}