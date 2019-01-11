package com.techelevator.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.Event;
import com.techelevator.model.foodmenu.FoodMenuItem;
import com.techelevator.model.foodmenu.FoodMenuItemDAO;

@Controller
public class CreateMenuController {
	
	private FoodMenuItemDAO foodMenuItemDAO;
	
	@Autowired
	public CreateMenuController(FoodMenuItemDAO foodMenuItemDAO) {
		this.foodMenuItemDAO = foodMenuItemDAO;
	}
	
	@RequestMapping(path="/eventMenu", method=RequestMethod.GET)
	public String displayCreateMenuWithMenuIdPage(ModelMap modelMap, HttpSession session) {
		Event event = (Event) session.getAttribute("event");
		
		modelMap.put("foodMenuItems", foodMenuItemDAO.getFoodMenuById(event.getMenuId()));
		modelMap.put("foodCategories", foodMenuItemDAO.getFoodCategories());
		return "eventMenu";
	}
	
	@RequestMapping(path="/eventMenu", method=RequestMethod.POST)
	public String createNewMenu(@RequestParam String foodName, int foodCategoryId, 
											   String description, HttpSession session) {
		Event event = (Event) session.getAttribute("event");
		
		FoodMenuItem menuItem = new FoodMenuItem();
		menuItem.setMenuId(event.getMenuId());
		menuItem.setName(foodName);
		menuItem.setFoodCategoryId(foodCategoryId);
		menuItem.setDescription(description);
		foodMenuItemDAO.saveFoodMenuItem(menuItem);
		return "redirect:/eventMenu";
	}
	
	@RequestMapping(path="/deleteMenuItem/{foodMenuItemId}", method=RequestMethod.POST)
	public String deleteMenuItem(@PathVariable int foodMenuItemId) {
		foodMenuItemDAO.deleteFoodMenuItem(foodMenuItemId);
		return "redirect:/eventMenu";
	}
	
}