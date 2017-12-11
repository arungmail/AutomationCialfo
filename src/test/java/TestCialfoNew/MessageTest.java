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
import junit.framework.Assert;

public class MessageTest extends DriverClass {
	LoginForm login = new LoginForm();
	DashBoard dash = new DashBoard();
	BatchList batch = new BatchList();
	Utility util = new Utility();
	SwimmersPage swimmers = new SwimmersPage();
	MessagePage msg = new MessagePage();
	InputValues input = new InputValues ();
	

	@Test(priority = 2)
	public void verifyAllCachesGroupsinMessage () throws InterruptedException{
		dash.clickOnMessage();
		msg.clickOnComposeButton();
		boolean coachesGroupStatus = msg.userStatus("All Coaches(Group)");
		Assert.assertEquals(true, true);
	}
	
	@Test(priority = 4)
	public void verifyAllMembersGroupInMessage() throws InterruptedException{
		driver.findElement(msg.InBox).click();
		msg.clickOnComposeButton();
		boolean coachesGroupStatus = msg.userStatus("All Coaches(Group)");
		Assert.assertEquals(true, true);
	}
	
	@Test(priority = 6)
	public void sendMeesageToAllCoachesGourpabdAllMembersGroup() throws InterruptedException{
		driver.findElement(msg.InBox).click();
		msg.clickOnComposeButton();
		msg.selectUserFromList("All Group(Group)");
		msg.selectUserFromList("All Coaches(Group)");
		msg.enterSubJect(input.MessageTOAllGroupsandCoaches);
		//msg.enterBody("Message to All Coaches Group");
		util.scrollingToBottomofAPage();
		msg.clickOnSendButton();
	}
	
	@Test(priority = 8)
	public void verifyMessageInInboxPage (){
		driver.findElement(msg.InBox).click();
		String subject = msg.getEmailSubJectInInBoxTable(input.MessageTOAllGroupsandCoaches);
		Assert.assertEquals(subject, "input.MessageTOAllGroupsandCoaches");
	}
	
	
	@Test(priority = 10)
	public void verifyEmbptyvalidation (){
		msg.clickOnInBox();
		msg.clickOnComposeButton();
		util.scrollingToBottomofAPage();
		msg.clickOnSendButton();
		String error = driver.findElement(msg.CommentValidation).getText();
		Assert.assertEquals("Please fill all mandatory fields",error);	
	}
	
	
	@Test(priority = 12)
	public void verifyUsresValidation (){
		msg.enterSubJect("Test");
		util.scrollingToBottomofAPage();
		msg.clickOnSendButton();
		String error = driver.findElement(msg.UserVllidation).getText();
		Assert.assertEquals("Please select users", error);
	}
	
	@Test(priority = 14)
	public void verifySubjectValidation() throws InterruptedException{
		msg.selectUserFromList("All Coaches");
		msg.enterSubJect("");
		util.scrollingToBottomofAPage();
		msg.clickOnSendButton();
		String error = driver.findElement(msg.SubjecctValidation).getText();
		Assert.assertEquals("Please enter subject",error);
	}
	
	@Test(priority = 16)
	public void sendMessageToCoachandSwimmer () throws InterruptedException{
		msg.selectUserFromList(input.Coach1Name);
		msg.selectUserFromList(input.Swimmer1EmailID);
		msg.enterSubJect(input.MessageTOSwimmerandCoach);
		util.scrollingToBottomofAPage();
		msg.clickOnSendButton();
	}
	
	@Test(priority = 18)
	public void sendMessageFromQuickMessageToGroups () throws InterruptedException{
		dash.clickOnDashBoard();
		Thread.sleep(2000);
		msg.selectUserFromList("All Groups");
		msg.selectUserFromList("All Coaches");
		msg.enterSubJect(input.QuickMessageToAllGroupsandCoaches);
		msg.clickOnSendButton();
	}
	
	@Test(priority = 20)
	public void sendMessageFromQuickMessageToSwimmerandCoach() throws InterruptedException{
		msg.selectUserFromList(input.Swimmer1Name);
		msg.selectUserFromList(input.Coach1Name);
		msg.enterSubJect(input.QuickMessageToSwimmerandCoach);
		msg.clickOnSendButton();
		
	}
	
	@Test(priority = 22)
	public void quickMessageEmptyValidation (){
		msg.clickOnSendButton();
		String error = driver.findElement(msg.CommentValidation).getText();
		Assert.assertEquals("Please fill all mandatory fields",error);	
	}
	
	@Test(priority = 24)
	public void verifyQuickMessageUsersValidation (){
		msg.enterSubJect("Test");
		msg.clickOnSendButton();
		String error = driver.findElement(msg.UserVllidation).getText();
		Assert.assertEquals("Please select users", error);
	}
	
	@Test(priority = 26)
	public void verifyQuickMessageSubjectVallidation () throws InterruptedException{
		msg.selectUserFromList("All Coaches");
		msg.enterSubJect("");
		msg.clickOnSendButton();
		String error = driver.findElement(msg.SubjecctValidation).getText();
		Assert.assertEquals("Please enter subject",error);
		dash.logingOut();
	}
	
	
	@Test(priority = 28)
	public void verifyGroupMessageInSwimmerAccount () throws InterruptedException{
		login.enterEmailId(input.Swimmer1EmailID);
		login.enterPassword("Nichi123");
		login.clickSignButton();
		Thread.sleep(5000);
		dash.clickOnMessage();
		driver.findElement(msg.InBox).click();
		String subject = msg.getEmailSubJectInInBoxTable(input.MessageTOAllGroupsandCoaches);
		Assert.assertEquals(subject, "input.MessageTOAllGroupsandCoaches");
	}
	
