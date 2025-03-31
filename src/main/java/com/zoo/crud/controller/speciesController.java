package com.zoo.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoo.crud.DTO.SpeciesDTO;
import com.zoo.crud.service.speciesService;

@RestController
@RequestMapping("/species")
public class speciesController {

    @Autowired
    private speciesService speciesService;

    @PostMapping("/")
    public ResponseEntity<Object> registerSpecies(@RequestBody SpeciesDTO species) {
        speciesService.save(species);
        return new ResponseEntity<>("Register ok", HttpStatus.OK);
    }
    
}
