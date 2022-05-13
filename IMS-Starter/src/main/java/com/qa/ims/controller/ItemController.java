package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.qa.ims.persistence.dao.ItemsDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

/**
 * Takes in Items details for CRUD functionality
 * 
 *
 */
public class ItemController implements CrudController<Item> {

	public static final Logger LOGGER = LogManager.getLogger();

	private ItemsDAO itemDAO;
	private Utils utils;

	public ItemController(ItemsDAO itemDAO, Utils utils) {
		super();
		this.itemDAO = itemDAO;
		this.utils = utils;
	}

	/**
	 * Reads all Items to console
	 */
	@Override
	public List<Item> readAll() {
		List<Item> items = itemDAO.readAll();
		for (Item item : items) {
			LOGGER.info(item);
		}
		return items;
	}

	/**
	 * Creates a Item by taking in user input
	 */
	@Override
	public Item create() {
		LOGGER.info("Please enter name of item:");
		String itemName = utils.getString();
		LOGGER.info("Please enter the price of the item");
		Double itemPrice = utils.getDouble();
		Item items = itemDAO.create(new Item(itemName, itemPrice));
		LOGGER.info("Item created");
		return items;
	}

	/**
	 * Updates an existing item by taking in user input
	 */
	@Override
	public Item update() {
		LOGGER.info("Please enter the id of the item you would like to update");
		Long itemId = utils.getLong();
		LOGGER.info("Please enter the item name");
		String itemName = utils.getString();
		LOGGER.info("Please enter the item price");
		Double itemPrice = utils.getDouble();
		Item items = itemDAO.update(new Item(itemId, itemName, itemPrice));
		LOGGER.info("Item Updated");
		return items;
	}

	/**
	 * Deletes an existing customer by the id of the item
	 * 
	 * 
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the item id of the item you would like to delete");
		Long itemId = utils.getLong();
		return itemDAO.delete(itemId);
	}

}

