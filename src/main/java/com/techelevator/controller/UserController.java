package com.techelevator.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.model.User;
import com.techelevator.model.UserDAO;

@Controller
public class UserController {

	private UserDAO userDAO;

	@Autowired
	public UserController(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@RequestMapping(path="/new", method=RequestMethod.GET)
	public String displayNewUserForm(ModelMap modelHolder, HttpSession session) {
		if( ! modelHolder.containsAttribute("user")) {
			modelHolder.addAttribute("user", new User());
		}
		session.setAttribute("errorMsg", "");
		return "newUser";
	}
	
	@RequestMapping(path="/newError", method=RequestMethod.GET)
	public String displayNewUserFormWithErrorMsg(ModelMap modelHolder) {
		if( ! modelHolder.containsAttribute("user")) {
			modelHolder.addAttribute("user", new User());
		}
		return "newUser";
	}
	
	@RequestMapping(path="/users", method=RequestMethod.POST)
	public String createUser(@Valid @ModelAttribute User user, BindingResult result, RedirectAttributes flash,
								HttpSession session) {
		if(result.hasErrors()) {
			flash.addFlashAttribute("user", user);
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "user", result);
			return "redirect:/new";
		}
		
		if(userDAO.getUserByUserName(user.getUserName()) == null && userDAO.getUserByEmail(user.getEmail()) == null) {
			userDAO.saveUser(user.getUserName(), user.getPassword(), user.getFirstName(), user.getLastName(),
					user.getEmail(), user.getFoodRestrictions());
			return "redirect:/login";
		} else {
			session.setAttribute("errorMsg", "That User Name or Password is already registered!");
			return "redirect:/newError";
		}
	}	
}
