package RonaldFredrick_Automation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RonaldFredrick_Automation.AbstractComponents.AbstractComponents;

public class Automation_HomePage extends AbstractComponents {

	WebDriver driver;
	String productName;

	public Automation_HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//p[text()='Automation Practice']")
	WebElement Automation_Logo;

	@FindBy(xpath = "//div[text()=' Product Added To Cart ']")
	WebElement successMessage;

	@FindBy(xpath = "//button[contains(text(),'Cart')]/..//button[@class='btn btn-custom']")
	WebElement Cart_Header_Btn;

	@FindBy(xpath = "(//div[contains(@class,'ngx-spinner')]//div)[1]")
	WebElement Spinner;

	@FindBy(xpath = "//button[text()=' HOME ']")
	WebElement Home_link;

	public void addItem_To_CartSection(String productName) {
		Home_link.click();
		waituntilElement(Automation_Logo);
		By itemAddToCart_btn = By.xpath("//b[text()='" + productName + "']/../..//button[text()=' Add To Cart']");
		waituntilElement(Automation_Logo);
		System.out.println(productName);
		if (Automation_Logo.isDisplayed() == true) {
			// System.out.println("second "+productName);
			driver.findElement(itemAddToCart_btn).click();
		}
		waituntilElement(successMessage);
		if (successMessage.isDisplayed() == true) {
			System.out.println("Item Added to cart");
			Cart_Header_Btn.click();
		}

	}

}
