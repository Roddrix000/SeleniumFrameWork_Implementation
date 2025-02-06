package RonaldFredrick_Automation.SeleniumFrameWork_Implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import RonaldFredrick_Automation.PageObjects.Automation_HomePage;
import RonaldFredrick_Automation.PageObjects.LoginPage;
import RonaldFredrick_Automation.PageObjects.MyCartPage;
import RonaldFredrick_Automation.PageObjects.Your_OrdersPage;
import RonaldFredrick_Automation.TestComponent.BaseTest;

public class ShoppingCart_Validation_Add_to_Cart extends BaseTest {

	public static String productName;
	public static String countryName = "British Indian Ocean Territory";

	@Test(dataProvider = "getData")
	public void Add_productTo_cart(String username, String password) throws InterruptedException {
		// Login to Application
		LoginPage lp = new LoginPage(driver);
		lp.Login_To_ShoppingApp_Valid(username, password);
		// verifying and Deleting Pre_Existing product
		Your_OrdersPage yop = new Your_OrdersPage(driver);
		// Adding product to cart
		Automation_HomePage hp = new Automation_HomePage(driver);
		productName = pes.getProperty("productName");
		hp.addItem_To_CartSection(productName);
		// My cart Flow
		MyCartPage mcp = new MyCartPage(driver);
		countryName = pes.getProperty("countryName");
		mcp.CheckOutPayment_process(countryName);
	}

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { { "anshika@gmail.com", "Iamking@000" }, { "samicex570@hdrlog.com", "Password@123" } };

	}

}
