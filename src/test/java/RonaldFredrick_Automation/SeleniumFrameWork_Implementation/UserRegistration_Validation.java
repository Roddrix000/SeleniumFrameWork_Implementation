package RonaldFredrick_Automation.SeleniumFrameWork_Implementation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import RonaldFredrick_Automation.PageObjects.RegistrationPage;
import RonaldFredrick_Automation.TestComponent.BaseTest;

public class UserRegistration_Validation extends BaseTest {

	@Test
	public void registration_Validation() throws InterruptedException {
		RegistrationPage reg = new RegistrationPage(driver);
		Assert.assertEquals(true, reg.registration_to_ShoppingApp());
		Thread.sleep(2000);
	}

}

// un : testin@gmail.com
//Pass: Password@888888
