package com.zoo.crud.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KeeperDTO {

     @JsonProperty("id")
    private int keeperID;
    private String nameKeeper;
    private String phone;
    private String specialty;

    public KeeperDTO() {
        // Constructor vacío necesario para Jackson
    }

    public KeeperDTO(int keeperID, String nameKeeper, String phone, String specialty) {
        this.keeperID = keeperID;
        this.nameKeeper = nameKeeper;
        this.phone = phone;
        this.specialty = specialty;
    }

    public int getKeeperID() {
        return keeperID;
    }

    public void setKeeperID(int keeperID) {
        this.keeperID = keeperID;
    }

    public String getNameKeeper() {
        return nameKeeper;
    }

    public void setNameKeeper(String nameKeeper) {
        this.nameKeeper = nameKeeper;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

}
