package org.doggy.tracker;

import org.springframework.ui.ModelMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

@Controller
public class ViewProfileController extends BaseController{
	
	@Autowired
	private UserJDBCTemplate userJDBCTemplate;
	
	@RequestMapping(value = "/viewProfile", method = RequestMethod.GET)
	public String viewProfile(ModelMap model){
		
		Authentication authentication = getUser();
        String currentPrincipalName = authentication.getName();
        
		User user = userJDBCTemplate.getUser(currentPrincipalName);
		
		model.addAttribute("firstName", user.getFirstName());
		model.addAttribute("lastName", user.getLastName());
		model.addAttribute("email", currentPrincipalName);
		
		return "viewProfile";
	}

}
