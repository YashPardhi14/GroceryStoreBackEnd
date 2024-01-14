package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.GroceryAmounts;
import com.app.repository.GroceryAmountsRepository;



@Service
public class GroceryAmountsService {
	
@Autowired
	GroceryAmountsRepository groceryAmountsRepository;



public List<GroceryAmounts> getAllAmount(){
	
	List<GroceryAmounts> getAllAmountDetails =groceryAmountsRepository.findAll();
	
	return getAllAmountDetails;
	
}
	
	
	
}
