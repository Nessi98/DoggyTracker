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

	public static void main(String[] args) throws Throwable {
		
		SpringApplication.run(Application.class, args);
        
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

         UserJDBCTemplate userJDBCTemplate = (UserJDBCTemplate)context.getBean("userJDBCTemplate");
         DeviceJDBCTemplate deviceJDBCTemplate = (DeviceJDBCTemplate)context.getBean("deviceJDBCTemplate");
         DeviceReportJDBCTemplate deviceReportJDBCTemplate = (DeviceReportJDBCTemplate)context.getBean("deviceReportJDBCTemplate");
         
         System.out.println("------Listing Multiple Records--------" );
         List<User> users = userJDBCTemplate.listUsers();
         
         for (User record : users) {
            System.out.print("First Name : " + record.getFirstName());
            System.out.print(",LastName : " + record.getLastName());
            System.out.println(", email : " + record.getEmail());
         }
         
    }

}