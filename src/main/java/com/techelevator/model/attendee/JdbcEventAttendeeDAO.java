package com.techelevator.model.attendee;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcEventAttendeeDAO implements EventAttendeeDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcEventAttendeeDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Attendee> getAllInvitedGuestsByEventId(int eventId) {
		
		String sqlQuery = "SELECT * FROM event_attendees WHERE event_id=?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, eventId);
		
		List<Attendee> guestList = new ArrayList<>();
		
		while(results.next()) {
			guestList.add(mapToAttendee(results));
		}
		
		return guestList;
	}

	@Override
	public List<Attendee> getAllConfirmedGuestsByEventId(int eventId) {
		
		String sqlQuery = "SELECT * FROM event_attendees WHERE event_id=? AND is_confirmed=?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, eventId, true);
		
		List<Attendee> guestList = new ArrayList<>();
		
		while(results.next()) {
			guestList.add(mapToAttendee(results));
		}
		
		return guestList;
	}
	
	@Override
	public void inviteGuestToEvent(Attendee attendee) {
		String sqlInsert = "INSERT INTO event_attendees (username, email, first_name, last_name, "
						+ "event_id) VALUES (?,?,?,?,?)";
		
		jdbcTemplate.update(sqlInsert, attendee.getUsername(), attendee.getEmail(), attendee.getFirstName(),
							attendee.getLastName(), attendee.getEventId());
	}
	
	@Override
	public void uninviteGuestToEvent(int eventAttendeeId) {
		String sqlDelete = "DELETE FROM event_attendees WHERE event_attendees_id=?";
		
		jdbcTemplate.update(sqlDelete, eventAttendeeId);
	}
	
	@Override
	public int getEventAttendessIdByUserNameAndEventId(String userName, int eventId) {
		String sqlQuery = "SELECT event_attendees_id FROM event_attendees WHERE username=? AND event_id=?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, userName, eventId);
		
		int eventAttendeeId = 0;
		if(results.next()) {
			eventAttendeeId = results.getInt("event_attendees_id");
		}
		return eventAttendeeId;
	}
	
	@Override
	public Boolean getConfirmation(String email, int eventId) {
		String sqlQuery = "SELECT is_confirmed " + 
				"FROM event_attendees " + 
				"WHERE event_id = ? AND email = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, eventId, email);
		
		Boolean isConfirmed = false;
		if(results.next()) {
			isConfirmed = results.getBoolean("is_confirmed");
		}
		return isConfirmed;
	}
	
	private Attendee mapToAttendee(SqlRowSet results) {
		Attendee attendee = new Attendee();
		
		attendee.setAttendeeId(results.getInt("event_attendees_id"));
		attendee.setUsername(results.getString("username"));
		attendee.setEventId(results.getInt("event_id"));
		attendee.setHost(results.getBoolean("is_host"));
		attendee.setConfirmed(results.getBoolean("is_confirmed"));
		attendee.setEmail(results.getString("email"));
		attendee.setFirstName(results.getString("first_name"));
		attendee.setLastName(results.getString("last_name"));
		
		return attendee;
	}

}
