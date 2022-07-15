package com.sclass.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sclass.pages.CreateBuildPage;
import com.sclass.pages.HomePage;
import com.sclass.pages.LoginPage;
import com.sclass.runners.CreateBuildRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateBuildStepImpl {

	private WebDriver driver = CreateBuildRunner.driver;
	private LoginPage loginPage = CreateBuildRunner.loginPage;
	private HomePage userPage = CreateBuildRunner.userPage;
	private CreateBuildPage createBuildPage = CreateBuildRunner.createBuildPage;

	@Given("A User is logs in to their account")
	public void a_user_is_logs_in_to_their_account() {
		driver.get("http://localhost:8081/loginPage.html");
		loginPage.usernameInput.sendKeys("elle");
		loginPage.passwordInput.sendKeys("pass");
		loginPage.loginButton.click();
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleContains("Your Home Page"));
	}

	@Given("They click they click the CreateBuild button to create a build")
	public void they_click_they_click_the_create_build_button_to_create_a_build() {
		userPage.createBuild.click();
	}

	@When("A User click the Motherboard Selector")
	public void a_user_click_the_motherboard_selector() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleContains("Create New Build"));
		createBuildPage.motherboardSelector = new Select(driver.findElement(By.id("motherboardSelector")));
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(
				ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//*[@id='motherboardSelector']/*"), 1));
		createBuildPage.motherboardSelector.selectByIndex(1);
	}

	@Then("The User should be able to pick a Motherboard")
	public void the_user_should_be_able_to_pick_a_motherboard() {
		assertEquals("AMD 4-Slot Mobo", createBuildPage.motherboardSelector.getFirstSelectedOption().getText());

	}

	@When("A User click the CPU Selector")
	public void a_user_click_the_cpu_selector() {
		createBuildPage.cpuSelector = new Select(driver.findElement(By.id("cpuSelector")));
		createBuildPage.cpuSelector.selectByIndex(1);
	}

	@Then("The User should be able to pick a CPU")
	public void the_user_should_be_able_to_pick_a_cpu() {
		assertEquals("AMD CPU", createBuildPage.cpuSelector.getFirstSelectedOption().getText());

	}

	@When("A User click the RAM Selector")
	public void a_user_click_the_ram_selector() {
		createBuildPage.ramSelector = new Select(driver.findElement(By.id("ramSelector")));
		createBuildPage.ramSelector.selectByIndex(1);
	}

	@Then("The User should be able to pick a RAM")
	public void the_user_should_be_able_to_pick_a_ram() {
		assertEquals("Generic RAM", createBuildPage.ramSelector.getFirstSelectedOption().getText());
	}

	@When("A User click the Storage Selector")
	public void a_user_click_the_storage_selector() {
		createBuildPage.storageSelector = new Select(driver.findElement(By.id("storageSelector")));
		createBuildPage.storageSelector.selectByIndex(1);
	}

	@Then("The User should be able to pick a Storage")
	public void the_user_should_be_able_to_pick_a_storage() {
		assertEquals("Generic Storage", createBuildPage.storageSelector.getFirstSelectedOption().getText());
	}

	@When("A User click the PowerSupply Selector")
	public void a_user_click_the_power_supply_selector() {
		createBuildPage.psuSelector = new Select(driver.findElement(By.id("psuSelector")));
		createBuildPage.psuSelector.selectByIndex(1);
	}

	@Then("The User should be able to pick a PowerSupply")
	public void the_user_should_be_able_to_pick_a_power_supply() {
		assertEquals("High Power Supply - 1000W", createBuildPage.psuSelector.getFirstSelectedOption().getText());
	}

	@When("A User click the Case Selector")
	public void a_user_click_the_case_selector() {
		createBuildPage.caseSelector = new Select(driver.findElement(By.id("caseSelector")));
		createBuildPage.caseSelector.selectByIndex(1);
	}

	@Then("The User should be able to pick a Case")
	public void the_user_should_be_able_to_pick_a_case() {
		assertEquals("Generic Case", createBuildPage.caseSelector.getFirstSelectedOption().getText());
	}

	@When("A User fills in the build name")
	public void a_user_fills_in_the_build_name() {
		createBuildPage.nameInput.sendKeys("Create Build Test");
	}

	@When("A User clicks on submit build")
	public void a_user_clicks_on_submit_build() {
		createBuildPage.submitButton.click();
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleContains("Your Home Page"));
	}

	@Then("They are redirected back to their home page")
	public void they_are_redirected_back_to_their_home_page() {
		assertEquals("Your Home Page", driver.getTitle());
	}

	@Then("Their new build is listed in the table")
	public void their_new_build_is_listed_in_the_table() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
				.numberOfElementsToBeMoreThan(By.xpath("//*[@id='buildTable']/tbody/tr[last()]/*"), 1));

		List<WebElement> lastTR = driver.findElements(By.xpath("//*[@id='buildTable']/tbody/tr[last()]/*"));

		assertEquals("Create Build Test", lastTR.get(1).getText());
		assertEquals("AMD 4-Slot Mobo", lastTR.get(2).getText());
		assertEquals("AMD CPU", lastTR.get(3).getText());
		assertEquals("Generic RAMx2", lastTR.get(4).getText());
		assertEquals("Generic Storage", lastTR.get(5).getText());
		assertEquals("High Power Supply", lastTR.get(6).getText());
		assertEquals("Generic Case", lastTR.get(7).getText());
	}
}
