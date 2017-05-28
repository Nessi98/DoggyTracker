package org.doggy.tracker;


import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/addDevice")
public class AddDeviceController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String addDevice(){
		
		return "addDevice";
	}
	
	@RequestMapping(method = RequestMethod.POST)
    public String processAddDevice(String imei, String activationKey, String name) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		DeviceJDBCTemplate deviceJDBCTemplate = (DeviceJDBCTemplate)context.getBean("deviceJDBCTemplate");

		List<Device> devices = deviceJDBCTemplate.listDevices();
		
        for (Device record : devices) {
            if(imei.equals(record.getImei()) && activationKey.equals(record.getActivationKey()) && record.getUserId() == 0 ){
            	
            	//File htmlWelcomeFile = new File("welcome.html");
            	//String htmlString = FileUtils.readFileToString(htmlWelcomeFile);
            	
            	//String body = "<form method=\"get\" action=\"/addDevice\"><div><input type=\"submit\" value=\"Add Device\"/></div></form>";
            	
            	//htmlString = htmlString.replace("$body", body);
            	//File newHtmlFile = new File("path/new.html");
            	//FileUtils.writeStringToFile(newHtmlFile, htmlString);

            	deviceJDBCTemplate.update(imei, record.getUserId(), name);
            	return "welcome";
            }
         }
         
        return "error";
	}
}
