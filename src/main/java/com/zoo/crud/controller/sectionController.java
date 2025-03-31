package com.zoo.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoo.crud.DTO.SectionDTO;
import com.zoo.crud.service.sectionService;

@RestController
@RequestMapping("/section")
public class sectionController {

    @Autowired
    private sectionService sectionService;

    @PostMapping("/")
    public ResponseEntity<Object> registersection(@RequestBody SectionDTO section) {
        sectionService.save(section);
        return new ResponseEntity<>("Register ok", HttpStatus.OK);
    }
    

}
