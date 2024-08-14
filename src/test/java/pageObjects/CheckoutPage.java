package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class CheckoutPage {
	
 public WebDriver driver;
 
 public CheckoutPage(WebDriver driver) {
	 this.driver=driver;
 }
	 By cartBag=By.xpath("//img[@alt='Cart']");
	 By CheckoutButton=By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	 By promoBtn=By.cssSelector(".promoBtn");
	 By PlaceOrderButton=By.xpath("//button[contains(text(),'Place Order')]");
	
	public void CheckoutItems(String shortname)
	{
		driver.findElement(cartBag).click();
		driver.findElement(CheckoutButton).click();

	}
	
	public boolean VerifyPromoBtn()
	{
		return driver.findElement(promoBtn).isDisplayed();
	}
	
	public boolean VerifyPlaceorder()
	{
		return driver.findElement(PlaceOrderButton).isDisplayed();
		
		}
	
}



