package com.zoo.crud.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatusDTO {

    @JsonProperty("id")
    private int statusID;
    private String nameStatus;

     // Constructor vacío
     public StatusDTO() {
        
     }

    public StatusDTO(int statusID, String nameStatus) {
        this.statusID = statusID;
        this.nameStatus = nameStatus;
    } 

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public String getNameStatus() {
        return nameStatus;
    }

    public void setNameStatus(String nameStatus) {
        this.nameStatus = nameStatus;
    }

}
