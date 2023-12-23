package com.netbanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUsername;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath = "//a[text()=\"Log out\"]")
	@CacheLookup
	WebElement btnLogout;
	
	public void setUsername(String username) {
		txtUsername.sendKeys(username);
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);

	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public void clickLogout() {
		btnLogout.click();
	}
	
}
