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

import com.zoo.crud.DTO.KeeperAnimalDTO;
import com.zoo.crud.service.keeperAnimalService;

@RestController
@RequestMapping("/keeperAnimal")
public class KeepersAnimalController {
     @Autowired
    private keeperAnimalService keeperAnimalService;

    @PostMapping("/")
    public ResponseEntity<Object> registerKeeperAnimal(@RequestBody KeeperAnimalDTO keeperAnimal){
        var message = keeperAnimalService.save(keeperAnimal);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllKeepersAnimals(){
        var listaKeepersAnimals = keeperAnimalService.findAll();
        return new ResponseEntity<>(listaKeepersAnimals, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneKeeperAnimal(@PathVariable int id) {
        var keeperAnimal = keeperAnimalService.findById(id);
        if (!keeperAnimal.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(keeperAnimal, HttpStatus.OK);
    }

    @GetMapping("/filter/{name}")
    public ResponseEntity<Object> getListKeepersAnimalsForName(@PathVariable String name) {
        var keeperAnimal = keeperAnimalService.getListKeeperAnimalsForName(name);
        if (keeperAnimal.isEmpty())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(keeperAnimal, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteKeeperAnimal(@PathVariable int id) {
        var message = keeperAnimalService.deleteKeeperAnimal(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateKeeperAnimal(@PathVariable int id, @RequestBody KeeperAnimalDTO keeperAnimalDTO) {
        var message = keeperAnimalService.updateKeeperAnimal(id, keeperAnimalDTO);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
