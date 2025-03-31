package com.zoo.crud.DTO;

import com.zoo.crud.model.registerAnimal;

public class MedicationDTO {

    private registerAnimal registerAnimal;
    private String description;
    private String medicine;
    private String dose;
    private String duration;

    public MedicationDTO(registerAnimal registerAnimal, String description, String medicine, String dose, String duration) {
        this.registerAnimal = registerAnimal;
        this.description = description;
        this.medicine = medicine;
        this.dose = dose;
        this.duration = duration;
    }

    public registerAnimal getRegisterAnimal() {
        return registerAnimal;
    }

    public void setRegisterAnimal(registerAnimal registerAnimal) {
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
