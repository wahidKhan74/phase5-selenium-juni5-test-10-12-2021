package com.simplilearn.webapp.test.screenshot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TakeBrowserWindowScreenTest {
	
	String siteUrl = "https://www.facebook.com/";
	String driverPath = "drivers/chromedriver";
	WebDriver driver;
	WebDriverWait wait;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 40);
		driver.get(siteUrl);
	}

	@AfterEach
	void tearDown() throws Exception {
		 driver.close();
	}
	
	@Test
	void testHomePageScreeShot() throws IOException {
		// type cast driver object to take screen shot object 
		TakesScreenshot tsc = (TakesScreenshot) driver;
		// take screen shot as file
		File src = tsc.getScreenshotAs(OutputType.FILE);
		// copy file scr to a path
		FileHandler.copy(src, new File("/home/wahidkhan74gmai/upload/facebook-homepage.png"));
		
	}
	
	@Test
	@DisplayName("Facebook Login Test  : Invalid Creds")
	void testLogin() throws IOException {
		driver.findElement(By.cssSelector("#email")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("abc@123");
		driver.findElement(By.name("login")).submit();
		
		takeScreeShot("facebook-data-entry.png");
		
		WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#error_box > div.fsl.fwb.fcb")));
		assertEquals("Wrong Credentials", errorMsg.getText());
		
		WebElement errorMsg2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"error_box\"]/div[2]")));
		assertEquals("Invalid username or password", errorMsg2.getText());
		
		takeScreeShot("facebook-invalid-creds.png");
		
	}

	@Test
	@DisplayName("Test Facebook login for fields 'Displayed' verification")
	void testLoginFieldsDisplayed() throws IOException {
		//find email field
		WebElement emailInput = driver.findElement(By.id("email"));
		WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
		WebElement submitButton = driver.findElement(By.name("login"));
		
		assertTrue(emailInput.isDisplayed());
		assertTrue(passwordInput.isDisplayed());
		assertTrue(submitButton.isDisplayed());
		takeScreeShot("facebook-data-fields.png");
	}
	
	private void takeScreeShot(String filename) throws IOException {
		// type cast driver object to take screen shot object 
		TakesScreenshot tsc = (TakesScreenshot) driver;
		// take screen shot as file
		File src = tsc.getScreenshotAs(OutputType.FILE);
		// copy file scr to a path
		FileHandler.copy(src, new File("/home/wahidkhan74gmai/upload/"+filename));
		
	}

}
