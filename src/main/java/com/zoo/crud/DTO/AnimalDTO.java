package com.zoo.crud.DTO;

import java.util.Date;

import com.zoo.crud.model.section;
import com.zoo.crud.model.species;
import com.zoo.crud.model.status;

public class AnimalDTO {

    private String nameAnimal;
    private Date dateBirth;
    private String foto;
    private species species;
    private section section;
    private status status;
    
    public AnimalDTO(String nameAnimal, Date dateBirth, String foto, species species, section section, status status) {
        this.nameAnimal = nameAnimal;
        this.dateBirth = dateBirth;
        this.foto = foto;
        this.species = species;
        this.section = section;
        this.status = status;
    }

    public String getNameAnimal() {
        return nameAnimal;
    }

    public void setNameAnimal(String nameAnimal) {
        this.nameAnimal = nameAnimal;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public species getSpecies() {
        return species;
    }

    public void setSpecies(species species) {
        this.species = species;
    }

    public section getSection() {
        return section;
    }

    public void setSection(section section) {
        this.section = section;
    }

    public status getStatus() {
        return status;
    }

    public void setStatus(status status) {
        this.status = status;
    }

}
