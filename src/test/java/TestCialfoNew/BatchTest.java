package TestCialfoNew;

import java.util.List;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.DriverClass;
import BasePackage.Utility;
import Pages.Atendance;
import Pages.BatchList;
import Pages.DashBoard;
import Pages.LoginForm;
import Pages.SwimmersPage;

public class BatchTest extends DriverClass {
	LoginForm login = new LoginForm();
	DashBoard dash = new DashBoard();
	BatchList batch = new BatchList();
	Utility util = new Utility();
	SwimmersPage swimmers = new SwimmersPage();
	InputValues input = new InputValues ();
	Atendance att = new Atendance ();
	
	
	
	
	//Testing 
	
	@Test (priority = 5)
	public void verifyUnApprovedCoachesStatusInAddBatchPage () throws InterruptedException{
		LoginForm.enterEmailId(input.club);
  		LoginForm.enterPassword(input.ClubPassword);
  		LoginForm.clickSignButton();
  		Thread.sleep(5000);
		dash.clickOnManageBatch();
		batch.clickOnAddbacthButton();
		batch.enterBacthname(input.BatchName1);
		//driver.findElement(By.xpath("html/body/div/app-root/app-manage-batch/div/section[2]/div/div/div/div/form/div[1]/div[2]/div/span/span[1]/span/span[2]/b")).click();
		//driver.findElement
		Thread.sleep(5000);
		driver.findElement(By.id("fff")).click();
		
		//driver.findElement(batch.CoachSelectionInCreateBatch).click();
		
		/*Thread.sleep(5000);
		Assert.assertEquals(batch.coachesStatusFromCreateBatch(input.Coach1), false);*/
	}
	
	/*@Test (priority = 10)
	public void verifyApprovedCoachesStatusInAddbatchPage (){
		driver.findElement(batch.CoachSelectionInCreateBatch).click();
		Assert.assertEquals(batch.coachesStatusFromCreateBatch(input.Coach1), true);
	}
	
	@Test (priority = 15)
	public void verifyUnApprovedSwimmersStatusInAddBatchPage (){
		driver.findElement(batch.SwimmersSelectionInCrreateBatch).click();
		Assert.assertEquals(batch.SwimmersStatusFromCreateBatch(input.Swimmer3), false);
	}
	
	@Test (priority = 20)
	public void verifyApprovedSwimmersStatusInAddBatchPAge(){
		driver.findElement(batch.SwimmersSelectionInCrreateBatch).click();
		Assert.assertEquals(batch.SwimmersStatusFromCreateBatch(input.Swimmer1), true);
	}
	
	@Test (priority = 25)
	
	public void createBatch (){
		driver.navigate().refresh();
		dash.clickOnSwimmers();
		dash.clickOnManageBatch();
		batch.clickOnAddbacthButton();
		batch.enterBacthname(input.BatchName1);
		driver.findElement(batch.CoachSelectionInCreateBatch).click();
		try {
			batch.selectCoachFromCreatebatch(input.Coach1);
			
		}
		catch (Exception e){
			System.out.println(e+"Coach not found, Selecting different coach");
			batch.selectCoachFromCreatebatch(input.Coach2);
		}
		driver.findElement(batch.SwimmersSelectionInCrreateBatch).click();
		try {
		batch.selectCoachFromCreatebatch(input.Swimmer1);
		}
		catch (Exception e){
			System.out.println(e+"Selecting another swimmer");
			batch.selectSwimmersFromCreateBatch(input.Swimmer2);
		}
		batch.clickOnCreateButton();
		System.out.println(batch.getSuccessmessage());
	}*/
	
