package com.zoo.crud.DTO;

public class SectionDTO {
    private String nameSection;
    private String location;

    public SectionDTO() {
    }

    public SectionDTO(String nameSection, String location) {
        this.nameSection = nameSection;
        this.location = location;
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
