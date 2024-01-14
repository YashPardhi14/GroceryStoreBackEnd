package com.app.model;
import jakarta.persistence.Column;
//
//import java.util.List;
//
//import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;



@Entity
@Table(name = "GROCERY_SOURCE")
public class GrocerySource {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SOURCE_ID")
	private Integer source_id;

	@Column(name="STATE_NAME")
	private String stateName;

//	@OneToMany(mappedBy = "grocerySource", cascade = CascadeType.ALL)
//	private List<GroceryInfo> groceryInfos;
//
//	public List<GroceryInfo> getGroceryInfos() {
//		return groceryInfos;
//	}
//
//	public void setGroceryInfos(List<GroceryInfo> groceryInfos) {
//		this.groceryInfos = groceryInfos;
//	}



	public String getStateName() {
		return stateName;
	}

	public Integer getSource_id() {
		return source_id;
	}

	public void setSource_id(Integer source_id) {
		this.source_id = source_id;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
	public String toString() {
		return "GrocerySource [source_id=" + source_id + ", stateName=" + stateName + "]";
	}

	

}
