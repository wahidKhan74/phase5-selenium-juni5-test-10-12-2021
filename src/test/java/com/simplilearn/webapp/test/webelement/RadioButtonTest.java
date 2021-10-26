package com.simplilearn.webapp.test.webelement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RadioButtonTest {

	String siteUrl = "C:\\Users\\HOME\\Desktop\\Siimplilearn\\FS-workpsace\\phase5-selenium-juni5-test-10-12-2021\\static\\web-element.html";
	String driverPath = "drivers/windows/chromedriver.exe";
	WebDriver driver;
	WebDriverWait wait;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		// explicit wait : explicit wait is used to tell the web driver to wait for a
		// certain condition
		// or maximum time to be exceeded before throwing " Element Not Visible
		// exception".
		wait = new WebDriverWait(driver, 40);
		driver.get(siteUrl);
	}

	@AfterEach
	void tearDown() throws Exception {
		 driver.close();
	}

	@Test
	@DisplayName("Test To Verify Radio Button One Exist")
	void testToVerifyRadioButtonOneExist() throws InterruptedException {
		WebElement radioButton1 = driver.findElement(By.id("male"));
		assertEquals(true, radioButton1.isDisplayed());
		assertEquals(true, radioButton1.isEnabled());
		assertEquals(false, radioButton1.isSelected());
		Thread.sleep(5000);
	}

	@Test
	@DisplayName("Test To Verify Radio Button Two Exist")
	void testToVerifyRadioButtonTwoExist() throws InterruptedException {
		WebElement radioButton2 = driver.findElement(By.id("female"));
		assertEquals(true, radioButton2.isDisplayed());
		assertEquals(true, radioButton2.isEnabled());
		assertEquals(false, radioButton2.isSelected());
		Thread.sleep(5000);
	}
	
	@Test
	@DisplayName("Test To Select Radio Button One")
	void testToSelectRadioButtonOne() throws InterruptedException {
		WebElement radioButton = driver.findElement(By.id("male"));
		assertEquals(true, radioButton.isDisplayed());
		assertEquals(true, radioButton.isEnabled());
		assertEquals(false, radioButton.isSelected());
		//select a radio button
		radioButton.click();
		Thread.sleep(5000);
		assertEquals(true, radioButton.isSelected());
	}
	
	@Test
	@DisplayName("Test To Select Radio Button Two")
	void testToSelectRadioButtonTwo() throws InterruptedException {
		WebElement radioButton = driver.findElement(By.id("female"));
		assertEquals(true, radioButton.isDisplayed());
		assertEquals(true, radioButton.isEnabled());
		assertEquals(false, radioButton.isSelected());
		//select a radio button
		radioButton.click();
		Thread.sleep(5000);
		assertEquals(true, radioButton.isSelected());
	}

}