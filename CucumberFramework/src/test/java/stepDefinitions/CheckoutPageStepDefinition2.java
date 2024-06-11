package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TextContextSetup;

public class CheckoutPageStepDefinition2 {
	public CheckoutPage checkoutPage;

	TextContextSetup textContextSetup;
	LandingPage landingPage;
	public CheckoutPageStepDefinition2(TextContextSetup textContextSetup ){
		this.textContextSetup= textContextSetup;
		this.checkoutPage =textContextSetup.pageObjectManager.getcheckoutPage();
		this.landingPage =textContextSetup.pageObjectManager.getLandingPage();
	}
	
	
	@Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout_and_validate_the_items_in_checkout_page(String name) throws InterruptedException {
	   checkoutPage.checkoutItems();
	   Assert.assertTrue(checkoutPage.getProductName().equals(landingPage.getProductName()));
	  Thread.sleep(2000);//we can add explicit wait for this and that is preferrable
	}
	@Then("Verify user has ability to enter promocode and place the order")
	public void verify_user_has_ability_to_enter_promocode_and_place_the_order() {
	 Assert.assertTrue(checkoutPage.verifyPromoButton());
	 Assert.assertTrue(checkoutPage.verifyPlaceOrder());
	   
	}
}
