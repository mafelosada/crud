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

import com.zoo.crud.DTO.ResponsesDTO;
import com.zoo.crud.DTO.SectionDTO;
import com.zoo.crud.service.sectionService;

@RestController
@RequestMapping("/section")
public class SectionsController {

    @Autowired
    private sectionService sectionService;

    @PostMapping("/")
    public ResponseEntity<Object> registerSection(@RequestBody SectionDTO section) {
        ResponsesDTO respuesta = sectionService.save(section);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }                                
    
    @GetMapping("/")
    public ResponseEntity<Object> getAllSections(){
        var listaSections = sectionService.findAll();
        return new ResponseEntity<>(listaSections, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneSection(@PathVariable int id) {
        var section = sectionService.findById(id);
        if (!section.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(section, HttpStatus.OK);
    }

    @GetMapping("/filter/{name}")
    public ResponseEntity<Object> getListSectionForName(@PathVariable String name) {
        var section = sectionService.getListSectionsForName(name);
        if (section.isEmpty())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(section, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSection(@PathVariable int id) {
        var message = sectionService.deleteSections(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSection(@PathVariable int id, @RequestBody SectionDTO section) {
        var message = sectionService.updateSections(id, section);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
