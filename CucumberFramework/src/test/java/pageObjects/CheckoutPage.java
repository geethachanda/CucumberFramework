package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.TextContextSetup;

public class CheckoutPage {
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
	}
	//by storing xpath in some variable and using that variable in the steps will help in maintenance activities
	//we need not keep changing xpaths everywhere in future in case it changes
	
	By cartBag = By.cssSelector("[alt='Cart']");
	By promoButton= By.cssSelector(".promoBtn");
	By placeOrder= By.xpath("//button[contains(text(),'Place Order')]");
	By productName= By.cssSelector("p.product-name");
	By checkOutButton= By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	
	public void checkoutItems() {
		driver.findElement(cartBag).click();
		driver.findElement(checkOutButton).click();
	}
	public Boolean verifyPromoButton() {
	return	driver.findElement(promoButton).isDisplayed();
}
	
	public Boolean verifyPlaceOrder() {
		return	driver.findElement(placeOrder).isDisplayed();
	}
	public String getProductName() {
		return	driver.findElement(productName).getText();
	}
}
