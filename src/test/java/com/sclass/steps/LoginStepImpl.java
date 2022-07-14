package com.sclass.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sclass.pages.LoginPage;
import com.sclass.runners.LoginRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepImpl {

	private WebDriver driver = LoginRunner.driver;
	private LoginPage loginPage = LoginRunner.loginPage;

	@Given("A User is on the Home page")
	public void a_user_is_on_the_home_page() {
		driver.get("http://localhost:8081/loginPage.html");
	}

	@When("A User enters their {string} and {string} in the login form and click the login button")
	public void a_user_enters_their_and_in_the_login_form_and_click_the_login_button(String username, String password) {
		loginPage.usernameInput.sendKeys(username);
		loginPage.passwordInput.sendKeys(password);
		loginPage.loginButton.click();
	}

	@Then("The User should be on their account page")
	public void the_user_should_be_on_their_account_page() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleContains("Your Home Page"));
		assertEquals("Your Home Page", driver.getTitle());
	}

}
