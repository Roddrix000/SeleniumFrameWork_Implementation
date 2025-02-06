package RonaldFredrick_Automation.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RonaldFredrick_Automation.AbstractComponents.AbstractComponents;

public class MyCartPage extends AbstractComponents {

	WebDriver driver;
	String countryName;

	public MyCartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div//h1[text()='My Cart']")
	WebElement MyCart_txt;

	@FindBy(xpath = "//button[text()='Continue Shopping']")
	WebElement ContinueShopping_Btn;

	@FindBy(xpath = "//div[@class='cartSection']//h3")
	List<WebElement> ItemNames;

	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement CheckOut;

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement selectCountry_TxtBx;

	@FindBy(xpath = "//a[text()='Place Order ']")
	WebElement PlaceOrder_btn;

	@FindBy(xpath = "//h1[contains(text(),' Thankyou for the order. ')]")
	WebElement ThankYouMessage;

	@FindBy(xpath = "//h1[contains(text(),' Thankyou for the order. ')]/../../following-sibling::tr[@class='ng-star-inserted']//label")
	List<WebElement> Products_Id;

	@FindBy(xpath = "//button[contains(text(),'ORDERS')]/..//button[@class='btn btn-custom']")
	WebElement Orders_link;

	public void CheckOutPayment_process(String countryName) {

		waituntilElement(MyCart_txt);
		if (MyCart_txt.isDisplayed() == true) {
			CheckOut.click();
		}
		selectCountry_TxtBx.click();
		By CountryList = By.xpath("//section[@class='ta-results list-group ng-star-inserted']//span[contains(text(),'"
				+ countryName + "')]");
		selectCountry_TxtBx.sendKeys(countryName);
		try {
			Thread.sleep(1000);
			driver.findElement(CountryList).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PlaceOrder_btn.click();
		waituntilElement(ThankYouMessage);
		if (ThankYouMessage.isDisplayed() == true) {
			System.out.println("Successfully Placed The order");
		}
	}

}
