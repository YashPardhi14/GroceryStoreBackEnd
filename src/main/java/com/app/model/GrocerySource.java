package com.app.model;
//
//import java.util.List;
//
//import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "GROCERY_SOURCE")
public class GrocerySource {

	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer state_id;

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

	public Integer getId() {
		return state_id;
	}

	public void setId(Integer id) {
		this.state_id = id;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
	public String toString() {
		return "GroceryInfo [id=" + state_id + ", stateName=" + stateName + "]";
	}

}
