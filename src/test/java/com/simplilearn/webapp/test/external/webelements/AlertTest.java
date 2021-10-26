package com.simplilearn.webapp.test.external.webelements;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

public class AlertTest {

	String siteUrl = "file:///home/wahidkhan74gmai/dell-projects-workspace/phase5-selenium-juni5-test-10-12-2021/static/alert-web-elements.html";
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
	@DisplayName("Alert Test :  simple  alert window ")
	void testAlertDailogWindow() throws InterruptedException {
		driver.findElement(By.cssSelector("body > p:nth-child(2) > button")).click();
		
		//switch to sub window
		Alert alert = driver.switchTo().alert();
		assertEquals("Do you really want to proceed ??", alert.getText());		
		Thread.sleep(3000);
		alert.accept();
	}
	
	@Test
	@DisplayName("Confirm Test :  confirmation  alert window with accept")
	void testConfirmDailogWindow() throws InterruptedException {
		//find and open confirm
		driver.findElement(By.cssSelector("body > p:nth-child(4) > button")).click();
		
		//switch to sub window
		Alert confirmAlert = driver.switchTo().alert();
		assertEquals("Please confirm the action is right ??", confirmAlert.getText());		
		Thread.sleep(3000);
		// confirmation with ok button click
		confirmAlert.accept();
	}
	
	@Test
	@DisplayName("Confirm Test :  confirmation  alert window with cancel")
	void testConfirmDailogWindowCancel() throws InterruptedException {
		//find and open confirm
		driver.findElement(By.cssSelector("body > p:nth-child(4) > button")).click();
		
		//switch to sub window
		Alert confirmAlert = driver.switchTo().alert();
		assertEquals("Please confirm the action is right ??", confirmAlert.getText());		
		Thread.sleep(3000);
		// confirmation with cancel button click
		confirmAlert.dismiss();
	}
	
	@Test
	@DisplayName("Prompt Test :  Prompt alert window with accept")
	void testPromptDailogWindow() throws InterruptedException {
		//find and open confirm
		driver.findElement(By.cssSelector("body > p:nth-child(6) > button")).click();
		
		//switch to sub window
		Alert prompt = driver.switchTo().alert();
		assertEquals("Please enter your name", prompt.getText());		
		Thread.sleep(3000);
		// prompt with ok button click
		prompt.accept();
	}
	
	
}
