package com.simplilearn.webapp.test.timeouts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitTimeOutTest {
	
	String siteUrl = "https://www.amazon.in/";
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
	@DisplayName("Amazon Test : Mobile Link Verfication")
	void testMobileNavLink() {
		// normal way find mobile link
		// WebElement mobileLink = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(2)"));
		// conditional explicit wait based finding web element
		WebElement mobileLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#nav-xshop > a:nth-child(2)")));
		
		assertEquals(true, mobileLink.isDisplayed());
		assertEquals(true, mobileLink.isEnabled());
		// perform a click
		mobileLink.click();
		// evaluate test
		String expected ="Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in";
		String actual = driver.getTitle();
		assertEquals(expected, actual);
	}
	

	@Test
	@DisplayName("Amazon Test : Fashion Link Verfication")
	void testFashionNavLink() {
		// find mobile link
		// WebElement fashionLink = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(5)"));
		
		WebElement fashionLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#nav-xshop > a:nth-child(5)")));
		assertEquals(true, fashionLink.isDisplayed());
		assertEquals(true, fashionLink.isEnabled());
		// perform a click
		fashionLink.click();
		// evaluate test
		String expected ="Amazon Fashion: Clothing, Footwear and Accessories online for Men, Women and Kids";
		String actual = driver.getTitle();
		assertEquals(expected, actual);
	}

}
