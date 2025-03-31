package com.zoo.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "species")
public class species {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="speciesID")
    private int speciesID;

    @Column(name="nameSpecies", length=50, nullable=false)
    private String nameSpecies;

    @Column(name ="description", columnDefinition="TEXT", nullable=false)
    private String description;

    public species() {
    }

    public species(int speciesID, String nameSpecies, String description) {
        this.speciesID = speciesID;
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
