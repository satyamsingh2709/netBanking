package com.netbanking.testCases;

import java.util.Arrays;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo1 {
	
	@Test
	public void learn() throws InterruptedException {
	
		WebDriver driver = new ChromeDriver();
		driver.get("http://192.168.165.10:9089/hkst2/servlet/BrowserServlet");
		Point p = new Point(250, 250);
		driver.manage().window().setPosition(p);
		Thread.sleep(5000);
		driver.close();
		
	}

}
