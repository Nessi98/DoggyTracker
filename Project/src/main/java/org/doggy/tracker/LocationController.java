package org.doggy.tracker;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/location")
public class LocationController {

	@RequestMapping(method = RequestMethod.GET)
    public void location( @RequestParam(value = "IMEI") String imei,
    		@RequestParam(value = "Description") String batteryLevel,
            @RequestParam(value = "GPS") List<String> params, HttpServletResponse response)  throws ServletException, IOException{
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		DeviceJDBCTemplate deviceJDBCTemplate = (DeviceJDBCTemplate)context.getBean("deviceJDBCTemplate");
		DeviceReportJDBCTemplate deviceJReportDBCTemplate = (DeviceReportJDBCTemplate)context.getBean("deviceReportJDBCTemplate");
		
		String lat = params.get(3);
		String lon = params.get(5);
		
		float latitude = Float.parseFloat(lat);
		float longitude = Float.parseFloat(lon);
		
		int remainder = (int)latitude / 100;
		latitude = remainder + ((latitude - remainder * 100)/60);
		
		remainder = (int)longitude / 100;
		longitude = remainder + ((longitude - remainder * 100)/60);
		
		Device device = deviceJDBCTemplate.getDevice(imei);
		DeviceReport deviceReport = deviceJReportDBCTemplate.getDeviceReport(device.getId());
		
		if(deviceReport == null){
			deviceJReportDBCTemplate.create(device.getId(), latitude, longitude, batteryLevel);
		}else{
			deviceJReportDBCTemplate.update(device.getId(), latitude, longitude, batteryLevel);
		}
		
		((ClassPathXmlApplicationContext)context).close();
		
		PrintWriter writer = response.getWriter();
		
        String htmlRespone = "<html> <head>";
        htmlRespone += "<meta name='viewport' content='initial-scale=1.0, user-scalable=no'/><title>Location</title> <style> #map { height: 25%; margin: 10%;  padding: 10%; }";
        htmlRespone += " </style></head> <body><div id='map'></div>";
        htmlRespone += "<script type='text/javascript'> function initMap() { var myLatLng = {lat: " + latitude + ", lng: " + longitude + "};";      
        htmlRespone += "var map = new google.maps.Map(document.getElementById('map'), { zoom: 20,  center: myLatLng}); var marker = new google.maps.Marker({ position: myLatLng, map: map});} </script>";    
        htmlRespone += "<script async='async' defer='defer' src='https://maps.googleapis.com/maps/api/js?key= AIzaSyAFDPa0zKd2Lua8zEJhJe8yVcuzbVAqeIw&callback=initMap'> </script></body>";
        htmlRespone += "</html>";
         
        // return response
        writer.println(htmlRespone);
    }

}

// example request: location?IMEI=861694038972483&User=Testdev2&Pass=M2IP1382&Description=%22Testdev2%22861694038972483BAT-0,48,3785GSM:%220578%22,%220890%22&GPS=$GNRMC,085606.510,A,4240.4820,N,02317.3632,E,0.23,0.00,171116,,,A*76&
