package com.netbanking.utilites;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	public ReadConfig(){
		try {
			FileInputStream fis = new FileInputStream("./Configuration/config.properties");
			prop=new Properties();
			prop.load(fis);	
		}catch(Exception e){
			System.out.println("Exception is "+ e.getMessage());
		}
		
	}
	
	public String baseUrl() {
		String url = prop.getProperty("url");
		return url;
	}
	
	public String userName() {
		String username = prop.getProperty("username");
		return username;
	}
	
	public String password() {
		String pass = prop.getProperty("password");
		return pass;
	}
	
}
