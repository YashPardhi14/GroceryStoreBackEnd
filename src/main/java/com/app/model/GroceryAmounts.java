package com.app.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="GROCERY_AMOUNTS")
public class GroceryAmounts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	     @Column(name="GROCERY_ID")
	     private Integer id;
	   

	    @Column(name = "ITEMS_AVAILABLE")
	    private int itemsAvailable;

	    @Column(name = "TOTAL_COST_OF_ITEMS")
	    private Double totalCostOfItems;

//	    @OneToOne
//	    @JoinColumn(name = "GROCERY_ID")
//	    private GroceryInfo groceryInfo;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public int getItemsAvailable() {
			return itemsAvailable;
		}

		public void setItemsAvailable(int itemsAvailable) {
			this.itemsAvailable = itemsAvailable;
		}

		public Double getTotalCostOfItems() {
			return totalCostOfItems;
		}

		public void setTotalCostOfItems(Double totalCostOfItems) {
			this.totalCostOfItems = totalCostOfItems;
		}
		
//
//		public GroceryInfo getGroceryInfo() {
//			return groceryInfo;
//		}
//
//		public void setGroceryInfo(GroceryInfo groceryInfo) {
//			this.groceryInfo = groceryInfo;
//		}

		@Override
		public String toString() {
			return "GroceryAmounts [id=" + id + ", itemsAvailable=" + itemsAvailable + ", totalCostOfItems="
					+ totalCostOfItems +  "]";
		}
	
	
	
	

}
