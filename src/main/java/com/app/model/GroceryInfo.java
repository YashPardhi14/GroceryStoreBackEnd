package com.app.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="GROCERY_INFO")
public class GroceryInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer item_id;
	
	
	@Column(name="GROCERY_NAME")
	private String groceryName;
	
	public GrocerySource getGrocerySource() {
		return grocerySource;
	}


	public void setGrocerySource(GrocerySource grocerySource) {
		this.grocerySource = grocerySource;
	}


	@Column(name = "COST_PER_ITEM")
	private Double costPerItem;
	
	@Column(name="grocery_source_id")
	private Integer sourceID;
	
	
	public Integer getItem_id() {
		return item_id;
	}


	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}


	public Integer getSourceID() {
		return sourceID;
	}


	public void setSourceID(Integer sourceID) {
		this.sourceID = sourceID;
	}


	@OneToOne(mappedBy = "groceryInfo",cascade = CascadeType.ALL)
	@JoinColumn(name="item_id",referencedColumnName = "id")
	private GroceryAmounts groceryAmounts;

	@ManyToOne
	    @JoinColumn(name = "grocery_source_id",referencedColumnName = "")
	    private GrocerySource grocerySource;



	public String getGroceryName() {
		return groceryName;
	}


	public void setGroceryName(String groceryName) {
		this.groceryName = groceryName;
	}


	public Double getCostPerItem() {
		return costPerItem;
	}


	public void setCostPerItem(Double costPerItem) {
		this.costPerItem = costPerItem;
	}


	public GroceryAmounts getGroceryAmounts() {
		return groceryAmounts;
	}


	public void setGroceryAmounts(GroceryAmounts groceryAmounts) {
		this.groceryAmounts = groceryAmounts;
	}


	@Override
	public String toString() {
		return "GroceryInfo [item_id=" + item_id + ", groceryName=" + groceryName + ", costPerItem=" + costPerItem
				+ ", sourceID=" + sourceID + ", groceryAmounts=" + groceryAmounts + ", grocerySource=" + grocerySource
				+ "]";
	}
	
	
	
	
	
	

	
	

}
