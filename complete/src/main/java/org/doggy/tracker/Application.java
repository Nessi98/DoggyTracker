package org.doggy.tracker;

import java.util.List;
import org.doggy.tracker.UserJDBCTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        
        ApplicationContext context = 
                new ClassPathXmlApplicationContext("Beans.xml");

         UserJDBCTemplate userJDBCTemplate = 
         (UserJDBCTemplate)context.getBean("userJDBCTemplate");
         
         System.out.println("------Records Creation--------" );
         userJDBCTemplate.create("Zara", "zara@gmail.com", "hello123");
         userJDBCTemplate.create("Nuha", "Nuha@gmail.com", "123");
         userJDBCTemplate.create("Ayan", "Ayan@gmai.com", "123123");

         System.out.println("------Listing Multiple Records--------" );
         List<User> users = userJDBCTemplate.listUsers();
         for (User record : users) {
            System.out.print("ID : " + record.getUserId() );
            System.out.print(", Name : " + record.getName() );
            System.out.println(", email : " + record.getEmail());
         }
    }

}