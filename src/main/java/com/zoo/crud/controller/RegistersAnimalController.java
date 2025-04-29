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

import com.zoo.crud.DTO.RegisterAnimalDTO;
import com.zoo.crud.service.registerAnimalService;

@RestController
@RequestMapping("/registerAnimal/")
public class RegistersAnimalController {
    @Autowired
    private registerAnimalService registerAnimalService;

    @PostMapping("/")
    public ResponseEntity<Object> registerAnimals(@RequestBody RegisterAnimalDTO registerAnimal){
        var message = registerAnimalService.save(registerAnimal);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllRegisters(){
        var listaRegisters = registerAnimalService. findAll();
        return new ResponseEntity<>(listaRegisters, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneRegister(@PathVariable int id) {
        var register = registerAnimalService.findById(id);
        if (!register.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(register, HttpStatus.OK); 
    }

    @GetMapping("/filter/{name}")
    public ResponseEntity<Object> getListRegistersForName(@PathVariable String name) {
        var register = registerAnimalService.getListRegisterAnimalsForDiagnostic(name);
        if (register.isEmpty())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(register, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRegister(@PathVariable int id) {
        var message = registerAnimalService.deleteRegisterAnimal(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateRegisterAnimals(@RequestBody RegisterAnimalDTO registerAnimal){
        var message = registerAnimalService.updateRegisterAnimal(registerAnimal);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
   
}
