package org.doggy.tracker;

import java.util.List;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {
	
	@Autowired
	private UserJDBCTemplate userJDBCTemplate;
	
	@RequestMapping(method = RequestMethod.GET)
	public String registration(){
		
		return "registration";
	}

	@RequestMapping(method = RequestMethod.POST)
    public String processRegistration(String firstName, String lastName, String email, String password) {	
			
		if(firstName.isEmpty() || firstName.length() < 3 || firstName.length() > 16) {
			return "error";
		}

		if(lastName.isEmpty() || lastName.length() < 3 || lastName.length() > 16) {
			return "error";
		}

		if(password.isEmpty() || password.length() < 5 || password.length() > 16) {
			return "error";
		}
		
		if(email.isEmpty() || !EmailValidator.getInstance().isValid(email)){
			return "error";
		}

		List<User> users = userJDBCTemplate.listUsers();
		
		for (User user : users) {
			if(email.equals(user.getEmail())){

		/*if(user.getEmail().equals(email)){
			((ClassPathXmlApplicationContext)context).close();
			return "error";
		}*/
		     return "error";
			}
		}
		
        Md5PasswordEncoder encoderMD5 = new Md5PasswordEncoder();
        String securePass = encoderMD5.encodePassword(password, null);
        
        userJDBCTemplate.create(firstName, lastName, email, securePass);
        
        return "redirect:/home";
	}
}
