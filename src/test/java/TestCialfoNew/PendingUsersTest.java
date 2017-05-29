package TestCialfoNew;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

	public void checkSwimmersAreInPendingListOrNot() {
		login.enterEmailId(input.club);
		login.enterPassword(input.ClubPassword);
		login.clickSignButton();
		driver.findElement(dash.PendingUsers).click();
		WebElement filter = driver.findElement(pending.FilterDropDown);
		util.selectValueByValue(filter, "reject");
		String actual = pending.getSwimmersFromTable(input.swimmer);
		Assert.assertEquals(input.swimmer, actual);
	}

	public void checkPendingUsersAreNotListedInSwimmersSelectionOnAddBatchPage() {
		driver.navigate().refresh();
		dash.clickOnManageBatch();
		batch.clickOnAddbacthButton();
		driver.findElement(batch.PlayerSelection).click();
		WebElement swimmersLilst = driver.findElement(batch.SwimmersResult);
		boolean swimmerstatus = batch.SwimmersFromCoachList(swimmersLilst, input.swimmer);
		Assert.assertEquals(swimmerstatus, false);

	}

	public void approveSwimmersFromPendingList() {
		driver.navigate().refresh();
		driver.findElement(dash.PendingUsers).click();
		WebElement filter = driver.findElement(pending.FilterDropDown);
		util.selectValueByValue(filter, "inactive");
		pending.approveSwimmerSBasedOnName(input.swimmer);
	}

	public void checkSwimmersMovedFromPendingListAfterApproving() {
		driver.navigate().refresh();
		driver.findElement(dash.PendingUsers).click();
		WebElement filter = driver.findElement(pending.FilterDropDown);
		util.selectValueByValue(filter, "inactive");
		boolean swimmerstatus;
		if (swimmerstatus = pending.getSwimmersFromTable(input.swimmer).equals(input.swimmer)) {
			swimmerstatus = true;
		} else {
			swimmerstatus = false;
		}
		// pending.getSwimmersFromTable(input.swimmer);
		Assert.assertEquals(swimmerstatus, false);
	}

	public void checkApprovedUsersDisplyedInUnAssignedList() throws InterruptedException {
		driver.navigate().refresh();
		dash.clickOnSwimmers();
		WebElement batchselection = driver.findElement(swimmers.BatchSelection);
		swimmers.batchSelection(batchselection, "Un Assigned");
		String actualSwimmer = driver.findElement(By.linkText(input.swimmer)).getText();
		String expectedSwimmer = input.swimmer;
		Assert.assertEquals(actualSwimmer, expectedSwimmer);
	}

	public void checkApprovedUsersDisplayedOnAddBatchPage() {
		driver.navigate().refresh();
		dash.clickOnManageBatch();
		batch.clickOnAddbacthButton();
		driver.findElement(batch.PlayerSelection).click();
		WebElement swimmersLilst = driver.findElement(batch.SwimmersResult);
		boolean swimmerstatus = batch.SwimmersFromCoachList(swimmersLilst, input.swimmer);
		Assert.assertEquals(swimmerstatus, true);
	}

	public void rejectSwimmersFromPendingList() {
		driver.navigate().refresh();
		driver.findElement(dash.PendingUsers).click();
		WebElement filter = driver.findElement(pending.FilterDropDown);
		util.selectValueByValue(filter, "inactive");
		pending.rejectSwimmersBasedOnSwimmerName(input.swimmer2);

	}

	public void checkSwimmerNotDisplayedInPendingListAfterReject() {
		driver.navigate().refresh();
		driver.findElement(dash.PendingUsers).click();
		WebElement filter = driver.findElement(pending.FilterDropDown);
		util.selectValueByValue(filter, "inactive");
		boolean swimmerstatus;
		if (swimmerstatus = pending.getSwimmersFromTable(input.swimmer).equals(input.swimmer)) {
			swimmerstatus = true;
		} else {
			swimmerstatus = false;
		}
		// pending.getSwimmersFromTable(input.swimmer);
		Assert.assertEquals(swimmerstatus, false);

	}

	public void checkSwimmerISDisplayedInRejectUsers() {
		driver.navigate().refresh();
		driver.findElement(dash.PendingUsers).click();
		WebElement filter = driver.findElement(pending.FilterDropDown);
		util.selectValueByValue(filter, "reject");
		boolean swimmerstatus;
		if (swimmerstatus = pending.getSwimmersFromTable(input.swimmer2).equals(input.swimmer2)) {
			swimmerstatus = true;
		} else {
			swimmerstatus = false;
		}
		// pending.getSwimmersFromTable(input.swimmer);
		Assert.assertEquals(swimmerstatus, true);

	}

	public void checkRejectedUsersNotDispplayingOnAddBatchList() {
		driver.navigate().refresh();
		dash.clickOnManageBatch();
		batch.clickOnAddbacthButton();
		driver.findElement(batch.PlayerSelection).click();
		WebElement swimmersLilst = driver.findElement(batch.SwimmersResult);
		boolean swimmerstatus = batch.SwimmersFromCoachList(swimmersLilst, input.swimmer2);
		Assert.assertEquals(swimmerstatus, false);
	}

	public void approveSwimmersFromRejectedList() {
		driver.navigate().refresh();
		driver.findElement(dash.PendingUsers).click();
		WebElement filter = driver.findElement(pending.FilterDropDown);
		util.selectValueByValue(filter, "reject");
		pending.approveSwimmerSBasedOnName(input.swimmer2);
	}

	public void checkSwimmerIsDisplayedOrNotAfterApprovingFromRejectedList() {
		driver.navigate().refresh();
		driver.findElement(dash.PendingUsers).click();
		WebElement filter = driver.findElement(pending.FilterDropDown);
		util.selectValueByValue(filter, "reject");
		boolean swimmerstatus;
		if (swimmerstatus = pending.getSwimmersFromTable(input.swimmer2).equals(input.swimmer2)) {
			swimmerstatus = true;
		} else {
			swimmerstatus = false;
		}
		// pending.getSwimmersFromTable(input.swimmer);
		Assert.assertEquals(swimmerstatus, false);
	}

	public void checkApprovedUsersfromRejectedTabDisplyedInUnAssignedList() throws InterruptedException {
		driver.navigate().refresh();
		dash.clickOnSwimmers();
		WebElement batchselection = driver.findElement(swimmers.BatchSelection);
		swimmers.batchSelection(batchselection, "Un Assigned");
		String actualSwimmer = driver.findElement(By.linkText(input.swimmer2)).getText();
		String expectedSwimmer = input.swimmer2;
		Assert.assertEquals(actualSwimmer, expectedSwimmer);
	}

	public void checkApprovedUsersFromRejectedListDisplayingOnAddBatchList() {
		driver.navigate().refresh();
		dash.clickOnManageBatch();
		batch.clickOnAddbacthButton();
		driver.findElement(batch.PlayerSelection).click();
		WebElement swimmersLilst = driver.findElement(batch.SwimmersResult);
		boolean swimmerstatus = batch.SwimmersFromCoachList(swimmersLilst, input.swimmer2);
		Assert.assertEquals(swimmerstatus, true);

	}

	public void checkCoachesAreInPendingListOrNot() {
		driver.navigate().refresh();
		driver.findElement(dash.PendingUsers).click();
		WebElement filter = driver.findElement(pending.FilterDropDown);
		util.selectValueByValue(filter, "inactive");
		String actual = pending.getSwimmersFromTable(input.coach);
		Assert.assertEquals(input.coach, actual);
	}

	public void approveCoachFromPendingList() {
		driver.navigate().refresh();
		driver.findElement(dash.PendingUsers).click();
		WebElement filter = driver.findElement(pending.FilterDropDown);
		util.selectValueByValue(filter, "inactive");
		pending.approveSwimmerSBasedOnName(input.coach);
	}

	public void checkCoachesmovedFromPendingListAfterApproving() {
		driver.navigate().refresh();
		driver.findElement(dash.PendingUsers).click();
		WebElement filter = driver.findElement(pending.FilterDropDown);
		util.selectValueByValue(filter, "inactive");
		boolean swimmerstatus;
		if (swimmerstatus = pending.getSwimmersFromTable(input.coach).equals(input.coach)) {
			swimmerstatus = true;
		} else {
			swimmerstatus = false;
		}
		// pending.getSwimmersFromTable(input.swimmer);
		Assert.assertEquals(swimmerstatus, false);
	}

	public void checkApprovedCoachesAreListingOnBatchesList() {
		driver.navigate().refresh();
		dash.clickOnManageBatch();
		batch.clickOnAddbacthButton();
		WebElement coachlist = driver.findElement(batch.CoachResult);
		boolean coachStatus = batch.coachesFromCoachList(coachlist, input.coach);
		Assert.assertEquals(coachStatus, true);
	}

	public void checkCoachAddedOrnotAfterApprovingFromPendingUsers() throws InterruptedException {
		driver.navigate().refresh();
		dash.clickOnCoach();
		Thread.sleep(500);
		String actuLCoachName = driver.findElement(By.linkText(input.coach)).getText();
		String expectedCoach = input.coach;
		Assert.assertEquals(expectedCoach, actuLCoachName);

	}

	public void rejectCoachesFromPendingList() {
		driver.navigate().refresh();
		driver.findElement(dash.PendingUsers).click();
		WebElement filter = driver.findElement(pending.FilterDropDown);
		util.selectValueByValue(filter, "inactive");
		pending.rejectSwimmersBasedOnSwimmerName(input.coach2);

	}

	public void checkCoachNotDisplayedInPendingListAfterReject() {
		driver.navigate().refresh();
		driver.findElement(dash.PendingUsers).click();
		WebElement filter = driver.findElement(pending.FilterDropDown);
		util.selectValueByValue(filter, "inactive");
		boolean swimmerstatus;
		if (swimmerstatus = pending.getSwimmersFromTable(input.coach2).equals(input.coach2)) {
			swimmerstatus = true;
		} else {
			swimmerstatus = false;
		}
		// pending.getSwimmersFromTable(input.swimmer);
		Assert.assertEquals(swimmerstatus, false);

	}

	public void checkCoachIsDisplayedInRejectUsers() {
		driver.navigate().refresh();
		driver.findElement(dash.PendingUsers).click();
		WebElement filter = driver.findElement(pending.FilterDropDown);
		util.selectValueByValue(filter, "reject");
		boolean swimmerstatus;
		if (swimmerstatus = pending.getSwimmersFromTable(input.coach2).equals(input.coach2)) {
			swimmerstatus = true;
		} else {
			swimmerstatus = false;
		}
		// pending.getSwimmersFromTable(input.swimmer);
		Assert.assertEquals(swimmerstatus, true);

	}

	public void checkRejectedCoachesAreNotDisplayedInAddBatchPage() {
		driver.navigate().refresh();
		dash.clickOnManageBatch();
		batch.clickOnAddbacthButton();
		WebElement coachlist = driver.findElement(batch.CoachResult);
		boolean coachStatus = batch.coachesFromCoachList(coachlist, input.coach2);
		Assert.assertEquals(coachStatus, false);
	}

	public void approveCoachesFromRejectedList() {
		driver.navigate().refresh();
		driver.findElement(dash.PendingUsers).click();
		WebElement filter = driver.findElement(pending.FilterDropDown);
		util.selectValueByValue(filter, "reject");
		pending.approveSwimmerSBasedOnName(input.coach2);
	}

	public void checkCoachesIsDisplayedOrNotAfterApprovingFromRejectedList() {
		driver.navigate().refresh();
		driver.findElement(dash.PendingUsers).click();
		WebElement filter = driver.findElement(pending.FilterDropDown);
		util.selectValueByValue(filter, "reject");
		boolean swimmerstatus;
		if (swimmerstatus = pending.getSwimmersFromTable(input.coach2).equals(input.coach2)) {
			swimmerstatus = true;
		} else {
			swimmerstatus = false;
		}
		// pending.getSwimmersFromTable(input.swimmer);
		Assert.assertEquals(swimmerstatus, false);
	}

	public void checkCoachAddedOrnotAfterApprovingFromRejectedUsers() throws InterruptedException {
		driver.navigate().refresh();
		dash.clickOnCoach();
		Thread.sleep(500);
		String actuLCoachName = driver.findElement(By.linkText(input.coach2)).getText();
		String expectedCoach = input.coach2;
		Assert.assertEquals(expectedCoach, actuLCoachName);

	}

	public void checkApprovedCoachesFromRejectedListDisplayedInAddBatchPage() {
		driver.navigate().refresh();
		dash.clickOnManageBatch();
		batch.clickOnAddbacthButton();
		WebElement coachlist = driver.findElement(batch.CoachResult);
		boolean coachStatus = batch.coachesFromCoachList(coachlist, input.coach2);
		Assert.assertEquals(coachStatus, true);
	}

}
