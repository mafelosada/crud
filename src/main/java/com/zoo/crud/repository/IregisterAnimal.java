package com.zoo.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zoo.crud.model.RegisterAnimals;

public interface IregisterAnimal extends JpaRepository<RegisterAnimals, Integer>{
    @Query("SELECT r FROM registerAnimal r WHERE r.isActive != false")
    List<RegisterAnimals> findAllActiveRegisterAnimals();

    List<RegisterAnimals> findByAnimal_NameAnimal(String name);


}
 