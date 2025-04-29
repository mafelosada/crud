package com.zoo.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.zoo.crud.DTO.KeeperAnimalDTO;
import com.zoo.crud.DTO.ResponsesDTO;
import com.zoo.crud.model.KeeperAnimals;
import com.zoo.crud.repository.Ianimals;
import com.zoo.crud.repository.Ikeeper;
import com.zoo.crud.repository.IkeeperAnimal;


@Service
public class keeperAnimalService {
    @Autowired
    private IkeeperAnimal data;

    @Autowired
    private Ianimals animalRepository;

    @Autowired
    private Ikeeper keeperRepository;

    public List<KeeperAnimals> findAll(){
        return data.findAll();  
    }   

    public List<KeeperAnimals> getListKeeperAnimalsForName(String name) {
        return data.findByKeeperNameKeeperContainingIgnoreCase(name);
    }

    public Optional<KeeperAnimals> findById(int id){
        return data.findById(id);
    }

    public ResponsesDTO deleteKeeperAnimal(int id){
        Optional<KeeperAnimals> keeperAnimal = findById(id);
        if (!keeperAnimal.isPresent()){
            return new ResponsesDTO(HttpStatus.NOT_FOUND.toString(), "The register does not exist");
        }
        
        data.deleteById(id);  // 🔹 Aquí realmente se elimina el registro.
    
        return new ResponsesDTO(HttpStatus.OK.toString(), "Se eliminó correctamente");

    }

    public ResponsesDTO save(KeeperAnimalDTO keeperAnimalDTO){
        KeeperAnimals keeperAnimal = convertToModel(keeperAnimalDTO);
        data.save(keeperAnimal);
        ResponsesDTO respuesta = new ResponsesDTO(
            HttpStatus.OK.toString(),
            "Se guardó correctamente"
        );
        return respuesta;
    }

    public ResponsesDTO updateKeeperAnimal(int id, KeeperAnimalDTO keeperAnimalDTO) {
        Optional<KeeperAnimals> optional = data.findById(id);
    
        if (!optional.isPresent()) {
            return new ResponsesDTO(HttpStatus.NOT_FOUND.toString(), "No se encontró el registro con ID: " + id);
        }
    
        KeeperAnimals keeperAnimal = convertToModel(keeperAnimalDTO);
        keeperAnimal.setKeeperAnimalID(id); // Asigna el ID existente para actualizar el registro correcto
    
        data.save(keeperAnimal);
    
        return new ResponsesDTO(HttpStatus.OK.toString(), "Se actualizó correctamente");
    }
    

    public KeeperAnimalDTO converToDTO(KeeperAnimals keeperAnimal){
        KeeperAnimalDTO keeperAnimalDTO = new KeeperAnimalDTO(
            keeperAnimal.getKeeperAnimalID(),
            keeperAnimal.getAnimal(),
            keeperAnimal.getKeeper()
        );
        return keeperAnimalDTO;
    }

    public KeeperAnimals convertToModel(KeeperAnimalDTO keeperAnimalDTO){
        var animal = animalRepository.findById(keeperAnimalDTO.getAnimal().getAnimalID())
            .orElseThrow(() -> new RuntimeException("Animal not found"));
        var keeper = keeperRepository.findById(keeperAnimalDTO.getKeeper().getKeeperID())
            .orElseThrow(() -> new RuntimeException("Keeper not found"));
        KeeperAnimals keeperAnimal = new KeeperAnimals(
            0,
            animal,
            keeper
        );
        return keeperAnimal;
    }
    
}
