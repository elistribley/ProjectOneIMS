package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Item {
	
	private Long itemId;
	private String itemName;
	private Double itemPrice;
	//CONSTRUCTORS
	public Item(Long itemId, String itemName, Double itemPrice) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}
	public Item() {
		super();
	}
	//GETTERS AND SETTERS
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}
	//HASHCODE AND EQUALS
	@Override
	public int hashCode() {
		return Objects.hash(itemId, itemName, itemPrice);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(itemId, other.itemId) && Objects.equals(itemName, other.itemName)
				&& Objects.equals(itemPrice, other.itemPrice);
	}
	
	
	
	
}
