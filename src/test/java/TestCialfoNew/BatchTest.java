package TestCialfoNew;

import java.util.List;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.DriverClass;
import BasePackage.Utility;
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
	
	
	
	
	
	public void verifyUnApprovedCoachesStatusInAddBatchPage (){
		dash.clickOnManageBatch();
		batch.clickOnAddbacthButton();
		batch.enterBacthname(input.batchName);
		driver.findElement(batch.CoachSelectionInCreateBatch).click();
		Assert.assertEquals(batch.coachesStatusFromCreateBatch(input.UnApprovedCoach), false);
	}
	
	public void verifyApprovedCoachesStatusInAddbatchPage (){
		driver.findElement(batch.CoachSelectionInCreateBatch).click();
		Assert.assertEquals(batch.coachesStatusFromCreateBatch(input.UnApprovedCoach1), true);
	}
	
	public void verifyUnApprovedSwimmersStatusInAddBatchPage (){
		driver.findElement(batch.SwimmersSelectionInCrreateBatch).click();
		Assert.assertEquals(batch.SwimmersStatusFromCreateBatch(input.UnApprovedSwimmer), false);
	}
	
	public void verifyApprovedSwimmersStatusInAddBatchPAge(){
		driver.findElement(batch.SwimmersSelectionInCrreateBatch).click();
		Assert.assertEquals(batch.SwimmersStatusFromCreateBatch(input.UnApprovedSwimmer1), true);
	}
	
	public void createBatch (){
		driver.navigate().refresh();
		dash.clickOnSwimmers();
		dash.clickOnManageBatch();
		batch.clickOnAddbacthButton();
		batch.enterBacthname(input.batchName);
		driver.findElement(batch.CoachSelectionInCreateBatch).click();
		try {
			batch.selectCoachFromCreatebatch(input.UnApprovedCoach2);
			
		}
		catch (Exception e){
			System.out.println(e+"Coach not found, Selecting different coach");
			batch.selectCoachFromCreatebatch(input.ApprovedCoach1);
		}
		driver.findElement(batch.SwimmersSelectionInCrreateBatch).click();
		try {
		batch.selectCoachFromCreatebatch(input.UnApprovedSwimmer1);
		}
		catch (Exception e){
			System.out.println(e+"Selecting another swimmer");
			batch.selectSwimmersFromCreateBatch(input.ApprovedSwimmer1);
		}
		batch.clickOnCreateButton();
		System.out.println(batch.getSuccessmessage());
	}
	
	public void batchesAresListedOrNot () {
		batch.getBatchFromList(input.batchName);
		Assert.assertEquals(batch.getBatchFromList(input.batchName), input.batchName);
	}
	
	public void batchNameValidationOnCreatebatchPage () throws InterruptedException{
		batch.clickOnAddbacthButton();
		batch.clickOnCreateButton();
		Thread.sleep(500);
		Assert.assertEquals(batch.getBatchnamevalidation(), "This field is required!");
	}
	
	public void coachValidationonCreatebatchPage (){
		batch.enterBacthname("dfhgdhf");
		batch.clickOnCreateButton();
		String coachvalidationError = driver.findElement(batch.CoachValidation).getText();
		Assert.assertEquals(coachvalidationError,"This field is required!");
	}
	public void swimmerValidationError () {
		driver.findElement(batch.CoachSelectionInCreateBatch).click();
		batch.selectCoachFromCreatebatch(input.UnApprovedCoach1);
		batch.clickOnCreateButton();
		String swimmervalidationError = driver.findElement(batch.SwimmerValdiation).getText();
		Assert.assertEquals(swimmervalidationError,  "This field is required!");
	}
	
	public void checkSwimmersCountInBatch (){
		driver.navigate().refresh();
		batch.getSwimmersCount(batch.batchName);
		Assert.assertEquals(batch.getSwimmersCount(batch.batchName), 1, "swimmer count");
	}
	
	public void assignBatchToCoach () throws InterruptedException{
		batch.selectCheckBoxbasedOnBatchName(batch.batchName);
		batch.clickOnAssign();
	    driver.findElement(batch.CoachSelectionInCoachAssign);
	    batch.selectCoachesFromAssignpage(input.UnApprovedCoach1);
	    driver.findElement(batch.AssignButtonInAssignPage).click(); 
	    Assert.assertEquals(batch.getSuccessmessage(), "Batch Transfered Sucessfully");
	}
	
	public void checkCoachNameAfterTranfertheBatch (){
		String currentCoach = batch.getCoachNameFromBatchesList(batch.batchName);
		String ecpectedCoach = input.CoachAfterApproving;
		Assert.assertEquals(currentCoach, ecpectedCoach);	
	}
	
	

	/*@Test(priority = 1)
	public void addingBatch() throws InterruptedException {
		login.enterEmailId(input.club);
		login.enterPassword(input.ClubPassword);
		login.clickSignButton();
		dash.clickOnManageBatch();
		batch.clickOnAddbacthButton();
		batch.enterBacthname(input.batchName);
		driver.findElement(batch.CoachSelection).click();
		Thread.sleep(500);
		WebElement coachlist = driver.findElement(batch.CoachResult);
		batch.selectCoachFromCoachList(coachlist,input.coach);
		// driver.findElement(By.xpath("//*[contains(@id,'rajajicoach')]")).click();
		Thread.sleep(5000);
		driver.findElement(batch.PlayerSelection).click();
		WebElement swimmersLilst = driver.findElement(batch.SwimmersResult);
		batch.selectSwimmersFromCoachList(swimmersLilst,input.swimmer);
		batch.clickOnCreateButton();
		String SuccessMessage = batch.getSuccessmessage();
		Assert.assertEquals(SuccessMessage, "Batch Added Sucessfully");
	}

	@Test(priority = 2)
	public void checkBatchIsAddedOrNot() {
		batch.getBatchFromList(input.batchName);
	}

	@Test(priority = 3)
	public void checkCoachIsmatchingorNotInBatchesPage() throws InterruptedException {
		
		 * login.enterEmailId("swimlife@gmail.com");
		 * login.enterPassword("12345678"); login.clickSignButton();
		 * dash.clickOnManageBatch(); batch.searchBatch("Automation");
		 * Thread.sleep(500);
		 
		WebElement batchestable = driver.findElement(batch.BatchTable);
		List<WebElement> batchRow = driver.findElements(batch.BatchRow);
		batchRow.size();

		for (int i = 0; i < batchRow.size(); i++) {
			List<WebElement> batchCol = batchRow.get(i).findElements(batch.BacthColumn);
			batchCol.size();

			for (int j = 0; j < batchCol.size(); j++) {
				String batchesNames = batchCol.get(j).getText();
				System.err.println(batchesNames);
				if (batchesNames.equalsIgnoreCase(input.batchName)) {
					String xpath1 = ".//*[@id='batcheslist']/tbody/tr[";
					String xpath2 = "]/td[5]";
					String actualCoachname = driver.findElement(By.xpath(xpath1 + i + xpath2)).getText();
					// Add coachname for Asert
					String expectedResult = input.coach;
					Assert.assertEquals(actualCoachname, expectedResult);

				}

			}
		}
	}

	@Test(priority = 4)
	public void searchBatchInbatchesPage() throws InterruptedException {
		
		 * login.enterEmailId("swimlife@gmail.com");
		 * login.enterPassword("12345678"); login.clickSignButton();
		 
		// dash.clickOnManageBatch();
		driver.navigate().refresh();
		batch.searchBatch(input.batchName);
		Thread.sleep(500);
		batch.getBatchFromList(input.batchName);
	}

	@Test(priority = 5)
	public void checkBatchNamevalidation() throws InterruptedException {
		
		 * login.enterEmailId("swimlife@gmail.com");
		 * login.enterPassword("12345678"); login.clickSignButton();
		 
		// dash.clickOnManageBatch();
		driver.navigate().refresh();
		batch.clickOnAddbacthButton();
		batch.enterBacthname("");
		driver.findElement(batch.CoachSelection).click();
		
		 * driver.findElement(By.xpath("//*[contains(@id,'rajajicoach')]")).
		 * click(); Thread.sleep(5000);
		 * driver.findElement(batch.PlayerSelection).click();
		 * driver.findElement(By.xpath("//*[contains(@id,'Ipadswimmer')]")).
		 * click();
		 
		batch.clickOnCreateButton();
		Thread.sleep(500);
		String actualSuccessMessage = batch.getBatchnamevalidation();
		String expectedSucesMessage = "This field is required!";
		Assert.assertEquals(actualSuccessMessage, expectedSucesMessage);
	}

	@Test(priority = 5)
	public void checkCoachNameisMatchingOrNotInSwimmersPage() throws InterruptedException {

		
		 * login.enterEmailId("swimlife@gmail.com");
		 * login.enterPassword("12345678"); login.clickSignButton();
		 
		dash.clickOnSwimmers();
		swimmers.search(input.swimmer);
		Thread.sleep(500);
		WebElement swimmertable = driver.findElement(swimmers.SwimmersTable);
		List<WebElement> swimRow = driver.findElements(swimmers.SwimmersRow);
		swimRow.size();

		for (int i = 0; i < swimRow.size(); i++) {
			List<WebElement> swimcol = swimRow.get(i).findElements(swimmers.SwimmersColoumn);
			swimcol.size();

			for (int j = 0; j < swimcol.size(); j++) {
				String swimmernames = swimcol.get(j).getText();
				System.err.println(swimmernames);
				if (swimmernames.equalsIgnoreCase(input.swimmer)) {
					String xpath1 = ".//*[@id='swimmertable']/tbody/tr[";
					String xpath2 = "]/td[9]";
					String actualCoachname = driver.findElement(By.xpath(xpath1 + i + xpath2)).getText();
					String expectedResult = input.coach;
					Assert.assertEquals(actualCoachname, expectedResult);

				}

			}
		}

	}

	@Test(priority = 6)

	public void checkBatchNameIsMaatchingOrNotInSwimmersPage() throws InterruptedException {

		
		 * login.enterEmailId("swimlife@gmail.com");
		 * login.enterPassword("12345678"); login.clickSignButton();
		 
		dash.clickOnSwimmers();
		swimmers.search(input.swimmer);
		Thread.sleep(500);
		swimmers.getmatchingBatch(input.swimmer,input.coach);
		WebElement swimmerstable = driver.findElement(swimmers.SwimmersTable);
		List<WebElement> swimRow = driver.findElements(swimmers.SwimmersRow);
		swimRow.size();

		for (int i = 0; i < swimRow.size(); i++) {
			List<WebElement> swimcol = swimRow.get(i).findElements(swimmers.SwimmersColoumn);
			swimcol.size();

			for (int j = 0; j < swimcol.size(); j++) {
				String swimmernames = swimcol.get(j).getText();
				System.err.println(swimmernames);
				if (swimmernames.equalsIgnoreCase(input.swimmer)) {
					String xpath1 = ".//*[@id='swimmertable']/tbody/tr[";
					String xpath2 = "]/td[8]";
					String actualCoachname = driver.findElement(By.xpath(xpath1 + i + xpath2)).getText();
					String expectedBatchname = input.batchName;
					Assert.assertEquals(actualCoachname, expectedBatchname);

				}

			}
		}
	}

	
	//Tranfring coach from Coach2
	@Test(priority = 7)
	public void tranferCoach() throws InterruptedException {
		
		 * login.enterEmailId("swimlife@gmail.com");
		 * login.enterPassword("12345678"); login.clickSignButton();
		 
		dash.clickOnManageBatch();
		// batch.searchBatch("Automation");
		batch.selectCheckBoxbasedOnBatchName(input.batchName);
		batch.clickOnTranferButton();
		Thread.sleep(500);
		String paranetwindowhandle = driver.getWindowHandle();
		System.out.println(paranetwindowhandle);
		driver.switchTo().window(paranetwindowhandle);
		driver.findElement(batch.CoachSelectionInTranferBatch).click();
		Thread.sleep(500);
		WebElement coachresult = driver.findElement(batch.CoachResult);

		batch.selectCoachFromCoachList(coachresult, input.coach2);

		batch.clickOnSubmitButton();
		Thread.sleep(500);
		batch.getSuccessmessage();
		System.out.println(batch.getSuccessmessage());

	}

	@Test(priority = 8)
	public void checkCoachnameInBatchespageAfterTranfer() {
		
												 * login.enterEmailId(
												 * "swimlife@gmail.com");
												 * login.enterPassword(
												 * "12345678");
												 * login.clickSignButton();
												 
		driver.navigate().refresh();
		WebElement batchestable = driver.findElement(batch.BatchTable);
		List<WebElement> swimRow = driver.findElements(batch.BatchRow);
		swimRow.size();

		for (int i = 0; i < swimRow.size(); i++) {
			List<WebElement> swimcol = swimRow.get(i).findElements(batch.BacthColumn);
			swimcol.size();

			for (int j = 0; j < swimcol.size(); j++) {
				String batchesNames = swimcol.get(j).getText();
				System.err.println(batchesNames);
				if (batchesNames.equalsIgnoreCase(input.batchName)) {
					String xpath1 = ".//*[@id='batcheslist']/tbody/tr[";
					String xpath2 = "]/td[5]";
					String actualCoachname = driver.findElement(By.xpath(xpath1 + i + xpath2)).getText();
					String expectedResult = input.coach2;
					Assert.assertEquals(actualCoachname, expectedResult);

				}

			}
		}

	}

	@Test(priority = 9)
	public void checkCoachNameIsSwimmersPageAftertransfer() throws InterruptedException {

		
		 * login.enterEmailId("swimlife@gmail.com");
		 * login.enterPassword("12345678"); login.clickSignButton();
		 
		dash.clickOnSwimmers();
		swimmers.search(input.swimmer);
		Thread.sleep(500);
		WebElement swimmertable = driver.findElement(swimmers.SwimmersTable);
		List<WebElement> swimRow = driver.findElements(swimmers.SwimmersRow);
		swimRow.size();

		for (int i = 0; i < swimRow.size(); i++) {
			List<WebElement> swimcol = swimRow.get(i).findElements(swimmers.SwimmersColoumn);
			swimcol.size();

			for (int j = 0; j < swimcol.size(); j++) {
				String swimmernames = swimcol.get(j).getText();
				System.err.println(swimmernames);
				if (swimmernames.equalsIgnoreCase(input.swimmer)) {
					String xpath1 = ".//*[@id='swimmertable']/tbody/tr[";
					String xpath2 = "]/td[9]";
					String actualCoachname = driver.findElement(By.xpath(xpath1 + i + xpath2)).getText();
					String expectedResult = input.coach2;
					Assert.assertEquals(actualCoachname, expectedResult);

				}

			}
		}

	}
	
	 * @AfterMethod public void afterMathos(){
	 * driver.findElement(By.xpath("//a[@href='/dashboard']")).click(); }
	 
	
	
	//Tranfering Swimmers2 to Coach2
	public void tranferSwimmersToBatch () throws InterruptedException
	{
		driver.navigate().refresh();
		driver.findElement(swimmers.BatchSelection).click();
		WebElement batchResult = driver.findElement(swimmers.batchresults);
		swimmers.batchSelection(batchResult, "Un Assigned");
		try 
		{
		swimmers.clickCheckBoxBasedOnSwimmersName(input.swimmer2);
		driver.findElement(swimmers.BatchResultsInTransferSwimmerpage);
		WebElement batchResult1 = driver.findElement(swimmers.BatchResultsInTransferSwimmerpage);
		batch.selectCoachFromCoachList(batchResult1,input.coach2);
		driver.findElement(swimmers.SubmitButonInTransferSwimmerPage).click();
		
		
		}
		catch(Exception e){
			System.out.println("swimmer not found");
		}
	}
	public void checkSwimmerAfterTransferingUnAssigned() throws InterruptedException
	{
		driver.navigate().refresh();
		WebElement batchselection = driver.findElement(swimmers.BatchSelection);
		swimmers.batchSelection(batchselection, "Un Assigned");
		Thread.sleep(500);
		boolean status = swimmers.getBooleanvalue(input.swimmer2);
		Assert.assertEquals(status, false);
		
	}
	*/
}
