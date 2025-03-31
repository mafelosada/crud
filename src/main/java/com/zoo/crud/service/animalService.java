package com.zoo.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoo.crud.DTO.AnimalDTO;
import com.zoo.crud.model.animal;
import com.zoo.crud.repository.Ianimal;

@Service
public class animalService {
    @Autowired
    private Ianimal data;

      public void save(AnimalDTO animalDTO){
        animal animal = convertToModel(animalDTO);
        data.save(animal);
    }

    public AnimalDTO converToDTO(animal animal){
        AnimalDTO animalDTO = new AnimalDTO(
            animal.getNameAnimal(),
            animal.getDateBirth(),
            animal.getFoto(),
            animal.getSpecies(),
            animal.getSection(),
            animal.getStatus()
        );
        return animalDTO;
    }

    public animal convertToModel(AnimalDTO animalDTO){
        animal animal = new animal(
            0,
            animalDTO.getNameAnimal(),
            animalDTO.getDateBirth(),
            animalDTO.getFoto(),
            animalDTO.getSpecies(),
            animalDTO.getSection(),
            animalDTO.getStatus()
        );
        return animal;
    }

}
