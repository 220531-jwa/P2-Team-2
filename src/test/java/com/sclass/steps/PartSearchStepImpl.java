package com.sclass.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sclass.pages.PartSearchPage;
import com.sclass.runners.PartSearchRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PartSearchStepImpl {

	private WebDriver driver = PartSearchRunner.driver;
//	private LoginPage loginPage = PartSearchRunner.loginPage;
//	private UserPage userPage = PartSearchRunner.userPage;
//	private CreateBuildPage createBuildPage = PartSearchRunner.createBuildPage;
	private PartSearchPage partSearchPage = PartSearchRunner.partSearchPage;

	@Given("A Visitor is on the Part Search page")
	public void a_visitor_is_on_the_part_search_page() {
		driver.get("http://localhost:8081/partSearch.html");
	}

	@When("A Visitor selects {string} from the selection dropdown")
	public void a_visitor_selects_from_the_selection_dropdown(String partType) {
		partSearchPage.partTypeSelector = new Select(driver.findElement(By.id(partType)));
	}

	@When("A Visitor enters a bottom-limit cash value into {string}")
	public void a_visitor_enters_a_bottom_limit_cash_value_into(String priceFloor) {
		partSearchPage.priceFloorInput.sendKeys(priceFloor);
	}

	@When("A Visitor enters a top-limit cash value into {string}")
	public void a_visitor_enters_a_top_limit_cash_value_into(String priceCeiling) {
		partSearchPage.priceCeilingInput.sendKeys(priceCeiling);
	}

	@When("A Visitor clicks the PartSearchButton")
	public void a_visitor_clicks_the_part_search_button() {
		partSearchPage.searchButton.click();
	}

	@Then("A relevant table of results should populate the page")
	public void a_relevant_table_of_results_should_populate_the_page() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfNestedElementLocatedBy(
				partSearchPage.resultTable, By.xpath("//table[@id='resultTable']/tbody/tr")));
		WebElement getRows = driver.findElement(By.xpath("//table[@id='resultTable']/tbody"));
		List<WebElement> TotalRowsList = getRows.findElements(By.tagName("tr"));
		assertTrue(TotalRowsList.size() > 0);
	}

}
