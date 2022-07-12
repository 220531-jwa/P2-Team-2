package com.sclass.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sclass.pages.LoginPage;
import com.sclass.runners.LoginRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateAccountStepImpl {

	private WebDriver driver = LoginRunner.driver;
	private LoginPage loginPage = LoginRunner.loginPage;

//	@Given("A User is on the Home page")
//	public void a_user_is_on_the_home_page();
//	{
//		driver.get("http://localhost:8080/home.html");
//	}

	@When("A User types in a new {string} and {string} into the login form and clicks create account button")
	public void a_user_types_in_a_new_and_into_the_login_form_and_clicks_create_account_button(String username,
			String password) {
		loginPage.usernameInput.sendKeys(username);
		loginPage.passwordInput.sendKeys(password);
		loginPage.createAccountButton.click();
	}

//	@Then("The User should receive a success alert")
//	public void the_user_should_receive_a_success_alert() {
//		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
//		assertTrue(driver.findElement(By.id("successAlert")).isDisplayed());
//	}

	@Then("The user gets redirected to their user page")
	public void get_redirected_to_their_user_page() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleContains("Your Account Page"));
		assertEquals("Your Account Page", driver.getTitle());
	}

}
