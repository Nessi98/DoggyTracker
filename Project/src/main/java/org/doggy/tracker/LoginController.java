																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																															package org.doggy.tracker;

import javax.servlet.http.HttpSession;
import org.springframework.ui.ModelMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String login(){
		
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.POST)
    public String processLogin(HttpSession session, HttpServletRequest request, String email, String password, ModelMap model) throws Exception {
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		UserJDBCTemplate userJDBCTemplate = (UserJDBCTemplate)context.getBean("userJDBCTemplate");

		User user = userJDBCTemplate.getUser(email);
		
		Md5PasswordEncoder encoderMD5 = new Md5PasswordEncoder();
        String securePass = encoderMD5.encodePassword(password, null);
        
        System.out.println("Test 2: " + securePass);
        
		if(!user.getPassword().equals(securePass)){
			System.out.print("This is a test" + userJDBCTemplate.getUser(email));
			((ClassPathXmlApplicationContext)context).close();
	
			return "error";
		}
		
		//session.invalidate();
	   // HttpSession newSession = request.getSession();
	    
	    //newSession.
		
		String firstName = user.getFirstName();
	    String lastName = user.getLastName();

		model.addAttribute("firstName", firstName);
		model.addAttribute("lastName", lastName);
		
        ((ClassPathXmlApplicationContext)context).close();
		return "home";
	}
}

