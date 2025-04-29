package com.zoo.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zoo.crud.model.Specie; 

public interface Ispecies extends JpaRepository<Specie, Integer>{
    @Query("SELECT s FROM species s WHERE s.status != false")
    List<Specie> findAllActiveSpecies();

    @Query("SELECT s FROM species s WHERE s.nameSpecies LIKE %?1%")
    List<Specie> findByNameSpecies(String name);

    List<Specie> findByNameSpeciesContainingIgnoreCase(String name);
    List<Specie> findByDescriptionContainingIgnoreCase(String description);


}
