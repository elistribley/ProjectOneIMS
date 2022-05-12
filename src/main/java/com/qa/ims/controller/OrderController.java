package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.qa.ims.persistence.dao.ItemsDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.Utils;

/**
 * Takes in Items details for CRUD functionality
 * @param <Order>
 *
 */
public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	


	
	@Override
	public Order create() {
		
			LOGGER.info("Please enter a order id");
			Long id = utils.getLong();
			LOGGER.info("Please enter a customer id");
			Long customerId = utils.getLong();
			Order order = orderDAO.create(new Order(id, customerId));
			LOGGER.info("order created");
			return order;
		}
		
	
		

	public Order addItem() {

				LOGGER.info("Please enter an order id");
				Long orderId = utils.getLong();
				LOGGER.info("Please enter the id of the item you would like to add?");
				Long itemId = utils.getLong();
				Order orders = orderDAO.addItem(orderId, itemId);
				LOGGER.info("Order updated");

					
				return orders;
	}
	//Spoke with richard about using a add or remove method
	@Override
	public Order update() {
	String addOrRemove = "";
	LOGGER.info("Please enter the id of the order you wish to update");
	Long orderId = utils.getLong();
	LOGGER.info("Would you like to add or remove an item from an order?");
	addOrRemove = utils.getString();
		if (addOrRemove.equals("add")) {
	LOGGER.info("Please enter the id of the item you wish to add to the order");
	Long itemId = utils.getLong();
	Order orders = orderDAO.addItem(orderId, itemId);
	LOGGER.info("Order Updated");
	return orders;
		} else if (addOrRemove.equals("remove")) {
	LOGGER.info("Please enter the id of the item you wish to remove from the order");
	Long itemId = utils.getLong();
	Order orders = orderDAO.deleteOrderItems(orderId, itemId);
	LOGGER.info("Order updated");
	return orders;
		} else {
	System.out.println("Please enter either add or remove");
	}
		return orderDAO.read(orderId);
	}
	
	
	@Override
	public int delete() {
		LOGGER.info("Please enter the order id of the item you would like to delete");
		Long orderId = utils.getLong();
		LOGGER.info("Order has been deleted");
		orderDAO.delete(orderId);
		return orderDAO.delete(orderId);
	}

	public Order deleteItem() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long orderId = utils.getLong();
		LOGGER.info("Please enter the item id of the item you would like to delete");
		Long itemId = utils.getLong();
		return orderDAO.deleteOrderItems(orderId, itemId);
	}


	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}




	
}