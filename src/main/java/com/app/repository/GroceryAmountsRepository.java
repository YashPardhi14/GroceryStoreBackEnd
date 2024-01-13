package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.app.model.GroceryAmounts;

public interface GroceryAmountsRepository extends JpaRepository<GroceryAmounts,Integer> {

}
