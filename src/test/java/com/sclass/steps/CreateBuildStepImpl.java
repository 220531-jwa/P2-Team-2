package com.sclass.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sclass.pages.CreateBuildPage;
import com.sclass.pages.HomePage;
import com.sclass.runners.CreateBuildRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateBuildStepImpl {

	private WebDriver driver = CreateBuildRunner.driver;
//	private LoginPage loginPage = CreateBuildRunner.loginPage;
	private HomePage userPage = CreateBuildRunner.userPage;
	private CreateBuildPage createBuildPage = CreateBuildRunner.createBuildPage;

//	@Given("A User is logged in")
//	public void a_user_is_logged_in() {
//		driver.get("http://localhost:8080/home.html");
//		loginPage.usernameInput.sendKeys("username"); //TODO: change these values
//		loginPage.passwordInput.sendKeys("password");
//		loginPage.loginButton.click();
//		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleContains("Your Home Page"));
//		//		assertEquals("Your Home Page", driver.getTitle());
//	}

	@Given("on the Create Build Page")
	public void on_the_create_build_page() {
		System.out.println("Breadcrumbs");
		userPage.createBuild.click();
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleContains("Create New Build"));
		// assertEquals("Create a Build", driver.getTitle());

	}

	@When("A User click the Motherboard Selector")
	public void a_user_click_the_motherboard_selector() {
		createBuildPage.motherboardSelector = new Select(driver.findElement(By.id("Motherboard")));
		createBuildPage.motherboardSelector.selectByIndex(1);
	}

	@Then("The User should be able to pick a motherboard")
	public void the_user_should_be_able_to_pick_a_motherboard() {

		assertEquals("0", createBuildPage.motherboardSelector.getFirstSelectedOption().getText());
	}

	@When("A User click the CPU Selector")
	public void a_user_click_the_cpu_selector() {
		createBuildPage.cpuSelector = new Select(driver.findElement(By.id("CPU")));
		createBuildPage.cpuSelector.selectByIndex(1);
	}

	@Then("The User should be able to pick a CPU")
	public void the_user_should_be_able_to_pick_a_cpu() {

		assertEquals("0", createBuildPage.cpuSelector.getFirstSelectedOption().getText());
	}

	@When("A User click the RAM Selector")
	public void a_user_click_the_ram_selector() {
		createBuildPage.ramSelector = new Select(driver.findElement(By.id("RAM")));
		createBuildPage.ramSelector.selectByIndex(1);
	}

	@Then("The User should be able to pick a RAM")
	public void the_user_should_be_able_to_pick_a_ram() {

		assertEquals("0", createBuildPage.ramSelector.getFirstSelectedOption().getText());

	}

	@When("A User click the Storage Selector")
	public void a_user_click_the_storage_selector() {
		createBuildPage.storageSelector = new Select(driver.findElement(By.id("Storage")));
		createBuildPage.storageSelector.selectByIndex(1);
	}

	@Then("The User should be able to pick a Storage")
	public void the_user_should_be_able_to_pick_a_storage() {
		assertEquals("0", createBuildPage.storageSelector.getFirstSelectedOption().getText());
	}

	@When("A User click the PowerSupply Selector")
	public void a_user_click_the_power_supply_selector() {
		createBuildPage.psuSelector = new Select(driver.findElement(By.id("PSU")));
		createBuildPage.psuSelector.selectByIndex(1);
	}

	@Then("The User should be able to pick a PowerSupply")
	public void the_user_should_be_able_to_pick_a_power_supply() {
		assertEquals("0", createBuildPage.psuSelector.getFirstSelectedOption().getText());
	}

	@When("A User click the Case Selector")
	public void a_user_click_the_case_selector() {
		createBuildPage.caseSelector = new Select(driver.findElement(By.id("Case")));
		createBuildPage.caseSelector.selectByIndex(1);
	}

	@Then("The User should be able to pick a Case")
	public void the_user_should_be_able_to_pick_a_case() {
		assertEquals("0", createBuildPage.caseSelector.getFirstSelectedOption().getText());
	}

}
