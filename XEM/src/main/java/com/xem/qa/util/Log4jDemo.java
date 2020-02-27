package com.xem.qa.util;


import org.apache.logging.log4j.Logger;



import org.apache.logging.log4j.LogManager;


public class Log4jDemo {

	static Logger logger=LogManager.getLogger(Log4jDemo.class);
	
	
	public static void main(String args[])
	{
		
		System.out.println("i am regular message");
		logger.info("i am info from Log4j family");
		logger.error("i am error from Log4j family");
		System.out.println("completed");
	}
}
