package com.techelevator.model.order;

public class ShortOrder {

	private String categoryName;
	private String menuItemName;
	private int numberOrdered;
	
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getMenuItemName() {
		return menuItemName;
	}
	public void setMenuItemName(String menuItemName) {
		this.menuItemName = menuItemName;
	}
	public int getNumberOrdered() {
		return numberOrdered;
	}
	public void setNumberOrdered(int numberOrdered) {
		this.numberOrdered = numberOrdered;
	}
}
