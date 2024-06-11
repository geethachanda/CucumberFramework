package stepDefinitions;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import pageObjects.LandingPage;
import utils.TextContextSetup;

public class Hooks {
	
	TextContextSetup textContextSetup;
	public Hooks(TextContextSetup textContextSetup ){
		this.textContextSetup= textContextSetup;
	}
	@After
	public void AfterScenario() throws Exception {
		textContextSetup.testBase.WebDriverManager().quit();
	}
	@AfterStep
	public void AddScreenShot(Scenario scenario) throws Exception{
		WebDriver driver =textContextSetup.testBase.WebDriverManager();
		if(scenario.isFailed()) {
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //commons-io dependency added for placing screenshot from one location to another
			byte[] fileContent=FileUtils.readFileToByteArray(src);
			scenario.attach(fileContent, "image/png", "image");//add apache commons.io dependency
			
		}
	}
}
