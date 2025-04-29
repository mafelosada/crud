package com.zoo.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoo.crud.DTO.AnimalDTO;
import com.zoo.crud.service.animalService;

@RestController
@RequestMapping("/animal")
@CrossOrigin(origins = "http://127.0.0.1:5500") 
public class AnimalsController {

     @Autowired
    private animalService animalService;

    @PostMapping("/")
    public ResponseEntity<Object> saveAnimal(@RequestBody AnimalDTO animalDTO) {
        var message = animalService.save(animalDTO);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    
    @GetMapping("/")
    public ResponseEntity<Object> getAllAnimals(){
        var listaAnimals = animalService.findAll();
        return new ResponseEntity<>(listaAnimals, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneAnimal(@PathVariable int id) {
        var animal = animalService.findById(id);
        if (!animal.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(animal, HttpStatus.OK); 
    }

    @GetMapping("/filter/{name}")
    public ResponseEntity<Object> getListAnimalsForName(@PathVariable String name) {
        var animal = animalService.getListAnimalsForName(name);
        if (animal.isEmpty())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(animal, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAnimal(@PathVariable int id) {
        var message = animalService.deleteAnimal(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAnimal(@PathVariable int id, @RequestBody AnimalDTO animalDTO) {
        var message = animalService.updateAnimal(id, animalDTO);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
