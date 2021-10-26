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
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownTest {
	
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
	@DisplayName("Select dropdown exist test")
	void testToVerifyDropDownExist() {
		WebElement dropdown = driver.findElement(By.id("vehicle"));
		assertEquals(true, dropdown.isDisplayed());
		assertEquals(true, dropdown.isEnabled());
	}
	
	@Test
	@DisplayName("Test first selected option from dropdown")
	void testFirstSelectedOption() throws InterruptedException {
		WebElement dropdown = driver.findElement(By.id("vehicle"));
		//map dropdown to select
		Select select = new Select(dropdown);
		
		//select first value by visible test
		select.selectByVisibleText("Bike");
		//selected option res.
		WebElement selectedRs = select.getFirstSelectedOption();
		assertEquals(" Bike ", selectedRs.getText());
		Thread.sleep(3000);
	}
	
	@Test
	@DisplayName("Test 3rd index selected option from dropdown")
	void test3rdIndexSelectedOption() throws InterruptedException {
		WebElement dropdown = driver.findElement(By.id("vehicle"));
		//map dropdown to select
		Select select = new Select(dropdown);
		
		//select 3rd index
		select.selectByIndex(3);
		//selected option res.
		WebElement selectedRs = select.getFirstSelectedOption();
		assertEquals(" Airplane ", selectedRs.getText());
		Thread.sleep(3000);
	}
	
	
	@Test
	@DisplayName("Test for value selected option from dropdown")
	void testValueSelectedOption() throws InterruptedException {
		WebElement dropdown = driver.findElement(By.id("vehicle"));
		//map dropdown to select
		Select select = new Select(dropdown);
		
		//select 3rd index
		select.selectByValue("car");
		//selected option res.
		WebElement selectedRs = select.getFirstSelectedOption();
		assertEquals(" Car ", selectedRs.getText());
		Thread.sleep(3000);
	}
}
