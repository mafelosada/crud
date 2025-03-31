package com.zoo.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoo.crud.DTO.KeeperAnimalDTO;
import com.zoo.crud.model.keeperAnimal;
import com.zoo.crud.repository.IkeeperAnimal;

@Service
public class keeperAnimalService {
    @Autowired
    private IkeeperAnimal data;

     public void save(KeeperAnimalDTO keeperAnimalDTO){
        keeperAnimal keeperAnimal = convertToModel(keeperAnimalDTO);
        data.save(keeperAnimal);
    }

    public KeeperAnimalDTO converToDTO(keeperAnimal keeperAnimal){
        KeeperAnimalDTO keeperAnimalDTO = new KeeperAnimalDTO(
            keeperAnimal.getAnimal(),
            keeperAnimal.getKeeper()
        );
        return keeperAnimalDTO;
    }

    public keeperAnimal convertToModel(KeeperAnimalDTO keeperAnimalDTO){
        keeperAnimal keeperAnimal = new keeperAnimal(
            0,
            keeperAnimalDTO.getAnimal(),
            keeperAnimalDTO.getKeeper()
        );
        return keeperAnimal;
    }
    
}
