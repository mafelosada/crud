package com.zoo.crud.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SectionDTO {
    @JsonProperty("id")
    private int sectionID;
    private String nameSection;
    private String location;

    public SectionDTO() {
    }

    public SectionDTO(int sectionID, String nameSection, String location) {
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
