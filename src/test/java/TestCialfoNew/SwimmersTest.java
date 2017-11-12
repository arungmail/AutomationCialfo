package TestCialfoNew;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.DriverClass;
import BasePackage.Utility;
import Pages.BatchList;
import Pages.CoachesPage;
import Pages.DashBoard;
import Pages.LoginForm;
import Pages.ProfilePage;
import Pages.SwimmersPage;

public class SwimmersTest extends DriverClass {
	LoginForm login = new LoginForm();
	DashBoard dash = new DashBoard();
	Utility util = new Utility();
	SwimmersPage swimmers = new SwimmersPage();
	BatchList batch = new BatchList();
	DriverClass driverclass = new DriverClass();
	InputValues input = new InputValues();
	CoachesPage coach = new CoachesPage ();
	ProfilePage profile = new ProfilePage ();
	
	
	
	
	@BeforeMethod
	public void refreshandclickOnSwimmers () throws InterruptedException{
		driver.navigate().refresh();
		dash.clickOnSwimmers();
		Thread.sleep(5000);
		
	}
	
	
	@Test(priority=10)
	
	//TC 1 - Adding swimmer
	public void addSwimmer () throws InterruptedException{
		LoginForm.enterEmailId(input.club);
  		LoginForm.enterPassword(input.ClubPassword);
  		LoginForm.clickSignButton(); 
  		Thread.sleep(5000);
		driver.navigate().refresh();
		dash.clickOnSwimmers();
		driver.findElement(swimmers.AddSwimmerButton).click();
		swimmers.addSwimmer("Arun", input.Swimmer1EmailID, "Sel", "SwimmerOne", "Nichi123", "Nichi123", "8753659888", "Bangalore");	
	}
	
	@Test(priority=10)
	
	//TC 2 - Add swimmer validation 
	public void addSwimmerValidationError (){
		driver.findElement(swimmers.AddSwimmerButton).click();
			
	}
	
	//TC 3 - Verifying swimmer in 
	public void verifyswimmerInUnassignedList () throws InterruptedException{
		driver.findElement(swimmers.BatchSelection).click();
		driver.findElement(swimmers.Searcharea).sendKeys("Un Assigned");
		swimmers.batchSelection("Un Assigned");
		swimmers.search(input.Swimmer1EmailID);
		boolean swiimerStatus = swimmers.getBooleanvalue(input.Swimmer1EmailID);
		Assert.assertEquals(swiimerStatus, true);
	}
	
	//TC 4 - Add Coach
	public void addCoach (){
		dash.clickOnCoach();
        driver.findElement(coach.AddCoachButton).click();
        coach.addCoach("coach", input.Coach1EmailID, "Sel", "CoachOne", "Nichi123", "Nichi123", "8977445566", "Bangalore");
		
	}
	
	//TC 5- Verify Added Coaches in Coaches Page 
	public void verifyAddedCoachInCoachesPage (){
		dash.clickOnCoach();
		boolean coachStatus = coach.coachStatusInCoachesPage(input.Coach1EmailID);
		Assert.assertEquals(coachStatus, true);
	}
	
	//TC 6 Verify Coaches in Swimmers coach selection page 
	public void verifyCoachInSwimmersCoachSelectionPage () throws InterruptedException{
		driver.findElement(swimmers.CoachSelection).click();
		swimmers.checkCoachStatus(input.Coach1Name);
		Assert.assertEquals(swimmers.checkCoachStatus(input.Coach1Name), true);
	}
	
	// TC 7 - Verify coach name in unassign swimmer
	public void verifyCoachNameforUnAssignedSwimmer (){
		dash.clickOnSwimmers();
		String coachName = swimmers.getmatchingCoachNameforSwimmers(input.Swimmer1EmailID);
		Assert.assertEquals(coachName, "");
	}
	
	public void verifyBatchname (){
		String batchname = swimmers.getmatchingBatch(input.Swimmer1EmailID);
		Assert.assertEquals(batchname, "Un Assigned");
	}
	
	//TC 8 - Verify Attendance Percentage of UnAssignswimmer
	public void verifyAttendanePecenatgeofUnAssignedSwimmer (){
		String per = swimmers.getAtendancePercentage(input.Swimmer1EmailID);
		Assert.assertEquals(per, "0.0%");
		
	}
	
	//TC - 9 Verify Swimmers Profile
	public void verifySwimmerProfileFromSwimmersPage (){
		dash.clickOnSwimmers();
		driver.findElement(By.partialLinkText(input.Swimmer1Name)).click();
		String profileName = driver.findElement(profile.ProfleNameInOverViewpage).getText();
		System.out.println(profileName);
		Assert.assertTrue(profileName.contains(input.Swimmer1Name));
	}
	
