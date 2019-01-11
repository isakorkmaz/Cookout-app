package com.techelevator.model;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface EventDAO {

	public List<Event> getHostedEventsByUsername(String username) throws SQLException;
	public List<Event> getInvitedEventsByUsername(String email) throws SQLException;
	public int createNewEvent(String hostUserName, String eventName, 
									  String eventDate, String eventTime) throws SQLException;
	public void editEvent(Event event);
	public Event getEventById(int eventId);
	public int getEventIdByMenuId(int menuId);
	public int getMenuIdByEventId(int eventId);
	public void changeRSVP(int eventId, String email);
}
