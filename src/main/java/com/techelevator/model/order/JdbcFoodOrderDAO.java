package com.techelevator.model.order;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcFoodOrderDAO implements FoodOrderDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcFoodOrderDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Order> getAllOrdersByMenuId(int menuId) {
		String sqlQuery="SELECT food_orders_id, food_orders.menu_id, food_orders.menu_item_id, food_orders.event_attendees_id, "
				+ "first_name, last_name, name, description, category_name FROM food_orders INNER JOIN menu_item ON food_orders.menu_item_id = menu_item.menu_item_id "
				+ "INNER JOIN food_category ON menu_item.food_category_id = food_category.food_category_id "
				+ "INNER JOIN event_attendees ON food_orders.event_attendees_id = event_attendees.event_attendees_id WHERE food_orders.menu_id=?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, menuId);
		
		List<Order> orders = new ArrayList<>();
		while(results.next()) {
			Order order = mapToOrder(results);
			orders.add(order);
		}
		return orders;
	}

	@Override
	public void saveOrder(Order order) {
		String sqlInsert = "INSERT INTO food_orders (menu_id, event_attendees_id, menu_item_id) "
							+ "VALUES (?,?,?);";
		
		jdbcTemplate.update(sqlInsert, order.getMenuId(), order.getEventAttendeeId(), order.getMenuItemId());
		
	}

	@Override
	public void deleteOrder(int foodOrdersId) {
		String sqlDelete = "DELETE FROM food_orders WHERE food_orders_id=?";
		
		jdbcTemplate.update(sqlDelete, foodOrdersId);
		
	}

	@Override
	public void updateOrder(Order order) {
		String sqlUpdate = "UPDATE food_orders SET menu_id=?, event_attendees_id=?, menu_item_id=? "
				+ "WHERE food_orders_id=?";
		
		jdbcTemplate.update(sqlUpdate, order.getMenuId(), order.getEventAttendeeId(), order.getMenuItemId(),
				order.getFoodOrderId());
		
	}
	
	@Override
	public List<ShortOrder> getAllShortOrders(int menuId) {
		String sqlQuery = "SELECT food_orders.menu_item_id, name, category_name, COUNT(*) as number_ordered " +
				"FROM food_orders " +
				"INNER JOIN menu_item " +
				"ON menu_item.menu_item_id = food_orders.menu_item_id " + 
				"INNER JOIN food_category " +
				"ON food_category.food_category_id = menu_item.food_category_id " +
				"WHERE food_orders.menu_id = ? " +
				"GROUP BY food_orders.menu_item_id, name, category_name";
				
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, menuId);
		
		List<ShortOrder> shortOrders = new ArrayList<>();
		while(results.next()) {
			ShortOrder shortOrder = mapToShortOrder(results);
			shortOrders.add(shortOrder);
		}
		return shortOrders;
	}
	
	private Order mapToOrder(SqlRowSet results) {
		Order order = new Order();
		
		order.setEventAttendeeId(results.getInt("event_attendees_id"));
		order.setMenuId(results.getInt("menu_id"));
		order.setMenuItemId(results.getInt("menu_item_id"));
		order.setFoodOrderId(results.getInt("food_orders_id"));
		order.setFirstName(results.getString("first_name"));
		order.setLastName(results.getString("last_name"));
		order.setMenutItemName(results.getString("name"));
		order.setDescription(results.getString("description"));
		order.setCategoryName(results.getString("category_name"));
		
		return order;
	}
	
	private ShortOrder mapToShortOrder(SqlRowSet results) {
		ShortOrder shortOrder = new ShortOrder();
		
		shortOrder.setCategoryName(results.getString("category_name"));
		shortOrder.setMenuItemName(results.getString("name"));
		shortOrder.setNumberOrdered(results.getInt("number_ordered"));
		
		return shortOrder;
	}
}
