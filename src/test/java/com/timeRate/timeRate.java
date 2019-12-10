package com.timeRate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import javax.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.junit.Test;
import com.timeRate.service.TimeRateI;
import com.timeRate.service.impl.TimeRateImpl;
import static org.mockito.Mockito.*;

public class timeRate {
	private TimeRateI timeRate;

	@Before
	public void beforeGameTest() {
		timeRate = new TimeRateImpl();
	}
	
	@Test
	public void test_setTimeRate() {
		int timesPerHour = 20;//20 times per hour
		timeRate.setTimeRate(timesPerHour);
		assertEquals(TimeRateImpl.timesPerHour, timesPerHour);
	}
	
	@Test
	public void test_sendRequest() {
		HttpServletResponse response = mock(HttpServletResponse.class); 
		TimeRateImpl.timesPerHour = 100;
		for(int i = 0; i<TimeRateImpl.timesPerHour; i++ ) {
			assertEquals("", timeRate.sendRequest(response));
		}
		assertNotEquals("", timeRate.sendRequest(response));//exceed
	}
	
}
