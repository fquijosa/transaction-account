package com.pichincha.backend.test.log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {

	private static final String LOG_FILE = "log4j.properties";
	private Logger log ;
	Properties properties = new Properties();
	
	
	public Log(String ClassName)
	{
		log = Logger.getLogger(ClassName);
	}
	
	public void WriteLog(String LogString)
	{
		try {
			properties.load(new FileInputStream(LOG_FILE));
			PropertyConfigurator.configure(properties);

			log.info(LogString);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
