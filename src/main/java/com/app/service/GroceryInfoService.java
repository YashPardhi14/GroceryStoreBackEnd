package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.GroceryAmounts;
import com.app.model.GroceryInfo;
import com.app.model.GrocerySource;
import com.app.repository.GroceryAmountsRepository;
import com.app.repository.GroceryInfoRepository;
import com.app.repository.GrocerySourceRepository;




@Service
public class GroceryInfoService {
	
	
	@Autowired
	private GroceryInfoRepository groceryInfoRepository;
	
	
	@Autowired
	private GroceryAmountsRepository groceryAmountsRepository;
	
	@Autowired
	private GrocerySourceRepository grocerySourceRepository;
	
	
	
	
	

	
	public List<GroceryInfo> getAllGroceries(){
		GrocerySource grocerySource = new GrocerySource();
		
		GroceryAmounts groceryAmount = new GroceryAmounts();
		
		groceryAmount.getTotalCostOfItems();
		
		grocerySource.getStateName();
		grocerySource.getSource_id();
		
		 List<GroceryInfo> groceries = groceryInfoRepository.findAll();
		 
		 return groceries;
		
		
		
	}
	
	
//	 @Transactional
	    public GroceryInfo addGrocery(GroceryInfo grocery) {
		 try {
			    grocery.getGroceryAmounts().setTotalCostOfItems(
			        grocery.getCostPerItem() * grocery.getGroceryAmounts().getItemsAvailable()
			    );

			    grocery.setGrocerySource(manageGrocerySource(grocery.getGrocerySource()));

			   return  groceryInfoRepository.save(grocery);  // Save all entities at once
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Failed to add grocery", e);
			}

			
}
	 
	 private GrocerySource manageGrocerySource(GrocerySource grocerySource) {
		    GrocerySource existingSource = grocerySourceRepository.findByName(grocerySource.getStateName());

		    if (existingSource != null) {
		        return existingSource;
		    } else {
		        return grocerySourceRepository.save(grocerySource);
		    }
		}
	 
	 public GroceryInfo getGroceryById(int Id) {
		 
		 GroceryInfo grocery =  groceryInfoRepository.findById(Id).orElse(null);
		 
		 if(grocery==null) {
			 System.out.println("Grocery with ID->"+Id +"(Not Present in the database.....)");
		 }
		 
		 
		 return grocery;
		 
	 }
	 
	 public GroceryInfo updateGrocery(int id,GroceryInfo updatedGrocery) {
		 
		 GroceryInfo existingGrocery = groceryInfoRepository.findById(id).orElse(null);
		 
		 if(existingGrocery !=null) {
			 existingGrocery.setGroceryName(updatedGrocery.getGroceryName());
			 
			 existingGrocery.setCostPerItem(updatedGrocery.getCostPerItem());
			 
			// Update item amounts if provided
			 if(updatedGrocery.getGroceryAmounts()!=null) {
				 existingGrocery.getGroceryAmounts().setItemsAvailable(updatedGrocery.getGroceryAmounts().getItemsAvailable());
				 
				 Double  newTotalCost =updatedGrocery.getCostPerItem() * (updatedGrocery.getGroceryAmounts().getItemsAvailable());
				 existingGrocery.getGroceryAmounts().setTotalCostOfItems(newTotalCost);
			 }
			 
			 
		           
		        // Update grocery source if provided and state changed
		        
		        if(updatedGrocery.getGrocerySource() != null && existingGrocery.getGrocerySource().getSource_id() != updatedGrocery.getGrocerySource().getSource_id()) {
		        	
		        	int newStateId = updatedGrocery.getGrocerySource().getSource_id();
		        	
		        	 // Try to find existing source with new state
		            Optional<GrocerySource> existingSourceState = grocerySourceRepository.findById(newStateId);
		            
		            if(existingSourceState.isPresent()) {
		            	existingGrocery.setGrocerySource(existingSourceState.get());
		            	
		        }else {
		        	GrocerySource newSource = new GrocerySource();
		        	newSource.setSource_id(newStateId);
		        	newSource.setStateName(updatedGrocery.getGrocerySource().getStateName());
		        	grocerySourceRepository.save(newSource);
		        	existingGrocery.setGrocerySource(newSource);
		        }

		         
			 
		 }
		        
		     // Save the updated grocery and return it
		         return groceryInfoRepository.save(existingGrocery);
		     
		 
	 }else {
		// Throw an error if the grocery with the given ID is not found
	        throw new RuntimeException("Grocery not found with ID: " + id);

	 }
		
	 
	  
}
	 
	 
}
	 
