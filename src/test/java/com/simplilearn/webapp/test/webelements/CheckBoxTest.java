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

public class CheckBoxTest {
	
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
	@DisplayName("Check Box One exist test")
	void testcheckBoxExist() {
		WebElement checkBox = driver.findElement(By.id("vehicle1"));
		assertEquals(true, checkBox.isDisplayed());
		assertEquals(true, checkBox.isEnabled());
		assertEquals(false, checkBox.isSelected());
	}
	
	@Test
	@DisplayName("Check Box Two exist test")
	void testcheckBox2Exist() {
		WebElement checkBox = driver.findElement(By.id("vehicle2"));
		assertEquals(true, checkBox.isDisplayed());
		assertEquals(true, checkBox.isEnabled());
		
		//default select
		assertEquals(true, checkBox.isSelected());
	}
	
	@Test
	@DisplayName("Select Check Box One test")
	void testSelectcheckBox1() throws InterruptedException {
		WebElement checkBox = driver.findElement(By.id("vehicle1"));
		assertEquals(true, checkBox.isDisplayed());
		assertEquals(true, checkBox.isEnabled());
		assertEquals(false, checkBox.isSelected());
		
		//click on checkBox
		checkBox.click();
		assertEquals(true, checkBox.isSelected());
		Thread.sleep(3000);
	}
	
	@Test
	@DisplayName("De Select Check Box Two test")
	void testSelectcheckBox2() throws InterruptedException {
		WebElement checkBox = driver.findElement(By.id("vehicle2"));
		assertEquals(true, checkBox.isDisplayed());
		assertEquals(true, checkBox.isEnabled());
		assertEquals(true, checkBox.isSelected());
		
		//click on checkBox for select
		checkBox.click();
		assertEquals(false, checkBox.isSelected());
		Thread.sleep(3000);
	}
	
	// write test for third Check Box
}
