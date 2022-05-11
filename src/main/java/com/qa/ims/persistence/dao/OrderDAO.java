package com.qa.ims.persistence.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItem;

import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	ItemsDAO itemDAO = new ItemsDAO();
	private Long orderId;
	private Long itemId;
	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderId = resultSet.getLong("order_id");
		Long customerId = resultSet.getLong("id_customer");	
		List<Item> items = readId(resultSet.getLong("order_id"));
		return new Order(orderId, customerId, items);
	}
//	public OrderItem modelFromResultSet2(ResultSet resultSet) throws SQLException {
//		Long orderItemsId = resultSet.getLong("id_order_items");
//		Long orderId = resultSet.getLong("id_order");
//		Long itemId = resultSet.getLong("item_id");
//		
//		return new OrderItem(orderItemsId, orderId, itemId);
//	}

	public List<Item> readId(Long orderId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM OrderItems WHERE id_order=?")) {
			List<Item> items = new ArrayList<Item>();
			while (resultSet.next()) {
				items.add(itemDAO.read(resultSet.getLong("item_id")));
			}
			return items;
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
//		List<Item> itemList = new ArrayList<>();
//		for (Long i : items) {
//			itemList.add(itemDAO.read(i))
//		}
//		return itemList;
		return null;
	}

	@Override
	public List<Order> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Orders");) {
			List<Order> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Order readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Orders ORDER BY order_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;

	}

	@Override
	public Order create(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("INSERT INTO Orders(id_customer) VALUES (?)");){
				statement.setLong(1, order.getCustomerId());
				statement.executeUpdate();
			return readLatest();
			
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	
	}
//	public OrderItem readLatestItems() {
//		try (Connection connection = DBUtils.getInstance().getConnection();
//				Statement statement = connection.createStatement();
//				ResultSet resultSet = statement.executeQuery("SELECT * FROM OrderItems ORDER BY id_order_items DESC");) {
//			resultSet.next();
//			return modelFromResultSet2(resultSet);
//		} catch (Exception e) {
//			LOGGER.debug(e);
//			LOGGER.error(e.getMessage());
//		}
//		return null;
//	}

	public OrderItem addItem(OrderItem orderItem) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO OrderItems(order_id, item_id) VALUES (?, ?)")){
			statement.setLong(1, orderId);
			statement.setLong(2, itemId);
			statement.executeQuery();
			LOGGER.info("This item has been added to order.");
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return orderItem;
	}

	public Order read(Long orderId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Orders WHERE order_id=?")) {
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
			LOGGER.info("Sorry, this order does not exist.");
		}
		return null;

	}

	@Override
	public Order update(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("UPDATE Orders SET order_id=? WHERE customer_id=?");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
 
	}

	@Override
	public int delete(Long orderId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("DELETE FROM Orders WHERE order_id=?")){
			statement.setLong(1, orderId);
			statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	public int deleteOrderLines(Long orderId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
			PreparedStatement statement = connection
					.prepareStatement("DELETE FROM OrderItems(order_id) VALUES (?)")){
			statement.setLong(1, orderId);
			statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	public int deleteOrderItems(Long orderId, Long itemId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("DELETE FROM OrderItems(order_id, item_id) VALUES (?, ?)")){
			statement.setLong(1, orderId);
			statement.setLong(2, itemId);
			statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}
	

}