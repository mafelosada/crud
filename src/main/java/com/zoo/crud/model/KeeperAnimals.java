package com.zoo.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "keeperAnimal")
public class KeeperAnimals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "keeperAnimalID")
    private int keeperAnimalID;

    @ManyToOne
    @JoinColumn(name = "animalID", nullable = false)
    private Animals animal;

    @ManyToOne
    @JoinColumn(name = "keeperID", nullable = false)
    private Keepers keeper;

    @Column(name = "isActive", nullable = false)
    private Boolean isActive = true;

    // Constructor vacío
    public KeeperAnimals() {
    }

    // Constructor con parámetros
    public KeeperAnimals(int keeperAnimalID, Animals animal, Keepers keeper) {
        this.keeperAnimalID = keeperAnimalID;
        this.animal = animal;
        this.keeper = keeper;
    }

    // Constructor con parámetros
    public KeeperAnimals(int keeperAnimalID, Animals animal, Keepers keeper, Boolean isActive) {
        this.keeperAnimalID = keeperAnimalID;
        this.animal = animal;
        this.keeper = keeper;
        this.isActive = isActive;
    }

    // Getters y Setters
    public int getKeeperAnimalID() {
        return keeperAnimalID;
    }

    public void setKeeperAnimalID(int keeperAnimalID) {
        this.keeperAnimalID = keeperAnimalID;
    }

    public Animals getAnimal() {
        return animal;
    }

    public void setAnimal(Animals animal) {
        this.animal = animal;
    }

    public Keepers getKeeper() {
        return keeper;
    }

    public void setKeeper(Keepers keeper) {
        this.keeper = keeper;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}

