package com.zoo.crud.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SpeciesDTO {

    @JsonProperty("id")
    private int speciesID;
    private String nameSpecies;
    private String description;

    public SpeciesDTO() {
    }

    public SpeciesDTO(int especiesID, String nameSpecies, String description) {
        this.speciesID = especiesID;
        this.nameSpecies = nameSpecies;
        this.description = description;
    }

    public int getSpeciesID() {
        return speciesID;
    }

    public void setSpeciesID(int speciesID) {
        this.speciesID = speciesID;
    }

    public String getNameSpecies() {
        return nameSpecies;
    }

    public void setNameSpecies(String nameSpecies) {
        this.nameSpecies = nameSpecies;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
