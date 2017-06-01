package org.doggy.tracker;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/accountSettings")
public class AccountSettingsController extends BaseController {
	
	@Autowired
	private UserJDBCTemplate userJDBCTemplate;
		
	@RequestMapping(method = RequestMethod.GET)
	public String accountSeetings(){
		
		return "accountSettings";
	}
		
	@RequestMapping(method = RequestMethod.POST)
	public String processAccountSettings(String newFirstName, String newLastName, String newPassword, String newEmail, ModelMap model) {
				
		Authentication authentication = getUser();
        String currentPrincipalName = authentication.getName();
		
		User user = userJDBCTemplate.getUser(currentPrincipalName);
				
		if(!newPassword.equals("")){
			Md5PasswordEncoder encoderMD5 = new Md5PasswordEncoder();
	        String securePass = encoderMD5.encodePassword(newPassword, null);
	        
			userJDBCTemplate.updateByPassword(securePass, user.getEmail());
		}
		
		if(!newEmail.equals("") && EmailValidator.getInstance().isValid(newEmail)){
			userJDBCTemplate.updateByEmail(newEmail, user.getEmail());
		}
		
		if(!newLastName.equals("")){
			userJDBCTemplate.updateByLastName(newLastName, user.getEmail());
		}
		
		if(!newFirstName.equals("")){
			userJDBCTemplate.updateByFirstName(newFirstName, user.getEmail());
			
			model.addAttribute("firstName", newFirstName);
			
			return "home";
		}
		
		model.addAttribute("firstName", user.getFirstName());
		
	    return "home";
	}

}
 