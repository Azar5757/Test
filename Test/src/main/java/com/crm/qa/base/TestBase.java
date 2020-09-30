package com.crm.qa.base;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.crm.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() throws IOException {
		
		
		try {
			File file = new File("D:\\Azar\\Test\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			FileInputStream fis=new FileInputStream(file);
			Properties pro =new Properties();
			pro.load(fis);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		
		String browsername =prop.getProperty("browser");
		if(browsername.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "D:\\Azar\\SeleniumJava\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else{
			System.out.println("browser not found");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}

}
