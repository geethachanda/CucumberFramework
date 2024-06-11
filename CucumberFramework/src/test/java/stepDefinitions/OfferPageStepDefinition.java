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
import pageObjects.OfferPage;
import utils.TextContextSetup;

public class OfferPageStepDefinition {
	
	
		String productNameOfferPage;
		TextContextSetup textContextSetup;
		public OfferPageStepDefinition(TextContextSetup textContextSetup ){
			this.textContextSetup= textContextSetup;
		}
		
		@Then("^User searched for same shortname (.+) in offer page to check if product exist$")
		public void user_searched_for_same_shortname_in_offer_page_to_check_if_product_exist(String shortname) throws InterruptedException {
			switchToOfferPage();
			OfferPage offerPage = textContextSetup.pageObjectManager.getOfferPage();
			offerPage.searchProduct(shortname);
			//Thread.sleep(2000);
		    productNameOfferPage= offerPage.getProductName();
		}
		public void switchToOfferPage() {
//			if(textContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers")) {
//				return;
//			}
//			else {
			LandingPage landingPage =textContextSetup.pageObjectManager.getLandingPage();
		    landingPage.selectTopDealsPage();
		    textContextSetup.genericUtils.switchToChildWindow();
			//}
		}
		
		@Then("Validate product in Offers Page matches with Landing Page")
		public void validate_product() {
			Assert.assertEquals(productNameOfferPage, textContextSetup.productNameLandingPage);
		}

	}


