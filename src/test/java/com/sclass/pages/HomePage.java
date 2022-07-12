package com.sclass.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "createBuild")
	public WebElement createBuild;

	@FindBy(id = "editBuild")
	public WebElement editBuild;

	@FindBy(id = "completedBuilds")
	public WebElement completedBuilds;

	@FindBy(id = "partSearch")
	public WebElement partSearch;
	
	@FindBy(id = "logout")
	public WebElement logout;

}
