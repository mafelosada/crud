package com.zoo.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zoo.crud.model.medication;

public interface Imedication extends JpaRepository<medication, Integer>{

}
