package com.techelevator.controller;

import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.Event;
import com.techelevator.model.EventDAO;
import com.techelevator.model.User;
import com.techelevator.model.address.Address;
import com.techelevator.model.address.AddressDAO;
import com.techelevator.model.attendee.Attendee;
import com.techelevator.model.attendee.EventAttendeeDAO;

@Controller
public class CreateEventController {
	
	private EventDAO eventDAO;
	private AddressDAO addressDAO;
	private EventAttendeeDAO eventAttendeeDAO;
	
	@Autowired
	public CreateEventController(EventDAO eventDAO, AddressDAO addressDAO, EventAttendeeDAO eventAttendeeDAO) {
		this.eventDAO = eventDAO;
		this.addressDAO = addressDAO;
		this.eventAttendeeDAO = eventAttendeeDAO;
	}
	
	@RequestMapping(path="/hostEventDetails", method=RequestMethod.GET)
	public String displayEventDetailsPage(HttpSession session, @RequestParam int eventId, ModelMap modelMap) {
		Event event = eventDAO.getEventById(eventId);
		session.setAttribute("event", event);
		modelMap.put("address", addressDAO.getAddressById(event.getAddressId()));
		
		return "hostEventDetails";
	}
	
	@RequestMapping(path="/test", method=RequestMethod.POST)
	public String displayEventDetailsPage(HttpSession session, ModelMap modelMap) {
		Event event = (Event) session.getAttribute("event");
		
		return "redirect:/hostEventDetails?eventId=" + event.getEventId();
	}
	
	
	@RequestMapping(path="/eventInfo", method=RequestMethod.GET)
	public String displayCreateEventPage(ModelMap modelMap, HttpSession session) {
		if (! (session.getAttribute("event") == null)) {
			Event event = (Event) session.getAttribute("event");
			modelMap.put("address", addressDAO.getAddressById(event.getAddressId()));
		}
		return "eventInfo";
	}
	
	@RequestMapping(path="/eventInfo", method=RequestMethod.POST)
	public String createNewEvent(HttpSession session, @RequestParam String eventName,  
							   String eventDate, String eventTime, String streetAddress,
							   String city, String state, int zip) throws SQLException {
		if(session.getAttribute("event") == null) {
			User user = (User) session.getAttribute("currentUser");
			String hostUserName = user.getUserName();
			int eventId = eventDAO.createNewEvent(hostUserName, eventName, eventDate, eventTime);
			Event event = eventDAO.getEventById(eventId);
			if(addressDAO.searchIsAddressInSystem(streetAddress, city, state, zip)) {
				int addressId = addressDAO.getAddressId(streetAddress, city, state, zip);
				event.setAddressId(addressId);
			} else {
				addressDAO.saveAddress(streetAddress, city, state, zip);
				event.setAddressId(addressDAO.getAddressId(streetAddress, city, state, zip));
			}
			session.setAttribute("event", event);
			eventDAO.editEvent(event);
		} else {
			Event event = (Event) session.getAttribute("event");
			
			event.setName(eventName);
			event.setEventDate(LocalDate.parse(eventDate));
			event.setEventTime(eventTime);
			
			if(addressDAO.searchIsAddressInSystem(streetAddress, city, state, zip)) {
				int addressId = addressDAO.getAddressId(streetAddress, city, state, zip);
				event.setAddressId(addressId);
			} else {
				Address address = new Address();
				address.setAddressId(event.getAddressId());
				address.setStreetAddress(streetAddress);
				address.setCity(city);
				address.setState(state);
				address.setZip(zip);
				addressDAO.updateAddress(address);
				event.setAddressId(addressDAO.getAddressId(streetAddress, city, state, zip));
			}
			
			session.setAttribute("event", event);
			eventDAO.editEvent(event);
		}
		return "redirect:/eventMenu";
	}
	
//	@RequestMapping(path="/editEventInfo", method=RequestMethod.GET)
//	public String displayEditEvent() {
//		return "eventInfo";
//	}
	
	@RequestMapping(path="/eventAddress", method=RequestMethod.GET)
	public String displayCreateEventAddress(HttpSession session, ModelMap modelMap) {
		Event event = (Event) session.getAttribute("event");
		if(event.getAddressId() == 0) {
			return "eventAddress";
		}
		modelMap.put("address", addressDAO.getAddressById(event.getAddressId()));
		return "eventAddress";
	}
	
	@RequestMapping(path="/guestEventDetails", method=RequestMethod.GET)
	public String displayGuestEventDetails(ModelMap modelMap, @RequestParam int eventId, HttpSession session) {
		Event event = eventDAO.getEventById(eventId);
		session.setAttribute("event", event);
		
		User user = (User) session.getAttribute("currentUser"); 
		Boolean boo = eventAttendeeDAO.getConfirmation(user.getEmail(), eventId);
		modelMap.put("eventAttendee", boo);
		modelMap.put("address", addressDAO.getAddressById(event.getAddressId()));

		return "guestEventDetails";
	}
	
	@RequestMapping(path="/guestEventDetails", method=RequestMethod.POST)
	public String updateGuestRSVP(HttpSession session) {
		User user = (User) session.getAttribute("currentUser");
		Event event = (Event) session.getAttribute("event");
		
		eventDAO.changeRSVP(event.getEventId(), user.getEmail());
		
		return "redirect:/guestEventDetails?eventId=" + event.getEventId();
	}
	
//	@RequestMapping(path="/eventAddress", method=RequestMethod.POST)
//	public String createAnAddressForEvent(@RequestParam String streetAddress, 
//										 String city, String state, int zip, HttpSession session) {
//		Event event = (Event) session.getAttribute("event");
//		
//		if(event.getAddressId() == 0) {
//			if(addressDAO.searchIsAddressInSystem(streetAddress, city, state, zip)) {
//				int addressId = addressDAO.getAddressId(streetAddress, city, state, zip);
//				event.setAddressId(addressId);
//				eventDAO.editEvent(event);
//				session.setAttribute("event", event);
//			} else {
//				addressDAO.saveAddress(streetAddress, city, state, zip);
//				event.setAddressId(addressDAO.getAddressId(streetAddress, city, state, zip));
//				session.setAttribute("event", event);
//			}
//		} else {
//			if(addressDAO.searchIsAddressInSystem(streetAddress, city, state, zip)) {
//				int addressId = addressDAO.getAddressId(streetAddress, city, state, zip);
//				event.setAddressId(addressId);
//				eventDAO.editEvent(event);
//				session.setAttribute("event", event);
//			} else {
//				Address address = new Address();
//				address.setAddressId(event.getAddressId());
//				address.setStreetAddress(streetAddress);
//				address.setCity(city);
//				address.setState(state);
//				address.setZip(zip);
//				addressDAO.updateAddress(address);
//				event.setAddressId(addressDAO.getAddressId(streetAddress, city, state, zip));
//				eventDAO.editEvent(event);
//				session.setAttribute("event", event);
//			}
//		}
//		return "redirect:/eventMenu";
//	}
}