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
    public String processLogin( HttpServletRequest request, String email, String password, ModelMap model) throws Exception {
		
		System.out.println("Login Controller");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		UserJDBCTemplate userJDBCTemplate = (UserJDBCTemplate)context.getBean("userJDBCTemplate");

		User user = userJDBCTemplate.getUser(email);
		
		Md5PasswordEncoder encoderMD5 = new Md5PasswordEncoder();
        String securePass = encoderMD5.encodePassword(password, null);
        
        System.out.println("Test 2: " + securePass);
        
		if(!user.getPassword().equals(securePass)){
			((ClassPathXmlApplicationContext)context).close();
	
			return "error";
		}
		
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.setAttribute("user", email);
		}
		
		//session.invalidate();
	   // HttpSession newSession = request.getSession();
	    //newSession.
		
		
		String firstName = user.getFirstName();
	    String lastName = user.getLastName();

		model.addAttribute("firstName", firstName);
		model.addAttribute("lastName", lastName);
		
        ((ClassPathXmlApplicationContext)context).close();
        
		return "redirect:/home";
	}
}

