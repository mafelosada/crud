package com.zoo.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zoo.crud.model.keeperAnimal;

public interface IkeeperAnimal extends JpaRepository<keeperAnimal, Integer>{

}
