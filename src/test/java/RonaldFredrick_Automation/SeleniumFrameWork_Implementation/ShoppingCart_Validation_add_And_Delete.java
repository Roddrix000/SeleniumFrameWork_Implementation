package RonaldFredrick_Automation.SeleniumFrameWork_Implementation;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import RonaldFredrick_Automation.PageObjects.Automation_HomePage;
import RonaldFredrick_Automation.PageObjects.LoginPage;
import RonaldFredrick_Automation.PageObjects.MyCartPage;
import RonaldFredrick_Automation.PageObjects.Your_OrdersPage;
import RonaldFredrick_Automation.TestComponent.BaseTest;

public class ShoppingCart_Validation_add_And_Delete extends BaseTest {

	// public static String productName;
	public static String countryName = "British Indian Ocean Territory";

	@Test(dataProvider = "getData")
	public void Add_and_Delete_Product_From_Cart(HashMap<String, String> input) throws InterruptedException {

		// Login to Application
		LoginPage lp = new LoginPage(driver);
		lp.Login_To_ShoppingApp_Valid(input.get("username"), input.get("password"));
		// verifying and Deleting Pre_Existing product
		Your_OrdersPage yop = new Your_OrdersPage(driver);
		yop.delete_existing_item();
		// Adding product to cart
		Automation_HomePage hp = new Automation_HomePage(driver);
		// productName = pes.getProperty("productName");
		hp.addItem_To_CartSection(input.get("productName"));
		// My cart Flow
		MyCartPage mcp = new MyCartPage(driver);
		countryName = pes.getProperty("countryName");
		mcp.CheckOutPayment_process(countryName);
		// Your Order
		yop.delete_product();
	}

	@DataProvider
	public Object[][] getData() {
		HashMap<String, String> m1 = new HashMap<String, String>();
		m1.put("username", "anshika@gmail.com");
		m1.put("password", "Iamking@000");
		m1.put("productName", "qwerty");
		HashMap<String, String> m2 = new HashMap<String, String>();
		m2.put("username", "samicex570@hdrlog.com");
		m2.put("password", "Password@123");
		m2.put("productName", "Banarsi Saree");

		return new Object[][] { { m1 }, { m2 } };
	}

}
