package RonaldFredrick_Automation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	// Username : samicex570@hdrlog.com
	// Password : Password@123

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail")
	WebElement username_TxtField;

	@FindBy(id = "userPassword")
	WebElement pasword_TxtField;

	@FindBy(xpath = "//input[@id='login']")
	WebElement login_Btn;

	@FindBy(xpath = "//div[@aria-label='Incorrect email or password.']")
	WebElement errorMessage;

	public void Login_To_ShoppingApp_Valid(String username, String password) {
		username_TxtField.sendKeys(username);
		pasword_TxtField.sendKeys(password);
		login_Btn.click();

	}

	public boolean Login_To_ShoppingApp_Invalid(String username, String password) throws InterruptedException {
		username_TxtField.sendKeys(username);
		pasword_TxtField.sendKeys(password);
		login_Btn.click();
		Thread.sleep(1000);
		boolean result;
		return result = errorMessage.isDisplayed();

	}

}
