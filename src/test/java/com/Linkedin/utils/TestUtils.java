package com.Linkedin.utils;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestUtils {
	public static WebDriver driver;
	public static boolean isBrowserOpened = false;
	public static String baseUrl="https://www.linkedin.com/";
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
			driver.get(baseUrl);
		}

	}

	@After
	public  void tearDown() throws Exception {
		System.out.println("Testing Done");
	}
}
