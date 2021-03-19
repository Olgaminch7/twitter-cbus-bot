package com.olgamelnichenko.property.reader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
	
	private InputStream inputStream;
	private final String FILE_NAME = "config.properties";
	private String API_KEY;
	
	public String getPropertyValue() {
		try {
			Properties properties = new Properties();
			inputStream = getClass().getClassLoader().getResourceAsStream(FILE_NAME);
			if (inputStream != null) {
				properties.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + FILE_NAME + "' not found in the classpath");
			}
			API_KEY = properties.getProperty("API_KEY");
		} catch (Exception e) {
			e.getMessage();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return API_KEY;
		
	}

}
