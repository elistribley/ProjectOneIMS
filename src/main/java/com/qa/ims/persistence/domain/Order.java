package com.qa.ims.persistence.domain;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

public class Order {
	
	private Long orderId;
	private Long customerId;
	
	private List<Item> items;

	public Order(Long orderId, Long customerId, List<Item> items) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.items = items;
	}

	public Order(Long customerId, List<Item> items) {
		super();
		this.customerId = customerId;
		this.items = items;
	}
	
	
	public Order(Long orderId, Long customerId) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
	}

	public Order(Long customerId) {
		super();
		this.customerId = customerId;
	}

	public Order() {
		super();
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, items, orderId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(customerId, other.customerId) && Objects.equals(items, other.items)
				&& Objects.equals(orderId, other.orderId);
	}
	
	

}
