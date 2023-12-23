package com.netbanking.testCases;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.netbanking.utilites.ReadConfig;

public class BaseClass {
	
//	public String url = "https://demo.guru99.com/v4/";
//	public String username = "mngr541146";
//	public String password = "ryzYsam";
	public static WebDriver driver;
	
	ReadConfig readConfig = new ReadConfig();
	String url = readConfig.baseUrl();
	String username = readConfig.userName();
	String password = readConfig.password();
	Logger logger;
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		
		if(br.equals("Chrome")) {
			driver=new ChromeDriver();			
		} else if(br.equals("Firefox")) {
			driver = new FirefoxDriver();			
		} else if(br.equals("IE")){
			driver = new EdgeDriver();
		}	
		
		driver.manage().window().maximize();			
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	

}
