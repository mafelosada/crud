package com.zoo.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoo.crud.DTO.FeedingDTO;
import com.zoo.crud.model.feeding;
import com.zoo.crud.repository.Ifeeding;

@Service
public class feedingService {
    @Autowired
    private Ifeeding data;

    public void save(FeedingDTO feedingDTO){
        feeding feeding = convertToModel(feedingDTO);
        data.save(feeding);
    }

    public FeedingDTO converToDTO(feeding feeding){
        FeedingDTO feedingDTO = new FeedingDTO(
            feeding.getNameFeeding()
        );
        return feedingDTO;
    }

    public feeding convertToModel(FeedingDTO feedingDTO){
        feeding feeding = new feeding(
            0,
            feedingDTO.getNameFeeding()
        );
        return feeding;
    }

}
