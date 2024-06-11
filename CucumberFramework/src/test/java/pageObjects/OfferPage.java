package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPage {
		WebDriver driver;
		
		public OfferPage(WebDriver driver) {
			this.driver=driver;
		}
		//by storing xpath in some variable and using that variable in the steps will help in maintenance activities
		//we need not keep changing xpaths everywhere in future in case it changes
		//if we declare the variable example:search as private no other classes can modify your locators only public method from same class can modify
		private By search = By.id("search-field");
		private By productName= By.cssSelector("tr td:nth-child(1)");
		
		public void searchProduct(String name) {
			driver.findElement(search).sendKeys(name);
		}
		
		public String getProductName() {
			return driver.findElement(productName).getText();
		}

	
}
