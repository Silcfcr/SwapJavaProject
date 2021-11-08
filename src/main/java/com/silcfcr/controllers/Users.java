package com.silcfcr.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.silcfcr.models.User;
import com.silcfcr.services.UserService;

@Controller
public class Users {
	private final UserService userService;

 
 public Users(UserService userService ) {
     this.userService = userService;
 }
 
 @RequestMapping("/")
 public String registerOrLogin(@ModelAttribute("user") User user) {
     return "Login&Registration.jsp";
 }
 

 @RequestMapping(value="/register", method=RequestMethod.POST)
 public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, RedirectAttributes redirectAttributes) {
			List<User> users = userService.findUsersByEmail(user.getEmail());
			 System.out.println(users);
			 if( users.size() > 0) {
					redirectAttributes.addFlashAttribute("errorMessage", "That user email already exists!");
					return "redirect:/";
				}
			if (!user.getPasswordConfirmation().equals(user.getPassword())) {
				redirectAttributes.addFlashAttribute( "errorMessage", "Password and Password confirmation should match!" );
				return "redirect:/";	
			}
			if ( result.hasErrors() ) {
				redirectAttributes.addFlashAttribute( "errorMessage", "You are not complying with data validation!" );
				return "redirect:/";
			}
			userService.registerUser(user);
			session.setAttribute("user_id", user.getId());	
			return "redirect:/dashboard";
 }
 
 
 @RequestMapping(value="/login", method=RequestMethod.POST)
 public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
     // if the user is authenticated, save their user id in session
     // else, add error messages and return the login page
	 if ( userService.authenticateUser(email, password) == false ) {
			redirectAttributes.addFlashAttribute( "loginError", "Trouble signing in, try again!" );
			return "redirect:/";
			
		}
		else {
			User user = userService.findByEmail(email);
			session.setAttribute("user_id", user.getId());
		}
	 return "redirect:/dashboard";
 }

@RequestMapping("/logout")
 public String logout(HttpSession session, RedirectAttributes redirectAttributes) {
     // invalidate session
	 session.setAttribute("user_id", null);
     // redirect to login page
	return "redirect:/";
 }

}