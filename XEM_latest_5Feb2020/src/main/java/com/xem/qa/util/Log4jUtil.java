package com.xem.qa.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jUtil {
	static Logger logger=LogManager.getLogger(Log4jUtil.class);
	
	public static void main(String[] args) {
		System.out.println("i am regular message");
		logger.info("i am info from Log4j family");
		logger.error("i am error from Log4j family");
		System.out.println("completed");

	}

}
