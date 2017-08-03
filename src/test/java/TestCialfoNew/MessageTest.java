package TestCialfoNew;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import BasePackage.DriverClass;
import BasePackage.Utility;
import Pages.BatchList;
import Pages.DashBoard;
import Pages.LoginForm;
import Pages.MessagePage;
import Pages.SwimmersPage;

public class MessageTest extends DriverClass {
	LoginForm login = new LoginForm();
	DashBoard dash = new DashBoard();
	BatchList batch = new BatchList();
	Utility util = new Utility();
	SwimmersPage swimmers = new SwimmersPage();
	MessagePage msg = new MessagePage();

	@Test
	public void composeMail() throws InterruptedException {
		login.enterEmailId("swimlife@gmail.com");
		login.enterPassword("12345678");
		login.clickSignButton();
		driver.findElement(dash.Message).click();
		msg.clickOnComposeButton();
		driver.findElement(msg.To).click();
		Thread.sleep(500);
		WebElement list = driver.findElement(msg.UserList);
		msg.selectUserFromList(list, "Divya Mohandas");
		// driver.findElement(msg.To).click();
		// msg.selectUserFromList(list, "Jithu Haridas");
		msg.enterSubJect("My First Automation Message");
		driver.findElement(By.xpath("//iframe[@class='wysihtml5-sandbox']")).click();
		msg.enterBody("Hi Test ");
		msg.clickOnSendButton();

	}
	
	
	

}
