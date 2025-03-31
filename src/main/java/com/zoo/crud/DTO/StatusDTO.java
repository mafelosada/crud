package com.zoo.crud.DTO;

public class StatusDTO {

    private String nameStatus;

     // Constructor vacío
     public StatusDTO() {
        
     }

    public StatusDTO(String nameStatus) {
        this.nameStatus = nameStatus;
    } 

    public String getNameStatus() {
        return nameStatus;
    }

    public void setNameStatus(String nameStatus) {
        this.nameStatus = nameStatus;
    }

}
