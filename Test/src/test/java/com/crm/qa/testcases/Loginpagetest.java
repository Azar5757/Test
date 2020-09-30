package com.crm.qa.testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.Loginpage;
public class Loginpagetest extends TestBase {
	Loginpage loginpage;
	Homepage homepage;

	public Loginpagetest() throws IOException {
		super();
	}
	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		loginpage =new Loginpage();
	}
	@Test(priority = 1)
	public void loginpagetitletest(){
		String title=loginpage.validateloginpagetitle();
		Assert.assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books &amp; More. Best Offers!");
	}
	@Test(priority = 2)
	public void flipkartimagetest(){
		boolean image=loginpage.validateflipkartimage();
		Assert.assertTrue(image);
	}
	@Test(priority = 3)
	public void logintest(){
		homepage =loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
}
