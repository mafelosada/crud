package com.zoo.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.zoo.crud.DTO.FeedingDTO;
import com.zoo.crud.DTO.ResponsesDTO;
import com.zoo.crud.model.Feedings;
import com.zoo.crud.repository.Ifeeding;

@Service
public class feedingService {
    @Autowired
    private Ifeeding data;

    public List<Feedings> findAll(){
        return data.findAll();
    }

    public List<Feedings> getListFeedingForName(String name) {
        return data.findByNameFeedingContainingIgnoreCase(name);
    }

    public Optional<Feedings> findById(int id){
        return data.findById(id);
    }

    public ResponsesDTO deleteFeeding(int id){
        Optional<Feedings> feeding = findById(id);
        if (!feeding.isPresent()){
            return new ResponsesDTO(HttpStatus.NOT_FOUND.toString(), "The register does not exist");
        }
        
        data.deleteById(id);  // 🔹 Aquí realmente se elimina el registro.
    
        return new ResponsesDTO(HttpStatus.OK.toString(), "Se eliminó correctamente");
    }

    public ResponsesDTO save(FeedingDTO feedingDTO){
        Feedings feeding = convertToModel(feedingDTO);
        data.save(feeding);
        ResponsesDTO respuesta = new ResponsesDTO(
            HttpStatus.OK.toString(),
            "Se guardó correctamente"
        );
        return respuesta;
    }

    public ResponsesDTO updateFeeding(int id, FeedingDTO feedingDTO){
        Optional<Feedings> feeding = findById(id);
        if (!feeding.isPresent()){
            return new ResponsesDTO(HttpStatus.NOT_FOUND.toString(), "The register does not exist");
        }
        
        Feedings updatedFeeding = feeding.get();
        updatedFeeding.setNameFeeding(feedingDTO.getNameFeeding());
        data.save(updatedFeeding);
    
        return new ResponsesDTO(HttpStatus.OK.toString(), "Se actualizó correctamente");
    }

    public FeedingDTO converToDTO(Feedings feeding){
        FeedingDTO feedingDTO = new FeedingDTO(
            feeding.getFeedingID(),
            feeding.getNameFeeding()
        );
        return feedingDTO;
    }

    public Feedings convertToModel(FeedingDTO feedingDTO){
        Feedings feeding = new Feedings(
            0,
            feedingDTO.getNameFeeding()
        );
        return feeding;
    }

}
