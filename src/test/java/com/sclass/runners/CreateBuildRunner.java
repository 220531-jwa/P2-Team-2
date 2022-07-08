package com.sclass.runners;

import java.io.File;

import org.junit.platform.suite.api.Suite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sclass.pages.CreateBuildPage;
import com.sclass.pages.LoginPage;
import com.sclass.pages.UserPage;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

@Suite
public class CreateBuildRunner {

	public static WebDriver driver;
	public static LoginPage loginPage;
	public static UserPage userPage;
	public static CreateBuildPage createBuildPage;


	@BeforeAll
	public static void setup() {

		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		driver = new ChromeDriver();

		loginPage = new LoginPage(driver);
	}

	@AfterAll
	public static void teardown() {
		driver.quit();
	}
	
}
