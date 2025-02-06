package RonaldFredrick_Automation.SeleniumFrameWork_Implementation;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import RonaldFredrick_Automation.AbstractComponents.AbstractComponents;
import RonaldFredrick_Automation.PageObjects.LoginPage;
import RonaldFredrick_Automation.TestComponent.BaseTest;
import dev.failsafe.internal.util.Assert;

public class UserAuthentication_Validation_Valid extends BaseTest {

	@Test(dataProvider = "getData", groups = "LoginScenarios")
	public void validLogin(String username, String password) {
		LoginPage logIn_Page = new LoginPage(driver);
		logIn_Page.Login_To_ShoppingApp_Valid(username, password);
	}

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { { "anshika@gmail.com", "Iamking@000" }, { "samicex570@hdrlog.com", "Password@123" } };
	}

}
