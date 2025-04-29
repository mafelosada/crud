package com.zoo.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zoo.crud.model.FeedingAnimals;

public interface IfeedingAnimal extends JpaRepository<FeedingAnimals, Integer> {

    List<FeedingAnimals> findByAnimalNameAnimalContainingIgnoreCase(String name);

    List<FeedingAnimals> findByIsActiveTrue();
}
