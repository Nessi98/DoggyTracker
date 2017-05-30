package org.doggy.tracker;

import org.springframework.ui.ModelMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class ViewProfileController {
	
	@RequestMapping(value = "/viewProfile", method = RequestMethod.GET)
	public String viewProfile(HttpServletRequest request, ModelMap model){
		HttpSession session = request.getSession(true); 
		//User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		
		System.out.println("View Profile Controller: " + currentPrincipalName);
		
		//String firstName = user.getFirstName();
		//String lastName = user.getLastName();
		//String email = user.getEmail();
		
		//model.addAttribute("firstName", firstName);
		//model.addAttribute("lastName", lastName);
		//model.addAttribute("email", email);
		
		return "viewProfile";
	}

}
