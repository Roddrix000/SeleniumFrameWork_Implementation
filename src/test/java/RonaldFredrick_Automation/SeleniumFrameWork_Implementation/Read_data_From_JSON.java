package RonaldFredrick_Automation.SeleniumFrameWork_Implementation;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import RonaldFredrick_Automation.PageObjects.Automation_HomePage;
import RonaldFredrick_Automation.PageObjects.LoginPage;
import RonaldFredrick_Automation.PageObjects.MyCartPage;
import RonaldFredrick_Automation.PageObjects.Your_OrdersPage;
import RonaldFredrick_Automation.TestComponent.BaseTest;

public class Read_data_From_JSON extends BaseTest {
	public static String productName;
	public static String countryName = "British Indian Ocean Territory";

	@Test(dataProvider = "getData")
	public void Add_To_Cart_JSON_dataProvider(HashMap<String, String> input) {
		LoginPage lp = new LoginPage(driver);
		lp.Login_To_ShoppingApp_Valid(input.get("email"), input.get("password"));
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
	public Object[][] getData() throws IOException {

		try {
			List<HashMap<String, String>> data = Json_data_reader(System.getProperty("user.dir")
					+ "//src//main//java//RonaldFredrick_Automation_Data//Application_Data.json");

			return new Object[][] { { data.get(0) }, { data.get(1) } };

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;

	}

}
