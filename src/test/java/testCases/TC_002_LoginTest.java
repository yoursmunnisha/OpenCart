package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	
	@Test(groups= {"Sanity", "Master"})
	public void TestLogin() {
    	try {
		logger.info("*** Start TC_002_LoginTest ***");
		
		HomePage homePage= new HomePage(driver);
		homePage.clickOnLogin();
		
		LoginPage loginPage= new LoginPage(driver);
		loginPage.sendEmail(rb.getString("email")); // valid email, get it from config file
		loginPage.sendPassword(rb.getString("password")); //// valid password, get it from config file
		loginPage.clickOnLogin();
		
		AccountPage accountPage= new AccountPage(driver);
		accountPage.EnterPin(rb.getString("securityPin"));
		accountPage.clickOnContinue();
		boolean targetPage= accountPage.isAccountPageExists();
		Assert.assertEquals(targetPage, true, "Invalid login data");
		Thread.sleep(15000);
    	}
    	catch(Exception e) {
    		Assert.fail();
    	}
    	logger.info("*** End Of TC_002_LoginTest");
	}
}
