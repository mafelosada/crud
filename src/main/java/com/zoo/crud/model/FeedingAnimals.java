package com.zoo.crud.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "feedingAnimal")
public class FeedingAnimals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedingAnimalID")
    private int feedingAnimalID;

    @ManyToOne
    @JoinColumn(name = "animalID", nullable = false)
    private Animals animal;

    @ManyToOne
    @JoinColumn(name = "feedingID", nullable = false)
    private Feedings feeding;

    @Column(name = "schedule", length = 50)
    private String schedule;

    @Column(name = "isActive", nullable = false)
    private Boolean isActive = true;

    // Constructor vacío
    public FeedingAnimals() {
    }

    // Constructor con parámetros
    public FeedingAnimals(int feedingAnimalID, Animals animal, Feedings feeding, String schedule) {
        this.feedingAnimalID = feedingAnimalID;
        this.animal = animal;
        this.feeding = feeding;
        this.schedule = schedule;
    }

     // Constructor con parámetros
     public FeedingAnimals(int feedingAnimalID, Animals animal, Feedings feeding, String schedule, Boolean isActive) {
        this.feedingAnimalID = feedingAnimalID;
        this.animal = animal;
        this.feeding = feeding;
        this.schedule = schedule;
        this.isActive = isActive;
    }

    // Getters y Setters
    public int getFeedingAnimalID() {
        return feedingAnimalID;
    }

    public void setFeedingAnimalID(int feedingAnimalID) {
        this.feedingAnimalID = feedingAnimalID;
    }

    public Animals getAnimal() {
        return animal;
    }

    public void setAnimal(Animals animal) {
        this.animal = animal;
    }

    public Feedings getFeeding() {
        return feeding;
    }

    public void setFeeding(Feedings feeding) {
        this.feeding = feeding;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}

