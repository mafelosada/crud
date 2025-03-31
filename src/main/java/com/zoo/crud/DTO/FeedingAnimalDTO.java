package com.zoo.crud.DTO;

import com.zoo.crud.model.animal;
import com.zoo.crud.model.feeding;

public class FeedingAnimalDTO {

    private animal animal;
    private feeding feeding;
    private String schedule;

    public FeedingAnimalDTO(animal animal, feeding feeding, String schedule) {
        this.animal = animal;
        this.feeding = feeding;
        this.schedule = schedule;
    }

    public animal getAnimal() {
        return animal;
    }

    public void setAnimal(animal animal) {
        this.animal = animal;
    }

    public feeding getFeeding() {
        return feeding;
    }

    public void setFeeding(feeding feeding) {
        this.feeding = feeding;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

}
