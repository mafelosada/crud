package com.zoo.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "feeding")
public class feeding {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="feedingID")
    private int feedingID;

    @Column(name ="nameFeeding", length=100, nullable=false)
    private String nameFeeding;

    public feeding() {
    }

    public feeding(int feedingID, String nameFeeding) {
        this.feedingID = feedingID;
        this.nameFeeding = nameFeeding;
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

    
}

