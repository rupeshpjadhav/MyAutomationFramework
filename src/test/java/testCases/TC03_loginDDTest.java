package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTest;
import utilities.DataProviders;

public class TC03_loginDDTest extends BaseTest{

	@Test (dataProvider = "LoginData", dataProviderClass=DataProviders.class,groups={"Regression","Master"})
	public void testLoginDDT(String email, String pwd, String exp)
	{
		// Valid - Login success - Logout - pass
		// Valid - Login not success - fail
		// InValid - Login success - Logout - fail
		// InValid - Login not success - pass
		try {
			HomePage hp = new HomePage(driver);
			logger.info("****** Starting TC03_loginDDTest *******");
			hp.clickMyAccount();
			logger.info("****** Clicked My Account *******");
			hp.clickLoginLink();
			logger.info("****** Clicked Login *******");

			LoginPage lp = new LoginPage(driver);

			lp.enter_email(email);
			logger.info("****** Entered email *******");
			lp.enter_password(pwd);
			logger.info("****** Entered password *******");
			lp.click_login();

			MyAccountPage ap = new MyAccountPage (driver);
			boolean Status = ap.IsHeadingPresent();
			logger.info("****** Checking heading *******");
			
			if (exp.equalsIgnoreCase("Valid"))
			{
				if (Status==true) {
					logger.info("****** Heading is present *******");
					logger.info("****** Login successful, test passed *******");
					hp.clickMyAccount();
					hp.clickLogoutLink();
					Assert.assertTrue(true);
				}
				else {
					logger.info("****** Heading is not present *******");
					logger.info("****** Login unsuccessful, test failed*******");
					Assert.assertTrue(false);
				}
				
			}
			
			if (exp.equalsIgnoreCase("InValid"))
			{
				if (Status==true) {
					logger.info("****** Heading is present *******");
					logger.info("****** Login successful, but test is failed *******");
					hp.clickMyAccount();
					hp.clickLogoutLink();
					Assert.assertTrue(false);
				}
				else {
					logger.info("****** Heading is not present *******");
					logger.info("****** Login unsuccessful as expected, hence test passed *******");
					Assert.assertTrue(true);
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Assert.fail();
		}


		
		logger.info("****** Finished TC03_loginDDTest *******");
	}
}
