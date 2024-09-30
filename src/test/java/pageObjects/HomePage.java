package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
 @FindBy(xpath="//span[normalize-space()='My Account']")
 WebElement MyAccLink;
 
 @FindBy(xpath="//a[normalize-space()='Register']")
 WebElement RegLink;
 
 @FindBy(xpath="//a[normalize-space()='Login']")
 WebElement LoginLink;
 
 @FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")
 WebElement LogoutLink;
 
 public void clickMyAccount()
 {
	 MyAccLink.click();
 }

 public void clickRegisterLink() 
 {
	 RegLink.click();
 }
 
 public void clickLoginLink()
 {
	 LoginLink.click();
 }
	
 public void clickLogoutLink()
 {
	 LogoutLink.click();
 }
}
