package com.simplilearn.webapp.test.amazon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class AmazonHomepageTest {

	// 1. Formulate a test url
	String siteUrl = "https://www.amazon.in/";
	String driverPath = "drivers/chromedriver";
	WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		// 2. Set selenium system properties
		System.setProperty("webdriver.chrome.driver", driverPath);

		// 3. Instantiate selenium webdriver
		driver = new ChromeDriver();

		// 4. lauch browser
		driver.get(siteUrl);

	}

	@AfterEach
	void tearDown() throws Exception {
		// 6. close driver
		//driver.close();
	}

	@Test
	@DisplayName("Test Amazon Home Page Title")
	void testAmazonHomePageTitle() {
		// 5. perform test
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actualTitle = driver.getTitle();
		assertEquals(expectedTitle, actualTitle);
	}
	
	@Test
	@DisplayName("Test Amazon Home Page source url")
	void testAmazonHomePageSourceURl() {
		assertEquals(siteUrl, driver.getCurrentUrl());
	}

}
