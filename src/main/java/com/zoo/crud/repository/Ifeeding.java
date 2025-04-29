package com.zoo.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zoo.crud.model.Feedings;

public interface Ifeeding extends JpaRepository<Feedings, Integer>{

    @Query("SELECT f FROM feeding f WHERE f.status != false")
    List<Feedings> findAllActiveFeeding();
    @Query("SELECT f FROM feeding f WHERE f.nameFeeding LIKE %?1%")
    List<Feedings> findByNameFeeding(String name);

    List<Feedings> findByNameFeedingContainingIgnoreCase(String name);
}
