package com.timeRate.service;

import javax.servlet.http.HttpServletResponse;

/**
 * A interface that limit rate.
 */
public interface TimeRateI {
	/**
	 * requests, test time rate
	 */
	public String sendRequest(HttpServletResponse response);

	/**
	 * set up how many times per hour
	 *
	 * @param name  timesPerHour
	 */
	public void setTimeRate(int timesPerHour);
}
