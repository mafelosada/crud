package com.zoo.crud.DTO;

public class SpeciesDTO {

    private String nameSpecies;
    private String description;

    public SpeciesDTO() {
    }

    public SpeciesDTO(String nameSpecies, String description) {
        this.nameSpecies = nameSpecies;
        this.description = description;
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
