package com.netbanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAccountPage {
	WebDriver driver;
	
	public NewAccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[text()=\"New Account\"]")
	WebElement newAccount;
	
	@FindBy(xpath="//input[@name=\"cusid\"]")
	WebElement customerId;
	
	@FindBy(xpath="//input[@name=\"inideposit\"]")
	WebElement initialDeposit;
	
	@FindBy(xpath="//input[@name=\"button2\"]")
	WebElement submitButton;
	
	public void clickNewAccount() {
		newAccount.click();
	}
	
	public void setCustomerId(String custId) {
		customerId.sendKeys(custId);
	}
	
	public void setDeposit(int amount) {
		initialDeposit.sendKeys(String.valueOf(amount));
	}
	
	public void submit() {
		submitButton.click();
	}
}
