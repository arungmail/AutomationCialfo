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
	InputValues input = new InputValues ();

	@Test
	public void composeMail() throws InterruptedException {
		dash.clickOnMessage();
		msg.clickOnComposeButton();
		driver.findElement(msg.To).click();
		Thread.sleep(500);
		msg.selectUserFromList(input.Swimmer1);
		msg.selectUserFromList(input.Coach1);
		driver.findElement(msg.Subject).sendKeys("First Message");
		msg.enterMessageBody(ifameName, contentTotype, element);

	}
	
	
	

}