	/*@Test (priority = 30)
	
	public void batchesAreListedOrNot () {
		batch.getBatchFromList(input.BatchName1);
		Assert.assertEquals(batch.getBatchFromList(input.BatchName1), input.BatchName1);
	}
	
	

	@Test (priority = 35)
	public void batchNameValidationOnCreatebatchPage () throws InterruptedException{
		batch.clickOnAddbacthButton();
		batch.clickOnCreateButton();
		Thread.sleep(500);
		Assert.assertEquals(batch.getBatchnamevalidation(), "This field is required!");
	}
	

	@Test (priority = 40)
	public void coachValidationonCreatebatchPage (){
		batch.enterBacthname(input.BatchName1);
		batch.clickOnCreateButton();
		String coachvalidationError = driver.findElement(batch.CoachValidation).getText();
		Assert.assertEquals(coachvalidationError,"This field is required!");
	}
	

	@Test (priority = 45)
	public void swimmerValidationError () {
		driver.findElement(batch.CoachSelectionInCreateBatch).click();
		batch.selectCoachFromCreatebatch(input.Coach1);
		batch.clickOnCreateButton();
		String swimmervalidationError = driver.findElement(batch.SwimmerValdiation).getText();
		Assert.assertEquals(swimmervalidationError,  "This field is required!");
	}
	
	@Test (priority = 50)
	public void checkSwimmersCountInBatch (){
		driver.navigate().refresh();
		batch.getSwimmersCount(input.BatchName1);
		Assert.assertEquals(batch.getSwimmersCount(input.BatchName1), 1, "swimmer count");
	}
	
	@Test (priority = 54)
	
	public void checkCoachNameOnbatchPageforTheBatch (){
		String coach = batch.getCoachNameFromBatchesList(input.BatchName1);
		Assert.assertEquals(coach, input.Coach1);
	}
	
	@Test (priority = 55)
	public void verifyCreatedbatchDisplaysInBatchPage () throws InterruptedException{
		dash.clickOnSwimmers();
		dash.clickOnManageBatch();
		Thread.sleep(500);
		String batchname = batch.getBatchFromList(input.BatchName1);
		Assert.assertEquals(batchname, input.BatchName1);
	
	public void swimmersInSwimmersPage (){
		//swimmers.search(input.ApprovedSwimmer1Firstname);
		driver.navigate().refresh();
		dash.clickOnSwimmers();
		String swimmerName = swimmers.getStringvalue(input.ApprovedSwimmer1Firstname);
		Assert.assertEquals(swimmerName, input.ApprovedSwimmer1Firstname);
	}
	}
	@Test (priority = 56)
	public void verifyCoachNameismatchignOrNotInbatchpage (){
		System.out.println(batch.getCoachNameFromBatchesList(input.Coach1));
		Assert.assertEquals(batch.getCoachNameFromBatchesList(input.Coach1),input.Coach1);
		
	}
	
	@Test (priority = 60)
	public void verifybatchNameInSwimmerPage () throws InterruptedException{
		driver.navigate().refresh();
		dash.clickOnManageBatch();
		dash.clickOnSwimmers();
		driver.findElement(swimmers.BatchSelection).click();
		Thread.sleep(5000);
		swimmers.batchSelection(input.BatchName1);
		Thread.sleep(500);
		Assert.assertEquals(swimmers.getmatchingBatch(input.Swimmer1EmailID), input.BatchName1);
		
	}
	
	@Test (priority = 65)
	public void verifyCoachNameInSwimmerspage (){
		Assert.assertEquals(swimmers.getmatchingCoachNameforSwimmers(input.Swimmer1), input.Coach1);
	}
	
	
	@Test (priority = 70)
	
    public void verifyBatchListedInAttendancePage() throws InterruptedException{
		dash.clickOnAttendance();
		Thread.sleep(5000);
	     boolean atteaneAtstus = att.batchIsDisplayedOrNot(input.BatchName1);
		Assert.assertEquals(atteaneAtstus, true);	
	}
	
	
	@Test (priority = 75)
	public void verifySwimmersIsBatchPageInAttendancePage () throws InterruptedException{
		if (att.batchIsDisplayedOrNot(input.BatchName1))equals(true);{
			String swimmerName= driver.findElement(By.linkText(input.Swimmer1)).getText();
			Assert.assertEquals(swimmerName, input.Swimmer1);	
		}	
		
	}

	@Test (priority = 80)
	public void assignSwimmersToAnotherBatch () throws InterruptedException{
		dash.clickOnSwimmers();
		Thread.sleep(5000);
		swimmers.clickCheckBoxBasedOnSwimmersName(input.Swimmer1EmailID);
		Thread.sleep(500);
		swimmers.clickOnTranferButton();
		swimmers.selectCoachFromCoacheSelectionInAssignSwimmerPage(input.Coach2);
		swimmers.selectBatchFromBatchesListInAssignSwimmerPage(input.Batchname2);
		driver.findElement(swimmers.TransferButtonInAssignpage).click();
		Thread.sleep(500);
	}
	
	@Test (priority = 85)
	public void swimmersInswimmersListAfterSwimmerTransfer () throws InterruptedException{
		driver.navigate().refresh();
		dash.clickOnSwimmers();
		driver.findElement(swimmers.BatchSelection).click();
		Thread.sleep(5000);
		swimmers.batchSelection(input.Batchname2);
		//swimmers.search(input.);
		Thread.sleep(500);
		String swimmerName = swimmers.getStringvalue(input.Swimmer2EmailID);
		Assert.assertEquals(swimmerName, input.Swimmer2EmailID);
	}
	
	@Test (priority = 80)
	public void veriyBatchNameAfterTransfer () throws InterruptedException{
		dash.clickOnCoach();
		dash.clickOnSwimmers();
		driver.findElement(swimmers.BatchSelection).click();
		swimmers.batchSelection(input.Batchname1);
	}
	@Test (priority = 90)
	public void verifyCoachNameAfterTranfer (){
		dash.clickOnSwimmers();
		Assert.assertEquals(swimmers.getmatchingCoachNameforSwimmers(input.Swimmer1EmailID),input.Coach2);
	}
	
	@Test (priority = 95)
	public void verifyUnApprovedCoachInAssigBatchToCoachSelectionpage () throws InterruptedException{
		dash.clickOnManageBatch();
		batch.selectCheckBoxbasedOnBatchName(input.BatchName1);
		batch.clickOnAssign();
	    driver.findElement(batch.CoachSelectionInCoachAssign).click();
	    Assert.assertEquals(batch.coachStatusInAssignPage(input.Coach3), input.Coach3);
	}
	
	@Test (priority = 100)

	public void assignBatchToCoach () throws InterruptedException{
		batch.selectCheckBoxbasedOnBatchName(input.Batchname2);
		batch.clickOnAssign();
		Thread.sleep(500);
	    driver.findElement(batch.CoachSelectionInCoachAssign).click();
	    Thread.sleep(500);
	    batch.selectCoachesFromAssignpage(input.Coach1);// Approved coach 1
	    driver.findElement(batch.AssignButtonInAssignPage).click(); 
	    Assert.assertEquals(batch.getSuccessmessage(), "Batch Transfered Sucessfully");
	}
	
	
	@Test (priority = 105)
	public void checkCoachNameAfterTranfertheBatch (){
		String currentCoach = batch.getCoachNameFromBatchesList(input.Batchname2);
		String ecpectedCoach = input.Coach1 ;
		Assert.assertEquals(currentCoach, ecpectedCoach);	
	}
	
	@Test (priority = 110)
	public void verifyBatchUnderOnNewCoach (){
		dash.clickOnSwimmers();
		String currentbatch = swimmers.getmatchingBatch(input.Swimmer1EmailID);
		Assert.assertEquals(currentbatch, input.Coach1);
	}
	
	*/
}
