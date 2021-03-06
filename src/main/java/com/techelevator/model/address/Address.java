package com.techelevator.model.address;

public class Address {

	private int addressId;
	private String streetAddress;
	private String city;
	private String state;
	private int zip;
	
	public int getAddressId() {
		return addressId;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public int getZip() {
		return zip;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	
	public boolean equals(Address address) {
		if(streetAddress.toUpperCase().equals(address.getStreetAddress().toUpperCase()) &&
			city.toUpperCase().equals(address.getCity().toUpperCase()) &&
			state.toUpperCase().equals(address.getState().toUpperCase()) &&
			zip == address.getZip()) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	
}
