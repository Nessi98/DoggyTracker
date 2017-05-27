package org.doggy.tracker;

import java.util.List;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String registration(){
		
		return "registration";
	}

	@RequestMapping(method = RequestMethod.POST)
    public String processRegistration(String firstName, String lastName, String email, String password) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		UserJDBCTemplate userJDBCTemplate = (UserJDBCTemplate)context.getBean("userJDBCTemplate");
		
		if(firstName.isEmpty() || firstName.length() < 3 || firstName.length() > 16) {
			return "error";
		}
		
		if(lastName.isEmpty() || lastName.length() < 3 || lastName.length() > 16) {
			return "error";
		}
		
		if(password.isEmpty() || password.length() < 5 || password.length() > 16) {
			return "error";
		}
		
		
		if(email.isEmpty() || EmailValidator.getInstance().isValid(email)){
			return "error";
		}

		List<User> users = userJDBCTemplate.listUsers();
		
        for (User record : users) {
            if(email.equals(record.getEmail())){

            	return "error";
            }
         }
         
        userJDBCTemplate.create(firstName, lastName, email, password);
        
        return "welcome";
	}
}
