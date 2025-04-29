package com.zoo.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.zoo.crud.DTO.AnimalDTO;
import com.zoo.crud.DTO.ResponsesDTO;
import com.zoo.crud.model.Animals;
import com.zoo.crud.repository.Ianimals;
import com.zoo.crud.repository.Isection;
import com.zoo.crud.repository.Ispecies;
import com.zoo.crud.repository.Istatus;

@Service
public class animalService {
    @Autowired
    private Ianimals data;

    @Autowired
    private Isection sectionRepository;

    @Autowired
    private Ispecies speciesRepository;

    @Autowired
    private Istatus statusRepository;


    public List<Animals> findAll(){
        return data.findAll();
    }

    public List<Animals> getListAnimalsForName(String name) {
        return data.findByNameAnimalContainingIgnoreCase(name);
    }

    public Optional<Animals> findById(int id){
        return data.findById(id);
    }

    public ResponsesDTO deleteAnimal(int id){
        Optional<Animals> animal = findById(id);
        if (!animal.isPresent()){
            return new ResponsesDTO(HttpStatus.NOT_FOUND.toString(), "The register does not exist");
        }
        
        data.deleteById(id);  // 🔹 Aquí realmente se elimina el registro.
    
        return new ResponsesDTO(HttpStatus.OK.toString(), "Se eliminó correctamente");
    }

    public ResponsesDTO save(AnimalDTO animalDTO){
        Animals animal = convertToModel(animalDTO);
        data.save(animal);
        ResponsesDTO respuesta = new ResponsesDTO(
            HttpStatus.OK.toString(),
            "Se guardó correctamente"
        );
        return respuesta;
    }

    public ResponsesDTO updateAnimal(int id, AnimalDTO animalDTO){
        Optional<Animals> animal = findById(id);
        if (!animal.isPresent()){
            return new ResponsesDTO(HttpStatus.NOT_FOUND.toString(), "The register does not exist");
        }
        
        Animals updatedAnimal = animal.get();
        updatedAnimal.setNameAnimal(animalDTO.getNameAnimal());
        updatedAnimal.setDateBirth(animalDTO.getDateBirth());
        updatedAnimal.setFoto(animalDTO.getFoto());
        updatedAnimal.setSpecies(animalDTO.getSpecies());
        updatedAnimal.setSection(animalDTO.getSection());
        updatedAnimal.setSstatus(animalDTO.getStatus());

        data.save(updatedAnimal); // Guardar el animal actualizado en la base de datos

        return new ResponsesDTO(HttpStatus.OK.toString(), "Se actualizó correctamente");
    }

    public AnimalDTO converToDTO(Animals animal){
        AnimalDTO animalDTO = new AnimalDTO(
            animal.getAnimalID(),
            animal.getNameAnimal(),
            animal.getDateBirth(),
            animal.getFoto(),
            animal.getSpecies(),
            animal.getSection(),
            animal.getSstatus()
        );
        return animalDTO;
    }

    public Animals convertToModel(AnimalDTO animalDTO){
        var species = speciesRepository.findById(animalDTO.getSpecies().getSpeciesID())
            .orElseThrow(() -> new RuntimeException("Species not found"));
    
        var section = sectionRepository.findById(animalDTO.getSection().getSectionID())
            .orElseThrow(() -> new RuntimeException("Section not found"));
    
        var status = statusRepository.findById(animalDTO.getStatus().getStatusID())
            .orElseThrow(() -> new RuntimeException("Status not found"));
    
        Animals animal = new Animals(
            0,
            animalDTO.getNameAnimal(),
            animalDTO.getDateBirth(),
            animalDTO.getFoto(),
            species,
            section,
            status
        );
    
        return animal;
    }
    
}
