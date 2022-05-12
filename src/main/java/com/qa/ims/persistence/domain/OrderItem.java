package com.qa.ims.persistence.domain;

import java.util.Objects;

public class OrderItem{

	private Long orderItemsId;
	private Long orderId;
	private Long itemId;
	
	
	public OrderItem(Long orderItemsId, Long orderId, Long itemId) {
		super();
		this.orderItemsId = orderItemsId;
		this.orderId = orderId;
		this.itemId = itemId;
		
	}
	
	
	public OrderItem(Long orderId, Long itemId) {
		super();
		this.orderId = orderId;
		this.itemId = itemId;
	}


	public OrderItem() {
		super();
	}
	public Long getOrderItemsId() {
		return orderItemsId;
	}
	public void setOrderItemsId(Long orderItemsId) {
		this.orderItemsId = orderItemsId;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(itemId, orderId, orderItemsId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(itemId, other.itemId) && Objects.equals(orderId, other.orderId)
				&& Objects.equals(orderItemsId, other.orderItemsId);
	}
	
	
	
	
	
}
