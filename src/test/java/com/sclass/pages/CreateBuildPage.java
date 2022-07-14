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
	
//	@FineBy(id="newBuild")
//	public WebElement newBuildButton
	
//	@FindBy(id="CPU")
//	public WebElement cpuElement;
//	public Select cpuSelector = new Select(cpuElement);
//	public Select getCPUSelector() {
//		return new Select(cpuElement);
//	}
	
	
	public Select cpuSelector;
	
	public Select motherboardSelector;
	
	public Select ramSelector;
	
	public Select storageSelector;
	
	public Select caseSelector;
	
	public Select psuSelector;
	
	@FindBy(id = "submit")
	public WebElement submitButton;
	
//	@FindBy(id="Motherboard")
//	public WebElement motherboardElement;
//	public Select getMotherboardSelector() {
//		return new Select(motherboardElement);
//	}
//	
//	@FindBy(id="RAM")
//	public WebElement ramElement;
//	public Select getRAMSelector() {
//		return new Select(ramElement);
//	}
//	
//	@FindBy(id="Storage")
//	public WebElement storageElement;
//	public Select getStorageSelector() {
//		return new Select(storageElement);
//	}
//	
//	@FindBy(id="Case")
//	public WebElement caseElement;
//	public Select getCaseSelector() {
//		return new Select(caseElement);
//	}
//	
//	@FindBy(id="PowerSupply")
//	public WebElement powerSupplyElement;
//	public Select getPowerSupplySelector() {
//		return new Select(powerSupplyElement);
//	}
//	
	
}
