package com.simplilearn.webapp.test.facebook;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookLoginTest {
	
	String siteUrl = "https://www.facebook.com/";
	String driverPath = "drivers/windows/chromedriver.exe";
	WebDriver driver;
	WebDriverWait wait;
	
	
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		// explicit wait : explicit wait is used to tell the web driver to wait for a certain condition 
		// or maximum time to be exceeded before throwing " Element Not Visible exception".
		wait = new WebDriverWait(driver, 40);
		driver.get(siteUrl);
	}

	@AfterEach
	void tearDown() throws Exception {
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


}
