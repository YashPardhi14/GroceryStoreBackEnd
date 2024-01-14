package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.GrocerySource;
import com.app.service.GrocerySourceService;

@RestController
@RequestMapping("/api/states")
public class GrocerySourceController {
	
	@Autowired
	
	GrocerySourceService gorcerySourceService;
	
	
	
	@GetMapping()
public List<GrocerySource>  getAllStates(){
		
		List<GrocerySource> allStates = gorcerySourceService.getAllState();
		
		return allStates;
	}
	
}