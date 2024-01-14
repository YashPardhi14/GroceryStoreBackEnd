package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.GrocerySource;
import com.app.repository.GrocerySourceRepository;





@Service
public class GrocerySourceService  {
	
	
	@Autowired
	GrocerySourceRepository grocerySourceService;
	
	
	public List<GrocerySource>  getAllState(){
		
		List<GrocerySource> allStates = grocerySourceService.findAll();
		
		return allStates;
	}
	
	
	

}
