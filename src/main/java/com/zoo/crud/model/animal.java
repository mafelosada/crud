package com.zoo.crud.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity(name = "animal")
public class animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animalID")
    private int animalID;

     @Column(name = "nameAnimal", length = 100, nullable = false)
    private String nameAnimal;

    @Column(name = "dateBirth", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateBirth;

    @Column(name = "foto", length = 225, nullable = false)
    private String foto;

    @ManyToOne
    @JoinColumn(name = "speciesID", nullable = false)
    private species species;

    @ManyToOne
    @JoinColumn(name = "sectionID", nullable = false)
    private section section;

    @ManyToOne
    @JoinColumn(name = "statusID", nullable = false)
    private status status;

     // Constructor vacío
     public animal() {
    }

    // Constructor con parámetros
    public animal(int animalID, String nameAnimal, Date dateBirth, String foto, species species, section section, status status) {
        this.animalID = animalID;
        this.nameAnimal = nameAnimal;
        this.dateBirth = dateBirth;
        this.foto = foto;
        this.species = species;
        this.section = section;
        this.status = status;
    }

     // Getters y Setters
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
