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

import com.zoo.crud.DTO.KeeperDTO;
import com.zoo.crud.DTO.ResponsesDTO;
import com.zoo.crud.service.keeperService;

@RestController
@RequestMapping("/keeper/")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class KeepersController {
      @Autowired
    private keeperService keeperService;

    @PostMapping("/")
    public ResponseEntity<Object> registerKeeper(@RequestBody KeeperDTO keeper){
        ResponsesDTO respuesta = keeperService.save(keeper);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<Object> getAllKeeper(){
        var listaKeeper = keeperService.findAll();
        return new ResponseEntity<>(listaKeeper, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneKeeper(@PathVariable int id) {
        var keeper = keeperService.findById(id);
        if (!keeper.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(keeper, HttpStatus.OK);
    }

    @GetMapping("/filter/{name}")
    public ResponseEntity<Object> getListKeeperForName(@PathVariable String name) {
        var keeper = keeperService.findByNameKeeper(name);
        if (keeper.isEmpty())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(keeper, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteKeeper(@PathVariable int id) {
        var message = keeperService.deleteKeeper(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateKeeper(@PathVariable int id, @RequestBody KeeperDTO keeper) {
        var message = keeperService.updateKeeper(id, keeper);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
