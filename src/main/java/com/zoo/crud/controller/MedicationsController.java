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

import com.zoo.crud.DTO.MedicationDTO;
import com.zoo.crud.service.medicationService;

@RestController
@RequestMapping("/medication/")
public class MedicationsController {
    @Autowired
    private medicationService medicationService;

    @PostMapping("/")
    public ResponseEntity<Object> registerMedication(@RequestBody MedicationDTO medication){
        var message = medicationService.save(medication);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllMedications(){
        var listaMedications = medicationService.findAll();
        return new ResponseEntity<>(listaMedications, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneMedication(@PathVariable int id) {
        var medication = medicationService.findById(id);
        if (!medication.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(medication, HttpStatus.OK); 
    }

    @PostMapping("/filter/{name}")
    public ResponseEntity<Object> getListMedicationsForName(@RequestBody String name) {
        var medication = medicationService.getListMedicationsForDescription(name);
        if (medication.isEmpty())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(medication, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMedication(@PathVariable int id) {
        var message = medicationService.deleteMedication(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateMedication(@RequestBody MedicationDTO medication){
        var message = medicationService.updateMedication(medication);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }



}
