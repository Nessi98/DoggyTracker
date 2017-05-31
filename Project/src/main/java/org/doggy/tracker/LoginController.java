package org.doggy.tracker;

import javax.servlet.http.HttpSession;
import org.springframework.ui.ModelMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{
	
	@Autowired
	private UserJDBCTemplate userJDBCTemplate;	
	
	@RequestMapping(name = "login", value = "/login", method = RequestMethod.GET)
	public String login() {	
		if (isUserLoggedIn()) {
			return " " ; // Don' t let him go to the logging page again
		}
		return "login";
	}
	
	@RequestMapping(name = "login", value = "/login", method = RequestMethod.POST)
	public String authenticate(HttpServletRequest request, String email, String password,  ModelMap model) throws Exception {
		if (isUserLoggedIn()) {
			return " " ; // Don' t let him login again
		}
		
		User user = userJDBCTemplate.getUser(email);
		Md5PasswordEncoder encoderMD5 = new Md5PasswordEncoder();
        String securePass = encoderMD5.encodePassword(password, null);
        
        System.out.println("Test 2: " + securePass);
        
		if(user == null || !user.getPassword().equals(securePass)){	
			return "error"; // username or password wrong error
		}
		
		Authentication auth =
				  new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
				 
		SecurityContextHolder.getContext().setAuthentication(auth);

		/*
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.setAttribute("user", email);
		}
		*/
		//Authentication auth = new UsernamePasswordAuthenticationToken(email, user.getPassword());
		
	    //securityContext.setAuthentication(auth);
		
		//String currentPrincipalName = auth.getName();
		
		//System.out.println("Login Controller: " + currentPrincipalName);
		
		//HttpSession session = request.getSession(true);
	    //session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
	    
	    model.addAttribute("firstName", user.getFirstName());        

		return "home";
	}
	
	@RequestMapping(name = "logout", value = "/logout" , method = RequestMethod.POST)
	public String logOut() {
		if (!isUserLoggedIn()) {
			return " "; // don' t let not logged in users log out  
		}
		
		SecurityContextHolder.getContext().setAuthentication(null);	
		return " " ;
	}
	
	// Could go to a base controller ?? 
	protected boolean isUserLoggedIn() {
		return SecurityContextHolder.getContext().getAuthentication() != null;
	}
}

