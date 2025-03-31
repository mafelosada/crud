package com.zoo.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoo.crud.DTO.MedicationDTO;
import com.zoo.crud.service.medicationService;

@RestController
@RequestMapping("/api/v1/medication")
public class medicationController {
    @Autowired
    private medicationService medicationService;

    @PostMapping("/")
    public ResponseEntity<Object> registerMedication(@RequestBody MedicationDTO medication){
        medicationService.save(medication);
        return new ResponseEntity<>("Register ok", HttpStatus.OK);
    }

}
