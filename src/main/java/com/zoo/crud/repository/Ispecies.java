package com.zoo.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zoo.crud.model.species; 

public interface Ispecies extends JpaRepository<species, Integer>{

}
