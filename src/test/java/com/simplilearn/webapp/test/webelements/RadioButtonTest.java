package com.simplilearn.webapp.test.webelements;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonTest {
	
	String siteUrl = "file:///home/wahidkhan74gmai/dell-projects-workspace/phase5-selenium-juni5-test-10-12-2021/static/web-elements.html";
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
	@DisplayName("Radio button One exist test")
	void testRadioButtonExist() {
		WebElement radioButton = driver.findElement(By.id("male"));
		assertEquals(true, radioButton.isDisplayed());
		assertEquals(true, radioButton.isEnabled());
		assertEquals(false, radioButton.isSelected());
	}
	
	@Test
	@DisplayName("Radio button Two exist test")
	void testRadioButton2Exist() {
		WebElement radioButton = driver.findElement(By.id("female"));
		assertEquals(true, radioButton.isDisplayed());
		assertEquals(true, radioButton.isEnabled());
		assertEquals(false, radioButton.isSelected());
	}
	
	@Test
	@DisplayName("Select Radio button One test")
	void testSelectRadioButton1() throws InterruptedException {
		WebElement radioButton = driver.findElement(By.id("male"));
		assertEquals(true, radioButton.isDisplayed());
		assertEquals(true, radioButton.isEnabled());
		assertEquals(false, radioButton.isSelected());
		
		//click on radiobutton
		radioButton.click();
		assertEquals(true, radioButton.isSelected());
		Thread.sleep(3000);
	}
	
	@Test
	@DisplayName("Select Radio button Two test")
	void testSelectRadioButton2() throws InterruptedException {
		WebElement radioButton = driver.findElement(By.id("female"));
		assertEquals(true, radioButton.isDisplayed());
		assertEquals(true, radioButton.isEnabled());
		assertEquals(false, radioButton.isSelected());
		
		//click on radiobutton
		radioButton.click();
		assertEquals(true, radioButton.isSelected());
		Thread.sleep(3000);
	}
	
	// write test for third radio button
}
