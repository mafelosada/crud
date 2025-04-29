package com.zoo.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoo.crud.DTO.FeedingAnimalDTO;
import com.zoo.crud.service.feedingAnimalService;

@RestController
@RequestMapping("/feedingAnimal/")
public class FeedingAnimalsController {
     @Autowired
    private feedingAnimalService feedingAnimalService;

    @PostMapping("/")
    public ResponseEntity<Object> registerFeedingAnimal(@RequestBody FeedingAnimalDTO feedingAnimal){
        var message = feedingAnimalService.save(feedingAnimal);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllFeedingAnimals(){
        var listaFeedingAnimals = feedingAnimalService.findAll();
        return new ResponseEntity<>(listaFeedingAnimals, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneFeedingAnimal(@PathVariable int id) {
        var feedingAnimal = feedingAnimalService.findById(id);
        if (!feedingAnimal.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(feedingAnimal, HttpStatus.OK);
    }

    @GetMapping("/filter/{name}")
    public ResponseEntity<Object> getListFeedingAnimalsForName(@PathVariable String name) {
        var feedingAnimal = feedingAnimalService.getListFeedingAnimalsForAnimalName(name);
        if (feedingAnimal.isEmpty())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(feedingAnimal, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFeedingAnimal(@PathVariable int id) {
        var message = feedingAnimalService.deleteFeedingAnimal(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateFeedingAnimal(@PathVariable int id, @RequestBody FeedingAnimalDTO feedingAnimalDTO) {
        var message = feedingAnimalService.updateFeedingAnimal(id, feedingAnimalDTO);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
