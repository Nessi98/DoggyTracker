package org.doggy.tracker;

import java.util.List;
import org.doggy.tracker.UserJDBCTemplate;
import org.doggy.tracker.DeviceJDBCTemplate;
import org.doggy.tracker.DeviceReportJDBCTemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
    	
        SpringApplication.run(Application.class, args);
        
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

         UserJDBCTemplate userJDBCTemplate = (UserJDBCTemplate)context.getBean("userJDBCTemplate");
         DeviceJDBCTemplate deviceJDBCTemplate = (DeviceJDBCTemplate)context.getBean("deviceJDBCTemplate");
         DeviceReportJDBCTemplate deviceReportJDBCTemplate = (DeviceReportJDBCTemplate)context.getBean("deviceReportJDBCTemplate");
         
         deviceJDBCTemplate.create(12, "1999828", "SSH12AB45");

         deviceReportJDBCTemplate.create("12.12", "12.12", "78%");
         deviceReportJDBCTemplate.create("75.34", "56.12", "8%");
         
         System.out.println("------Listing Multiple Records--------" );
         List<User> users = userJDBCTemplate.listUsers();
         
         for (User record : users) {
            System.out.print("ID : " + record.getUserId() );
            System.out.print(", Name : " + record.getName() );
            System.out.println(", email : " + record.getEmail());
         }
         
         userJDBCTemplate.update(9, "fvg");
    }

}