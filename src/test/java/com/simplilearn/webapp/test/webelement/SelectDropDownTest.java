package com.simplilearn.webapp.test.webelement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectDropDownTest {
	

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
	@DisplayName("Test Select Drop Downn Exist")
	void testSelectDropDownnExist() throws InterruptedException {
		WebElement dropdown = driver.findElement(By.id("vehicle"));
		assertEquals(true, dropdown.isDisplayed());
		assertEquals(true, dropdown.isEnabled());
		Thread.sleep(5000);
	}
	
	
	@Test
	@DisplayName("Test Default Select Option :: Bike ::")
	void testSelectDefaultOption() throws InterruptedException {
		WebElement dropdown = driver.findElement(By.id("vehicle"));
		Select select = new Select(dropdown);
		
		// select bike as first selected option
		select.selectByVisibleText("Bike");
		
		//get selected option
		WebElement selectedOpt = select.getFirstSelectedOption();
		
		assertEquals("Bike", selectedOpt.getText());
		
		Thread.sleep(5000);
	}
	
	
	@Test
	@DisplayName("Test Select Option :: Car ::")
	void testSelectCarOption() throws InterruptedException {
		WebElement dropdown = driver.findElement(By.id("vehicle"));
		Select select = new Select(dropdown);
		
		// select car as first selected option
		// select.selectByVisibleText("Car");
		 select.selectByIndex(1);
		
		//get selected option
		WebElement selectedOpt = select.getFirstSelectedOption();
		
		assertEquals("Car", selectedOpt.getText());
		
		Thread.sleep(5000);
	}
	
	
	@Test
	@DisplayName("Test Select Option :: Train ::")
	void testSelectTrainOption() throws InterruptedException {
		WebElement dropdown = driver.findElement(By.id("vehicle"));
		Select select = new Select(dropdown);
		
		// select car as first selected option
		// select.selectByVisibleText("Train");
		// select.selectByIndex(3);
		
		 select.selectByValue("train");
		
		//get selected option
		WebElement selectedOpt = select.getFirstSelectedOption();
		
		assertEquals("Train", selectedOpt.getText());
		
		Thread.sleep(5000);
	}
}
