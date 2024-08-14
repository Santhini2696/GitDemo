package Utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class Testcontextsetup {
	public WebDriver driver;
	public String landingpageproductname;
	public PageObjectManager pageobjectmanager;
	public TestBase testbase;
	public GenericUtils genericUtils;
	public String offerpageproductname;
	
	
	public Testcontextsetup() throws IOException
	{
		testbase=new TestBase();
		 pageobjectmanager=new PageObjectManager(testbase.WebDriverManager());
		 genericUtils=new GenericUtils(testbase.WebDriverManager());
	}
}
