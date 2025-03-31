package com.zoo.crud.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "feedingAnimal")
public class feedingAnimal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedingAnimalID")
    private int feedingAnimalID;

    @ManyToOne
    @JoinColumn(name = "animalID", nullable = false)
    private animal animal;

    @ManyToOne
    @JoinColumn(name = "feedingID", nullable = false)
    private feeding feeding;

    @Column(name = "schedule", length = 50)
    private String schedule;

    // Constructor vacío
    public feedingAnimal() {
    }

    // Constructor con parámetros
    public feedingAnimal(int feedingAnimalID, animal animal, feeding feeding, String schedule) {
        this.feedingAnimalID = feedingAnimalID;
        this.animal = animal;
        this.feeding = feeding;
        this.schedule = schedule;
    }

    // Getters y Setters
    public int getFeedingAnimalID() {
        return feedingAnimalID;
    }

    public void setFeedingAnimalID(int feedingAnimalID) {
        this.feedingAnimalID = feedingAnimalID;
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

