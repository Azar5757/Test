package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class Loginpage extends TestBase{
	
	

	@FindBy(className="_2zrpKA _1dBPDZ")
	WebElement username;
	
	@FindBy(xpath = "//input[@class='_2zrpKA _3v41xv _1dBPDZ']")
	WebElement password;
	
	@FindBy(className = "_2AkmmA _1LctnI _7UHT_c")
	WebElement loginbutton;
	
	@FindBy(className = "_1e_EAo")
	WebElement flipkartimage;
	
	
	public Loginpage() throws IOException {
		PageFactory.initElements(driver, this);
		
	}
	
	public String validateloginpagetitle() {
		return driver.getTitle();
	}
	
	public boolean validateflipkartimage() {
		return flipkartimage.isDisplayed();
	}
	
	public Homepage login(String un,String pw) {
		
		username.sendKeys(un);
		password.sendKeys(pw);
		loginbutton.click();
		
		return new Homepage();
		
	}
	

	
	

}
