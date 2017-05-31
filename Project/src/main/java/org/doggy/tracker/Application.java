package org.doggy.tracker;

import org.doggy.tracker.DeviceJDBCTemplate;
import org.doggy.tracker.DeviceReportJDBCTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebSecurity
@EnableWebMvc
@ImportResource("Beans.xml")
public class Application {

	public static void main(String[] args) throws Throwable {
		
		SpringApplication.run(Application.class, args);
        
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        DeviceJDBCTemplate deviceJDBCTemplate = (DeviceJDBCTemplate)context.getBean("deviceJDBCTemplate");
        DeviceReportJDBCTemplate deviceReportJDBCTemplate = (DeviceReportJDBCTemplate)context.getBean("deviceReportJDBCTemplate");
         
    }

}