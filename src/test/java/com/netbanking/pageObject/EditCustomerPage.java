package com.netbanking.pageObject;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
	
	WebDriver driver;
	
	public EditCustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()=\"Edit Customer\"]")
	WebElement editCustomer;

	@FindBy(xpath = "//input[@name=\"cusid\"]")
	WebElement customerId;
	
	@FindBy(xpath = "//input[@name=\"AccSubmit\"]")
	WebElement submitBtn;
	
	@FindBy(xpath = "//input[@name=\"res\"]")
	WebElement resetBtn;
	
	@FindBy(xpath="//textarea[@name=\"addr\"]")
	WebElement address;
	
	@FindBy(xpath="//input[@name=\"city\"]")
	WebElement city;
	
	@FindBy(xpath="//input[@name=\"sub\"]")
	WebElement submit;
	
	public void clickEditCustomer() {
		editCustomer.click();
	}
	
	public void setCustomerId(String custId) {
		customerId.sendKeys(custId);
	}
	
	public void clickSubmit() {
		submitBtn.click();
	}
	
	public void changeAddress(String add) {
		address.sendKeys(add);
	}
	
	public void changeCity(String ct) {
		city.sendKeys(ct);
	}
	
	public void submitChanges() {
		submit.click();
	}
}
