package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public WebDriver driver;
	
public WebDriver WebDriverManager() throws IOException
{
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\Resources\\global.properties");
	Properties prop=new Properties();
	prop.load(fis);
	String url=prop.getProperty("QAUrl");
	
	
	if(driver==null)
	{
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.setPageLoadStrategy(PageLoadStrategy.NONE);
	//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\Resources\\chromdriver.exe");
	driver=new ChromeDriver(options);
	
	}
		if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			//firefox
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get(url);
	}
	return driver;
}
	
	

}

	