package com.sclass.runners;

import java.io.File;

import org.junit.platform.suite.api.Suite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sclass.pages.HomePage;
import com.sclass.pages.LoginPage;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

@Suite
public class UserFeaturesRunner {

	public static WebDriver driver;
	public static HomePage userPage;
	public static LoginPage loginPage;

	@BeforeAll
	public static void setup() {

		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		driver = new ChromeDriver();

		userPage = new HomePage(driver);
		loginPage = new LoginPage(driver);

	}

	@AfterAll
	public static void teardown() {
		driver.quit();
	}
}
