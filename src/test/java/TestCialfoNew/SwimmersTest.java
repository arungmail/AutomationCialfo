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
import org.testng.annotations.Test;

import BasePackage.DriverClass;
import BasePackage.Utility;
import Pages.BatchList;
import Pages.DashBoard;
import Pages.LoginForm;
import Pages.SwimmersPage;

public class SwimmersTest extends DriverClass {
	LoginForm login = new LoginForm();
	DashBoard dash = new DashBoard();
	Utility util = new Utility();
	SwimmersPage swimmers = new SwimmersPage();
	BatchList batch = new BatchList();
	DriverClass driverclass = new DriverClass();
	InputValues input = new InputValues();

	@Test

	/*
	 * public void checkAddedBatchIsListedOrNot() {
	 * login.enterEmailId(input.club); login.enterPassword(input.ClubPassword);
	 * login.clickSignButton(); dash.clickOnSwimmers();
	 * driver.findElement(swimmers.BatchSelection).click(); List <String>
	 * batchname = new ArrayList <String>(); WebElement batchlist =
	 * driver.findElement(By.xpath("html/body/span/span/span[2]")); List
	 * <WebElement> batches = batchlist.findElements(By.tagName("li")); for
	 * (WebElement webElement : batches) {
	 * System.out.println(webElement.getText()); if
	 * (webElement.getText().equalsIgnoreCase("Week End Batch")) {
	 * //Thread.sleep(500); batchname.add("Week End Batch");
	 * Assert.assertEquals(webElement, "Week End Batch"); break; } }
	 * 
	 * }
	 */

	public void verifyUnApprovedCoachesareListedInCoachesFilterOrNot() {

	}

	public void checkApprovedSwimmersDisplyedInUnAssignedList() throws InterruptedException {
		driver.navigate().refresh();
		dash.clickOnSwimmers();
		WebElement batchselection = driver.findElement(swimmers.BatchSelection);
		swimmers.batchSelection("Un Assigned");
		Thread.sleep(500);
		swimmers.search(input.SwimmerAfterApprovng);
		Thread.sleep(500);
		String actualSwimmer = driver.findElement(By.linkText(input.SwimmerAfterApprovng)).getText();
		// String expectedSwimmer = input.swimmer;
		Assert.assertEquals(actualSwimmer, input.SwimmerAfterApprovng);
	}

	public void verifyBatchesAreListedOrNot() throws InterruptedException {
		WebElement batchSelection = driver.findElement(swimmers.BatchSelection);
		batchSelection.click();
		Thread.sleep(500);
		swimmers.batchSelection("xxx");

		// swimmers.checkBatchStatus("xxxx");
		Assert.assertEquals(swimmers.checkBatchStatus("xxx"), true);

	}

	public void checkUnApprovedCoachinCoachSelection() throws InterruptedException {
		WebElement coachSelection = driver.findElement(swimmers.CoachSelection);
		coachSelection.click();
		Thread.sleep(500);
		swimmers.coachSelection("");
		Assert.assertEquals(swimmers.checkCoachStatus(input.UnApprovedCoach), false);

	}

	public void checkApprovedCoachesInCoachesList() throws InterruptedException {
		WebElement coachSelection = driver.findElement(swimmers.CoachSelection);
		coachSelection.click();
		Thread.sleep(500);
		swimmers.coachSelection("");
		Assert.assertEquals(swimmers.checkCoachStatus(input.UnApprovedCoach1), true);

	}

	public void checkUnAssignedSwimmerAttendancePercenatge() throws InterruptedException {
		WebElement batchselection = driver.findElement(swimmers.BatchSelection);
		swimmers.batchSelection("Un Assigned");
		Thread.sleep(500);
		swimmers.search(input.SwimmerAfterApprovng);
		Thread.sleep(500);
		// swimmers.getAtendancePercentage(input.SwimmerAfterApprovng);
		Assert.assertEquals(swimmers.getAtendancePercentage(input.SwimmerAfterApprovng), "0%");
	}

	public void addSwimmerFromSwimmerPage() {
		driver.findElement(swimmers.AddSwimmerButton).click();
		driver.findElement(swimmers.ScreenName).sendKeys("xxxx");
		driver.findElement(swimmers.Firstname).sendKeys(input.SwimmerFirstNameAddedInsideClub);
		driver.findElement(swimmers.EmailId).sendKeys("xxxxx");
		driver.findElement(swimmers.Lastname).sendKeys("xxx");
		driver.findElement(swimmers.Password).sendKeys("dfdsfdf");
		driver.findElement(swimmers.ConfirmPassword).sendKeys("dhfdsfgdshf");
		driver.findElement(swimmers.PhoneNumber).sendKeys("xxxx");
		driver.findElement(swimmers.Location).sendKeys("sfafas");
		WebElement year = driver.findElement(swimmers.Year);
		WebElement month = driver.findElement(swimmers.Month);
		WebElement day = driver.findElement(swimmers.Day);
		util.selectValueByValue(day, "1990");
		util.selectValueByValue(month, "March");
		util.selectValueByValue(year, "28");
		driver.findElement(swimmers.RegisterButton).click();

	}

