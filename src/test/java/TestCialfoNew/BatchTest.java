package TestCialfoNew;

import java.util.List;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	
	// TC 1 - Verify Unapproved Coaches in Add batch page 
	@Test (priority = 5)
	public void verifyUnApprovedCoachesStatusInAddBatchPage () throws InterruptedException{
		LoginForm.enterEmailId(input.club);
  		LoginForm.enterPassword(input.ClubPassword);
  		LoginForm.clickSignButton();
  		Thread.sleep(5000);
		dash.clickOnManageBatch();
		batch.clickOnAddbacthButton();
		/*batch.enterBacthname(input.BatchName1);
		driver.findElement(batch.CoachSelectionInCreateBatch).click();
		driver.findElement(batch.CoachSearhArea).sendKeys(input.UpApprovedCoach);*/
		batch.coachesStatusFromCreateBatch(input.UpApprovedCoach);
		Assert.assertEquals(batch.coachesStatusFromCreateBatch(input.UpApprovedCoach), false);
	}
	
	// TC 2 - Verify Approved coaches in Add batch page 
	@Test (priority = 10)
	public void verifyApprovedCoachesInAddbatchpage (){

		Assert.assertEquals(batch.coachesStatusFromCreateBatch(input.Coach1Name), true);
	}
	
	
	//TC 3 - Verify UnApproved Swimmers in Add batches page 
	@Test (priority = 15)
	public void verifyUnApprovedSwimmersStatusInAddBatchPage (){
		/*driver.findElement(batch.SwimmersSelectionInCrreateBatch).click();
		driver.findElement(batch.SwimmerSearchArea).sendKeys(input.UnApprovedSwimmer);*/
		boolean status = batch.SwimmersStatusFromCreateBatch(input.UnApprovedSwimmer);
		Assert.assertEquals(status, false);
	}
	
	//TC 4 - Verify Approved swimmers in Create batch Page 
	@Test (priority = 20)
	public void verifyApprovedSwimmersStatusInAddBatchPAge(){
		dash.clickOnCoach();
		dash.clickOnSwimmers();
		/*driver.findElement(batch.SwimmerSearchArea).clear();
		driver.findElement(batch.SwimmerSearchArea).sendKeys(input.Swimmer1Name);*/
		boolean status = batch.SwimmersStatusFromCreateBatch(input.Swimmer1Name);
		Assert.assertEquals(status, true);
	}
	
	// TC 4 - Verify Create batch 
	@Test (priority = 25)
	
	public void createBatch (){
		driver.navigate().refresh();
		dash.clickOnSwimmers();
		dash.clickOnManageBatch();
		batch.clickOnAddbacthButton();
		batch.enterBacthname(input.BatchName1);
		//driver.findElement(batch.CoachSelectionInCreateBatch).click();
		try {
			batch.selectCoachFromCreatebatch(input.Coach1Name);
			
		}
		catch (Exception e){
			System.out.println(e+"Coach not found, Selecting different coach");
			//batch.selectCoachFromCreatebatch(input.);
		}
		//driver.findElement(batch.SwimmersSelectionInCrreateBatch).click();
		try {
		batch.selectCoachFromCreatebatch(input.Swimmer1Name);
		}
		catch (Exception e){
			System.out.println(e+"Selecting another swimmer");
			//batch.selectSwimmersFromCreateBatch(input.Swimmer2);
		}
		batch.clickOnCreateButton();
		System.out.println(batch.getSuccessmessage());
	}
	

	
	//TC 5 - Verify batches in create batch page


	@Test (priority = 56)
	public void verifyCoachNameismatchignOrNotInbatchpage (){
		System.out.println(batch.getCoachNameFromBatchesList(input.Coach1Name));
		Assert.assertEquals(batch.getCoachNameFromBatchesList(input.Coach1Name),input.Coach1Name);
		
	}
	
	
	// TC 13 -  Verify batch in Swimmers page 
	@Test (priority = 60)
	public void verifybatchNameInSwimmerPage () throws InterruptedException{
		driver.navigate().refresh();
		dash.clickOnManageBatch();
		dash.clickOnSwimmers();

		boolean status = swimmers.checkBatchStatus(input.BatchName1);
		Assert.assertEquals(status,true);
	}
	@Test (priority = 65)
	public void verifyCoachNameInSwimmerspage (){
		Assert.assertEquals(swimmers.getmatchingCoachNameforSwimmers(input.Swimmer1EmailID), input.Coach1Name);
	}
	
	
	@Test (priority = 70)
	
    public void verifyBatchListedInAttendancePage() throws InterruptedException{
		dash.clickOnAttendance();
		Thread.sleep(5000);
	     boolean atteaneAtstus = att.batchIsDisplayedOrNot(input.BatchName1);
		Assert.assertEquals(atteaneAtstus, true);	
	}
	
	
	@Test (priority = 75)
	public void verifySwimmersInBatchPageInAttendancePage () throws InterruptedException{
		if (att.batchIsDisplayedOrNot(input.BatchName1))equals(true);{
			String swimmerName= driver.findElement(By.linkText(input.Swimmer1Name)).getText();
			Assert.assertEquals(swimmerName, input.Swimmer1Name);	
		}	
		
	}
	
	// TC 15 - verify Swimmer in coach profile page 
	public void verifySwimmersInCoachProfilePage (){
		dash.clickOnCoach();
		driver.findElement(By.linkText(input.Coach1Name)).click();
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		boolean swimmerStatus = driver.findElement(By.linkText(input.Swimmer1Name)).isDisplayed();
		Assert.assertEquals(swimmerStatus, true);
		
	}

	
	//TC 16 - Transfer swimmer
	@Test (priority = 80)
	public void assignSwimmersToBatch () throws InterruptedException{
		dash.clickOnSwimmers();
		Thread.sleep(5000);
		swimmers.clickCheckBoxBasedOnSwimmersName(input.Swimmer2EmailID);
		Thread.sleep(500);
		swimmers.clickOnTranferButton();
		swimmers.selectCoachFromCoacheSelectionInAssignSwimmerPage(input.Coach1Name);
		swimmers.selectBatchFromBatchesListInAssignSwimmerPage(input.BatchName1);
		driver.findElement(swimmers.TransferButtonInAssignpage).click();
		Thread.sleep(500);
	}
	
	// TC - 17 Verify Swimmers in Swimmerslist after Transfer 
	@Test (priority = 85)
	public void swimmersInswimmersListAfterSwimmerTransfer () throws InterruptedException{
		driver.navigate().refresh();
		dash.clickOnSwimmers();
		//driver.findElement(swimmers.BatchSelection).click();
		swimmers.batchSelection(input.BatchName1);
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
		swimmers.batchSelection(input.BatchName1);
	}
	public void verifyCoachNameAfterTranfer (){
		dash.clickOnSwimmers();
		String coach = swimmers.getmatchingCoachNameforSwimmers(input.Swimmer2EmailID);
		Assert.assertEquals(coach,input.Coach1Name);
	}
	

	//TC 19 - 
	public void verifyCoachNameInSwimmerspageafterTranfer (){
		Assert.assertEquals(swimmers.getmatchingCoachNameforSwimmers(input.Swimmer2EmailID), input.Coach1Name);
}
	
	public void verifyAttendanePecenatgeofUnAssignedSwimmer (){
		String per = swimmers.getAtendancePercentage(input.Swimmer2EmailID);
		Assert.assertEquals(per, "0.0%");
		
	}
	public void verifyBatchname (){
		String batchname = swimmers.getmatchingBatch(input.Swimmer2EmailID);
		Assert.assertEquals(batchname,input.BatchName1);
	}
	
	public void checkSwimmersCountInBatch1 (){
		driver.navigate().refresh();
		dash.clickOnSwimmers();
		dash.clickOnManageBatch();
		batch.getSwimmersCount(input.BatchName1);
		Assert.assertEquals(batch.getSwimmersCount(input.BatchName1), "2");
	}
	
	
	
	
	@Test (priority = 100)

	public void assignBatchToCoach () throws InterruptedException{
		batch.selectCheckBoxbasedOnBatchName(input.BatchName1);
		batch.clickOnAssign();
		Thread.sleep(500);
	    batch.selectCoachesFromAssignpage(input.Coach2Name);// Approved coach 1
	    driver.findElement(batch.AssignButtonInAssignPage).click(); 
	    Assert.assertEquals(batch.getSuccessmessage(), "Batch Transfered Sucessfully");
	}
	
	
	@Test (priority = 105)
	public void checkCoachNameAfterTranferTheBatch (){
		String currentCoach = batch.getCoachNameFromBatchesList(input.Batchname2);
		String ecpectedCoach = input.Coach2Name ;
		Assert.assertEquals(currentCoach, ecpectedCoach);	
	}
	
	@Test (priority = 110)
	public void verifyBatchUnderOnNewCoach (){
		dash.clickOnSwimmers();
		String currentbatch = swimmers.getmatchingBatch(input.Swimmer2EmailID);
		Assert.assertEquals(currentbatch, input.Coach2Name);
	}
	
	public void verifyCoachNamefortheSwimmer (){
		dash.clickOnSwimmers();
		String coachName = swimmers.getmatchingCoachNameforSwimmers(input.Swimmer1EmailID);
		Assert.assertEquals(coachName,input.Coach2Name);
	}
	
	public void verifyAttendanePecenatgeOfSwimmer (){
		String per = swimmers.getAtendancePercentage(input.Swimmer1EmailID);
		Assert.assertEquals(per, "0.0%");
	}
	
	public void verifySwimmersInOLDCoachProfileAfterTransfer (){
		dash.clickOnCoach();
		driver.findElement(By.linkText(input.Coach1Name)).click();
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		boolean swimmerStatus = driver.findElement(By.linkText(input.Swimmer1Name)).isDisplayed();
		Assert.assertEquals(swimmerStatus, false);
		
	}
	public void verifySwimmersInNewCoachProfilePage (){
		dash.clickOnCoach();
		driver.findElement(By.linkText(input.Coach1Name)).click();
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		boolean swimmerStatus = driver.findElement(By.linkText(input.Swimmer1Name)).isDisplayed();
		Assert.assertEquals(swimmerStatus, true);
	}
	
	public void verifySwimmersInCoachFilter () throws InterruptedException{
		dash.clickOnSwimmers();
		swimmers.coachSelection(input.Coach2Name);
		boolean status = driver.findElement(By.linkText(input.Swimmer1Name)).isDisplayed();
		Assert.assertEquals(status, true);
	}
	
	public void verifycoachFilterInBatchPageCase1 (){
		dash.clickOnManageBatch();
		batch.mainCoachSelection(input.Coach2Name);
		boolean status = driver.findElement(By.linkText(input.BatchName1)).isDisplayed();
		Assert.assertEquals(status, true);
	}
	
	public void verifycoachFilterInBatchPageCase2 (){
		dash.clickOnManageBatch();
		batch.mainCoachSelection(input.Coach1Name);
		boolean status = driver.findElement(By.linkText(input.BatchName1)).isDisplayed();
		Assert.assertEquals(status, true);
	}
	
	
}
