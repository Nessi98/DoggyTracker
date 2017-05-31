package org.doggy.tracker;

import javax.servlet.http.HttpSession;
import org.springframework.ui.ModelMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String login(){
		
		return "login";
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public String authenticate(HttpServletRequest request, HttpServletResponse response, String email, String password,  ModelMap model) throws Exception {
		
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
		
		Authentication auth = new UsernamePasswordAuthenticationToken(email, user.getPassword());
		
		SecurityContext securityContext = SecurityContextHolder.getContext();
	    securityContext.setAuthentication(auth);
		
		String currentPrincipalName = auth.getName();
		
		System.out.println("Login Controller: " + currentPrincipalName);
		
		HttpSession session = request.getSession(true);
	    session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);

	    
	    if(session != null){
	    	System.out.println("Test2" );
	    }
	    model.addAttribute("firstName", user.getFirstName());
        ((ClassPathXmlApplicationContext)context).close();
        

		return "redirect:/home";
	}
}

