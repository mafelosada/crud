package com.zoo.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "section")
public class section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sectionID")
    private int sectionID;

    @Column(name="nameSection", length=50, nullable=false)
    private String nameSection;

    @Column(name ="location", length=100, nullable=false)
    private String location;

    public section() {
    }

    public section(int sectionID, String nameSection, String location) {
        this.sectionID = sectionID;
        this.nameSection = nameSection;
        this.location = location;
    }

    public int getSectionID() {
        return sectionID;
    }

    public void setSectionID(int sectionID) {
        this.sectionID = sectionID;
    }

    public String getNameSection() {
        return nameSection;
    }

    public void setNameSection(String nameSection) {
        this.nameSection = nameSection;
    }   

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}

