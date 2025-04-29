package com.zoo.crud.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zoo.crud.model.Animals;
import com.zoo.crud.model.Keepers;

public class KeeperAnimalDTO {

    @JsonProperty("id")
    private int keeperAnimalID;
    private Animals animal;
    private Keepers keeper;

    public KeeperAnimalDTO() {
    }

    public KeeperAnimalDTO(int keeperAnimalID, Animals animal, Keepers keeper) {
        this.keeperAnimalID = keeperAnimalID;
        this.animal = animal;
        this.keeper = keeper;
    }

    public int getKeeperAnimalID() {
        return keeperAnimalID;
    }

    public void setKeeperAnimalID(int keeperAnimalID) {
        this.keeperAnimalID = keeperAnimalID;
    }

    public Animals getAnimal() {
        return animal;
    }

    public void setAnimal(Animals animal) {
        this.animal = animal;
    }

    public Keepers getKeeper() {
        return keeper;
    }

    public void setKeeper(Keepers keeper) {
        this.keeper = keeper;
    }

}
