package com.Linkedin.common;

import java.io.FileInputStream;
import java.util.Properties;

import junit.framework.Assert;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Linkedin.utils.TestUtils;
import com.Linkedin.utils.ExcelUtils;
import com.Linkedin.pageobjects.*;

public class LinkedinLogin extends TestUtils{
	public WebDriverWait wait;
	Properties prop= new Properties();

	@Test
	public void testLinkedinLogin() throws Exception {
		try{
			String xl = "./supportFiles/Credentials.xlsx";
			String Sheet = "Sheet1";
			int rowCount = ExcelUtils.getRowCount(xl, Sheet);
			System.out.println("row count:"+rowCount);
			for (int i=1;i<=rowCount;i++)
			{   
				String inputType=ExcelUtils.getCellValue(xl, Sheet, i, 0);
				String UserName=ExcelUtils.getCellValue(xl, Sheet, i, 1);
				String Password=ExcelUtils.getCellValue(xl, Sheet, i, 2);
				HomePageObjects.username(driver).sendKeys(UserName);
				HomePageObjects.password(driver).sendKeys(Password);
				HomePageObjects.submit(driver).click();
				loginValidation(driver,inputType);
			
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
/**
 * 
 * @param driver
 * @param inputType
 * @throws Exception
 */
	private void loginValidation(WebDriver driver, String inputType)throws Exception {
		try{
			FileInputStream fis=new FileInputStream("./supportFiles/messages.properties");
			prop.load(fis);
			switch (inputType) {
			case "valid":
				Actions act= new Actions(driver);
				act.moveToElement(HomePageObjects.profile(driver)).click().perform();
				Thread.sleep(3000);
				act.moveToElement(HomePageObjects.manage(driver)).perform();
				act.moveToElement(HomePageObjects.signout(driver)).click().perform();
				break;
				
			case "invalid:":
				wait.until(ExpectedConditions.titleIs("Sign In to LinkedIn"));
				Assert.assertEquals(prop.getProperty("invalidUsername"), HomePageObjects.invalidUserName(driver).getText());
				Assert.assertEquals(prop.getProperty("invalidPassword"), HomePageObjects.invalidPassword(driver).getText());
				
				break;
				
			default:
				break;
			}
			Thread.sleep(4000);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		
	}


}
