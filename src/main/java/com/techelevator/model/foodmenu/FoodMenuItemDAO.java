package com.techelevator.model.foodmenu;

import java.util.List;

public interface FoodMenuItemDAO {

		public List<FoodMenuItem> getFoodMenuById(int menuId);
		
		public void saveFoodMenuItem(FoodMenuItem menuItem);
		
		public List<FoodCategory> getFoodCategories();
		
		public void deleteFoodMenuItem(int foodMenuItemId);
		
		public FoodMenuItem getFoodMenuItemById(int foodMenuItemId);
}
