package com.techelevator.model.address;

public interface AddressDAO {
	
	public boolean searchIsAddressInSystem(String streetAddress, String city, String state, int zip);
	
	public int getAddressId(String streetAddress, String city, String state, int zip);
	
	public void saveAddress(String streetAddress, String city, String state, int zip);
	
	public void updateAddress(Address address) ;
	
	public Address getAddressById(int addressId);
}
