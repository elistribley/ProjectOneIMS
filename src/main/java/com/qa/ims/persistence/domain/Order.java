package com.qa.ims.persistence.domain;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

public class Order {
	
	private Long orderId;
	private Long customerId;
	private Long orderDetailsId;
	private Date dateForOrder;
	private List<Item> items;
	
	public Order(Long orderId, Long customerId, Long orderDetailsId, Date dateForOrder,  List<Item> items) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderDetailsId = orderDetailsId;
		this.dateForOrder = dateForOrder;
		this.items = items;

	}

	public Order(Long orderId, Long customerId, Long orderDetailsId, List<Item> items) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderDetailsId = orderDetailsId;
		this.items = items;
	}

	public Order(Long orderId, Long orderDetailsId, List<Item> items) {
		super();
		this.orderId = orderId;
		this.orderDetailsId = orderDetailsId;
		this.items = items;
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

	public Long getOrderDetailsId() {
		return orderDetailsId;
	}

	public void setOrderDetailsId(Long orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}

	public Date getDateForOrder() {
		return dateForOrder;
	}

	public void setDateForOrder(Date dateForOrder) {
		this.dateForOrder = dateForOrder;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, dateForOrder, items, orderDetailsId, orderId);
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
		return Objects.equals(customerId, other.customerId) && Objects.equals(dateForOrder, other.dateForOrder)
				&& Objects.equals(items, other.items) && Objects.equals(orderDetailsId, other.orderDetailsId)
				&& Objects.equals(orderId, other.orderId);
	}

	

}
