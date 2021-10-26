package com.simplilearn.webapp.test.external.webelements;

import java.util.Iterator;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserPopupWindowTest {

	String siteUrl = "https://www.amazon.in/";
	String driverPath = "drivers/chromedriver";
	WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(siteUrl);
	}

	@AfterEach
	void tearDown() throws Exception {
		 driver.close();
	}
	
	@Test
	@DisplayName("Amazon Test : Location Popup Verfication")
	void testLocationPopup() throws InterruptedException {
		// find and click location popoup
		driver.findElement(By.id("nav-global-location-popover-link")).click();
		Thread.sleep(3000);
		//swith from main window to popup window
		String mainWindow = driver.getWindowHandle();
		//list of external popups
		Set<String> winodws = driver.getWindowHandles();
		Iterator<String> itr = winodws.iterator();
		while (itr.hasNext()) {
			String childWindow = itr.next();
			// switch to child window
			driver.switchTo().window(childWindow);
			// enter pin location
			driver.findElement(By.id("GLUXZipUpdateInput")).sendKeys("500038");
			// submit location
			driver.findElement(By.cssSelector("#GLUXZipUpdate > span > input")).click();
		}
		driver.switchTo().window(mainWindow);
		Thread.sleep(5000);
	}
}
