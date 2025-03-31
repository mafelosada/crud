package com.zoo.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "status")

public class status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="statusID")
    private int statusID;

    @Column(name ="nameStatus", nullable=false)
    private String nameStatus;

    public status() {
    }

    public status(int statusID, String nameStatus) {
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
