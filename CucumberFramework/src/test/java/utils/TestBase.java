package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public WebDriver driver;
	public WebDriver WebDriverManager() throws Exception {
		  File src=new File("./src/test/resources/global.properties");
  		FileInputStream fis=new FileInputStream(src);
  		Properties prop = new Properties();
  		prop.load(fis);
  		String url=prop.getProperty("QAUrl");
  		String browser_properties = prop.getProperty("browser");
  		String browser_maven = System.getProperty("browser");
  		String browser = browser_maven!=null? browser_maven : browser_properties;
		if(driver==null){
			
				switch(browser.toLowerCase()){
				case "chrome":
					driver = new ChromeDriver();
					break;
				case "edge":
					driver = new EdgeDriver();
					break;
				case "firefox":
					driver = new FirefoxDriver();
					break;
				default:
					driver = new ChromeDriver();
					break;
					
				}
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
		driver.get(url);
		}
		return driver;
	}

}
