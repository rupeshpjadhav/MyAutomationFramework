package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BasePage {

	WebDriver driver;
	//creating a constructor to take the driver from child and initiate the driver. 
	//This class will be extended by all the page object classes
	//Child class will create a constructor which will pass the driver to this basepage constructor 
	public BasePage (WebDriver driver)
	{
		this.driver = driver;	
		PageFactory.initElements(driver,this);
		
	}
	
}