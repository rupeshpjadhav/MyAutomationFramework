package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (xpath = "//input[@id='input-email']") WebElement txt_inputemail;
	
	@FindBy (xpath = "//input[@id='input-password']") WebElement txt_inputpwd;

	@FindBy (xpath="//input[@value='Login']") WebElement btn_login;
	
	public void enter_email(String uname) {
		txt_inputemail.sendKeys(uname);
	}
	
	public void enter_password(String pwd) {
		txt_inputpwd.sendKeys(pwd);
	}
	
	public void click_login() {
		btn_login.click();
	}
}
