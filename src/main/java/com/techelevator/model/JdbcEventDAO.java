package com.techelevator.model;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.attendee.EventAttendeeDAO;

@Component
public class JdbcEventDAO implements EventDAO {

	private JdbcTemplate jdbcTemplate;
	private EventAttendeeDAO eventAttendeeDAO;

	@Autowired
	public JdbcEventDAO(DataSource dataSource, EventAttendeeDAO eventAttendeeDAO) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.eventAttendeeDAO = eventAttendeeDAO;
	}

	@Override
	public List<Event> getHostedEventsByUsername(String username) throws SQLException {

		String sqlQuery = "SELECT * FROM events "
						+ "WHERE host_username = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, username);

		List<Event> events = new ArrayList<>();
		while (results.next()) {
			events.add(mapToEvent(results));
		}
		return events;
	}

	@Override
	public List<Event> getInvitedEventsByUsername(String email) throws SQLException {

		String sqlQuery = "SELECT * FROM events JOIN event_attendees "
						+ "ON events.event_id = event_attendees.event_id "
						+ "WHERE email = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, email);
		List<Event> events = new ArrayList<>();
			
		while (results.next()) {
			events.add(mapToEvent(results));
		}
		return events;
	}
	
	@Override
	public int createNewEvent(String hostUserName, String eventName, 
									  String eventDate, String eventTime){
		
		// DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		
		LocalDate date = LocalDate.parse(eventDate);
		
		String sqlInsert = "INSERT INTO events (host_username, event_name, event_date, event_time) "
						+ "VALUES (?,?,?,?)";
		jdbcTemplate.update(sqlInsert, hostUserName, eventName, date, eventTime);
		int eventId = getCurrentId();
		
		return eventId;
	}
	
	
	@Override
	public void editEvent(Event event){
		String sqlUpdate ="UPDATE events SET event_name=?, event_date=?, event_time=?, address_id=? "
				+ "WHERE event_id=?"; 
		jdbcTemplate.update(sqlUpdate, event.getName(), event.getEventDate(), 
										event.getEventTime(), event.getAddressId(), event.getEventId());
	}
	
	@Override
	public int getEventIdByMenuId(int menuId) {
		String sqlQuery = "SELECT event_id FROM events WHERE menu_id=?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, menuId);
		
		int eventId = 0;
		if(results.next()) {
			eventId = results.getInt("event_id");
		}
		return eventId;
	}
	
	@Override
	public int getMenuIdByEventId(int eventId) {
		String sqlQuery = "SELECT menu_id FROM events WHERE event_id=?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, eventId);
		
		int menuId = 0;
		if(results.next()) {
			menuId = results.getInt("menu_id");
		}
		return menuId;
	}
	
	@Override
	public Event getEventById(int eventId) {
		String sqlQuery = "SELECT * FROM events WHERE event_id=?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, eventId);
		
		Event event = null;
		if(results.next()) {
			event = mapToEvent(results);
		}
		return event;
	}
	
	public int getCurrentId() {
		String sqlQuery = "SELECT MAX(event_id) as current_id FROM events";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery);
		
		int currentId = 0;
		if(results.next()) {
			currentId = results.getInt("current_id");
		}
		return currentId;
	}
	
	public int getNextId() {
		String sqlQuery = "SELECT MAX(event_id) as next_id FROM events";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery);
		
		int nextId = 0;
		if(results.next()) {
			nextId = results.getInt("next_id");;
		}
		return nextId;
	}
	
	public void changeRSVP(int eventId, String email) {
		
		Boolean rsvp = eventAttendeeDAO.getConfirmation(email, eventId);;
		
		if (rsvp) {
			String sqlQuery = "UPDATE event_attendees SET is_confirmed = 'false' "
					+ "WHERE event_id = ? AND email = ?";
			jdbcTemplate.update(sqlQuery, eventId, email);	
		}
		
		if (!rsvp) {
			String sqlQuery = "UPDATE event_attendees SET is_confirmed = 'true' "
					+ "WHERE event_id = ? AND email = ?";
			jdbcTemplate.update(sqlQuery, eventId, email);	
		}
	}
	
	private Event mapToEvent(SqlRowSet results) {
		
		Event event = new Event();
		
		event.setEventId(results.getInt("event_id"));
		event.setAddressId(results.getInt("address_id"));
		event.setName(results.getString("event_name"));
		event.setHostUserName(results.getString("host_username"));
		event.setEventDate(results.getDate("event_date").toLocalDate());
		event.setEventTime(results.getString("event_time"));
		event.setMenuId(results.getInt("menu_id"));
		
		return event;
	}
	
}








