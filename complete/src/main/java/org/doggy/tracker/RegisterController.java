package org.doggy.tracker;

import java.util.Map;
 
import org.doggy.tracker.User;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
@RequestMapping(value = "/register")
public class RegisterController {
 
    @RequestMapping(method = RequestMethod.GET)
    public String viewRegistration(Map<String, Object> model) {
        User userForm = new User();    
        model.put("userForm", userForm);
         
        return "Registration";
    }
     
    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("userForm") User user, Map<String, Object> model) {
         
        // i will implement the registration logic later
         
        // for testing purpose:
        System.out.println("username: " + user.getName());
        System.out.println("email: " + user.getEmail());
        System.out.println("password: " + user.getPassword());
         
        return "RegistrationSuccess";
    }
}