	//TC - 10 Verify Swimmers email id in Profile page 
	public void verifySwimmersEmailIdInProfilePage (){
		String emailId = driver.findElement(By.linkText(input.Swimmer1EmailID)).getText();
		Assert.assertEquals(emailId, input.Swimmer1EmailID);
	}
	
	//TC - 11  Verify coach Profile 
	public void verifyCoachProfileFromSwimmersPage (){
		dash.clickOnSwimmers();
		driver.findElement(By.linkText(input.Coach1Name)).click();
		String coachname = driver.findElement(profile.ProfleNameInOverViewpage).getText();
		Assert.assertEquals(coachname, input.Coach1Name);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



}

	
	// Verifying approved swimmers available in Unassigned list
	
	/*@Test(priority=10)
	public void verifyApprovedSwimmersDisplyedInUnAssignedList() throws InterruptedException {
		LoginForm.enterEmailId(input.club);
  		LoginForm.enterPassword(input.ClubPassword);
  		LoginForm.clickSignButton(); 
  		Thread.sleep(5000);
		driver.navigate().refresh();
		dash.clickOnSwimmers();
		Thread.sleep(5000);
		WebElement batchselection = driver.findElement(swimmers.BatchSelection);
		batchselection.click();
		swimmers.batchSelection("Un Assigned");
		Thread.sleep(500);
		swimmers.search(input.Swimmer1EmailID);
		Thread.sleep(500);
		String actualSwimmer = driver.findElement(By.linkText(input.Swimmer1EmailID)).getText();
		// String expectedSwimmer = input.swimmer;
		Assert.assertEquals(actualSwimmer, input.Swimmer1EmailID);
	}

	public void verifyBatchesAreListedOrNot() throws InterruptedException {
		WebElement batchSelection = driver.findElement(swimmers.BatchSelection);
		batchSelection.click();
		Thread.sleep(500);
		swimmers.batchSelection("xxx");

		// swimmers.checkBatchStatus("xxxx");
		Assert.assertEquals(swimmers.checkBatchStatus("xxx"), true);

	}
	
	@Test(priority=15)

	public void checkUnApprovedCoachinCoachSelection() throws InterruptedException {
		WebElement coachSelection = driver.findElement(swimmers.CoachSelection);
		coachSelection.click();
		Thread.sleep(500);
		//swimmers.coachSelection("");
		Assert.assertEquals(swimmers.checkCoachStatus(input.Coach3EmailID), false);

	}
	
	@Test(priority=20)

	public void checkApprovedCoachesInCoachesList() throws InterruptedException {
		WebElement coachSelection = driver.findElement(swimmers.CoachSelection);
		coachSelection.click();
		Thread.sleep(500);
		swimmers.coachSelection("");
		Assert.assertEquals(swimmers.checkCoachStatus(input.UnApprovedCoach1), true);

	}
	
	@Test(priority=25)

	public void checkUnAssignedSwimmerAttendancePercenatge() throws InterruptedException {
		WebElement batchselection = driver.findElement(swimmers.BatchSelection);
		batchselection.click();
		swimmers.batchSelection("Un Assigned");
		Thread.sleep(500);
		swimmers.search(input.Swimmer1AfterApprovng);
		Thread.sleep(500);
		// swimmers.getAtendancePercentage(input.SwimmerAfterApprovng);
		Assert.assertEquals(swimmers.getAtendancePercentage(input.Swimmer1EmailID), "0%");
	}
	
	@Test(priority=30)

	public void addSwimmerFromSwimmerPage() {
		driver.findElement(swimmers.AddSwimmerButton).click();
		driver.findElement(swimmers.ScreenName).sendKeys("xxxx");
		driver.findElement(swimmers.Firstname).sendKeys("");
		driver.findElement(swimmers.EmailId).sendKeys(input.Swimmer2EmailID);
		driver.findElement(swimmers.Lastname).sendKeys("xxx");
		driver.findElement(swimmers.Password).sendKeys("dfdsfdf");
		driver.findElement(swimmers.ConfirmPassword).sendKeys("dhfdsfgdshf");
		driver.findElement(swimmers.PhoneNumber).sendKeys("xxxx");
		driver.findElement(swimmers.Location).sendKeys("sfafas");
		WebElement year = driver.findElement(swimmers.Year);
		year.click();
		util.selectValueByValue(year, "2000");
		WebElement month = driver.findElement(swimmers.Month);
		month.click();
		util.selectValueByValue(month, "4");
		WebElement day = driver.findElement(swimmers.Day);
		day.click();
		util.selectValueByValue(day, "28");
		driver.findElement(swimmers.AddSwimmerButton).click();
		
	}
	@Test(priority=35)

	public void verifySwimmerIsAvailableOrNotOnUnassigned() throws InterruptedException {
		WebElement batchselection = driver.findElement(swimmers.BatchSelection);
		batchselection.click();
		swimmers.batchSelection("Un Assigned");
		Thread.sleep(500);
		swimmers.search(input.Swimmer1AfterApprovng);
		Thread.sleep(500);
		String actualSwimmer = driver.findElement(By.linkText(input.Swimmer2EmailID)).getText();
		// String expectedSwimmer = input.swimmer;
		Assert.assertEquals(actualSwimmer,input.Swimmer2EmailID);
	}
	

	@Test(priority=40)
	public void checkvalidationError (){
		driver.findElement(swimmers.AddSwimmerButton).click();
		driver.findElement(swimmers.RegisterButton).click();
		Assert.assertEquals(swimmers.getAnValidationError(swimmers.NameValidation), "This field is required!");
		Assert.assertEquals(swimmers.getAnValidationError(swimmers.FirstNameValidation), "This field is required!");
		Assert.assertEquals(swimmers.getAnValidationError(swimmers.LastNameValidation), "This field is required!");
		Assert.assertEquals(swimmers.getAnValidationError(swimmers.Password), "This field is required!");
		Assert.assertEquals(swimmers.getAnValidationError(swimmers.ConfirmPasswordValidation), "This field is required!");
		//Assert.assertEquals(swimmers., expected);
		
	}
	
	@Test(priority=45)
	
	public void verifyDOBValidationError1 (){
		driver.findElement(swimmers.AddSwimmerButton).click();
		driver.findElement(swimmers.ScreenName).sendKeys("ssaa");
		driver.findElement(swimmers.Firstname);
		driver.findElement(swimmers.EmailId).sendKeys("xxxxx");
		driver.findElement(swimmers.Lastname).sendKeys("xxx");
		driver.findElement(swimmers.Password).sendKeys("dfdsfdf");
		driver.findElement(swimmers.ConfirmPassword).sendKeys("dhfdsfgdshf");
		driver.findElement(swimmers.PhoneNumber).sendKeys("xxxx");
		driver.findElement(swimmers.Location).sendKeys("sfafas");
		WebElement year = driver.findElement(swimmers.Year);
		year.click();
	          try{
	        	  util.selectValueByValue(year, "50000");
	          }
	          catch (Exception e){
	        	  System.out.println(e+"gdsdgfhdsghsd");
	          }
		WebElement month = driver.findElement(swimmers.Month);
		month.click();
		util.selectValueByValue(month, "4");
		WebElement day = driver.findElement(swimmers.Day);
		day.click();
		util.selectValueByValue(day, "28");
		driver.findElement(swimmers.RegisterButton).click();
		Assert.assertEquals(swimmers.DOBValidation, "Please select Date of birth");
	}
	
	
	@Test(priority=50)
	public void verifyDOBValidationError2 (){
		
		WebElement year = driver.findElement(swimmers.Year);
		WebElement month = driver.findElement(swimmers.Month);
		WebElement day = driver.findElement(swimmers.Day);
		util.selectValueByValue(day, "1990");
		util.selectValueByValue(month, "");
		util.selectValueByValue(year, "28");
		driver.findElement(swimmers.RegisterButton).click();
		Assert.assertEquals(swimmers.DOBValidation, "Please select Date of birth");
	}
	
	
	@Test(priority=55)
	public void checkUnApprovedCoachesNotInSwimmerAssignPage () throws InterruptedException{
		dash.clickOnSwimmers();
		Thread.sleep(500);
		swimmers.clickCheckBoxBasedOnSwimmersName(input.Coach3);
		swimmers.clickOnTranferButton();
		WebElement coachSelection = driver.findElement(swimmers.CoachSelectionInAssignSwimmerPage);
		coachSelection.click();
		Assert.assertEquals(swimmers.checkCoachStatusinAssignSwimmerPage(input.Coach3), false);
	}
	
	
	@Test(priority=60)
	public void checkApprovedCoachesInSwimmerAssignPage () throws InterruptedException{
		WebElement coachSelection = driver.findElement(swimmers.CoachSelectionInAssignSwimmerPage);
		coachSelection.click();
		Assert.assertEquals(swimmers.checkCoachStatusinAssignSwimmerPage(input.Coach1), true);
	}
	
}*/

