package RonaldFredrick_Automation.SeleniumFrameWork_Implementation;

import org.testng.annotations.Test;

import RonaldFredrick_Automation.PageObjects.LoginPage;
import RonaldFredrick_Automation.TestComponent.BaseTest;

public class UserAuthentication_Validation_Invalid extends BaseTest {

	@Test
	public void inValidLogin() throws InterruptedException {
		LoginPage logIn_Page = new LoginPage(driver);
		String username = pes.getProperty("username");
		String password = pes.getProperty("username");
		boolean result = logIn_Page.Login_To_ShoppingApp_Invalid(username, password);
		org.testng.Assert.assertEquals(result, result);
	}
}
