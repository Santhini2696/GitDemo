package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LandingPage {
	
 public WebDriver driver;
 
 public LandingPage(WebDriver driver) {
	 this.driver=driver;
 }
	 By search=By.xpath("//input[@class='search-keyword']");
	 By productName=By.xpath("//h4[contains(text(),'Tomato - 1 Kg')]");
	 By TopDealLink=By.linkText("Top Deals");
	 By increment=By.cssSelector("a.increment");
	 By addtocart=By.xpath("//button[contains(text(),'ADD TO CART')]");
	
	
	public void searchitem(String name)
	{
		driver.findElement(search).sendKeys(name);

	}
	public void IncrementQuantity(int quantity)
	{
		int i=quantity;
		while(i>0)
			
		{
			driver.findElement(increment).click();
			i--;
		}

	}
	
	public void addToCart()
	{
		driver.findElement(addtocart).click();
	}
	
	public String getProductName()
	{
		return driver.findElement(productName).getText();
		
		}
	public void SelectTopDealPage()
	{
		driver.findElement(TopDealLink).click();	
	}
	public String getTitleLandingPage() {
		return driver.getTitle();
		
	}
}



