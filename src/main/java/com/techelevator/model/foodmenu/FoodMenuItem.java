package com.techelevator.model.foodmenu;

public class FoodMenuItem {

	private int menuItemId;
	private int menuId;
	private int foodCategoryId;
	private String name;
	private String description;
	private String foodCategory;
	
	
	public String getFoodCategory() {
		return foodCategory;
	}
	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}
	public int getMenuItemId() {
		return menuItemId;
	}
	public void setMenuItemId(int menuItemId) {
		this.menuItemId = menuItemId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getMenuId() {
		return menuId;
	}
	public int getFoodCategoryId() {
		return foodCategoryId;
	}
	public String getName() {
		return name;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public void setFoodCategoryId(int foodCategoryId) {
		this.foodCategoryId = foodCategoryId;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
