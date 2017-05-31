package org.doggy.tracker;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/addDevice")
public class AddDeviceController extends BaseController{
	
	@RequestMapping(method = RequestMethod.GET)
	public String addDevice(){
		
		return "addDevice";
	}
	
	@RequestMapping(method = RequestMethod.POST)
    public String processAddDevice(String imei, String activationKey, String name) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		DeviceJDBCTemplate deviceJDBCTemplate = (DeviceJDBCTemplate)context.getBean("deviceJDBCTemplate");

		Device device = deviceJDBCTemplate.getDevice(imei);

		if(activationKey.equals(device.getActivationKey()) && device.getUserId() == 0 ){
               	deviceJDBCTemplate.update(name, device.getUserId(), device.getId());
            	((ClassPathXmlApplicationContext)context).close();  	
            	
            	return "home";
        }
        
        ((ClassPathXmlApplicationContext)context).close(); 
        return "error";
	}
}