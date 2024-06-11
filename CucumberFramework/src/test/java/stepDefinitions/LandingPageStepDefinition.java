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
import pageObjects.LandingPage;
import utils.TextContextSetup;

public class LandingPageStepDefinition {

	TextContextSetup textContextSetup;
	LandingPage landingPage;
	public LandingPageStepDefinition(TextContextSetup textContextSetup ){
		this.textContextSetup= textContextSetup;
		this.landingPage =textContextSetup.pageObjectManager.getLandingPage();
	}
	
	@Given("User is on Greenkart landing page")
	public void user_is_on_greenkart_landing_page() {
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
  
	}
	@When("^User searched with shortname (.+) and extracted the actual name of the product$")
	public void user_searched_with_shortname_and_extracted_the_actual_name_of_the_product(String shortname) throws InterruptedException {
		landingPage.searchProduct(shortname);
		Thread.sleep(2000);
		textContextSetup.productNameLandingPage = landingPage.getProductName().split("-")[0].trim();
		System.out.println(textContextSetup.productNameLandingPage);
	}
	@When("Added {string} items of the selected product to cart")
	public void added_items_of_the_selected_product_to_cart(String number) throws InterruptedException {
	  landingPage.incrementItems(number);
	  landingPage.addToCart();
	}
}
