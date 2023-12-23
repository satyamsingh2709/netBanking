package com.netbanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {
	
	WebDriver driver;
	
	public NewCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()=\"New Customer\"]")
	WebElement newCustomerlnk;
	
	@FindBy(xpath = "//input[@name=\"name\"]")
	WebElement customerName;
	
	@FindBy(xpath = "//input[@value=\"m\"]")
	WebElement genderMale;
	
	@FindBy(xpath = "//input[@value=\"f\"]")
	WebElement genderFemale;
	
	@FindBy(xpath = "//input[@id=\"dob\"]")
	WebElement dateOfBirth;
	
	@FindBy(xpath = "//textarea[@name=\"addr\"]")
	WebElement address;
	
	@FindBy(xpath = "//input[@name=\"city\"]")
	WebElement city;
	
	@FindBy(xpath = "//input[@name=\"state\"]")
	WebElement state;
	
	@FindBy(xpath = "//input[@name=\"pinno\"]")
	WebElement pincode;
	
	@FindBy(xpath = "//input[@name=\"telephoneno\"]")
	WebElement phoneNo;
	
	@FindBy(xpath = "//input[@name=\"emailid\"]")
	WebElement emailid;
	
	@FindBy(xpath = "//input[@name=\"password\"]")
	WebElement password;
	
	@FindBy(xpath = "//input[@name=\"sub\"]")
	WebElement submitbtn;
	
	@FindBy(xpath = "//td[text()=\"Customer ID\"]/following::td[1]")
	WebElement custId;
	
	public void clickNewCustomerLink() {
		newCustomerlnk.click();
	}
	
	public void setCustomerName(String name) {
		customerName.sendKeys(name);
	}
	
	public void selectGender(String gender) {
		if(gender.equalsIgnoreCase("Male")) {
			genderMale.click();
		}else {
			genderFemale.click();
		}
	}
	
	public void setDateOfBirth(String dd, String mm, String yyyy) {
		dateOfBirth.sendKeys(dd);
		dateOfBirth.sendKeys(mm);
		dateOfBirth.sendKeys(yyyy);
	}
	
	public void setAddress(String add) {
		address.sendKeys(add);
	}
	
	public void setCity(String ct) {
		city.sendKeys(ct);
	}
	
	public void setState(String st) {
		state.sendKeys(st);
	}
	
	public void setPincode(long pin) {
		pincode.sendKeys(String.valueOf(pin));
	}
	
	public void setEmailid(String email) {
		emailid.sendKeys(email);
	}
	public void setPhoneNo(long no) {
		phoneNo.sendKeys(String.valueOf(no));
	}
	
	public void setPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void submitDetails() {
		submitbtn.click();
	}
	
	public String getCustomerId() {
		String custNo = custId.getText();
		return custNo;
	}
}
