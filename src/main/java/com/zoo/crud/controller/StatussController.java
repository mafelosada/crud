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
import com.zoo.crud.DTO.StatusDTO;
import com.zoo.crud.service.statusService;

@RestController
@RequestMapping("/status")
public class StatussController {

    @Autowired
    private statusService statusService;
 
    @PostMapping("/")
    public ResponseEntity<Object> registerStatus(@RequestBody StatusDTO status){
        ResponsesDTO respuesta = statusService.save(status);

        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllStatus(){
        var listaStatus = statusService.findAll();
        return new ResponseEntity<>(listaStatus, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneStatus(@PathVariable int id) {
        var status = statusService.findById(id);
        if (!status.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping("/filter/{name}")
    public ResponseEntity<Object> getListStatusForName(@PathVariable String name) {
        var status = statusService.getListStatusForName(name);
        if (status.isEmpty())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteStatus(@PathVariable int id) {
        var message = statusService.deleteStatus(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateStatus(@PathVariable int id, @RequestBody StatusDTO status) {
        var message = statusService.updateStatus(id, status);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    

}
