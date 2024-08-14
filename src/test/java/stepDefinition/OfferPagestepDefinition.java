package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Utils.Testcontextsetup;
public class OfferPagestepDefinition {
	public WebDriver driver;
	public String offerpageproductname;
	public String landingpageproductname;
	Testcontextsetup testcontextsetup;
	PageObjectManager pageobjectmanager;
	private OffersPage OffersPage;
	
	
	public OfferPagestepDefinition(Testcontextsetup testcontextsetup) {
		this.testcontextsetup=testcontextsetup;
		this.OffersPage=testcontextsetup.pageobjectmanager.getOfferpagePage();
		}
	
	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_shortname_in_offers_page(String shortname) {
		SwitchToOffersPage();
		OffersPage offerspage=testcontextsetup.pageobjectmanager.getOfferpagePage();
		OffersPage.searchitem(shortname);
	offerpageproductname=OffersPage.getProductName();
	
		
	}
	
	
	public void SwitchToOffersPage()
	{
		//if already switched to offer page >> skip below part
		//if (testcontextsetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"))
		LandingPage landingPage=testcontextsetup.pageobjectmanager.getLandingPage();
	    landingPage.SelectTopDealPage();
		testcontextsetup.genericUtils.SwitchWindowToChild();
		//explict wait, parse string
	}
	@Then("validate product name in offers page matches with Landing Page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
	    Assert.assertEquals(offerpageproductname,testcontextsetup.landingpageproductname);

	}

}
