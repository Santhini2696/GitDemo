package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import pageObjects.OffersPage;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Utils.Testcontextsetup;

public class CheckoutPageStepDefinition {
	public WebDriver driver;
	public String offerpageproductname;
	public String landingpageproductname;
	Testcontextsetup testcontextsetup; 
	public CheckoutPage checkoutPage;
	
	public CheckoutPageStepDefinition(Testcontextsetup testcontextsetup) {
		this.testcontextsetup=testcontextsetup;
		this.checkoutPage=testcontextsetup.pageobjectmanager.getCheckoutpage();
		}
	
	@Then(" Verify user has ability to enter promo code and place the order")
	public void  Verify_user_has_ability_to_enter_promo_code()
	{
		
		Assert.assertTrue(checkoutPage.VerifyPromoBtn());
		Assert.assertTrue(checkoutPage.VerifyPlaceorder());
	}
	
	@Then("^User proceeds to Checkout and Validate the (.+) items in checkout page$")
	public void User_proceeds_to_Checkout(String shortname)
	{
		checkoutPage.CheckoutItems(shortname);
	
	}
	
}
