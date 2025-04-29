package com.zoo.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zoo.crud.model.Sections;

public interface Isection extends JpaRepository<Sections, Integer> {
    @Query("SELECT s FROM section s WHERE s.status != false")
    List<Sections> getListSectionsActive();


    @Query("SELECT s FROM section s WHERE s.nameSection LIKE %?1%")
    List<Sections> findByNameSection(String name);

    List<Sections> findByNameSectionContainingIgnoreCase(String name);

}
