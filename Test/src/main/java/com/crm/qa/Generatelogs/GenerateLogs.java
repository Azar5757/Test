package com.crm.qa.Generatelogs;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GenerateLogs {
	
	WebDriver driver;
	@Test
	public void launchbrowser() {
		Logger log = Logger.getLogger(GenerateLogs.class);
		
		System.setProperty("webdriver.chrome.driver", "D:\\Azar\\SeleniumJava\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		log.info("Launching Browser");
		
		driver.get("http://www.google.com");
		log.info("Google url has been launched");
		
		String title =driver.getTitle();
		System.out.println("title value is:"+title);
		log.info("title value is:"+title);
		
		if(title.equals("Google")) {
			System.out.println("correct title is Google");
			log.info("Correct title is Google and test case is passed");
		}else {
			System.out.println("correct title is not a Google");
			log.info("Correct title is not a Google then test case is failed");
			
		}
		
		driver.quit();
		
		
	}

}
