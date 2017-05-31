
package org.doggy.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/home")
public class HomeController extends BaseController{
	
	@Autowired
	private UserJDBCTemplate userJDBCTemplate;
	
	@RequestMapping(method = RequestMethod.GET)
	public String welcome(ModelMap model){
		
		SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        String currentPrincipalName = authentication.getName();
        
		User user = userJDBCTemplate.getUser(currentPrincipalName);
		
		model.addAttribute("firstName", user.getFirstName());
		
		return "home";
	}

}