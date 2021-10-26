package com.simplilearn.webapp.test.facebook;

<<<<<<< HEAD
import org.junit.jupiter.api.AfterEach;
=======
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
>>>>>>> 342be0fee1d14497c738d4a4945fab72c6432296
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

<<<<<<< HEAD
import static org.junit.jupiter.api.Assertions.*;

public class FacebookLoginTest {
	
	String siteUrl = "https://www.facebook.com/";
	String driverPath = "drivers/chromedriver";
	WebDriver driver;
	WebDriverWait wait;
	
=======
public class FacebookLoginTest {
	
	String siteUrl = "https://www.facebook.com/";
	String driverPath = "drivers/windows/chromedriver.exe";
	WebDriver driver;
	WebDriverWait wait;
	
	
>>>>>>> 342be0fee1d14497c738d4a4945fab72c6432296
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		// explicit wait : explicit wait is used to tell the web driver to wait for a certain condition 
<<<<<<< HEAD
		// or maximum time to be exceeded before throwing " Element Not Visible exception"
=======
		// or maximum time to be exceeded before throwing " Element Not Visible exception".
>>>>>>> 342be0fee1d14497c738d4a4945fab72c6432296
		wait = new WebDriverWait(driver, 40);
		driver.get(siteUrl);
	}

	@AfterEach
	void tearDown() throws Exception {
<<<<<<< HEAD
		 driver.close();
	}
	
	@Test
	@DisplayName("Facebook Login Test  : Invalid Creds")
	void testLogin() {
		driver.findElement(By.cssSelector("#email")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("abc@123");
		driver.findElement(By.name("login")).submit();
		
		WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#error_box > div.fsl.fwb.fcb")));
		assertEquals("Wrong Credentials", errorMsg.getText());
		
		WebElement errorMsg2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"error_box\"]/div[2]")));
		assertEquals("Invalid username or password", errorMsg2.getText());
	}
=======
		  driver.close();
	}

	@Test
	@DisplayName("Test Facebook login for fields 'Displayed' verification")
	void testLoginFieldsDisplayed() {
		//find email field
		WebElement emailInput = driver.findElement(By.id("email"));
		WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
		WebElement submitButton = driver.findElement(By.name("login"));
		
		assertTrue(emailInput.isDisplayed());
		assertTrue(passwordInput.isDisplayed());
		assertTrue(submitButton.isDisplayed());
		
	}
	
	@Test
	@DisplayName("Test Facebook login for fields 'Enabled' verification")
	void testLoginFieldsEnable() {
		//find email field
		WebElement emailInput = driver.findElement(By.id("email"));
		WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
		WebElement submitButton = driver.findElement(By.name("login"));
		
		assertTrue(emailInput.isEnabled());
		assertTrue(passwordInput.isEnabled());
		assertTrue(submitButton.isEnabled());
		
	}
	
	@Test
	@DisplayName("Test Facebook login for Invalid credntials")
	void testLoginInvalidCreds() {
		//find email field
		WebElement emailInput = driver.findElement(By.id("email"));
		WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
		WebElement submitButton = driver.findElement(By.name("login"));
		
		emailInput.sendKeys("abc@gmail.com");
		passwordInput.sendKeys("password");
		submitButton.submit();
		
		WebElement errorElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#error_box > div.fsl.fwb.fcb")));
		Assertions.assertEquals("You can't log in at the moment", errorElem.getText());
	}


>>>>>>> 342be0fee1d14497c738d4a4945fab72c6432296
}
