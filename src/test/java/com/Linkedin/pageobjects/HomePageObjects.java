package com.Linkedin.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.Linkedin.utils.TestUtils;

public class HomePageObjects {
	
private static WebElement element = null;
	
	public static WebElement username(WebDriver driver){
		element = driver.findElement(By.id("login-email"));
		return element;
	}
	
	public static WebElement password(WebDriver driver){
		element = driver.findElement(By.id("login-password"));
		return element;
	}
	
	public static WebElement submit(WebDriver driver){
		element = driver.findElement(By.id("login-submit"));
		return element;
	}
	
	public static WebElement profile(WebDriver driver){
		element = driver.findElement(By.xpath(".//*[@id='nav-settings__dropdown-trigger']"));
		return element;
	}
	
	public static WebElement manage(WebDriver driver){
		element = driver.findElement(By.xpath("//li[@class='nav-dropdown__action']"));
		return element;
	}
	public static WebElement signout(WebDriver driver){
		element = driver.findElement(By.xpath("//a[contains(text()[2],'Sign out')]"));
		return element;
	}
	
	public static WebElement invalidUserName(WebDriver driver){
		element = driver.findElement(By.xpath(".//*[@id='session_key-login-error']"));
		return element;
	}
	
	public static WebElement invalidPassword(WebDriver driver){
		element = driver.findElement(By.xpath(".//*[@id='session_password-login-error']"));
		return element;
	}
	
	public static WebElement forgotPasswordlink(WebDriver driver){
		element = driver.findElement(By.xpath(".//*[@id='layout-main']/div/div[1]/div/form/a"));
		return element;
	}
	
	public static WebElement forgotPasswordInput(WebDriver driver){
		element = driver.findElement(By.id("userName-requestPasswordReset"));
		return element;
	}
	

	public static WebElement forgotPasswordSubmit(WebDriver driver){
		element = driver.findElement(By.id("btnSubmitResetRequest"));
		return element;
	}
	
	public static WebElement EmailSuccess(WebDriver driver){
		element = driver.findElement(By.xpath(".//*[@id='body']/div/h1"));
		return element;
		
	}
	
	public static WebElement ResetInvalidEmail(WebDriver driver){
		element = driver.findElement(By.xpath(".//*[@id='userName-requestPasswordReset-error']"));
		return element;
	}

	public static WebElement forgotPasswordEmailSubmit(WebDriver driver) {
		element = driver.findElement(By.linkText("Submit"));
		return element;
	}
}
