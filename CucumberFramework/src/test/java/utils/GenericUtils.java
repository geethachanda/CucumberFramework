package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	WebDriver driver;
	public GenericUtils(WebDriver driver) {
		this.driver =driver;
	}
	
	public void switchToChildWindow() {
		Set<String> windowIds=driver.getWindowHandles();
		Iterator<String> itr =windowIds.iterator();
		String parentWindow =itr.next();
		String childWindow =itr.next();
        driver.switchTo().window(childWindow);
	}

}
