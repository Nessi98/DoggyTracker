package org.doggy.tracker;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/accountSettings")
public class AccountSettingsController {
		
		@RequestMapping(method = RequestMethod.GET)
		public String accountSeetings(){
			
			return "accountSettings";
		}
		
		@RequestMapping(method = RequestMethod.POST)
	    public String processAccountSettings(String newPassword, String newEmail) {
			
			ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
			UserJDBCTemplate userJDBCTemplate = (UserJDBCTemplate)context.getBean("userDBCTemplate");

			
	        return "error";
		}

}
