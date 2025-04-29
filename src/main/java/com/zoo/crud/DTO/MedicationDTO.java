package com.zoo.crud.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zoo.crud.model.RegisterAnimals;

public class MedicationDTO {

    @JsonProperty("id")
    private int medicationID;
    private RegisterAnimals registerAnimal;
    private String description;
    private String medicine;
    private String dose;
    private String duration;

    public MedicationDTO() {
    }

    public MedicationDTO( int medicationID, RegisterAnimals registerAnimal, String description, String medicine, String dose, String duration) {
        this.medicationID = medicationID;
        this.registerAnimal = registerAnimal;
        this.description = description;
        this.medicine = medicine;
        this.dose = dose;
        this.duration = duration;
    }

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

}
