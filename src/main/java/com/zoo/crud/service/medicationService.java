package com.zoo.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoo.crud.DTO.MedicationDTO;
import com.zoo.crud.model.medication;
import com.zoo.crud.repository.Imedication;

@Service
public class medicationService {
    @Autowired
    private Imedication data;

    public void save(MedicationDTO medicationDTO){
        medication medication = convertToModel(medicationDTO);
        data.save(medication);
    }

    public MedicationDTO converToDTO(medication medication){
        MedicationDTO medicationDTO = new MedicationDTO(
            medication.getRegisterAnimal(),
            medication.getDescription(),
            medication.getMedicine(),
            medication.getDose(),
            medication.getDuration()
        );
        return medicationDTO;
    }

    public medication convertToModel(MedicationDTO medicationDTO){
        medication medication = new medication(
            0,
            medicationDTO.getRegisterAnimal(),
            medicationDTO.getDescription(),
            medicationDTO.getMedicine(),
            medicationDTO.getDose(),
            medicationDTO.getDuration()
        );
        return medication;
    }

}
