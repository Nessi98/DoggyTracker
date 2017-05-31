package org.doggy.tracker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/accountSettings")
public class AccountSettingsController extends BaseController {
		
		@RequestMapping(method = RequestMethod.GET)
		public String accountSeetings(){
			
			return "accountSettings";
		}
		
		@RequestMapping(method = RequestMethod.POST)
	    public String processAccountSettings(String newPassword, String newEmail) {
			
						
	        return "error";
		}

}
 