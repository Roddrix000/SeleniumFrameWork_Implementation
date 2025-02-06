package RonaldFredrick_Automation.TestComponent;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.io.FileUtils;

public class BaseTest {

	public WebDriver driver;
	public Properties pes;

	@BeforeMethod
	public void initializeDriver() throws IOException {
		pes = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "//src//main//java//RonaldFredrick_Automation//Resources//GlobalData.properties");
		pes.load(fis);
		String browserName = (String) System.getProperty("browser") != null ? System.getProperty("browser")
				: pes.getProperty("browser");
		String Appurl = pes.getProperty("url");
		switch (browserName) {
		case "Chrome":
			driver = new ChromeDriver();
			break;
		case "ChromeHeadless":
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("headless");
			driver = new ChromeDriver(opt);
			driver.manage().window().setSize(new Dimension(1440, 900));
			break;
		case "FireFox":
			// Fireflox Driver
			System.setProperty("webdriver.gecko.driver",
					"D://FireFox&Edgedriver//geckodriver-v0.35.0-win-aarch64//geckodriver.exe");

			// Initialize Firefox WebDriver
			driver = new FirefoxDriver();

			break;
		case "Edge":
			// Microsoft Driver Driver
			System.setProperty("webdriver.edge.driver", "D://FireFox&Edgedriver//edgedriver_win64//msedgedriver.exe");
			// Initialize Edge WebDriver
			driver = new EdgeDriver();
			break;
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(Appurl);
	}

	public static List<HashMap<String, String>> Json_data_reader(String filepath) throws IOException {
		// fetching the data from JSON
		try {
			String jsonContent = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
			// Converting String to Hashmap
			ObjectMapper mapper = new ObjectMapper();
			List<HashMap<String, String>> data = mapper.readValue(jsonContent,
					new TypeReference<List<HashMap<String, String>>>() {
					});

			return data;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;

	}

	public String getScreenShot(String testcase, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "\\reports\\" + testcase + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "\\reports\\" + testcase + ".png";

	}

	@AfterMethod
	public void teraDown() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}

}
