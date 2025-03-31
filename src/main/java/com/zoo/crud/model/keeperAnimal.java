package com.zoo.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "keeperAnimal")
public class keeperAnimal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "keeperAnimalID")
    private int keeperAnimalID;

    @ManyToOne
    @JoinColumn(name = "animalID", nullable = false)
    private animal animal;

    @ManyToOne
    @JoinColumn(name = "keeperID", nullable = false)
    private keeper keeper;

    // Constructor vacío
    public keeperAnimal() {
    }

    // Constructor con parámetros
    public keeperAnimal(int keeperAnimalID, animal animal, keeper keeper) {
        this.keeperAnimalID = keeperAnimalID;
        this.animal = animal;
        this.keeper = keeper;
    }

    // Getters y Setters
    public int getKeeperAnimalID() {
        return keeperAnimalID;
    }

    public void setKeeperAnimalID(int keeperAnimalID) {
        this.keeperAnimalID = keeperAnimalID;
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
}

