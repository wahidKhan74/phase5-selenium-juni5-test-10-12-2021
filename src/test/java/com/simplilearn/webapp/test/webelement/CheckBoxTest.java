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

public class CheckBoxTest {

	String siteUrl = "C:\\Users\\HOME\\Desktop\\Siimplilearn\\FS-workpsace\\phase5-selenium-juni5-test-10-12-2021\\static\\web-element.html";
	String driverPath = "drivers/windows/chromedriver.exe";
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
	@DisplayName("Test To Verify Check Box One Exist")
	void testToVerifyCheckBoxOneExist() throws InterruptedException {
		WebElement checkBox1 = driver.findElement(By.id("vehicle1"));
		assertEquals(true, checkBox1.isDisplayed());
		assertEquals(true, checkBox1.isEnabled());
		assertEquals(false, checkBox1.isSelected());
		Thread.sleep(5000);
	}

	@Test
	@DisplayName("Test To Verify Check Box Two Exist")
	void testToVerifyCheckBoxTwoExist() throws InterruptedException {
		WebElement checkBox2 = driver.findElement(By.id("vehicle2"));
		assertEquals(true, checkBox2.isDisplayed());
		assertEquals(true, checkBox2.isEnabled());
		assertEquals(true, checkBox2.isSelected());
		Thread.sleep(5000);
	}
	
	@Test
	@DisplayName("Test To Select Check Box One :: vehicle1 ")
	void testToSelectCheckBoxOne() throws InterruptedException {
		WebElement checkBox = driver.findElement(By.id("vehicle1"));
		assertEquals(true, checkBox.isDisplayed());
		assertEquals(true, checkBox.isEnabled());
		assertEquals(false, checkBox.isSelected());
		//select a Check Box
		checkBox.click();
		Thread.sleep(5000);
		assertEquals(true, checkBox.isSelected());
	}
	
	@Test
	@DisplayName("Test To Deselect Check Box Two")
	void testToSelectCheckBoxTwo() throws InterruptedException {
		WebElement checkBox = driver.findElement(By.id("vehicle2"));
		assertEquals(true, checkBox.isDisplayed());
		assertEquals(true, checkBox.isEnabled());
		assertEquals(true, checkBox.isSelected());
		//deselect a Check Box
		checkBox.click();
		Thread.sleep(5000);
		assertEquals(false, checkBox.isSelected());
	}

}