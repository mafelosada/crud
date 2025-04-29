package com.zoo.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zoo.crud.model.KeeperAnimals;

public interface IkeeperAnimal extends JpaRepository<KeeperAnimals, Integer>{

    List<KeeperAnimals> findByKeeperNameKeeperContainingIgnoreCase(String name);
    List<KeeperAnimals> findByIsActiveTrue();
}
