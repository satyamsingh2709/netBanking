package com.netbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.netbanking.pageObject.LoginPage;
import com.netbanking.pageObject.NewCustomerPage;
import com.netbanking.utilites.FileReader;

import junit.framework.Assert;

public class AddCustomerTest_TC001 extends BaseClass {
	
	@Test(dataProvider="custData")
	public void addNewCustomer(String custName, String gender, String dob, String add, String city, 
							   String state, String pin, String mobNo, String email, String pass) throws InterruptedException, IOException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickLogin();
		
		//Add new Customer
		NewCustomerPage customerPage = new NewCustomerPage(driver);
		//System.out.println(custName +" "+ gender +" "+ dob +" "+ add +" "+ city +" "+ state +" "+pin
		//					+" "+ mobNo +" "+ email+" "+ pass);
		
		customerPage.clickNewCustomerLink();
		Thread.sleep(3000);
		customerPage.setCustomerName(custName);
		customerPage.selectGender(gender);
		String[] arr= dob.split("/");
		customerPage.setDateOfBirth(arr[0], arr[1], "20"+arr[2]);
		customerPage.setAddress(add);
		customerPage.setCity(city);
		customerPage.setState(state);
		long pincode = Long.parseLong(pin);
		customerPage.setPincode(pincode);
		long phoneno = Long.parseLong(mobNo);
		customerPage.setPhoneNo(phoneno);
		customerPage.setEmailid(email);
		customerPage.setPassword(pass);
		customerPage.submitDetails();
		
		
		Thread.sleep(5000);
		boolean b = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(b) {
			String custId = customerPage.getCustomerId();
			setValue(0,custId);
			Assert.assertTrue(true);
			System.out.println("Customer Registered Successfully");
			
			
		}else {
			System.out.println("Test Failed");
			Assert.assertTrue(false);
		}
	}
	
	@DataProvider(name="custData")
	public Object[][] getCustomerData() throws IOException {
		String filePath = "./DataFiles/LoginData.xlsx";
		String sheetName = "Sheet2";
		int rowNum=1;
		int colCount=FileReader.getCellCount(filePath, sheetName, rowNum);
		Object customerData[][] = new Object[rowNum][colCount];
		
		for(int i =rowNum;i<=rowNum;i++) {
			for(int j=0;j<colCount;j++) {
				customerData[0][j]=FileReader.readCellData(filePath, sheetName, rowNum, j);
			}
		}
		return customerData;
	}
	
	public void setValue(int ColNum, String Data) throws IOException {
		String filePath = "./DataFiles/AccountData.xlsx";
		String sheetName = "Sheet1";
		int rowNum = FileReader.getRowCount(filePath, sheetName);
		FileReader.setData(filePath, sheetName, rowNum, ColNum, Data);
	}
}
