package com.sclass.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateBuildPage {

	private WebDriver driver;
	
	public CreateBuildPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "nameInput")
	public WebElement nameInput;
	
	public Select motherboardSelector;
	
	public Select cpuSelector;
	
	public Select ramSelector;
	
	@FindBy(id = "hasFourRAMCheckbox")
	public WebElement hasFourRAMCheckBox;
	
	public Select storageSelector;

	public Select psuSelector;
	
	public Select caseSelector;
	
	@FindBy(id = "submit")
	public WebElement submitButton;
	
}
