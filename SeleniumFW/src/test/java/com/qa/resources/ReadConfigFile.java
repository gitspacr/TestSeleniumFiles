package com.qa.resources;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigFile {
	
	Properties prop;
	
	
	public ReadConfigFile() {
		
		
		try {
			
			File file=new File("./Configuration/config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop=new Properties();
			prop.load(fis);
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}
	
	public String launchUrl() {
		
		try {
			
			String getURl=prop.getProperty("url");
			return getURl;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	
	public String browserAccess() {
		
		try {
			
			String getBrowser=prop.getProperty("browser");
			return getBrowser;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
