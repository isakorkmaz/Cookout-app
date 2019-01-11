package com.techelevator.model.address;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcAddressDAO implements AddressDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcAddressDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean searchIsAddressInSystem(String streetAddress, String city, String state, int zip) {
		String sqlQuery = "SELECT * FROM address WHERE street_address=? AND city=? AND state=? " + "AND zip=?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, streetAddress, city, state, zip);

		if (results.next()) {
			return true;
		}
		return false;
	}

	@Override
	public int getAddressId(String streetAddress, String city, String state, int zip) {

		String sqlQuery = "SELECT address_id FROM address WHERE street_address=? AND city=? AND state=? " + "AND zip=?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, streetAddress, city, state, zip);

		if (results.next()) {
			int addressId = results.getInt("address_id");
			return addressId;
		}
		return 0;
	}

	@Override
	public void saveAddress(String streetAddress, String city, String state, int zip) {
		String sqlInsert = "INSERT INTO address (street_address, city, state, zip) VALUES" + "(?,?,?,?)";
		jdbcTemplate.update(sqlInsert, streetAddress, city, state, zip);
	}
	
	@Override
	public void updateAddress(Address address) {
		String sqlUpdate = "UPDATE address SET street_address=?, city=?, state=?, zip=? WHERE address_id=?";
		
		jdbcTemplate.update(sqlUpdate, address.getStreetAddress(), address.getCity(), address.getState(),
					address.getZip(), address.getAddressId());
	}
	
	@Override
	public Address getAddressById(int addressId) {
		String sqlQuery = "SELECT * FROM address WHERE address_id=?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, addressId);
		
		Address address = null;
		if(results.next()) {
			address = mapToAddress(results);
		}
		return address;
	}
	
	private Address mapToAddress(SqlRowSet results) {
		Address address = new Address();
		
		address.setAddressId(results.getInt("address_id"));
		address.setStreetAddress(results.getString("street_address"));
		address.setCity(results.getString("city"));
		address.setState(results.getString("state"));
		address.setZip(results.getInt("zip"));
		
		return address;
	}

}
