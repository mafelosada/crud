package com.zoo.crud.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zoo.crud.model.Animals;
import com.zoo.crud.model.Feedings;

public class FeedingAnimalDTO {

    @JsonProperty("id")
    private int feedingAnimalID;
    private Animals animal;
    private Feedings feeding;
    private String schedule;

    public FeedingAnimalDTO() {
    }
    public FeedingAnimalDTO(int feedingAnimalID, Animals animal, Feedings feeding, String schedule) {
        this.feedingAnimalID = feedingAnimalID;
        this.animal = animal;
        this.feeding = feeding;
        this.schedule = schedule;
    }

    public int getFeedingAnimalID(){
        return feedingAnimalID;
    }
    public void setFeedingAnimalID(int feedingAnimalID){
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
}
