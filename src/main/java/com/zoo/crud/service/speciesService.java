package com.zoo.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoo.crud.DTO.SpeciesDTO;
import com.zoo.crud.model.species;
import com.zoo.crud.repository.Ispecies;

@Service
public class speciesService {
    @Autowired
    private Ispecies data;

     public void save(SpeciesDTO speciesDTO){
        species species = convertToModel(speciesDTO);
        data.save(species);
    }

    public SpeciesDTO converToDTO(species species){
        SpeciesDTO speciesDTO = new SpeciesDTO(
            species.getNameSpecies(),
            species.getDescription()
        );
        return speciesDTO;
    }

    public species convertToModel(SpeciesDTO speciesDTO){
        species species = new species(
            0,
            speciesDTO.getNameSpecies(),
            speciesDTO.getDescription()
        );
        return species;
    }

}
