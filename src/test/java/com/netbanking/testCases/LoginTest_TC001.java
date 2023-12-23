package com.netbanking.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.netbanking.pageObject.LoginPage;

import junit.framework.Assert;

public class LoginTest_TC001 extends BaseClass {
	LoginPage loginPage;
	@Test
	public void LoginTest() {
		
		loginPage = new LoginPage(driver);		
		
		loginPage.setUsername(username);		
		loginPage.setPassword(password);		
		loginPage.clickLogin();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			System.out.println(driver.getTitle());
			Assert.assertTrue(true);
		} else {
			System.out.println(driver.getTitle());
			Assert.assertTrue(false);
		}
		
	}
	@AfterMethod
	public void logout() {
		loginPage = new LoginPage(driver);		
		loginPage.clickLogout();
	}

}
