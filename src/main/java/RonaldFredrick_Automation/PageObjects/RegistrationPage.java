package RonaldFredrick_Automation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RonaldFredrick_Automation.AbstractComponents.AbstractComponents;
import dev.failsafe.internal.util.Assert;

public class RegistrationPage extends AbstractComponents {

	WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "firstName")
	WebElement firstName_Txtbox;

	@FindBy(id = "lastName")
	WebElement lastName_Txtbox;

	@FindBy(id = "userEmail")
	WebElement email_Txtbox;

	@FindBy(id = "userMobile")
	WebElement mobile_Txtbox;

	@FindBy(xpath = "//select[contains(@class,'custom-select')]")
	WebElement occupation_dropDown;

	@FindBy(xpath = "//span[text()='Male']//preceding-sibling::input[@value='Male']")
	WebElement gender_RadioBtn;

	@FindBy(id = "userPassword")
	WebElement userPassword_TxtBox;

	@FindBy(id = "confirmPassword")
	WebElement confirmPassword_TxtBox;

	@FindBy(xpath = "//div[text()=' I am 18 year or Older ']//preceding-sibling::div/child::input")
	WebElement age_Confim;

	@FindBy(xpath = "//input[@id='login']")
	WebElement register_Btn;

	@FindBy(xpath = "//a[text()='Register here']")
	WebElement registerHere_btn;

	@FindBy(xpath = "//div//h1[text()='Account Created Successfully']")
	WebElement successMessage;

	public boolean registration_to_ShoppingApp() {
		registerHere_btn.click();
		waituntilElement(firstName_Txtbox);
		firstName_Txtbox.sendKeys((String) genData("fname"));
		lastName_Txtbox.sendKeys((String) genData("lname"));
		email_Txtbox.sendKeys((String) genData("fname") + "@gmail.com");
		mobile_Txtbox.sendKeys((String) genData("mob"));
		// Select Occupatio
		selectElement(occupation_dropDown, "Student");
		gender_RadioBtn.click();
		userPassword_TxtBox.sendKeys("Pass1@99999");
		confirmPassword_TxtBox.sendKeys("Pass1@99999");
		age_Confim.click();
		register_Btn.click();
		waituntilElement(successMessage);
		return successMessage.isDisplayed();

	}

}
