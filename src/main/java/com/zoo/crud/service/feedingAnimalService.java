package com.zoo.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.zoo.crud.DTO.FeedingAnimalDTO;
import com.zoo.crud.DTO.ResponsesDTO;
import com.zoo.crud.model.FeedingAnimals;
import com.zoo.crud.repository.Ianimals;
import com.zoo.crud.repository.Ifeeding;
import com.zoo.crud.repository.IfeedingAnimal;

@Service
public class feedingAnimalService {
    @Autowired
    private IfeedingAnimal data;

    @Autowired
    private Ianimals animalRepository;

    @Autowired
    private Ifeeding feedingRepository;

    public List<FeedingAnimals> findAll(){
        return data.findAll();  
    }

    public List<FeedingAnimals> getListFeedingAnimalsForAnimalName(String name) {
        return data.findByAnimalNameAnimalContainingIgnoreCase(name);
    }

    public Optional<FeedingAnimals> findById(int id){
        return data.findById(id);
    }

    public ResponsesDTO deleteFeedingAnimal(int id){
        Optional<FeedingAnimals> feedingAnimal = findById(id);
        if (!feedingAnimal.isPresent()){
            return new ResponsesDTO(HttpStatus.NOT_FOUND.toString(), "The register does not exist");
        }
        
        data.deleteById(id);  // 🔹 Aquí realmente se elimina el registro.
    
        return new ResponsesDTO(HttpStatus.OK.toString(), "Se eliminó correctamente");

    }

    public ResponsesDTO save(FeedingAnimalDTO feedingAnimalDTO){
        FeedingAnimals feedingAnimal = convertToModel(feedingAnimalDTO);
        data.save(feedingAnimal);
        ResponsesDTO respuesta = new ResponsesDTO(
            HttpStatus.OK.toString(),
            "Se guardó correctamente"
        );
        return respuesta;
    }

   public ResponsesDTO updateFeedingAnimal(int id, FeedingAnimalDTO feedingAnimalDTO){
    Optional<FeedingAnimals> optional = data.findById(id);
    
    if (!optional.isPresent()) {
        return new ResponsesDTO(HttpStatus.NOT_FOUND.toString(), "No se encontró el registro con ID: " + id);
    }

    FeedingAnimals feedingAnimal = convertToModel(feedingAnimalDTO);
    feedingAnimal.setFeedingAnimalID(id); // importante para actualizar el registro correcto

    data.save(feedingAnimal);

    return new ResponsesDTO(HttpStatus.OK.toString(), "Se actualizó correctamente");
}


    public FeedingAnimalDTO converToDTO(FeedingAnimals feedingAnimal){
        FeedingAnimalDTO feedingAnimalDTO = new FeedingAnimalDTO(
            feedingAnimal.getFeedingAnimalID(),
            feedingAnimal.getAnimal(),
            feedingAnimal.getFeeding(),
            feedingAnimal.getSchedule()
        );
        return feedingAnimalDTO;
    }

    public FeedingAnimals convertToModel(FeedingAnimalDTO feedingAnimalDTO){
        // Verificar si el animal y la alimentación existen en la base de datos
        var animal = animalRepository.findById(feedingAnimalDTO.getAnimal().getAnimalID())
            .orElseThrow(() -> new RuntimeException("Animal not found"));
        var feeding = feedingRepository.findById(feedingAnimalDTO.getFeeding().getFeedingID())
            .orElseThrow(() -> new RuntimeException("Feeding not found"));
        FeedingAnimals feedingAnimal = new FeedingAnimals(
            0,
            animal,
            feeding,
            feedingAnimalDTO.getSchedule()
        );
        return feedingAnimal;
    }
}
