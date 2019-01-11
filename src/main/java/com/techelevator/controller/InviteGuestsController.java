package com.techelevator.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.Event;
import com.techelevator.model.User;
import com.techelevator.model.UserDAO;
import com.techelevator.model.attendee.Attendee;
import com.techelevator.model.attendee.EventAttendeeDAO;
import com.techelevator.model.attendee.SendEmail;

@Controller
public class InviteGuestsController {
	
	private EventAttendeeDAO eventAttendeeDAO;
	private UserDAO userDAO;
	
	public InviteGuestsController(EventAttendeeDAO eventAttendeeDAO, UserDAO userDAO) {
		this.eventAttendeeDAO = eventAttendeeDAO;
		this.userDAO = userDAO;
	}
	
	@RequestMapping(path="/eventGuests", method=RequestMethod.GET)
	public String displayInviteGuestsPage(HttpSession session, ModelMap modelMap) {
		Event event = (Event) session.getAttribute("event");
		modelMap.put("guestList", eventAttendeeDAO.getAllInvitedGuestsByEventId(event.getEventId()));
		return "eventGuests";
	}
	
	@RequestMapping(path="/eventGuests", method=RequestMethod.POST)
	public String createNewGuest(@RequestParam String firstName, String lastName, String email, HttpSession session) {
		
		Event event = (Event) session.getAttribute("event");
		
		User user = userDAO.getUserByEmail(email);
		Attendee attendee = new Attendee();
		User hostUser = (User) session.getAttribute("currentUser");
		String hostName = hostUser.getFirstName() + " " + hostUser.getLastName();
		
		if(user != null) {
			attendee.setFirstName(user.getFirstName());
			attendee.setLastName(user.getLastName());
			attendee.setUsername(user.getUserName());
			attendee.setEmail(user.getEmail());
			attendee.setEventId(event.getEventId()); 
			eventAttendeeDAO.inviteGuestToEvent(attendee);
		} else {
			attendee.setFirstName(firstName);
			attendee.setLastName(lastName);
			attendee.setEmail(email);
			attendee.setEventId(event.getEventId());
			eventAttendeeDAO.inviteGuestToEvent(attendee);
		}
		
		SendEmail sendEmail = new SendEmail();
		sendEmail.SendEmails(attendee.getEmail(), attendee.getFirstName(), attendee.getLastName(), hostName);
		
		return "redirect:/eventGuests";
	}
	
	@RequestMapping(path="/uninviteGuest/{eventAttendeeId}", method=RequestMethod.POST)
	public String uninviteGuest(@PathVariable int eventAttendeeId) {
		
		eventAttendeeDAO.uninviteGuestToEvent(eventAttendeeId);
		
		return "redirect:/eventGuests";
	}
	
}