package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.model.Event;
import com.techelevator.model.User;
import com.techelevator.model.attendee.EventAttendeeDAO;
import com.techelevator.model.foodmenu.FoodMenuItem;
import com.techelevator.model.foodmenu.FoodMenuItemDAO;
import com.techelevator.model.order.FoodOrderDAO;
import com.techelevator.model.order.Order;
import com.techelevator.model.order.ShortOrder;

@Controller
public class FoodOrderController {

	private FoodOrderDAO foodOrderDAO;
	private FoodMenuItemDAO foodMenuItemDAO;
	private EventAttendeeDAO eventAttendeeDAO;
	
	@Autowired
	public FoodOrderController(FoodOrderDAO foodOrderDAO, FoodMenuItemDAO foodMenuItemDAO, EventAttendeeDAO eventAttendeeDAO) {
		this.foodOrderDAO = foodOrderDAO;
		this.foodMenuItemDAO = foodMenuItemDAO;
		this.eventAttendeeDAO = eventAttendeeDAO;
	}
	
	@RequestMapping(path="/viewShortOrders", method=RequestMethod.GET)
	public String displayShortOrders(ModelMap modelMap, HttpSession session) {
		Event event = (Event) session.getAttribute("event");
		// List<Order> orders = foodOrderDAO.getAllOrdersByMenuId(event.getMenuId());
		
		List<ShortOrder> shortOrders = foodOrderDAO.getAllShortOrders(event.getMenuId());
		modelMap.put("shortOrders", shortOrders);
		
		return "viewShortOrders";
	}
	
	@RequestMapping(path="/viewAllOrders", method=RequestMethod.GET)
	public String displayAllOrders(ModelMap modelMap, HttpSession session) {
		Event event = (Event) session.getAttribute("event");
		
		modelMap.put("orders", foodOrderDAO.getAllOrdersByMenuId(event.getMenuId()));
		
		return "viewAllOrders";
	}
	
	@RequestMapping(path="/deleteOrder/{foodOrdersId}", method=RequestMethod.POST)
	public String finishAnOrder(@PathVariable int foodOrdersId) {
		foodOrderDAO.deleteOrder(foodOrdersId);
		
		return "redirect:/viewAllOrders";
	}
	
	@RequestMapping(path="/placeOrder", method=RequestMethod.GET)
	public String displayPlaceOrderPage(ModelMap modelMap, HttpSession session) {
		Event event = (Event) session.getAttribute("event");
		modelMap.put("menu", foodMenuItemDAO.getFoodMenuById(event.getMenuId()));
		modelMap.put("orders", foodOrderDAO.getAllOrdersByMenuId(event.getMenuId()));
		
		return "guestOrderPage";
	}
	
	@RequestMapping(path="/addOrder/{menuItemId}", method=RequestMethod.POST)
	public String guestPlaceOrder(@PathVariable int menuItemId, HttpSession session) {
		User user = (User) session.getAttribute("currentUser");
		Event event = (Event) session.getAttribute("event");
		
		int attendeeId = eventAttendeeDAO.getEventAttendessIdByUserNameAndEventId(user.getUserName(), event.getMenuId());
		
		FoodMenuItem menuItem = foodMenuItemDAO.getFoodMenuItemById(menuItemId);
		
		Order order = new Order();
		
		order.setCategoryName(menuItem.getFoodCategory());
		order.setDescription(menuItem.getDescription());
		order.setEventAttendeeId(attendeeId);
		order.setFirstName(user.getFirstName());
		order.setLastName(user.getLastName());
		order.setMenuId(event.getMenuId());
		order.setMenuItemId(menuItemId);
		order.setMenutItemName(menuItem.getName());
		
		foodOrderDAO.saveOrder(order);
		
		return "redirect:/placeOrder";
	}
}
