package com.zoo.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zoo.crud.model.Statuss; 

public interface Istatus extends JpaRepository<Statuss, Integer>{
    @Query("SELECT s FROM status s WHERE s.status != false")
    Statuss getListStatusActive();
    @Query("SELECT s FROM status s WHERE s.nameStatus LIKE %?1%")
    Statuss getListStatusForName(String name);

    List<Statuss> findByNameStatusContainingIgnoreCase(String name);
}
