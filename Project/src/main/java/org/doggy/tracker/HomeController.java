
package org.doggy.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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

        Authentication authentication = getUser();
        String currentPrincipalName = authentication.getName();
        
		User user = userJDBCTemplate.getUser(currentPrincipalName);
		
		model.addAttribute("firstName", user.getFirstName());
		
		return "home";
	}

}