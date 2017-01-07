package org.doggy.tracker;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
public class WebController extends WebMvcConfigurerAdapter {

    public void addViewControllers(ViewControllerRegistry registry) {
    	System.out.print(" i am in addViewControlller");
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/")
    public String showUser(User user) { 
    	System.out.print(" i am in showForm");
        return "form";
    }

    @PostMapping("/")
    public String checkUserInfo(@Valid User user, BindingResult bindingResult) {
    	
    	System.out.print(" i am here");

        /*if (bindingResult.hasErrors()) {
        	System.out.print("now i am here");
            return "form";
        }*/

        return "redirect:/results";
    }
}