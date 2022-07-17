package com.sclass.runners;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sclass.pages.CreateBuildPage;
import com.sclass.pages.EditBuildPage;
import com.sclass.pages.HomePage;
import com.sclass.pages.LoginPage;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class EditBuildRunner {
	public static WebDriver driver;
	public static LoginPage loginPage;
	public static HomePage userPage;
	public static EditBuildPage editBuildPage;
	
	@BeforeAll
	public static void setup() {

		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		driver = new ChromeDriver();

		loginPage = new LoginPage(driver);
		userPage = new HomePage(driver);
		editBuildPage = new EditBuildPage(driver);
	}

	@AfterAll
	public static void teardown() {
		driver.quit();
	}
}
