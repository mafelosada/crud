package com.zoo.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "feeding")
public class Feedings {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="feedingID")
    private int feedingID;

    @Column(name ="nameFeeding", length=100, nullable=false)
    private String nameFeeding;

    @Column(name="status")
    private Boolean status = true; 

    public Feedings() {
    }

    public Feedings(int feedingID, String nameFeeding) {
        this.feedingID = feedingID;
        this.nameFeeding = nameFeeding;
    }

    public Feedings(int feedingID, String nameFeeding, Boolean status) {
        this.feedingID = feedingID;
        this.nameFeeding = nameFeeding;
        this.status = status;
    }

    public int getFeedingID() {
        return feedingID;
    }

    public void setFeedingID(int feedingID) {
        this.feedingID = feedingID;
    }   

    public String getNameFeeding() {
        return nameFeeding;
    }

    public void setNameFeeding(String nameFeeding) {
        this.nameFeeding = nameFeeding;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    
}

