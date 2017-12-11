package TestCialfoNew;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import BasePackage.DriverClass;
import BasePackage.Utility;
import Pages.BatchList;
import Pages.DashBoard;
import Pages.LoginForm;
import Pages.PendingUsers;
import Pages.SwimmersPage;
import junit.framework.Assert;

public class PendingUsersTest extends DriverClass {
	LoginForm login = new LoginForm();
	PendingUsers pending = new PendingUsers();
	InputValues input = new InputValues();
	DashBoard dash = new DashBoard();
	Utility util = new Utility();

	SwimmersPage swimmers = new SwimmersPage();
	BatchList batch = new BatchList();
     
	@Test(priority=10)
	public void verifyUnApprovedSwimmersAreInPendingListOrNot() {
		/*login.enterEmailId(input.club);
		login.enterPassword(input.ClubPassword);
		login.clickSignButton();*/
		driver.findElement(dash.PendingUsers).click();
		WebElement filter = driver.findElement(pending.FilterDropDown);
		WebElement role = driver.findElement(pending.FilterByRole);
		util.selectValueByValue(filter, "inactive");
		util.selectValueByValue(role, "Player");
		pending.usersIsListedOrNot(input.Swimmer1EmailID);
		boolean swimmerStatus = pending.usersIsListedOrNot(input.Swimmer1EmailID);
		Assert.assertEquals(true, swimmerStatus);
	}
	
	@Test(priority=15)
	public void checkUnApprovedCoachesAreListedOrNot (){
		WebElement filter = driver.findElement(pending.FilterDropDown);
		WebElement role = driver.findElement(pending.FilterByRole);
		util.selectValueByValue(filter, "inactive");
		util.selectValueByValue(role, "Coach");
		boolean coachStatus = pending.usersIsListedOrNot(input.Coach1EmailID);
		Assert.assertEquals(true, coachStatus);
	}
	
	@Test(priority=20)
	public void rejectSwimmer(){
		WebElement filter = driver.findElement(pending.FilterDropDown);
		WebElement role = driver.findElement(pending.FilterByRole);
		util.selectValueByValue(filter, "inactive");
		util.selectValueByValue(role, "Player");
		pending.approveOrRejectSwimmerSBasedOnName(input.Swimmer3EmailID,"Reject");
	}
	
	@Test(priority=25)
	public void rejectCoach (){
		driver.navigate().refresh();
		WebElement filter = driver.findElement(pending.FilterDropDown);
		WebElement role = driver.findElement(pending.FilterByRole);
		util.selectValueByValue(filter, "inactive");
		util.selectValueByValue(role, "Coach");
		pending.approveOrRejectSwimmerSBasedOnName(input.Swimmer3EmailID, "Reject");
		
	}
	
	@Test(priority=30)
	public void checkSwimmerInRejectedTab (){
		driver.navigate().refresh();
		WebElement filter = driver.findElement(pending.FilterDropDown);
		WebElement role = driver.findElement(pending.FilterByRole);
		util.selectValueByValue(filter, "reject");
		util.selectValueByValue(role, "Player");
		boolean swimmerStatus = pending.usersIsListedOrNot(input.Swimmer3EmailID);
		Assert.assertEquals(true, swimmerStatus);
	}
	
	@Test(priority=35)
	public void checkCoachInRejectedTab (){
		driver.navigate().refresh();
		WebElement filter = driver.findElement(pending.FilterDropDown);
		WebElement role = driver.findElement(pending.FilterByRole);
		util.selectValueByValue(filter, "reject");
		util.selectValueByValue(role, "Coach");
		boolean coachStatus = pending.usersIsListedOrNot(input.Coach3EmailID);
		Assert.assertEquals(true, coachStatus);
	}
	
	@Test(priority=40)
	public void approveSwimmerFromPendingList(){
		WebElement filter = driver.findElement(pending.FilterDropDown);
		WebElement role = driver.findElement(pending.FilterByRole);
		util.selectValueByValue(filter, "inactive");
		util.selectValueByValue(role, "Player");
        pending.approveOrRejectSwimmerSBasedOnName(input.Swimmer1EmailID, "Approve");
	}
	
	@Test(priority=45)
	public void approveCoachesFromPendingTab (){
		WebElement filter = driver.findElement(pending.FilterDropDown);
		WebElement role = driver.findElement(pending.FilterByRole);
		util.selectValueByValue(filter, "inactive");
		util.selectValueByValue(role, "Coach");
		pending.approveOrRejectSwimmerSBasedOnName(input.Coach1EmailID, "Approve");
	}
	
	@Test(priority=50)
	public void checkApprovedSwimmerInPendinglistOrNot(){
		driver.navigate().refresh();
		WebElement filter = driver.findElement(pending.FilterDropDown);
		WebElement role = driver.findElement(pending.FilterByRole);
		util.selectValueByValue(filter, "inactive");
		util.selectValueByValue(role, "Player");
		boolean swimmerStatus = pending.usersIsListedOrNot(input.Swimmer1EmailID);
		Assert.assertEquals(false, swimmerStatus);
	}
	
	@Test(priority=55)
	public void checkApprovedCoachesInPendingList(){
		WebElement filter = driver.findElement(pending.FilterDropDown);
		WebElement role = driver.findElement(pending.FilterByRole);
		util.selectValueByValue(filter, "inactive");
		util.selectValueByValue(role, "Coach");
		Assert.assertEquals(false, pending.usersIsListedOrNot(input.Coach1EmailID));
		
	}
	

}
