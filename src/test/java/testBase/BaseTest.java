package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	//All reusable and common methods to be added in this class, and this will be extended by all the test cases class 
	
public WebDriver driver;
public Logger logger;
public Properties p;
	
	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os, String browser) throws IOException
	{
		logger=LogManager.getLogger(this.getClass());  //lOG4J2
		
		FileReader f = new FileReader("./src//test//resources//config.properties");
		p =new Properties ();
		p.load(f);
		
		switch (browser.toLowerCase())
		{
		case "chrome" : driver = new ChromeDriver(); break;
		case "edge" : driver = new EdgeDriver(); break;
		case "firefox": driver = new FirefoxDriver(); break;
		default: System.out.println("Invalid browser"); return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL")); 
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	// To create random strings and random numbers
	public String randomString()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(6);
		return generatedstring;
	}
	
	public String randomNumber()
	{
		String generatednumber=RandomStringUtils.randomNumeric(6);
		return generatednumber;
	}
	
	public String randomAlphaNumberic()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(3);
		String generatednumber=RandomStringUtils.randomNumeric(3);
		return (generatedstring+"@"+"&"+generatednumber+"*");
	}

}