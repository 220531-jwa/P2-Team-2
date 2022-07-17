package com.sclass.steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sclass.pages.EditBuildPage;
import com.sclass.pages.HomePage;
import com.sclass.pages.LoginPage;
import com.sclass.runners.EditBuildRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class EditBuildStempImpl {
	
	private WebDriver driver = EditBuildRunner.driver;
	private LoginPage loginPage = EditBuildRunner.loginPage;
	private HomePage userPage = EditBuildRunner.userPage;
	private EditBuildPage editBuildPage = EditBuildRunner.editBuildPage;
	
	@Given("They click they click the EditBuild button to create a build")
	public void they_click_they_click_the_edit_build_button_to_create_a_build() {
	new WebDriverWait(driver, Duration.ofSeconds(10)).until
		(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"Edit Build\"]/button")));
	driver.findElement(By.xpath("//*[@id=\"Edit Build\"]/button"));
	}

	@Then("Their modified build is listed in the table")
	public void their_modified_build_is_listed_in_the_table() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
