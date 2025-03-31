package com.zoo.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zoo.crud.model.keeper;

public interface Ikeeper extends JpaRepository<keeper, Integer>{

}
