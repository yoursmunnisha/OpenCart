package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="input-username")
	WebElement txtUserName;
	
	@FindBy(id="input-firstname")
	WebElement txtfirstName;
	
	@FindBy(id="input-lastname")
	WebElement txtLastName;
	
	@FindBy(id="input-email")
	WebElement txtEmail;
	
	@FindBy(id="input-country")
	WebElement CountyDropdown;    
	
	@FindBy(id="input-password")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement privacyBox;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btnContinue;
	
	@FindBy(xpath="//div[@id='button-register']/button[1]")
	WebElement btnRegister;
	
	@FindBy(xpath="//div[@id='register']//h3[.='Welcome to OpenCart, your account has been created']")
	WebElement msgConfirmation;
	
	@FindBy(linkText="CONTINUE")
	WebElement linkContinue;
	
	public void setUsername(String userName) {
		txtUserName.sendKeys(userName);
	}
	
	public void setFirstName(String fname) {
		txtfirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String Email) {
		txtEmail.sendKeys(Email);
	}
	
	public void selectCountry(String countryVal) {
		Select country= new Select(CountyDropdown);
		country.selectByValue(countryVal);
	}
	
	public void setPassword(String Password) {
		txtPassword.sendKeys(Password);
	}
	
	public void selectPrivacyCheckBox() {
		privacyBox.click();
	}
	public void clickOnRegister() {
		btnRegister.click();
	}
	
	public String getConformationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch(Exception e) {
			return (e.getMessage());
		}
	}
	
	public void clickOnContinue() {
		linkContinue.click();
	}

}
