package com.zoo.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "status")

public class Statuss {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="statusID")
    private int statusID;

    @Column(name ="nameStatus", nullable=false)
    private String nameStatus;

    @Column(name="status")
    private Boolean status = true; 

    public Statuss() {
    }

    public Statuss(int statusID, String nameStatus) {
        this.statusID = statusID;
        this.nameStatus = nameStatus;
    }

    
    public Statuss(int statusID, String nameStatus, Boolean status) {
        this.statusID = statusID;
        this.nameStatus = nameStatus;
        this.status = status;
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

    public Boolean getStatus() {
        return status;
    }   

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
