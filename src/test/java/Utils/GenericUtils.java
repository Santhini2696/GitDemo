package Utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	public WebDriver driver;
	
	public GenericUtils(WebDriver driver) {
		this.driver=driver;
		
	}
public void SwitchWindowToChild()
{
	Set<String> s1=driver.getWindowHandles();
	Iterator<String> li=s1.iterator();
	String parentwindow=li.next();
	String childwindow=li.next();
	driver.switchTo().window(childwindow);
}

}
