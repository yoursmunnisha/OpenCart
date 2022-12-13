package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends HomePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="input-email")
	WebElement txtEmail;  
	
	@FindBy(id="input-password")
	WebElement txtPassword;
	
	@FindBy(xpath="//button[@type='submit'][1]")
	WebElement btnLogin;
	
	public void sendEmail(String Email) {
		txtEmail.sendKeys(Email);
	}
	
	public void sendPassword(String Password) {
		txtPassword.sendKeys(Password);
	}
	
	public void clickOnLogin() {
		btnLogin.click();
	}
	

}
