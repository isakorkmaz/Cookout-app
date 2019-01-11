package com.techelevator.model.attendee;

import java.util.List;

public interface EventAttendeeDAO {
	
	public List<Attendee> getAllInvitedGuestsByEventId(int eventId);
	
	public List<Attendee> getAllConfirmedGuestsByEventId(int eventId);
	
	public void inviteGuestToEvent(Attendee attendee);
	
	public void uninviteGuestToEvent(int eventAttendeeId);
	
	public int getEventAttendessIdByUserNameAndEventId(String userName, int eventId);
	
	public Boolean getConfirmation(String email, int eventId);
}
