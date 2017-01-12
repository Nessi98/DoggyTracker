package org.doggy.tracker;

import org.springframework.stereotype.Controller;

// I will use this Greeting Controller to make my DeviceReportController
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingController {

	@RequestMapping(value = "/greeting")
    public String greeting(@RequestParam(value = "User") String User,
            @RequestParam(value = "Pass") String pass,
            @RequestParam(value = "IMEI") String imei,
            @RequestParam(value = "GPS") List<String> params, Model model){
		
		String lat = params.get(3);
		String lon = params.get(5);
		
		float lat1 = Float.parseFloat(lat);
		float lng = Float.parseFloat(lon);
		int i = (int)lat1 / 100;
		
		lat1 = i + ((lat1 - i*100)/60);
		i = (int)lng / 100;
		lng = i + ((lng - i*100)/60);

		model.addAttribute("lat", lat1);
		model.addAttribute("lng", lng);
		
        return "greeting";
    }

}