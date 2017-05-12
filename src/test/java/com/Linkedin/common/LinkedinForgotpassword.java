package com.Linkedin.common;

import java.io.FileInputStream;
import java.util.Properties;
import junit.framework.Assert;

import com.Linkedin.pageobjects.HomePageObjects;
import com.Linkedin.utils.ExcelUtils;
import com.Linkedin.utils.TestUtils;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LinkedinForgotpassword extends TestUtils{
	Properties prop= new Properties();



	@Test
	public void testLinkedinForgotPassword() throws Exception {
		try{
			String xl = "./supportFiles/Credentials.xlsx";
			String Sheet = "Sheet1";
			FileInputStream fis=new FileInputStream("./supportFiles/messages.properties");
			prop.load(fis);
			HomePageObjects.forgotPasswordlink(driver).click();
			Assert.assertEquals(prop.getProperty("forgotPageTitle"),driver.getTitle());
			int rowCount = ExcelUtils.getRowCount(xl, Sheet);
			System.out.println("row count:"+rowCount);
			for (int i=1;i<=rowCount;i++)
			{   
				String inputType=ExcelUtils.getCellValue(xl, Sheet, i, 0);
				String UserName=ExcelUtils.getCellValue(xl, Sheet, i, 1);
				HomePageObjects.forgotPasswordInput(driver).sendKeys(UserName);
				boolean isenabled=HomePageObjects.forgotPasswordSubmit(driver).isEnabled();
				Assert.assertEquals(true, isenabled);
				Thread.sleep(3000);
				HomePageObjects.forgotPasswordSubmit(driver).click();
				forgotPasswordValidation(driver,inputType);
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
	private void forgotPasswordValidation(WebDriver driver, String inputType)throws Exception {
		try{

			switch (inputType) {
			case "valid":
				String actualDisplayed = HomePageObjects.EmailSuccess(driver).getText();
				Assert.assertEquals(prop.getProperty("emailSuccess"),actualDisplayed);
				break;

			case "invalid:":
				String actualErrorDisplayed = HomePageObjects.ResetInvalidEmail(driver).getText();
				Assert.assertEquals(prop.getProperty("invalidEmail"),actualErrorDisplayed);
				break;

			default:
				break;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

}
