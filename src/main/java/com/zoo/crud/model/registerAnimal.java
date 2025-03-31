package com.zoo.crud.model;

import jakarta.persistence.*;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "registerAnimal")
public class registerAnimal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registerAnimalID")
    private int registerAnimalID;

    @ManyToOne
    @JoinColumn(name = "animalID", nullable = false)
    private animal animal;

    @ManyToOne
    @JoinColumn(name = "keeperID", nullable = false)
    private keeper keeper;

    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "diagnostic", columnDefinition = "TEXT", nullable = false)
    private String diagnostic;

    // Constructor vacío
    public registerAnimal() {
    }

    // Constructor con parámetros
    public registerAnimal(int registerAnimalID, animal animal, keeper keeper, Date date, String diagnostic) {
        this.registerAnimalID = registerAnimalID;
        this.animal = animal;
        this.keeper = keeper;
        this.date = date;
        this.diagnostic = diagnostic;
    }

    // Getters y Setters
    public int getRegisterAnimalID() {
        return registerAnimalID;
    }

    public void setRegisterAnimalID(int registerAnimalID) {
        this.registerAnimalID = registerAnimalID;
    }

    public animal getAnimal() {
        return animal;
    }

    public void setAnimal(animal animal) {
        this.animal = animal;
    }

    public keeper getKeeper() {
        return keeper;
    }

    public void setKeeper(keeper keeper) {
        this.keeper = keeper;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }
}

