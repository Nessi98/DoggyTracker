package org.doggy.tracker;


import org.springframework.stereotype.Controller;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/location")
public class LocationController {

	@RequestMapping(method = RequestMethod.GET)
    public String location(@RequestParam(value = "User") String User,
            @RequestParam(value = "Pass") String pass,
            @RequestParam(value = "IMEI") String imei,
            @RequestParam(value = "GPS") List<String> params, Model model){
		
		String lat = params.get(3);
		String lon = params.get(5);
		
		float latitude = Float.parseFloat(lat);
		float longitude = Float.parseFloat(lon);
		
		int remainder = (int)latitude / 100;
		latitude = remainder + ((latitude - remainder * 100)/60);
		
		remainder = (int)longitude / 100;
		longitude = remainder + ((longitude - remainder * 100)/60);

        return "location";
    }

}

// greeting?IMEI=861694038972483&User=Testdev2&Pass=M2IP1382&Description="Testdev2"861694038972483BAT-0,48,3785GSM:"0578","0890"&GPS=$GNRMC,085606.510,A,4240.4820,N,02317.3632,E,0.23,0.00,171116,,,A*76&
//get for the map
//Store string in coockie with JS