package com.sclass.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "usernameInput")
	public WebElement usernameInput;

	@FindBy(id = "passwordInput")
	public WebElement passwordInput;

	@FindBy(id = "loginButton")
	public WebElement loginButton;

	@FindBy(id = "createAccountButton")
	public WebElement createAccountButton;

//	@FindBy(id = "successAlert")
//	public WebElement successMessage;

}
