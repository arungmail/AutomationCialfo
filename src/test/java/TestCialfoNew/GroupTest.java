package TestCialfoNew;

import BasePackage.DriverClass;
import BasePackage.Utility;
import Pages.Atendance;
import Pages.BatchList;
import Pages.DashBoard;
import Pages.Groups;
import Pages.LoginForm;
import Pages.SwimmersPage;
import junit.framework.Assert;

public class GroupTest extends DriverClass {
	LoginForm login = new LoginForm();
	DashBoard dash = new DashBoard();
	BatchList batch = new BatchList();
	Utility util = new Utility();
	SwimmersPage swimmers = new SwimmersPage();
	InputValues input = new InputValues ();
	Atendance att = new Atendance ();
	Groups group = new Groups ();
	
	public void verifyPublicGroupsInClubAccount(){
		dash.clickOnGroups();
		boolean status = group.checkGroupName(input.PublicGroups);
		Assert.assertEquals(status, true);
	}
	
	public void verifymembersInPublicGroup () throws InterruptedException{
		boolean coachStatus = group.statusOfMembersFromContactList(input.PublicGroups, input.Coach1Name);
		boolean swimmerStatus = group.statusOfMembersFromContactList(input.PublicGroups, input.Swimmer1Name);
		Assert.assertEquals(coachStatus, true);
		Assert.assertEquals(swimmerStatus, true);	
	}

	
	public void verifyAllcoachesGroups (){
		boolean status = group.checkGroupName(input.AllCoachesGroup);
		Assert.assertEquals(status, true);
	}
	
	public void verifyCoachesGroupMembers () throws InterruptedException{
		boolean coachStatus = group.statusOfMembersFromContactList(input.AllCoachesGroup, input.Coach1Name);
		boolean swimmersStatus = group.statusOfMembersFromContactList(input.AllCoachesGroup, input.Swimmer1Name);
		Assert.assertEquals(coachStatus, true);
		Assert.assertEquals(swimmersStatus, false);
		
		}
	
	public void verifyClubandCoachAccountGroup(){
		boolean status = group.checkGroupName(input.club+"-"+input.Coach1Name);
		Assert.assertEquals(status, true);
	}
	
	public void verifyClubandCoachGroupMembers () throws InterruptedException{
		boolean coachStatus = group.statusOfMembersFromContactList(input.club+"-"+input.Coach1Name, input.Coach1Name);
		Assert.assertEquals(coachStatus, true);
	}
	
	public void createPersonalBatch (){
		driver.findElement(group.GroupCreationButton).click();
		driver.findElement(group.GroupnameInAddGroup).sendKeys(input.Personalgroup);
		group.selectSwimmersonAddGroup(input.Coach1Name);
		group.selectSwimmersonAddGroup(input.Swimmer1Name);
		group.clickOnCreateButton();
	}
	
	public void verifyPersonalGroup(){
		boolean status = group.checkGroupName(input.Personalgroup);
		Assert.assertEquals(status, true);
	}
	
	public void verifyPersonalGroupMembers () throws InterruptedException{
		boolean coachStatus = group.statusOfMembersFromContactList(input.Personalgroup, input.Swimmer1Name);
		boolean swimmerStatus = group.statusOfMembersFromContactList(input.Personalgroup, input.Coach1Name);
		Assert.assertEquals(coachStatus, true);
		Assert.assertEquals(swimmerStatus, true);
	}
	
	public void verifyPublicGroupInCoachAccount () throws InterruptedException{
		dash.logingOut();
		LoginForm.enterEmailId(input.Coach1EmailID);
  		LoginForm.enterPassword("Nichi123");
  		LoginForm.clickSignButton();
  		verifyPublicGroupsInClubAccount();	
	}
	
	public void verifyMembersinPublicGroupInCoachAccount () throws InterruptedException{
	 verifymembersInPublicGroup();
	}
	public void verifyAllcoachesGroupsInCoachAccount (){
		verifyAllcoachesGroups();
	}
	
	public void verifyMembersInAllcoachesGroupIncoachAccount() throws InterruptedException{
		verifyCoachesGroupMembers();
	}
	public void verifypersonalGroupInCoachAccount (){
		verifyPersonalGroup();
	}
	
	public void verifymembersOfPersonalGroupInCoachAccount() throws InterruptedException{
		verifyPersonalGroupMembers();
	}
	
	public void verifyCoachplusClubGroupInClubAccount (){
		//dash.clickOnGroups();
		boolean status = group.checkGroupName(input.club+"-"+input.Coach1Name);
		Assert.assertEquals(status, true);
		
	}
	
	public void verifyClubandCoachGroupMembersInCoachAccount () throws InterruptedException{
		boolean coachStatus = group.statusOfMembersFromContactList(input.club+"-"+input.Coach1Name, input.Coach1Name);
		Assert.assertEquals(coachStatus, true);
	}
	
	public void verifybatchGroupInCoachAccount (){
		boolean status = group.checkGroupName(input.BatchName1);
		Assert.assertEquals(status, true);
	}
	
	public void verifyBatchGroupMembers () throws InterruptedException{
		boolean coachStatus = group.statusOfMembersFromContactList(input.Personalgroup, input.Swimmer1Name);
		boolean swimmerStatus = group.statusOfMembersFromContactList(input.Personalgroup, input.Coach1Name);
		Assert.assertEquals(coachStatus, true);
		Assert.assertEquals(swimmerStatus, true);
	}
	
	public void verifypublicGroupInSwimmerAccount () throws InterruptedException{
		dash.logingOut();
		LoginForm.enterEmailId(input.Swimmer1EmailID);
  		LoginForm.enterPassword("Nichi123");
  		LoginForm.clickSignButton();
  		verifyPublicGroupsInClubAccount();	
	}
	
	public void verifyMembersinPublicGroupInSwimmerAccount () throws InterruptedException{
		verifymembersInPublicGroup();
	}
	
	/*public void verifyAllcoachesGroupsInCoacAccount (){
		verifyAllcoachesGroups();
	}*/
	
	
	public void verifypersonalGroupInSwimmerAccount (){
		verifyPersonalGroup();
	}
	
	public void verifymembersOfPersonalGroupInSwimmerAccount() throws InterruptedException{
		verifyPersonalGroupMembers();
	}
	
	
	public void verifySwimmerAndCoachAccount(){
		//dash.clickOnGroups();
		boolean status = group.checkGroupName((input.club+"-"+input.Coach1Name));
		Assert.assertEquals(status, true);
	}
	
	public void verifymembersSwimmerandCoachGroupInSwimmerAccount () throws InterruptedException{
	    boolean swimmerStatus = group.statusOfMembersFromContactList(input.Swimmer1Name+"-"+input.Coach1Name, input.Coach1Name);
	    Assert.assertEquals(swimmerStatus, true);
	
	}

}
