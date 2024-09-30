package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseTest;

public class TC01_AccountRegistration extends BaseTest{
	
	
	@Test
	public void VerifyAccountRegistration ()
	{
		logger.info("***** Starting test - TC01_AccountRegistration ****** ");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("***** Clicked on My Account ****** ");
			hp.clickRegisterLink();
			logger.info("***** Clicked on Register ****** ");
			AccountRegistrationPage arp = new AccountRegistrationPage (driver);
			logger.info("***** Providing user details ****** ");
			arp.enterFirstName(randomString().toUpperCase());
			arp.enterLastName(randomString().toUpperCase());
			String Email = randomString().toUpperCase() + "@gmail.com";
			arp.enterEmail(Email);
			arp.enterTelephone(randomNumber());
			String pwd = randomAlphaNumberic().toString();
			arp.setPassword(pwd);
			arp.confirmPassword(pwd);
			arp.checkPolicy();
			arp.continueButton();
			logger.info("***** User details provided ****** ");
			
			String Actual_message = arp.messageConfirmation();
			logger.info("***** Confirming the message ****** ");
			Assert.assertEquals(Actual_message, "Your Account Has Been Created!", "Account Failed to create");
			
			if(Actual_message.equals("Your Account Has Been Created!"))
					{
				Assert.assertTrue(true);
					}
			else
			{
				logger.error("****Message Not matching, Test Failed");
				logger.debug("This is the debug message");
				Assert.assertTrue(false);
			}
			
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			Assert.fail();
			e.printStackTrace();
		}
		
		
		logger.info("***** Finished test - TC01_AccountRegistration ****** ");
	}
	
	
	

}
