package com.zoo.crud.DTO;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zoo.crud.model.Animals;
import com.zoo.crud.model.Keepers;

public class RegisterAnimalDTO {

    @JsonProperty("id")
    private int registerAnimalID;
     private Animals animal;
    private Keepers keeper;
    private Date date;
    private String diagnostic;

    public RegisterAnimalDTO() {
    }

    public RegisterAnimalDTO(int registerAnimalID, Animals animal, Keepers keeper, Date date, String diagnostic) {
        this.registerAnimalID = registerAnimalID;
        this.animal = animal;
        this.keeper = keeper;
        this.date = date;
        this.diagnostic = diagnostic;
    }

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

}
