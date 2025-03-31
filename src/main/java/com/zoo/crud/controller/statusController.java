package com.zoo.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoo.crud.DTO.StatusDTO;
import com.zoo.crud.service.statusService;

@RestController
@RequestMapping("/status")
public class statusController {

    @Autowired
    private statusService statusService;
 
    @PostMapping("/")
    public ResponseEntity<Object> registerStatus(@RequestBody StatusDTO status){
        statusService.save(status);
        return new ResponseEntity<>("Register ok", HttpStatus.OK);
    }
    

}
