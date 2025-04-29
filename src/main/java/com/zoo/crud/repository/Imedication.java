package com.zoo.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zoo.crud.model.Medications;

public interface Imedication extends JpaRepository<Medications, Integer>{
    @Query("SELECT m FROM medication m WHERE m.isActive != false")
    List<Medications> findAllActiveMedications();

    @Query("SELECT m FROM medication m WHERE m.medicine LIKE %?1%")
    List<Medications> findByMedicine(String name);

    List<Medications> findByMedicineContaining(String name);


}