	public void verifySwimmerIsAvailableOrNotOnUnassigned() throws InterruptedException {
		WebElement batchselection = driver.findElement(swimmers.BatchSelection);
		swimmers.batchSelection("Un Assigned");
		Thread.sleep(500);
		swimmers.search(input.SwimmerAfterApprovng);
		Thread.sleep(500);
		String actualSwimmer = driver.findElement(By.linkText(input.SwimmerEmailIdAddedByInsideClub)).getText();
		// String expectedSwimmer = input.swimmer;
		Assert.assertEquals(actualSwimmer, input.SwimmerAfterApprovng);
	}
/*
	public void screenNameValidation() {
		driver.findElement(swimmers.AddSwimmerButton).click();
		driver.findElement(swimmers.ScreenName).sendKeys("");
		driver.findElement(swimmers.Firstname);
		driver.findElement(swimmers.EmailId).sendKeys("xxxxx");
		driver.findElement(swimmers.Lastname).sendKeys("xxx");
		driver.findElement(swimmers.Password).sendKeys("dfdsfdf");
		driver.findElement(swimmers.ConfirmPassword).sendKeys("dhfdsfgdshf");
		driver.findElement(swimmers.PhoneNumber).sendKeys("xxxx");
		driver.findElement(swimmers.Location).sendKeys("sfafas");
		WebElement year = driver.findElement(swimmers.Year);
		WebElement month = driver.findElement(swimmers.Month);
		WebElement day = driver.findElement(swimmers.Day);
		util.selectValueByValue(day, "1990");
		util.selectValueByValue(month, "March");
		util.selectValueByValue(year, "28");
		driver.findElement(swimmers.RegisterButton).click();
		String error = swimmers.getAnValidationError(swimmers.NameValidation);
		Assert.assertEquals(error, "This field is required!");
	}

	public void verifyFirstNameValidation() {
		
		driver.findElement(swimmers.Firstname).sendKeys("");
		driver.findElement(swimmers.EmailId).sendKeys("xxxxx");
		driver.findElement(swimmers.Lastname).sendKeys("xxx");
		driver.findElement(swimmers.Password).sendKeys("dfdsfdf");
		driver.findElement(swimmers.ConfirmPassword).sendKeys("dhfdsfgdshf");
		driver.findElement(swimmers.PhoneNumber).sendKeys("xxxx");
		driver.findElement(swimmers.Location).sendKeys("sfafas");
		WebElement year = driver.findElement(swimmers.Year);
		WebElement month = driver.findElement(swimmers.Month);
		WebElement day = driver.findElement(swimmers.Day);
		util.selectValueByValue(day, "1990");
		util.selectValueByValue(month, "March");
		util.selectValueByValue(year, "28");
		driver.findElement(swimmers.RegisterButton).click();
		Assert.assertEquals(swimmers.getAnValidationError(swimmers.FirstNameValidation), "This field is required!");
	}
	
	public void verifyLastNameValidationError (){
		driver.findElement(swimmers.EmailId).sendKeys("xxxxx");
		driver.findElement(swimmers.Lastname).sendKeys("");
		driver.findElement(swimmers.Password).sendKeys("dfdsfdf");
		driver.findElement(swimmers.ConfirmPassword).sendKeys("dhfdsfgdshf");
		driver.findElement(swimmers.PhoneNumber).sendKeys("xxxx");
		driver.findElement(swimmers.Location).sendKeys("sfafas");
		WebElement year = driver.findElement(swimmers.Year);
		WebElement month = driver.findElement(swimmers.Month);
		WebElement day = driver.findElement(swimmers.Day);
		util.selectValueByValue(day, "1990");
		util.selectValueByValue(month, "March");
		util.selectValueByValue(year, "28");
		driver.findElement(swimmers.RegisterButton).click();
		Assert.assertEquals(swimmers.getAnValidationError(swimmers.LastNameValidation), "This field is required!");
	}
	*/
	
