package com.zoo.crud.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity(name = "registerAnimal")
public class RegisterAnimals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registerAnimalID")
    private int registerAnimalID;

    @ManyToOne
    @JoinColumn(name = "animalID", nullable = false)
    private Animals animal;

    @ManyToOne
    @JoinColumn(name = "keeperID", nullable = false)
    private Keepers keeper;

    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "diagnostic", columnDefinition = "TEXT", nullable = false)
    private String diagnostic;

    @Column(name="status")
    private Boolean isActive;

    // Constructor vacío
    public RegisterAnimals() {
    }

    // Constructor con parámetros
    public RegisterAnimals(int registerAnimalID, Animals animal, Keepers keeper, Date date, String diagnostic) {
        this.registerAnimalID = registerAnimalID;
        this.animal = animal;
        this.keeper = keeper;
        this.date = date;
        this.diagnostic = diagnostic;
    }


    // Constructor con parámetros
    public RegisterAnimals(int registerAnimalID, Animals animal, Keepers keeper, Date date, String diagnostic,  Boolean isActive) {
        this.registerAnimalID = registerAnimalID;
        this.animal = animal;
        this.keeper = keeper;
        this.date = date;
        this.diagnostic = diagnostic;
        this.isActive = isActive;
    }

    // Getters y Setters
    public int getRegisterAnimalID() {
        return registerAnimalID;
    }

    public void setRegisterAnimalID(int registerAnimalID) {
        this.registerAnimalID = registerAnimalID;
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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}

