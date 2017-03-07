package org.doggy.tracker;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
