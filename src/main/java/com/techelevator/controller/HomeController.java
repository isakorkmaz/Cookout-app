package com.techelevator.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.model.EventDAO;
import com.techelevator.model.User;

@Controller
public class HomeController {
	
	private EventDAO eventDao;

	@Autowired
	public HomeController(EventDAO eventDao) {
		this.eventDao = eventDao;
	}
	
	@RequestMapping(path="/{username}", method=RequestMethod.GET)
	public String displayHomePage(@PathVariable String username, ModelMap modelMap, HttpSession session) throws SQLException {
		User user = (User) session.getAttribute("currentUser");
		
		modelMap.put("hostList", eventDao.getHostedEventsByUsername(username));
		modelMap.put("invitedList", eventDao.getInvitedEventsByUsername(user.getEmail()));
		modelMap.put("userName", username);
		session.setAttribute("event", null);
		
		return "home";
	}
}
