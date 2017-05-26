package TestCialfoNew;

import org.openqa.selenium.WebElement;

import BasePackage.DriverClass;
import BasePackage.Utility;
import Pages.DashBoard;
import Pages.LoginForm;
import Pages.PendingUsers;
import junit.framework.Assert;

public class PendingUsersTest extends DriverClass{
	LoginForm login = new LoginForm ();
	PendingUsers pending = new PendingUsers ();
	InputValues input = new InputValues ();
	DashBoard dash = new DashBoard ();
	Utility util = new Utility ();
	
	
	public void checkSwimmersAreInPendingListOrNot ()
	{
		login.enterEmailId(input.club);
		login.enterPassword(input.ClubPassword);
		login.clickSignButton();
		driver.findElement(dash.PendingUsers).click();
		WebElement filter = driver.findElement(pending.FilterDropDown);
		util.selectValueByValue(filter, "reject");
		String actual = pending.getSwimmersFromTable(input.swimmer);
		Assert.assertEquals(input.swimmer, actual);		
	}
	public void approveSwimmersFromPendingList ()
	{
		driver.navigate().refresh();
		driver.findElement(dash.PendingUsers).click();
		WebElement filter = driver.findElement(pending.FilterDropDown);
		util.selectValueByValue(filter, "inactive");
		pending.approveSwimmerSBasedOnName(input.swimmer);	
	}
	public void checkSwimmersmovedFromPendingListAfterApproving ()
	{
		driver.navigate().refresh();
		driver.findElement(dash.PendingUsers).click();
		WebElement filter = driver.findElement(pending.FilterDropDown);
		util.selectValueByValue(filter, "inactive");
		pending.getSwimmersFromTable(input.swimmer).
			
		}
		
		
		
		
		
	}
	
}
