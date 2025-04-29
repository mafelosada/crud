package com.zoo.crud.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FeedingDTO {

     @JsonProperty("id")
    private int feedingID;
    private String nameFeeding;

    public FeedingDTO() {
        // Constructor vacío necesario para Jackson
    }


    public FeedingDTO(int feedingID, String nameFeeding) {
        this.nameFeeding = nameFeeding;
        this.feedingID = feedingID;
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
