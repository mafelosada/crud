package com.zoo.crud.DTO;

import com.zoo.crud.model.animal;
import com.zoo.crud.model.keeper;

public class KeeperAnimalDTO {

    private animal animal;
    private keeper keeper;

    public KeeperAnimalDTO(animal animal, keeper keeper) {
        this.animal = animal;
        this.keeper = keeper;
    }

    public animal getAnimal() {
        return animal;
    }

    public void setAnimal(animal animal) {
        this.animal = animal;
    }

    public keeper getKeeper() {
        return keeper;
    }

    public void setKeeper(keeper keeper) {
        this.keeper = keeper;
    }

}
