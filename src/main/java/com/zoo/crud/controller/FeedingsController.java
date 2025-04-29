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

import com.zoo.crud.DTO.FeedingDTO;
import com.zoo.crud.DTO.ResponsesDTO;
import com.zoo.crud.service.feedingService;

@RestController
@RequestMapping("/feeding/")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class FeedingsController {
    @Autowired
    private feedingService feedingService;

    @PostMapping("/")
    public ResponseEntity<Object> registerFeeding(@RequestBody FeedingDTO feeding){
        ResponsesDTO respuesta = feedingService.save(feeding);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllFeeding(){
       var listaFeeding = feedingService.findAll();
        return new ResponseEntity<>(listaFeeding, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneFeeding(@PathVariable int id) {
        var feeding = feedingService.findById(id);
        if (!feeding.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(feeding, HttpStatus.OK);
    }

    @GetMapping("/filter/{filter}")
    public ResponseEntity<Object> getListFeedingForName(@PathVariable String filter) {
        var feeding = feedingService.getListFeedingForName(filter);
        if (feeding.isEmpty())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(feeding, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFeeding(@PathVariable int id) {
        var message = feedingService.deleteFeeding(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateFeeding(@PathVariable int id, @RequestBody FeedingDTO feeding) {
        var message = feedingService.updateFeeding(id, feeding);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
