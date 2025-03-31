package com.zoo.crud.DTO;

import java.util.Date;

import com.zoo.crud.model.animal;
import com.zoo.crud.model.keeper;

public class RegisterAnimalDTO {

     private animal animal;
    private keeper keeper;
    private Date date;
    private String diagnostic;

    public RegisterAnimalDTO(animal animal, keeper keeper, Date date, String diagnostic) {
        this.animal = animal;
        this.keeper = keeper;
        this.date = date;
        this.diagnostic = diagnostic;
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
