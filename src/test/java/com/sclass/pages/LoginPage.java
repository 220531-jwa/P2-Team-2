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

	@FindBy(id = "username")
	public WebElement usernameInput;

	@FindBy(id = "password")
	public WebElement passwordInput;

	@FindBy(xpath = "/location/of/loginbutton")
	public WebElement loginButton;

	@FindBy(xpath = "/location/of/createbutton")
	public WebElement createAccountButton;

}
