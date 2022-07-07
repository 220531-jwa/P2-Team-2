package com.sclass.steps;

import org.openqa.selenium.WebDriver;

import com.sclass.runners.CreateAccountRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateAccountStepImpl {

	private WebDriver driver = CreateAccountRunner.driver;
	//TODO: pom
	
	@Given("a User is on the Create Account page")
	public void a_user_is_on_the_create_account_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the User types in a new {string} into the")
	public void the_user_types_in_a_new_into_the(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the User types in a new {string}")
	public void the_user_types_in_a_new(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("The User should receive a success message")
	public void the_user_should_receive_a_success_message() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("then be redirected to their user page.")
	public void then_be_redirected_to_their_user_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
}
