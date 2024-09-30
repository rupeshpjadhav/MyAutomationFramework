package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTest;

public class TC02_loginTest extends BaseTest{

	@Test
	public void testLogin()
	{
		HomePage hp = new HomePage(driver);
		logger.info("****** Starting TC02_loginTest *******");
		hp.clickMyAccount();
		logger.info("****** Clicked My Account *******");
		hp.clickLoginLink();
		logger.info("****** Clicked Login *******");

		LoginPage lp = new LoginPage(driver);

		lp.enter_email(p.getProperty("email"));
		logger.info("****** Entered email *******");
		lp.enter_password(p.getProperty("password"));
		logger.info("****** Entered password *******");
		lp.click_login();

		MyAccountPage ap = new MyAccountPage (driver);
		boolean Status = ap.IsHeadingPresent();
		logger.info("****** Checking heading *******");
		
		if (Status==true) {
			logger.info("****** Heading is present *******");
			logger.info("****** Login successful *******");
			hp.clickMyAccount();
			hp.clickLogoutLink();
			Assert.assertTrue(true);
		}
		else {
			logger.info("****** Heading is not present *******");
			logger.info("****** Login unsuccessful *******");
			Assert.assertTrue(false);
		}

		
		logger.info("****** Finished TC02_loginTest *******");
	}
}
