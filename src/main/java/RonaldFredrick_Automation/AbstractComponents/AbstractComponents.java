package RonaldFredrick_Automation.AbstractComponents;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {

	WebDriver driver;

	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
	}

	public void selectElement(WebElement ele, String visibletxt) {
		Select sel = new Select(ele);
		sel.selectByVisibleText(visibletxt);
	}

	public void waituntilElement(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele));

	}

	public static Object genData(String choice) {
		Random random = new Random();

		switch (choice.toLowerCase()) {
		case "fname": // Generate a random first name
			return generateRandomString(random, 5, 8); // Generate a string of length 5-8 characters

		case "lname": // Generate a random last name
			return generateRandomString(random, 5, 10); // Generate a string of length 5-10 characters

		case "mob": // Generate a random 10-digit mobile number
			int firstDigit = random.nextInt(3) + 7; // Generates 7, 8, or 9
			StringBuilder mobileNumber = new StringBuilder();
			mobileNumber.append(firstDigit);
			for (int i = 0; i < 9; i++) {
				mobileNumber.append(random.nextInt(10)); // Appends a random digit (0-9)
			}
			return mobileNumber.toString();

		default:
			return "Invalid choice. Please use 'fname', 'lname', or 'mob'.";
		}

	}

	private static String generateRandomString(Random random, int minLength, int maxLength) {
		int length = random.nextInt(maxLength - minLength + 1) + minLength; // Random length in range
		StringBuilder result = new StringBuilder();
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"; // Characters to choose from

		for (int i = 0; i < length; i++) {
			result.append(alphabet.charAt(random.nextInt(alphabet.length())));
		}

		return result.toString();
	}



}
