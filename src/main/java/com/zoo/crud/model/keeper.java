package com.zoo.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "keeper")
public class keeper {
    /*
    * Atributos o columnas de la entidad Keeper
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="keeperID")
    private int keeperID;

    @Column(name="nameKeeper", length=100, nullable=false)
    private String nameKeeper;

    @Column(name="phone", length=15, nullable=false)
    private String phone;

    @Column(name="specialty", length=100, nullable=false)
    private String specialty;

    // Constructor vacío
    public keeper() {
    }

    // Constructor con parámetros
    public keeper(int keeperID, String nameKeeper, String phone, String specialty) {
        this.keeperID = keeperID;
        this.nameKeeper = nameKeeper;
        this.phone = phone;
        this.specialty = specialty;
    }

    // Métodos getter y setter
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
