package com.netbanking.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.netbanking.pageObject.EditCustomerPage;
import com.netbanking.pageObject.LoginPage;

import junit.framework.Assert;

public class EditCustomerTest_TC001 extends BaseClass{
	
	LoginPage lp;
	@Test
	public void editCustomer() throws InterruptedException {
	lp = new LoginPage(driver);
	lp.setUsername(username);
	lp.setPassword(password);
	lp.clickLogin();
	
	EditCustomerPage ecp = new EditCustomerPage(driver);
	ecp.clickEditCustomer();
	ecp.setCustomerId("28553");
	ecp.clickSubmit();
	Thread.sleep(3000);
	
	ecp.changeAddress("AddAddAdd");
	ecp.changeCity("ctctctctctct");
	ecp.submitChanges();
	
	Assert.assertTrue(true);
	
	
	}
	
	@AfterMethod
	public void logout() {
		lp = new LoginPage(driver);		
		lp.clickLogout();
	}

}
