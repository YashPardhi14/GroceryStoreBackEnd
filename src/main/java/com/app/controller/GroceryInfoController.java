package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.GroceryInfo;
import com.app.service.GroceryAmountsService;
import com.app.service.GroceryInfoService;
import com.app.service.GrocerySourceService;

@RestController
@RequestMapping("/api/groceries")
public class GroceryInfoController {

	
	@Autowired
	private GroceryInfoService groceryInfoService;
	
	@Autowired
	private GroceryAmountsService groceryAmountService;
	
	@Autowired
	private GrocerySourceService grocerySourceservice;
	
	
	
	
	@GetMapping
	public ResponseEntity<List<GroceryInfo>> getAllGrocery(){
		
		try {
			List<GroceryInfo> groceries = groceryInfoService.getAllGroceries();
			
			return new ResponseEntity<>(groceries,HttpStatus.OK);
			
		}catch(Exception e) {
			
			e.printStackTrace(); // or log the exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<GroceryInfo> addGrocery(@RequestBody GroceryInfo grocery) {
	    try {
	        // Add the grocery using the service
	        GroceryInfo savedGrocery = groceryInfoService.addGrocery(grocery);

	        // Return a success response with the added grocery
	        return ResponseEntity.ok(savedGrocery);  // Use ResponseEntity.ok for 200 status
	    } catch (Exception error) {
	        // Print the error for now (replace with logging later)
	        System.out.println("Error adding grocery: " + error.getMessage());

	        // Return an error response
	        return ResponseEntity.status(500).build();  // 500 for internal server error
	    }
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<GroceryInfo> getGroceryById(@PathVariable int id) {
		
		try {
			
			GroceryInfo groceryById =groceryInfoService.getGroceryById(id);
			
			if(groceryById !=null) {
				return ResponseEntity.ok(groceryById);  // Return the grocery if found
			}else {
				return ResponseEntity.notFound().build(); // Return 404 if not found
			}
			
		}catch(Exception error){
			 // Print the error for now (replace with logging later)
			System.out.println("Error while Feteching the data"+error.getMessage());
			// Return 500 for internal server error
			return ResponseEntity.status(500).build();
			
		}
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<GroceryInfo> updateMyGrocery(@PathVariable int id,@RequestBody GroceryInfo updatedGrocery){
		
		try {
			
			GroceryInfo savedGrocery = groceryInfoService.updateGrocery(id, updatedGrocery);
			
			return ResponseEntity.ok(savedGrocery);
			
		}catch(Exception error) {
			 // Print the error for now (replace with logging later)
            System.out.println("Error updating grocery: " + error.getMessage());
            return ResponseEntity.status(500).build();  // Return 500 for internal server error
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
}
