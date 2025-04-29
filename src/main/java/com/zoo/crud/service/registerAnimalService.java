package com.zoo.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.zoo.crud.DTO.RegisterAnimalDTO;
import com.zoo.crud.DTO.ResponsesDTO;
import com.zoo.crud.model.RegisterAnimals;
import com.zoo.crud.repository.Ianimals;
import com.zoo.crud.repository.Ikeeper;
import com.zoo.crud.repository.IregisterAnimal;

@Service
public class registerAnimalService {
    @Autowired
    private IregisterAnimal data;

    @Autowired
    private Ianimals animalRepository;

    @Autowired
    private Ikeeper keeperRepository;

    public List<RegisterAnimals> findAll(){
        return data.findAll();
    }

    public List<RegisterAnimals> getListRegisterAnimalsForDiagnostic(String name){
        return data.findByAnimal_NameAnimal(name);
    }

    public Optional<RegisterAnimals> findById(int id){
        return data.findById(id);
    }

    public ResponsesDTO deleteRegisterAnimal(int id){
        Optional<RegisterAnimals> registerAnimal = findById(id);
        if (!registerAnimal.isPresent()){
            return new ResponsesDTO(HttpStatus.NOT_FOUND.toString(), "The register does not exist");
        }
        
        data.deleteById(id);  // 🔹 Aquí realmente se elimina el registro.
    
        return new ResponsesDTO(HttpStatus.OK.toString(), "Se eliminó correctamente");
    }

    public ResponsesDTO save(RegisterAnimalDTO registerAnimalDTO){
        RegisterAnimals registerAnimal = convertToModel(registerAnimalDTO);
        data.save(registerAnimal);
        ResponsesDTO respuesta = new ResponsesDTO(
            HttpStatus.OK.toString(),
            "Se guardó correctamente"
        );
        return respuesta;
    }

    public ResponsesDTO updateRegisterAnimal(RegisterAnimalDTO registerAnimalDTO){
        RegisterAnimals registerAnimal = convertToModel(registerAnimalDTO);
        data.save(registerAnimal);
        ResponsesDTO respuesta = new ResponsesDTO(
            HttpStatus.OK.toString(),
            "Se actualizó correctamente"
        );
        return respuesta;
    }

    public RegisterAnimalDTO converToDTO(RegisterAnimals registerAnimal){
        RegisterAnimalDTO registerAnimalDTO = new RegisterAnimalDTO(
            registerAnimal.getRegisterAnimalID(),
            registerAnimal.getAnimal(),
            registerAnimal.getKeeper(),
            registerAnimal.getDate(),
            registerAnimal.getDiagnostic()
        );
        return registerAnimalDTO;
    }

    public RegisterAnimals convertToModel(RegisterAnimalDTO registerAnimalDTO){
        var animal = animalRepository.findById(registerAnimalDTO.getAnimal().getAnimalID())
            .orElseThrow(() -> new RuntimeException("Animal not found"));
        var keeper = keeperRepository.findById(registerAnimalDTO.getKeeper().getKeeperID())
            .orElseThrow(() -> new RuntimeException("Keeper not found"));
        RegisterAnimals registerAnimal = new RegisterAnimals(
            0,
            animal,
            keeper,
            registerAnimalDTO.getDate(),
            registerAnimalDTO.getDiagnostic()
        );
        return registerAnimal;
    }

}
