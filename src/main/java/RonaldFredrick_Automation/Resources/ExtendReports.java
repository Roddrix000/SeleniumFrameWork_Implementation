package RonaldFredrick_Automation.Resources;

import java.sql.Date;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReports {

	public static ExtentReports extendReports() {

		
		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yyyy HH_mm_ss"));
		String path = System.getProperty("user.dir") + "\\Extend_Reports\\" + timestamp + ".html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Selenium Frame Work Automation");
		reporter.config().setDocumentTitle("Test Results");
		ExtentReports extent = new ExtentReports();
		// attaching the report
		extent.attachReporter(reporter);
		extent.setSystemInfo("Automation tester", "Ronald fredrick");
		return extent;
	}
}
