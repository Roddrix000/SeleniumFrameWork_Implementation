package RonaldFredrick_Automation.stepDefinitions;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import RonaldFredrick_Automation.PageObjects.Automation_HomePage;
import RonaldFredrick_Automation.PageObjects.LoginPage;
import RonaldFredrick_Automation.PageObjects.MyCartPage;
import RonaldFredrick_Automation.PageObjects.Your_OrdersPage;
import RonaldFredrick_Automation.TestComponent.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseTest {

	@Given("I landed on Ecommerce")
	public void I_landed_on_Ecommerce() throws IOException {
		initializeDriver();
	}

	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String username, String password) {
		LoginPage lg = new LoginPage(driver);
		lg.Login_To_ShoppingApp_Valid(username, password);
	}

	@When("^I add product (.+) to cart$")
	public void I_add_product_to_cart(String productName) {
		System.out.println(productName);
		Automation_HomePage hp = new Automation_HomePage(driver);
		hp.addItem_To_CartSection(productName);
	}

	@And("^checkout (.+) and submit the order$")
	public void checkout_and_submit_the_order(String country) {
		MyCartPage mcp = new MyCartPage(driver);
		mcp.CheckOutPayment_process(country);
	}

	@And("^checkout (.+) and submit and delete the order$")
	public void checkout_and_submit_the_order_andDelete(String country) {
		MyCartPage mcp = new MyCartPage(driver);
		mcp.CheckOutPayment_process(country);
		Your_OrdersPage yop = new Your_OrdersPage(driver);
		yop.delete_product();
	}

	@Then("{string} is displayed on confirmation")
	public void message_is_displayed_on_confirmation(String string) {
		WebElement ThankYouMessage = driver.findElement(By.xpath("//h1[contains(text(),' Thankyou for the order. ')]"));
		if (ThankYouMessage.isDisplayed() == true) {
			System.out.println("Successfully Placed The order");
		}
		driver.quit();
	}

	@Then("{string} is displayed on orderPage")
	public void errorMessage_is_displayed_on_orderPage(String string) {
		WebElement DeleteMessage = driver.findElement(By.xpath("//div[text()=' Orders Deleted Successfully ']"));
		if (DeleteMessage.isDisplayed() == true) {
			System.out.println("Successfully Placed The order");
		}
		driver.quit();
	}
}
