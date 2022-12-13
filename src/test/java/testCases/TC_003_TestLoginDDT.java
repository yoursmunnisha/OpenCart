package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_TestLoginDDT extends BaseClass {
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void Tesr_loginDDT(String Email, String Password, String ExpResult) {
		try {
			logger.info("*** Start TC_003_TestLoginDDT ***");
			
			HomePage homePage= new HomePage(driver);
			homePage.clickOnLogin();
			
			LoginPage loginPage= new LoginPage(driver);
			loginPage.sendEmail(Email); 
			loginPage.sendPassword(Password); 
			loginPage.clickOnLogin();
			
			AccountPage accountPage= new AccountPage(driver);
			accountPage.EnterPin(rb.getString("securityPin"));
			accountPage.clickOnContinue();
			boolean targetPage= accountPage.isAccountPageExists();
		
			Thread.sleep(15000);
			if(ExpResult.equals("Valid")) {
				if(targetPage==true) {
					accountPage.clickOnLogout();
					Assert.assertTrue(true); //valid Data, Test Pass
				}
				else {
					Assert.assertTrue(false);//Invalid Data, Test Fail
				}
				
			}
			if(ExpResult.equals("Invalid")) {
				if(targetPage==true) {
					accountPage.clickOnLogout();
					Assert.assertTrue(false); //Invalid Data, Test pass
				}
				else {
					Assert.assertTrue(false);//Invalid Data, Test Fail
				}
			}
	    	}
	    	catch(Exception e) {
	    		Assert.fail();
	    	}
	    	logger.info("*** End Of TC_003_TestLoginDDT ***");
		}

}
