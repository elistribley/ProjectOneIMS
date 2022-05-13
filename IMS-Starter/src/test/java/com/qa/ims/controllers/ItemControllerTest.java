package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.ItemController;

import com.qa.ims.persistence.dao.ItemsDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {
	@Mock
	private Utils utils;

	@Mock
	private ItemsDAO itemDAO;

	@InjectMocks
	private ItemController itemController;

	@Test
	public void testCreate() {
		final String itemName = "Comic Book";
		final Double itemPrice = 9.99;
		final Long id = 5L;
		final Item created = new Item(itemName, itemPrice);
		Mockito.when(utils.getString()).thenReturn(itemName);
		Mockito.when(utils.getDouble()).thenReturn(itemPrice);
		
		Mockito.when(itemDAO.create(any(Item.class))).thenReturn(created);
		assertEquals(created, itemController.create());
		Mockito.verify(utils, times(1)).getString();
		Mockito.verify(utils, times(1)).getDouble();
		
		Mockito.verify(itemDAO, times(1)).create(any(Item.class));
	}

	@Test
	public void testReadAll() {
		List<Item> items = new ArrayList<>();
		items.add(new Item(5L, "Comic Book", 9.99));
		Mockito.when(itemDAO.readAll()).thenReturn(items);
		assertEquals(items, itemController.readAll());
		Mockito.verify(itemDAO, times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		final String itemName = "Comic Book";
		final Double itemPrice = 9.99;
		final Long id = 5L;
		final Item updated = new Item(id, itemName, itemPrice);
		Mockito.when(utils.getString()).thenReturn(itemName);
		Mockito.when(utils.getDouble()).thenReturn(itemPrice);
		Mockito.when(utils.getLong()).thenReturn(id);
		Mockito.when(itemDAO.update(any(Item.class))).thenReturn(updated);
		assertEquals(updated, itemController.update());
		Mockito.verify(utils, times(1)).getString();
		Mockito.verify(utils, times(1)).getDouble();
		Mockito.verify(itemDAO, Mockito.times(1)).update(updated);
	}

	@Test
	public void testDelete() {
		final Long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(itemDAO.delete(ID)).thenReturn(1);

		assertEquals(1L, this.itemController.delete());

		Mockito.verify(utils, times(1)).getLong();
		Mockito.verify(itemDAO, times(1)).delete(ID);

	}
}