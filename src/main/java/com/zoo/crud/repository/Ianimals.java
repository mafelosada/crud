package com.zoo.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zoo.crud.model.Animals;

public interface Ianimals extends JpaRepository<Animals, Integer>{

      @Query("SELECT a FROM animal a WHERE a.isActive = true")
      List<Animals> findAllActiveAnimal();
      

      @Query("SELECT a FROM animal a WHERE a.nameAnimal LIKE %?1%")
      List<Animals> findByNameAnimal(String name);

      List<Animals> findByNameAnimalContainingIgnoreCase(String name);

}