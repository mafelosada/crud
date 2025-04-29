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
public class Animals {
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
    private Specie species;

    @ManyToOne
    @JoinColumn(name = "sectionID", nullable = false)
    private Sections section;

    @ManyToOne
    @JoinColumn(name = "statusID", nullable = false)
    private Statuss status;

    @Column(name = "isActive", nullable = false)
    private Boolean isActive = true;


     // Constructor vacío
     public Animals() {
    }
     // Constructor con parámetros
     public Animals(int animalID, String nameAnimal, Date dateBirth, String foto, Specie species, Sections section, Statuss status) {
        this.animalID = animalID;
        this.nameAnimal = nameAnimal;
        this.dateBirth = dateBirth;
        this.foto = foto;
        this.species = species;
        this.section = section;
        this.status = status;
    }
       // Constructor con parámetros
       public Animals(int animalID, String nameAnimal, Date dateBirth, String foto, Specie species, Sections section, Statuss status, Boolean isActive) {
        this.animalID = animalID;
        this.nameAnimal = nameAnimal;
        this.dateBirth = dateBirth;
        this.foto = foto;
        this.species = species;
        this.section = section;
        this.status = status;
        this.isActive = isActive;
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

    public Statuss getSstatus() {
        return status;
    }

    public void setSstatus(Statuss status) {
        this.status = status;
    }
    public Boolean getIsActive() {
        return isActive;
    }
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }


}
