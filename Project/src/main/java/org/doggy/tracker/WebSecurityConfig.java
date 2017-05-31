package org.doggy.tracker;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	http.authorizeRequests()
    	    	.antMatchers("/", "/registration", "/login").permitAll() 
    			.anyRequest().authenticated()
    			.and()
    		.formLogin()
    		    .loginPage("/login")
    		    .loginProcessingUrl("/login").usernameParameter("email").passwordParameter("password")
    		    .defaultSuccessUrl("/home")
    		    .and()
    		.csrf().disable();
    	}
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth, UserJDBCTemplate userJDBCTemplate) throws Exception {
    	auth.authenticationProvider(authenticationProvider(userJDBCTemplate));
    }
    	
    private AuthenticationProvider authenticationProvider(UserJDBCTemplate userJDBCTemplate) {
    	DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    	
    	authenticationProvider.setUserDetailsService(userJDBCTemplate);
    	authenticationProvider.setPasswordEncoder(new Md5PasswordEncoder());

    	return authenticationProvider;
    }
    
}