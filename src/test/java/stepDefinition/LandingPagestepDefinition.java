package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OffersPage;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utils.Testcontextsetup;

public class LandingPagestepDefinition {
	public WebDriver driver;
	public String offerpageproductname;
	public String landingpageproductname;
	Testcontextsetup testcontextsetup; 
	LandingPage landingPage;
	
	public LandingPagestepDefinition(Testcontextsetup testcontextsetup) {
		this.testcontextsetup=testcontextsetup;
		this.landingPage=testcontextsetup.pageobjectmanager.getLandingPage();
		
		}
	
	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page()  {
		landingPage.getTitleLandingPage();
	//Assert.assertTrue(landingPage.getTitleLandingPage().contains("Greenkart"));
	
	
	}
	@When("^user searched with Shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortname) {
		landingPage.searchitem(shortname);
		//testcontextsetup.driver.findElement(By.xpath("//input[@class='search-keyword']")).sendKeys(shortname);
		testcontextsetup.landingpageproductname = landingPage.getProductName().split("-")[0].trim();
	    System.out.println(testcontextsetup.landingpageproductname + " is extracted productname in the home page");
	    System.out.println("Completed");
	}
	@When("Added {string} items of the selected product to cart")
	public void Added_items_of_the_selected_product_to_cart(String quantity) {
	landingPage.IncrementQuantity(Integer.parseInt(quantity));	
	landingPage.addToCart();

	}
	
}
