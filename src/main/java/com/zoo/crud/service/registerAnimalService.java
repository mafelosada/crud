package com.zoo.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoo.crud.DTO.RegisterAnimalDTO;
import com.zoo.crud.model.registerAnimal;
import com.zoo.crud.repository.IregisterAnimal;

@Service
public class registerAnimalService {
    @Autowired
    private IregisterAnimal data;

     public void save(RegisterAnimalDTO registerAnimalDTO){
        registerAnimal registerAnimal = convertToModel(registerAnimalDTO);
        data.save(registerAnimal);
    }

    public RegisterAnimalDTO converToDTO(registerAnimal registerAnimal){
        RegisterAnimalDTO registerAnimalDTO = new RegisterAnimalDTO(
            registerAnimal.getAnimal(),
            registerAnimal.getKeeper(),
            registerAnimal.getDate(),
            registerAnimal.getDiagnostic()
        );
        return registerAnimalDTO;
    }

    public registerAnimal convertToModel(RegisterAnimalDTO registerAnimalDTO){
        registerAnimal registerAnimal = new registerAnimal(
            0,
            registerAnimalDTO.getAnimal(),
            registerAnimalDTO.getKeeper(),
            registerAnimalDTO.getDate(),
            registerAnimalDTO.getDiagnostic()
        );
        return registerAnimal;
    }

}
