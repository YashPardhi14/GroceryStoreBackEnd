package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.GrocerySource;

public interface GrocerySourceRepository extends JpaRepository<GrocerySource, Integer> {

}
