package com.netbanking.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.netbanking.pageObject.LoginPage;
import com.netbanking.pageObject.NewCustomerPage;

import junit.framework.Assert;

public class AddCustomerTest_TC002 extends BaseClass {
	
	LoginPage lp;
	@Test
	public void addNewCustomer() throws InterruptedException {
		lp= new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickLogin();
		
		NewCustomerPage customerPage = new NewCustomerPage(driver);
		customerPage.clickNewCustomerLink();
		Thread.sleep(3000);
		customerPage.setCustomerName("CustC");
		customerPage.selectGender("Female");
		String dd="20";
		String mm="12";
		String yyyy="2001";
		customerPage.setDateOfBirth(dd, mm, yyyy);
		customerPage.setAddress("addddddrressss");
		customerPage.setCity("ctctct");
		customerPage.setState("stststst");
		customerPage.setPincode(222222L);
		customerPage.setPhoneNo(1231231234L);
		customerPage.setEmailid("emailgfdgdl@gmail.com");
		customerPage.setPassword("passwordpassword");
		customerPage.submitDetails();
		
		Thread.sleep(5000);
		boolean b = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(b) {
			String custId = customerPage.getCustomerId();
			System.out.println(custId);
			Assert.assertTrue(true);
			System.out.println("Customer Registered Successfully");
			
			
		}else {
			System.out.println("Test Failed");
			Assert.assertTrue(false);
		}
	}
	
	@AfterMethod
	public void logout() {
		lp = new LoginPage(driver);		
		lp.clickLogout();
	}


}
