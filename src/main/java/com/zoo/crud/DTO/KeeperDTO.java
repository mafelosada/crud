package com.zoo.crud.DTO;

public class KeeperDTO {

    private String nameKeeper;
    private String phone;
    private String specialty;

    public KeeperDTO(String nameKeeper, String phone, String specialty) {
        this.nameKeeper = nameKeeper;
        this.phone = phone;
        this.specialty = specialty;
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
