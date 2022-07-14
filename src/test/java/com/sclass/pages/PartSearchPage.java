package com.sclass.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PartSearchPage {

	private WebDriver driver;

	public PartSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "priceFloorInput")
	public WebElement priceFloorInput;

	@FindBy(id = "priceCeilingInput")
	public WebElement priceCeilingInput;

	@FindBy(id = "searchButton")
	public WebElement searchButton;

	@FindBy(id = "resultTable")
	public WebElement resultTable;

//	@FindBy(id = "partTypeSelector")
//	public Select partTypeSelector;

}
