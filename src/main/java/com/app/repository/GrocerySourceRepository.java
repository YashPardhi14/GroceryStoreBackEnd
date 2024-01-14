package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.model.GrocerySource;

public interface GrocerySourceRepository extends JpaRepository<GrocerySource, Integer> {

	
	@Query("SELECT gs FROM GrocerySource gs WHERE gs.stateName = :stateName")
	GrocerySource findByName(@Param("stateName") String stateName);
}
