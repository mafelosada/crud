package com.zoo.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

    @GetMapping("/{section}")
    public String loadSection(@PathVariable String section) {
        return section;
    }

}

