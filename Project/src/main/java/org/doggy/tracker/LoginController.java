																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																															package org.doggy.tracker;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String login(){
		
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.POST)
    public String processLogin(String email, String password, ModelMap model) {
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		UserJDBCTemplate userJDBCTemplate = (UserJDBCTemplate)context.getBean("userJDBCTemplate");

		List<User> users = userJDBCTemplate.listUsers();
		
		for (User record : users) {
			if(email.equals(record.getEmail()) && password.equals(record.getPassword())){
			    String firstName = record.getFirstName();
			    String lastName = record.getLastName();

				model.addAttribute("firstName", firstName);
				model.addAttribute("lastName", lastName);
				
				return "home";
			}
		}
        
		return "error";
	}
}

