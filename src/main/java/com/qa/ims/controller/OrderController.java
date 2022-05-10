package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.qa.ims.persistence.dao.ItemsDAO;
import com.qa.ims.persistence.dao.OrderDAO;
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
	public List<Order> readAll() {
		List<Order> orders = (List<Order>) orderDAO;
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	
	@Override
	public Order create() {
		LOGGER.info("Please enter your customer ID");
		Long customerId = utils.getLong();
		Order order = orderDAO.create(new Order(customerId));
		LOGGER.info("Would you like to add an item to your order?");
		LOGGER.info("Yes or No?");
		
		String newItem = utils.getString();
		addItem(newItem);
		
		return order;
		
	}
		

	public Order addItem(String newItem) {

		if (newItem.toLowerCase().equals("yes")) {

			boolean flag = true;

			while (flag) {
				LOGGER.info("Please enter a item id");
				Long itemId = utils.getLong();
				LOGGER.info("Please enter an order id");
				Long orderId = utils.getLong();
				orderDAO.addItem(new OrderItem(null, itemId, orderId));
				LOGGER.info("Item successfully added to order");
				LOGGER.info("Would you like to add another item?");
				LOGGER.info("Enter yes or no");
				String addAnother = utils.getString();

				if (addAnother.toLowerCase().equals("no")) {
					flag = false;
				}
			}
			return null;

		} else {
			LOGGER.info("Bye");
			return null;
		}
	}
	@Override
	public Order update() {
		Long orderId = null;
		Order currentOrder = null;
		Long customerId = null;
		do {
			LOGGER.info("Enter the id of the order you would like to update.");
			orderId = utils.getLong();
			LOGGER.info("Please enter a new customer id");
			customerId = utils.getLong();
			orderDAO.update(new Order(orderId, customerId));
			LOGGER.info("Order Updated");
			currentOrder = orderDAO.read(orderId);
		} while (currentOrder == null);
		boolean exit = false;
		//GOT THIS IDEA FROM ONLINE -- SOURCE
		do {
			currentOrder = orderDAO.read(orderId);
			LOGGER.info(currentOrder.toString());
			LOGGER.info("Would you like to add or delete an item? Enter 'add', 'delete' or 'exit'.");
			String selection = utils.getString().toLowerCase();
			Long itemID;
			switch (selection) {
			case "delete":
				LOGGER.info("Enter item id to delete");
				itemID = utils.getLong();
				orderDAO.deleteOrderItems(currentOrder.getOrderId(), itemID);
				break;
			case "add":

				LOGGER.info("Please enter a item id");
				Long itemId = utils.getLong();
				LOGGER.info("Please enter a customer id");
				Long custId = utils.getLong();
				orderDAO.addItem(new OrderItem(null, itemId, custId));
				LOGGER.info("Item successfully added to order");
				break;
			case "exit":
				exit = true;
				break;
			default:
				LOGGER.info("Error");
				break;
			}
		} while (exit);
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

}