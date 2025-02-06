package RonaldFredrick_Automation.SeleniumFrameWork_Implementation;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;

import RonaldFredrick_Automation.TestComponent.BaseTest;

public class Login_validation extends BaseTest{

	
	@Test
	public void intenallyfailed_Login()
	{
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("helllo");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Pass");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		boolean val = driver.findElement(By.xpath("//p[text()='Automation Practice']")).isDisplayed();
		Assert.assertTrue(val);
	}
	
}
