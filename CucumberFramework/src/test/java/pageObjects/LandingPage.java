package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.TextContextSetup;

public class LandingPage {
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}
	//by storing xpath in some variable and using that variable in the steps will help in maintenance activities
	//we need not keep changing xpaths everywhere in future in case it changes
	By search = By.xpath("//input[@type='search']");
	By productName= By.cssSelector("h4.product-name");
	By topDeals= By.linkText("Top Deals");
	By increment = By.className("quantity");
	By addtocart= By.xpath("//button[contains(text(),'ADD TO CART')]");
	
     
	public void searchProduct(String name) {
		driver.findElement(search).sendKeys(name);
	}


	public String getProductName() {
		return driver.findElement(productName).getText();
	}

	public void selectTopDealsPage() {
		driver.findElement(topDeals).click();
	}
	public String getTitleLandingPage()
	{
		return driver.getTitle();
	}
	
	public void incrementItems(String number) throws InterruptedException {
		driver.findElement(increment).clear();
		driver.findElement(increment).sendKeys("3");
		Thread.sleep(2000);

	}
	public void addToCart() {
		driver.findElement(addtocart).click();
	}
	
	
	
}
