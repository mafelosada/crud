package com.zoo.crud.DTO;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zoo.crud.model.Sections;
import com.zoo.crud.model.Specie;
import com.zoo.crud.model.Statuss;

public class AnimalDTO {

     @JsonProperty("id")
    private int animalID;
    private String nameAnimal;
    private Date dateBirth;
    private String foto;
    private Specie species;
    private Sections section;
    private Statuss status;
    
    public AnimalDTO(int animalID, String nameAnimal, Date dateBirth, String foto, Specie species, Sections section, Statuss status) {
        this.animalID = animalID;
        this.nameAnimal = nameAnimal;
        this.dateBirth = dateBirth;
        this.foto = foto;
        this.species = species;
        this.section = section;
        this.status = status;
    }

    public int getAnimalID() {
        return animalID;
    }

    public void setAnimalID(int animalID) {
        this.animalID = animalID;
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

    public Specie getSpecies() {
        return species;
    }

    public void setSpecies(Specie species) {
        this.species = species;
    }

    public Sections getSection() {
        return section;
    }

    public void setSection(Sections section) {
        this.section = section;
    }

    public Statuss getStatus() {
        return status;
    }

    public void setStatus(Statuss status) {
        this.status = status;
    }

}
