package com.netbanking.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.netbanking.pageObject.LoginPage;
import com.netbanking.pageObject.NewAccountPage;

import junit.framework.Assert;

public class NewAccountTest_TC001 extends BaseClass{
	
	LoginPage lp;
	
	@Test
	public void newAccount() {
		lp = new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickLogin();
		
		NewAccountPage nap = new NewAccountPage(driver);
		nap.clickNewAccount();
		nap.setCustomerId("28553");
		nap.setDeposit(10000);
		nap.clickNewAccount();
		
		Assert.assertTrue(true);
		
	}
	
	@AfterMethod
	public void logout() {
		lp = new LoginPage(driver);		
		lp.clickLogout();
	}

}
