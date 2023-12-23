package com.netbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.netbanking.pageObject.LoginPage;
import com.netbanking.utilites.FileReader;

import junit.framework.Assert;

public class LoginTest_TC002 extends BaseClass {
	
	LoginPage lp;
	
	@Test(dataProvider = "loginData")
	public void loginTest(String username, String password) throws InterruptedException {
		lp = new LoginPage(driver);
		
		lp.setUsername(username);
		System.out.println("UserName entered");
		Thread.sleep(5000);
		
		lp.setPassword(password);
		System.out.println("Password entered");
		
		lp.clickLogin();
		Thread.sleep(3000);
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			System.out.println("Invalid credentials");
			Assert.assertTrue(false);
			
		}else {
			Thread.sleep(3000);
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
			System.out.println("Login Successful");
		}
		
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	
	
	@DataProvider(name = "loginData")
	public String[][] getData() throws IOException{
		
		String filePath = "./DataFiles/LoginData.xlsx";
		String sheetName = "Sheet1";
		int rowCount = FileReader.getRowCount(filePath, sheetName);
		int colCount = FileReader.getCellCount(filePath, sheetName, 0);
		
		String login[][] = new String [rowCount][colCount];
		
		for(int i =1;i<=rowCount;i++) {
			for(int j=0;j<colCount;j++) {
				login[i-1][j] = FileReader.readCellData(filePath, sheetName, i, j);
			}
		}
		return login;
	}

}
