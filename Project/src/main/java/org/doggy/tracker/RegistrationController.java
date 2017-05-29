package org.doggy.tracker;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
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
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		UserJDBCTemplate userJDBCTemplate = (UserJDBCTemplate)context.getBean("userJDBCTemplate");
		
		User user = userJDBCTemplate.getUser(email);

		if(user.getEmail().equals(email)){
			((ClassPathXmlApplicationContext)context).close();
			return "error";
		}

        Md5PasswordEncoder encoderMD5 = new Md5PasswordEncoder();
        String securePass = encoderMD5.encodePassword(password, null);
        
        //System.out.println("This is the password :" + securePass);
        
        userJDBCTemplate.create(firstName, lastName, email, securePass);
        ((ClassPathXmlApplicationContext)context).close();
        
        return "welcome";
	}
}
