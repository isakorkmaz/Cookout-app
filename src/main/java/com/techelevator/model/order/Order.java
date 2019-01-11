package com.techelevator.model.order;

public class Order {

	private int foodOrderId;
	private int menuId;
	private int eventAttendeeId;
	private int menuItemId;
	private String firstName;
	private String lastName;
	private String menutItemName;
	private String description;
	private String categoryName;
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMenutItemName() {
		return menutItemName;
	}
	public void setMenutItemName(String menutItemName) {
		this.menutItemName = menutItemName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getEventAttendeeId() {
		return eventAttendeeId;
	}
	public void setEventAttendeeId(int eventAttendeeId) {
		this.eventAttendeeId = eventAttendeeId;
	}
	public int getMenuItemId() {
		return menuItemId;
	}
	public void setMenuItemId(int menuItemId) {
		this.menuItemId = menuItemId;
	}
	public int getFoodOrderId() {
		return foodOrderId;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setFoodOrderId(int foodOrderId) {
		this.foodOrderId = foodOrderId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	
}
