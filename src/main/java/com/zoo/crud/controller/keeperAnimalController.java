package com.zoo.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoo.crud.DTO.KeeperAnimalDTO;
import com.zoo.crud.service.keeperAnimalService;

@RestController
@RequestMapping("/api/v1/keeperAnimal")
public class keeperAnimalController {
     @Autowired
    private keeperAnimalService keeperAnimalService;

    @PostMapping("/")
    public ResponseEntity<Object> registerKeeperAnimal(@RequestBody KeeperAnimalDTO keeperAnimal){
        keeperAnimalService.save(keeperAnimal);
        return new ResponseEntity<>("Register ok", HttpStatus.OK);
    }
}
