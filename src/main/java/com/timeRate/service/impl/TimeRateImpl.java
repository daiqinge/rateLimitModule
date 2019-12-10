package com.timeRate.service.impl;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import com.timeRate.bean.Constants;
import com.timeRate.service.TimeRateI;

@Service
public class TimeRateImpl implements TimeRateI{
	public static int timesPerHour = Constants.INITIAL_TIMES;
	public static int timeCount;
	private static Date preDate = new Date();
	
	@Override
	public String sendRequest(HttpServletResponse response) {
		int passSeconds = (int) ((new Date().getTime() - preDate.getTime())/1000);
		if(passSeconds > Constants.SECONDS_OF_ONE_HOUR) {
			preDate = new Date();
			timeCount = 1;
			return "";
		}
		timeCount++;
		if(timeCount > timesPerHour) {
			int waitSeconds = Constants.SECONDS_OF_ONE_HOUR - passSeconds;
			response.setStatus(Constants.TOO_MANY_REQUESTS_429);
			return "Rate limit exceeded. Try again in " + waitSeconds + " seconds";
		}
		return "";
	}

	@Override
	public void setTimeRate(int timesPerHour) {
		TimeRateImpl.timesPerHour = timesPerHour;
	}

}
