package com.zoo.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoo.crud.DTO.FeedingAnimalDTO;
import com.zoo.crud.model.feedingAnimal;
import com.zoo.crud.repository.IfeedingAnimal;

@Service
public class feedingAnimalService {
    @Autowired
    private IfeedingAnimal data;

     public void save(FeedingAnimalDTO feedingAnimalDTO){
        feedingAnimal feedingAnimal = convertToModel(feedingAnimalDTO);
        data.save(feedingAnimal);
    }

    public FeedingAnimalDTO converToDTO(feedingAnimal feedingAnimal){
        FeedingAnimalDTO feedingAnimalDTO = new FeedingAnimalDTO(
            feedingAnimal.getAnimal(),
            feedingAnimal.getFeeding(),
            feedingAnimal.getSchedule()
        );
        return feedingAnimalDTO;
    }

    public feedingAnimal convertToModel(FeedingAnimalDTO feedingAnimalDTO){
        feedingAnimal feedingAnimal = new feedingAnimal(
            0,
            feedingAnimalDTO.getAnimal(),
            feedingAnimalDTO.getFeeding(),
            feedingAnimalDTO.getSchedule()
        );
        return feedingAnimal;
    }
}
