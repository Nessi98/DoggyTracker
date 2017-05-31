package org.doggy.tracker;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public abstract class BaseController {
	public Authentication getUser() {
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
	public boolean isUserAuthenticated() {
		Authentication user = getUser();
		return user != null;
	}
}
