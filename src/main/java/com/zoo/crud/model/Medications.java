package com.zoo.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "medication")
public class Medications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicationID")
    private int medicationID;

    @ManyToOne
    @JoinColumn(name = "registerAnimalID", nullable = false)
    private RegisterAnimals registerAnimal;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "medicine", length = 100)
    private String medicine;

    @Column(name = "dose", length = 50)
    private String dose;

    @Column(name = "duration", length = 50)
    private String duration;

    @Column(name = "isActive", nullable = false)
    private Boolean isActive = true;

    // Constructor vacío
    public Medications() {
    }

        // Constructor con parámetros
        public Medications(int medicationID, RegisterAnimals registerAnimal, String description, String medicine, String dose, String duration) {
            this.medicationID = medicationID;
            this.registerAnimal = registerAnimal;
            this.description = description;
            this.medicine = medicine;
            this.dose = dose;
            this.duration = duration;
        }

    // Constructor con parámetros
    public Medications(int medicationID, RegisterAnimals registerAnimal, String description, String medicine, String dose, String duration, Boolean isActive) {
        this.medicationID = medicationID;
        this.registerAnimal = registerAnimal;
        this.description = description;
        this.medicine = medicine;
        this.dose = dose;
        this.duration = duration;
        this.isActive = isActive;
    }

    // Getters y Setters
    public int getMedicationID() {
        return medicationID;
    }

    public void setMedicationID(int medicationID) {
        this.medicationID = medicationID;
    }

    public RegisterAnimals getRegisterAnimal() {
        return registerAnimal;
    }

    public void setRegisterAnimal(RegisterAnimals registerAnimal) {
        this.registerAnimal = registerAnimal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}

