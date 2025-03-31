package com.zoo.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoo.crud.DTO.RegisterAnimalDTO;
import com.zoo.crud.service.registerAnimalService;

@RestController
@RequestMapping("/api/v1/registerAnimal")
public class registerAnimalController {
    @Autowired
    private registerAnimalService registerAnimalService;

    @PostMapping("/")
    public ResponseEntity<Object> registerAnimals(@RequestBody RegisterAnimalDTO registerAnimal){
        registerAnimalService.save(registerAnimal);
        return new ResponseEntity<>("Register ok", HttpStatus.OK);
    }
}
