package com.techelevator.model;

import java.time.LocalDate;

public class Event {
	
	private String name;
	private int eventId;
	private String hostUserName;
	private LocalDate eventDate;
	private String eventTime;
	private int addressId;
	private int menuId;
	
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getEventTime() {
		return eventTime;
	}
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getHostUserName() {
		return hostUserName;
	}
	public void setHostUserName(String hostUserName) {
		this.hostUserName = hostUserName;
	}
	public LocalDate getEventDate() {
		return eventDate;
	}
	public void setEventDate(LocalDate eventDateTime) {
		this.eventDate = eventDateTime;
	}
	
}
