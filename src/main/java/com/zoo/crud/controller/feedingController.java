package com.zoo.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoo.crud.DTO.FeedingDTO;
import com.zoo.crud.service.feedingService;

@RestController
@RequestMapping("/api/v1/feeding")
public class feedingController {
    @Autowired
    private feedingService feedingService;

    @PostMapping("/")
    public ResponseEntity<Object> registerFeeding(@RequestBody FeedingDTO feeding){
        feedingService.save(feeding);
        return new ResponseEntity<>("Register ok", HttpStatus.OK);
    }


}
