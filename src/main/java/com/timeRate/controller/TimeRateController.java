package com.timeRate.controller;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.timeRate.service.TimeRateI;

@RestController
@RequestMapping("/timeRateController")
public class TimeRateController {
	@Autowired
	private TimeRateI timeRate;
	
	@GetMapping("/getTimeRate")
	public String getTimeRate(HttpServletResponse response) {
		return timeRate.sendRequest(response);
	}
	
	@GetMapping("/setTimeRate")
	public void setTimeRate(int timesPerHour) {
		timeRate.setTimeRate(timesPerHour);
	}
	

}
