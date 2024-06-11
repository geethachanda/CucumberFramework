package test.runner;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//reports=Inbuilt cucumber options->html, xml, junit, json. Third Party Plugin-> Extent

@CucumberOptions(features="@target/failed_scenarios.txt", glue="stepDefinitions", monochrome=true, 
plugin= {"pretty" ,"json:target\\Cucumber-Reports\\Cucumber.json", 
		"html:target\\Cucumber-Reports\\report.html",
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})


public class FailedTestRunner extends AbstractTestNGCucumberTests {
	
	//to run parallely super denotes parent class AbstractTestNGCucumberTests and scenarios is method of that parent class that helps you to run pparallely
	//by calling scenarios method from parent class and setting the parallel attribute to true we can run tests parallely
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios(){
		return super.scenarios();
	}

}
