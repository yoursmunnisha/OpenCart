package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

	public AccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//p[.='Welcome to OpenCart!']")
	WebElement btnLogin;
	
	@FindBy(name="pin")
	WebElement SecurityPin;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btnContinue;
	
	@FindBy(linkText="LOGOUT")
	WebElement linkLogout;
	
	public boolean isAccountPageExists() {
		try {
			boolean account=btnLogin.isDisplayed();
			return account;
		}
		catch(Exception e) {
			return (false);
		}
	}
	
	public void EnterPin(String pin) {
		SecurityPin.sendKeys(pin);
	}
	
	public void clickOnContinue() {
		btnContinue.click();
	}
	
	public void clickOnLogout() {
		linkLogout.click();
	}

}
