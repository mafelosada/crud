package com.zoo.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoo.crud.DTO.AnimalDTO;
import com.zoo.crud.service.animalService;

@RestController
@RequestMapping("/animal")
public class animalController {

     @Autowired
    private animalService animalService;

    @PostMapping("/")
    public ResponseEntity<Object> registerAnimal(@RequestBody AnimalDTO animal){
        animalService.save(animal);
        return new ResponseEntity<>("Register ok", HttpStatus.OK);
    }

}
