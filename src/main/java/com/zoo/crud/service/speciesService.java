package com.zoo.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.zoo.crud.DTO.ResponsesDTO;
import com.zoo.crud.DTO.SpeciesDTO;
import com.zoo.crud.model.Specie;
import com.zoo.crud.repository.Ispecies;

@Service
public class speciesService {
    @Autowired
    private Ispecies data;

    public List<Specie> findAll(){
        return data.findAll();
    }

    public List<Specie> getListSpeciesForName(String name) {
        return data.findByNameSpeciesContainingIgnoreCase(name);
    }    

    public Optional<Specie> findById(int id){
        return data.findById(id);
    }

    public ResponsesDTO deleteSpecies(int id){
        Optional<Specie> species = findById(id);
        if (!species.isPresent()){
            return new ResponsesDTO(HttpStatus.NOT_FOUND.toString(), "The register does not exist");
        }
        
        data.deleteById(id);  // 🔹 Aquí realmente se elimina el registro.
    
        return new ResponsesDTO(HttpStatus.OK.toString(), "Se eliminó correctamente");
    }
    

    public ResponsesDTO save(SpeciesDTO speciesDTO){
        Specie species = convertToModel(speciesDTO);
        data.save(species);
        ResponsesDTO respuesta = new ResponsesDTO(
            HttpStatus.OK.toString(),
            "Se guardó correctamente"
        );
        return respuesta;
    }

    public ResponsesDTO updateSpecies(int id, SpeciesDTO speciesDTO){
        Optional<Specie> species = findById(id);
        if (!species.isPresent()){
            return new ResponsesDTO(HttpStatus.NOT_FOUND.toString(), "The register does not exist");
        }
        
        Specie updatedSpecies = species.get();
        updatedSpecies.setNameSpecies(speciesDTO.getNameSpecies());
        updatedSpecies.setDescription(speciesDTO.getDescription());
    
        data.save(updatedSpecies);  // 🔹 Guardamos los cambios en la BD
    
        return new ResponsesDTO(HttpStatus.OK.toString(), "Se actualizó correctamente");
    }
    


    public SpeciesDTO converToDTO(Specie species){
        SpeciesDTO speciesDTO = new SpeciesDTO(
            species.getSpeciesID(),
            species.getNameSpecies(),
            species.getDescription()
        );
        return speciesDTO;
    }

    public Specie convertToModel(SpeciesDTO speciesDTO){
        Specie species = new Specie(
            0,
            speciesDTO.getNameSpecies(),
            speciesDTO.getDescription()
        );
        return species;
    }

}
