package com.Linkedin.utils;

import java.util.concurrent.TimeUnit;
import java.io.File;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestUtils {
public static WebDriver driver;
public static boolean isBrowserOpened = false;
	@Before
	public void setup() throws Exception{
		if (!isBrowserOpened) {
			if(driver == null){
			driver = new FirefoxDriver();
				Thread.sleep(5000);
			}
		isBrowserOpened = true;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.linkedin.com/");
			}
			
	}
	
	@After
	public void tearDown() throws Exception {
		driver.close();
	}
}
