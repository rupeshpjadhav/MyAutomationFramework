package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage 
{

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txt_fname;

	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txt_lname;

	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_email;

	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txt_telephone;

	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_setpassword;

	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txt_confirmpassword;

	@FindBy(xpath="//input[@name='agree']")
	WebElement check_policy;

	@FindBy(xpath="//input[@value='Continue']")
	WebElement btn_continue;

	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement verifymessage;


	public void enterFirstName (String fname)
	{
		txt_fname.sendKeys(fname);
	}

	public void enterLastName (String lname)
	{
		txt_lname.sendKeys(lname);
	}

	public void enterEmail (String email)
	{
		txt_email.sendKeys(email);
	}

	public void enterTelephone (String phone)
	{
		txt_telephone.sendKeys(phone);
	}

	public void setPassword (String password)
	{
		txt_setpassword.sendKeys(password);
	}

	public void confirmPassword (String password)
	{
		txt_confirmpassword.sendKeys(password);
	}

	public void checkPolicy ()
	{
		check_policy.click();
	}

	public void continueButton ()
	{
		btn_continue.click();
	}

	public String messageConfirmation()
	{	
		try {
			return (verifymessage.getText());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return (e.getMessage());
		}
	}
}
