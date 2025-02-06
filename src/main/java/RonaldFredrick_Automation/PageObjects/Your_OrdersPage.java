package RonaldFredrick_Automation.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RonaldFredrick_Automation.AbstractComponents.AbstractComponents;

public class Your_OrdersPage extends AbstractComponents {

	WebDriver driver;
	String tabelOrderId;

	public Your_OrdersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div//h1[text()='Your Orders']")
	WebElement yourOrders_txt;

	@FindBy(xpath = "//button[contains(text(),'ORDERS')]/..//button[@class='btn btn-custom']")
	WebElement Orders_link;
	@FindBy(xpath = "//th[text()='Order Id']/../../following-sibling::tbody//th")
	WebElement orderID;

	@FindBy(xpath = "//button[text()='View']")
	WebElement view_Btn;

	@FindBy(xpath = "//div[text()=' You have No Orders to show at this time.']")
	WebElement No_Order_Txt;

	@FindBy(xpath = "//button[contains(text(),' Sign Out ')]/..//button[@class='btn btn-custom']")
	WebElement sign_out_Btn;

	@FindBy(xpath = "//button[text()='Delete']")
	List<WebElement> Delete_btn;

	@FindBy(xpath = "//div[text()=' Orders Deleted Successfully ']")
	WebElement orderDeleted_message;

	public void delete_product() {
		Orders_link.click();
		waituntilElement(yourOrders_txt);
		String tabelOrderId = orderID.getText();
		By Delete_btn = By.xpath("//th[text()='Order Id']/../../following-sibling::tbody//th[text()='" + tabelOrderId
				+ "']/..//td//button[text()='Delete']");
		driver.findElement(Delete_btn).click();
		waituntilElement(No_Order_Txt);
		sign_out_Btn.click();

	}

	public void delete_existing_item() throws InterruptedException {
		Orders_link.click();
		boolean check;
		waituntilElement(yourOrders_txt);
		try {
			check = No_Order_Txt.isDisplayed();
			if (check == true) {
				driver.findElement(By.xpath("//button[text()=' HOME ']")).click();
				System.out.println("No Order present at the Movement..!!");

			}
		} catch (Exception e) {
			// TODO: handle exception
			for (WebElement ele : Delete_btn) {
				WebElement del = driver.findElement(By.xpath("//button[text()='Delete']"));
				waituntilElement(del);
				del.click();
				waituntilElement(orderDeleted_message);
				Thread.sleep(2000);
			}
		}

	}
}
