package org.doggy.tracker;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
        http.authorizeRequests()
        // allow the authenticate method to be accessible for the unautheticated users
	        	.antMatchers("/", "/registration", "/login/authenticate").permitAll()
	        	.anyRequest().authenticated()
	        	.and()
	        .formLogin()
	        	.loginPage("/login")
	        	.permitAll()
	        	.and()
	        .httpBasic()
	        	.and()
        	.logout().clearAuthentication(true)
        		.permitAll();
    } 
    
	
    /*@Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;
    
    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }*/
    
}