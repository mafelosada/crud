package com.zoo.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zoo.crud.model.Keepers;

public interface Ikeeper extends JpaRepository<Keepers, Integer>{

    @Query("SELECT k FROM keeper k WHERE k.status != false")
    List<Keepers> findAllActiveKeepers();
    @Query("SELECT k FROM keeper k WHERE k.nameKeeper LIKE %?1%")
    List<Keepers> findByNameKeeper(String name);

    List<Keepers> findByNameKeeperContainingIgnoreCase(String name);
}