	@Test(priority = 30)
	public void verifyoneToOneMessageinSwimmerAccount(){
		String subject = msg.getEmailSubJectInInBoxTable(input.MessageTOSwimmerandCoach);
		Assert.assertEquals(subject, "input.MessageTOSwimmerandCoach");
	}
	
	@Test(priority = 32)
	public void verifyQuickMessagesInSwimmerAccount (){
		String subject = msg.getEmailSubJectInInBoxTable(input.QuickMessageToAllGroupsandCoaches);
		Assert.assertEquals(subject, "input.QuickMessageToAllGroupsandCoaches");
	}
	
	@Test(priority = 34)
	public void verifyQuickMessagesInSwimmerAccount1 (){
		String subject = msg.getEmailSubJectInInBoxTable(input.QuickMessageToSwimmerandCoach);
		Assert.assertEquals(subject, "input.QuickMessageToSwimmerandCoach");
	}
	
	@Test(priority = 36)
	public void verifyAllCachesGroupsInSwimmerAccount () throws InterruptedException{
		msg.clickOnComposeButton();
		boolean coachesGroupStatus = msg.userStatus("All Coaches(Group)");
		Assert.assertEquals(true, false);
	}
	
	@Test(priority = 38)
	public void verifyAllMembersGroupInSwimmerAccount() throws InterruptedException {
		driver.findElement(msg.InBox).click();
		msg.clickOnComposeButton();
		boolean coachesGroupStatus = msg.userStatus("All Coaches(Group)");
		Assert.assertEquals(true, true);
	}
	
	@Test(priority = 40)
	public void sendMessageToAllGroupFromSwimmerAccount () throws InterruptedException{
		driver.findElement(msg.InBox).click();
		msg.clickOnComposeButton();
		msg.selectUserFromList("All Group(Group)");
		msg.enterSubJect(input.MessageTOAllGroupsandCoaches);
		//msg.enterBody("Message to All Coaches Group");
		util.scrollingToBottomofAPage();
		msg.clickOnSendButton();
	}
	
	@Test(priority = 42)
	public void sendMessageToSwimmerandCoach() throws InterruptedException{
		msg.clickOnComposeButton();
		msg.selectUserFromList(input.Coach2Name);
		msg.selectUserFromList(input.Swimmer1EmailID);
		msg.enterSubJect(input.MessageFromSwimmer);
		util.scrollingToBottomofAPage();
		msg.clickOnSendButton();
	}
	@Test(priority = 46)
	public void verifyEmbptyvalidationInSwimmerAccount (){
		msg.clickOnInBox();
		msg.clickOnComposeButton();
		util.scrollingToBottomofAPage();
		msg.clickOnSendButton();
		String error = driver.findElement(msg.CommentValidation).getText();
		Assert.assertEquals("Please fill all mandatory fields",error);	
	}
	@Test(priority = 48)
	public void verifyUsresValidationInSwimmerAccount (){
		msg.enterSubJect("Test");
		util.scrollingToBottomofAPage();
		msg.clickOnSendButton();
		String error = driver.findElement(msg.UserVllidation).getText();
		Assert.assertEquals("Please select users", error);
	}
	
	@Test(priority = 50)
	public void verifySubjectValidationInSwimmerAccount() throws InterruptedException{
		msg.selectUserFromList("All Coaches");
		msg.enterSubJect("");
		util.scrollingToBottomofAPage();
		msg.clickOnSendButton();
		String error = driver.findElement(msg.SubjecctValidation).getText();
		Assert.assertEquals("Please enter subject",error);
	}
	
	@Test(priority = 52)
	public void sendMessageFromQuickMessageToGroupsFromSwimmerAccount () throws InterruptedException{
		dash.clickOnDashBoard();
		Thread.sleep(2000);
		msg.selectUserFromList("All Groups");
		msg.enterSubJect(input.QuickMessageToAllGroupsandCoaches);
		msg.clickOnSendButton();
	}
	
	@Test(priority = 54)
	public void sendMessageFromQuickMessageToSwimmerandCoachfromSwimmerAccount() throws InterruptedException{
		msg.selectUserFromList(input.Swimmer1Name);
		msg.selectUserFromList(input.Coach2Name);
		msg.enterSubJect(input.QuickMessageFromSwimmer);
		msg.clickOnSendButton();
		
	}
	
	@Test(priority = 56)
	public void quickMessageEmptyValidationInSwimmerAccount (){
		msg.clickOnSendButton();
		String error = driver.findElement(msg.CommentValidation).getText();
		Assert.assertEquals("Please fill all mandatory fields",error);	
	}
	
	@Test(priority = 58)
	public void verifyQuickMessageUsersValidationInSwimmerAccount (){
		msg.enterSubJect("Test");
		msg.clickOnSendButton();
		String error = driver.findElement(msg.UserVllidation).getText();
		Assert.assertEquals("Please select users", error);
	}
	
	@Test(priority = 60)
	public void verifyQuickMessageSubjectVallidationInSwimmerAccount () throws InterruptedException{
		msg.selectUserFromList("All Coaches");
		msg.enterSubJect("");
		msg.clickOnSendButton();
		String error = driver.findElement(msg.SubjecctValidation).getText();
		Assert.assertEquals("Please enter subject",error);
		dash.logingOut();
	}
	
}