	public void checkvalidationError (){
		driver.findElement(swimmers.AddSwimmerButton).click();
		driver.findElement(swimmers.RegisterButton).click();
		Assert.assertEquals(swimmers.NameValidation, "This field is required!");
		Assert.assertEquals(swimmers.FirstNameValidation, "This field is required!");
		Assert.assertEquals(swimmers.LastNameValidation, "This field is required!");
		Assert.assertEquals(swimmers.Password, "This field is required!");
		Assert.assertEquals(swimmers.ConfirmPasswordValidation, "This field is required!");
		//Assert.assertEquals(swimmers., expected);
		
	}
	
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
		WebElement month = driver.findElement(swimmers.Month);
		WebElement day = driver.findElement(swimmers.Day);
		util.selectValueByValue(day, "");
		util.selectValueByValue(month, "March");
		util.selectValueByValue(year, "28");
		driver.findElement(swimmers.RegisterButton).click();
		Assert.assertEquals(swimmers.DOBValidation, "Please select Date of birth");
	}
	
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
	
	public void checkUnApprovedCoachesNotInSwimmerAssignPage () throws InterruptedException{
		dash.clickOnSwimmers();
		Thread.sleep(500);
		swimmers.clickCheckBoxBasedOnSwimmersName("");
		WebElement coachSelection = driver.findElement(swimmers.CoachSelectionInAssignSwimmerPage);
		coachSelection.click();
		Assert.assertEquals(swimmers.checkCoachStatusinAssignSwimmerPage(input.UnApprovedCoach), false);
	}
	
	public void checkApprovedCoachesInSwimmerAssignPage () throws InterruptedException{
		WebElement coachSelection = driver.findElement(swimmers.CoachSelectionInAssignSwimmerPage);
		coachSelection.click();
		Assert.assertEquals(swimmers.checkCoachStatusinAssignSwimmerPage(input.UnApprovedCoach1), true);
	}
	
	
	

	
	/*
	 * public void simmerAfterSearch() throws InterruptedException {
	 * login.enterEmailId(input.club); login.enterPassword(input.ClubPassword);
	 * login.clickSignButton(); dash.clickOnSwimmers();
	 * swimmers.search(input.swimmer2); Thread.sleep(5000); String
	 * actulaSwimmername =
	 * driver.findElement(By.linkText(input.swimmer2)).getText();
	 * System.out.println(actulaSwimmername); String expectedSwimmername =
	 * input.swimmer2; Assert.assertEquals(actulaSwimmername,
	 * expectedSwimmername); }
	 

	public void searchInvalidSwimmers() throws InterruptedException {
		driver.navigate().refresh();
		dash.clickOnSwimmers();
		swimmers.search("sngbdjgbsd");
		Thread.sleep(5000);
		WebElement error = driver.findElement(swimmers.DataEmptyMessage);
		String actualError = util.getErrorMessage(error);
		String expectedError = "No data available in table";
		Assert.assertEquals(actualError, expectedError);

	}

	
	 * public void tranferSwimmersToBatch () throws InterruptedException {
	 * driver.navigate().refresh();
	 * driver.findElement(swimmers.BatchSelection).click(); WebElement
	 * batchResult = driver.findElement(swimmers.batchresults);
	 * swimmers.batchSelection(batchResult, ""); try {
	 * swimmers.clickCheckBoxBasedOnSwimmersName("Divya");
	 * driver.findElement(swimmers.BatchResultsInTransferSwimmerpage);
	 * WebElement batchResult1 =
	 * driver.findElement(swimmers.BatchResultsInTransferSwimmerpage);
	 * batch.selectCoachFromCoachList(batchResult1, "cvf");
	 * driver.findElement(swimmers.SubmitButonInTransferSwimmerPage).click();
	 * 
	 * 
	 * } catch(Exception e){ System.out.println("swimmer not found"); }
	 * 
	 * }
	 

	public void checkSwimmersisdiaplayingAfterSwimmertranfer() throws InterruptedException {
		driver.navigate().refresh();
		dash.clickOnSwimmers();
		driver.findElement(swimmers.BatchSelection).click();
		WebElement batchList3 = driver.findElement(swimmers.batchresults);
		swimmers.batchSelection(batchList3, "");
		String actulaSwimmer = driver.findElement(By.linkText("Divya")).getText();

		String expectedSwimmer = "Divya";
		Assert.assertEquals(actulaSwimmer, expectedSwimmer);

	}

	public void checkbatchnameIsMatchingOrNot() {
		swimmers.getmatchingBatch("Divya", "");
	}

	public void checkCoachIsmatchingOrNot() {
		// swimmers.getmatchingCoachNameforSwimmers(swimmername,
		// expectedCoachName);
		// swimmers.getmatchingCoachNameforSwimmers((driverclass.getValuesFromPropertiesFile("BrowserName"),
		// "fdgf"));
	}*/
}
