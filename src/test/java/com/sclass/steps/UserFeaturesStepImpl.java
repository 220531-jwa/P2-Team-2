package com.sclass.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sclass.pages.LoginPage;
import com.sclass.pages.HomePage;
import com.sclass.runners.LoginRunner;
import com.sclass.runners.UserFeaturesRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserFeaturesStepImpl {

	private WebDriver driver = UserFeaturesRunner.driver;
	private HomePage userPage = UserFeaturesRunner.userPage;
	private LoginPage loginPage = LoginRunner.loginPage;

	@Given("A User is logged in")
	public void a_user_is_logged_in(String username, String password) {
		driver.get("http://localhost:8081/loginPage.html");
		loginPage.usernameInput.sendKeys(username);
		loginPage.passwordInput.sendKeys(password);
		loginPage.loginButton.click();
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleContains("Your Home Page"));
	}

//	@Given("A User is on their UserPage")
//	public void a_user_is_on_their_user_page() {
//		assertEquals(driver.getCurrentUrl(), "http://localhost:8080/userPage.html");
//	}

	@When("They click they click the CreateBuild button")
	public void they_click_they_click_the_create_build_button() {
		userPage.createBuild.click();
	}

	@Then("They are redirected to the CreateBuild Page")
	public void they_are_redirected_to_the_create_build_page() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleContains("Create a Build"));
		assertEquals("Create a Build", driver.getTitle());
	}

	@When("They click they click the EditBuild button")
	public void they_click_they_click_the_edit_build_button() {
		userPage.editBuild.click();
	}

	@Then("They are redirected to the EditBuild Page")
	public void they_are_redirected_to_the_edit_build_page() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleContains("Edit a Build"));
		assertEquals("Edit a Build", driver.getTitle());
	}

//	@When("They click they click the CompletedBuilds button")
//	public void they_click_they_click_the_completed_builds_button() {
//		userPage.completedBuilds.click();
//	}
//
//	@Then("They are redirected to the CompletedBuilds Page")
//	public void they_are_redirected_to_the_completed_builds_page() {
//		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleContains("Completed Builds"));
//		assertEquals("Completed Builds", driver.getTitle());
//	}

	@When("They click they click the PartSearch button")
	public void they_click_they_click_the_part_search_button() {
		userPage.partSearch.click();
	}

	@Then("They are redirected to the PartSearch Page")
	public void they_are_redirected_to_the_part_search_page() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleContains("Search for Parts"));
		assertEquals("Search for Parts", driver.getTitle());
	}

}
