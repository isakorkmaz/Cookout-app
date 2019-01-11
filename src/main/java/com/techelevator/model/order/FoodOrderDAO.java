package com.techelevator.model.order;

import java.util.List;

public interface FoodOrderDAO {
	
	public List<Order> getAllOrdersByMenuId(int menuId);
	
	public void saveOrder(Order order);
	
	public void deleteOrder(int foodOrdersId);
	
	public void updateOrder(Order order);
	
	public List<ShortOrder> getAllShortOrders(int menuId);
}
