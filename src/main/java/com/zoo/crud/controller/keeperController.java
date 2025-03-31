package com.zoo.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoo.crud.DTO.KeeperDTO;
import com.zoo.crud.service.keeperService;

@RestController
@RequestMapping("/api/v1/keeper")
public class keeperController {
      @Autowired
    private keeperService keeperService;

    @PostMapping("/")
    public ResponseEntity<Object> registerKeeper(@RequestBody KeeperDTO keeper){
        keeperService.save(keeper);
        return new ResponseEntity<>("Register ok", HttpStatus.OK);
    }


}
