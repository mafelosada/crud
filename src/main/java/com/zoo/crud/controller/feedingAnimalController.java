package com.zoo.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoo.crud.DTO.FeedingAnimalDTO;
import com.zoo.crud.service.feedingAnimalService;

@RestController
@RequestMapping("/api/v1/feedingAnimal")
public class feedingAnimalController {
     @Autowired
    private feedingAnimalService feedingAnimalService;

    @PostMapping("/")
    public ResponseEntity<Object> registerFeedingAnimal(@RequestBody FeedingAnimalDTO feedingAnimal){
        feedingAnimalService.save(feedingAnimal);
        return new ResponseEntity<>("Register ok", HttpStatus.OK);
    }

}
