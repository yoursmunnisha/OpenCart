package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//WebElement
	@FindBy(xpath="//div/a/span[.='My Account']")
	WebElement ElementMyLink;
	
	@FindBy(linkText="REGISTER")
	WebElement linkRegister;
	
	@FindBy(linkText="LOGIN")
	WebElement linkLogin;
	
	//Action
	public void clickOnMyLink() {
		ElementMyLink.click();
	}
	public void clickOnRegister() {
		linkRegister.click();
	}
	public void clickOnLogin() {
		linkLogin.click();
	}

}
