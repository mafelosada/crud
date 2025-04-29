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

import com.zoo.crud.DTO.ResponsesDTO;
import com.zoo.crud.DTO.SpeciesDTO;
import com.zoo.crud.service.speciesService;


@RestController
@RequestMapping("/species/")
@CrossOrigin(origins = "http://127.0.0.1:5500") 
public class SpecieController {

    @Autowired
    private speciesService speciesService;

    @PostMapping("/")
    public ResponseEntity<Object> createSpecies(@RequestBody SpeciesDTO species) {
        ResponsesDTO message = speciesService.save(species);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllSpecies(){
        var listaSpecies = speciesService.findAll();
        return new ResponseEntity<>(listaSpecies, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneSpecies(@PathVariable int id) {
        var species = speciesService.findById(id);
        if (!species.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(species, HttpStatus.OK);
    }

    @GetMapping("/filter/{name}")
    public ResponseEntity<Object> getListUserForName(@PathVariable String name) {
        var species = speciesService.getListSpeciesForName(name);
        if (species.isEmpty())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(species, HttpStatus.OK);
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSpecies(@PathVariable int id) {
        var message = speciesService.deleteSpecies(id);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSpecies(@PathVariable int id, @RequestBody SpeciesDTO species) {
        var message = speciesService.updateSpecies(id, species);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
