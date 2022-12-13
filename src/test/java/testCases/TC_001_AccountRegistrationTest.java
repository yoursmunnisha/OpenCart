package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups= {"Regression", "Master"})
	void test_account_Registration() {
		logger.info("*** Start TC_001_AccountRegistrationTest *** ");
		try {
		HomePage homePage= new HomePage(driver);
		homePage.clickOnRegister();
		
		logger.info("clicked on register link");
		AccountRegistrationPage regPage= new AccountRegistrationPage(driver);
		
		logger.info("send customer data");
		regPage.setUsername(randomString().toUpperCase());
		regPage.setFirstName(randomString().toUpperCase());
		regPage.setLastName(randomString().toUpperCase());
		regPage.setEmail(randomString()+"@gmail.com");
		regPage.selectCountry("99");
		regPage.setPassword(randomAlphaNumeric());
		Thread.sleep(5000);
		
		logger.info("clicked on register button");
		regPage.clickOnRegister();
		
		logger.info("validate success message");
		String confrmMsg=regPage.getConformationMsg();
		Assert.assertEquals(confrmMsg, "Welcome to OpenCart, your account has been created");
		
		logger.info("click on continue");
		regPage.clickOnContinue();
		logger.info("*** End TC_001_AccountRegistrationTest *** ");
		}
		catch(Exception e) {
			logger.error("execution failed");
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
	

}
