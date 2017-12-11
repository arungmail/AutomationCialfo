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
//import Pages.login;
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
	CoachesPage coach = new CoachesPage();
	ProfilePage profile = new ProfilePage();

	public void refreshandclickOnSwimmers() throws InterruptedException {
		driver.navigate().refresh();
		dash.clickOnSwimmers();
		Thread.sleep(5000);

	}

	@Test(priority = 10)

	// TC 1 - Adding swimmer
	public void addSwimmer() throws InterruptedException {
		/*login.enterEmailId(input.club);
		login.enterPassword(input.ClubPassword);
		login.clickSignButton();
		Thread.sleep(5000);*/
		refreshandclickOnSwimmers();
		driver.findElement(swimmers.AddSwimmerButton).click();
		swimmers.addSwimmer("Arun", input.Swimmer1EmailID, "Sel", "SwimmerOne", "Nichi123", "Nichi123", "8753659880",
				"Bangalore");
	}

	@Test(priority = 10)

	// TC 2 - Add swimmer validation
	public void addSwimmerValidationError() {
		driver.findElement(swimmers.AddSwimmerButton).click();

	}

	// TC 3 - Verifying swimmer in Unassignd List

	@Test(priority = 11)
	public void verifySwimmerInUnassignedList() throws InterruptedException {
		dash.clickOnSwimmers();
		swimmers.batchSelection("Un Assigned");
		swimmers.search(input.Swimmer1EmailID);
		boolean swiimerStatus = swimmers.getBooleanvalue(input.Swimmer1EmailID);
		Assert.assertEquals(swiimerStatus, true);
	}

	// TC 4 - Add Coach

	@Test(priority = 12)
	public void addCoach() {
		dash.clickOnCoach();
		driver.findElement(coach.AddCoachButton).click();
		coach.addCoach("coach", input.Coach1EmailID, "Sel", "CoachOne", "Nichi123", "Nichi123", "8977445562",
				"Bangalore");

	}

	@Test(priority = 13)
	// TC 5- Verify Added Coaches in Coaches Page
	public void verifyAddedCoachInCoachesPage() {
		dash.clickOnCoach();
		boolean coachStatus = coach.coachStatusInCoachesPage(input.Coach1EmailID);
		Assert.assertEquals(coachStatus, true);
	}

	@Test(priority = 14)
	// TC 6 Verify Coaches in Swimmers coach selection page
	public void verifyCoachInSwimmersCoachSelectionPage() throws InterruptedException {
		dash.clickOnSwimmers();
		Thread.sleep(5000);
		swimmers.checkCoachStatus(input.Coach1Name);
		Assert.assertEquals(swimmers.checkCoachStatus(input.Coach1Name), true);
	}

	@Test(priority = 15)
	// TC 7 - Verify coach name in unassign swimmer
	public void verifyCoachNameforUnAssignedSwimmer() throws InterruptedException {
		refreshandclickOnSwimmers();
		swimmers.search(input.Swimmer1EmailID);
		Thread.sleep(5000);
		String coachName = driver.findElement(swimmers.CoachNameinSwimmerspage).getText();
		Assert.assertNull(coachName);
	}

	@Test(priority = 16)
	public void verifyBatchname() throws InterruptedException {
		// String batchname = swimmers.getmatchingBatch(input.Swimmer1EmailID);
		swimmers.search(input.Swimmer1EmailID);
		Thread.sleep(5000);
		String batchname = driver.findElement(swimmers.BatchNameInSwimmersPage).getText();
		System.out.println(batchname);
		Assert.assertEquals(batchname, "Un Assigned");
	}

	@Test(priority = 17)
	// TC 8 - Verify Attendance Percentage of UnAssignswimmer
	public void verifyAttendanePecenatgeofUnAssignedSwimmer() throws InterruptedException {
		// String per = swimmers.getAtendancePercentage(input.Swimmer1EmailID);
		swimmers.search(input.Swimmer1EmailID);
		Thread.sleep(5000);
		String per = driver.findElement(swimmers.AttendanceInSwimmerPage).getText();
		Assert.assertEquals(per, "0.0%");

	}

	@Test(priority = 18)
	// TC - 9 Verify Swimmers Profile
	public void verifySwimmerProfileFromSwimmersPage() {
		dash.clickOnSwimmers();
		swimmers.clickOnSwimmerName(input.Swimmer1EmailID);
		String profileName = driver.findElement(profile.ProfleNameInOverViewpage).getText();
		System.out.println(profileName);
		Assert.assertTrue(profileName.contains(input.Swimmer1Name));
	}

	@Test(priority = 19)
	// TC - 10 Verify Swimmers email id in Profile page
	public void verifySwimmersEmailIdInProfilePage() {
		String emailId = driver.findElement(By.linkText(input.Swimmer1EmailID)).getText();
		Assert.assertEquals(emailId, input.Swimmer1EmailID);
	}

	@Test(priority = 20)
	// TC - 11 Verify coach Profile
	public void verifyCoachProfileFromSwimmersPage() {
		dash.clickOnSwimmers();
		driver.findElement(By.linkText(input.Coach1Name)).click();
		String coachname = driver.findElement(profile.ProfleNameInOverViewpage).getText();
		Assert.assertEquals(coachname, input.Coach1Name);
	}

	@Test(priority = 22)
	public void verifyUserNameValidation() {
		dash.clickOnSwimmers();
		driver.findElement(swimmers.AddSwimmerButton).click();
		swimmers.addSwimmer("", "dhfdshg@gmail.com", "Arun", "Vijay", "Nichi123", "Nichi123", "9901395048",
				"Bangalore");
		String error = driver.findElement(swimmers.NameValidation).getText();
		Assert.assertEquals(error, "This field is required!");
	}

	@Test(priority = 24)
	public void verifyEmailValidation() {
		driver.navigate().refresh();
		// driver.findElement(swimmers.AddSwimmerButton).click();
		swimmers.addSwimmer("dfds", "", "Arun", "Vijay", "Nichi123", "Nichi123", "9901395048", "Bangalore");
		String error = driver.findElement(swimmers.EmailValidation).getText();
		Assert.assertEquals(error, "This field is required!");
	}

	@Test(priority = 26)
	public void verifyInvalidEmailID() {
		driver.navigate().refresh();
		swimmers.addSwimmer("hfgd", "dhfdshg", "Arun", "Vijay", "Nichi123", "Nichi123", "9901395048", "Bangalore");
		String error = driver.findElement(swimmers.EmailValidation).getText();
		Assert.assertEquals(error, "Invalid email address!");
	}

	@Test(priority = 28)
	public void verifyExistingEmailIDValidation() {
		driver.navigate().refresh();
		swimmers.addSwimmer("hfgd", input.Swimmer1EmailID, "Arun", "Vijay", "Nichi123", "Nichi123", "9901395048",
				"Bangalore");
		String error = driver.findElement(swimmers.EmailValidation).getText();
		Assert.assertEquals(error, "Email you have entered already exist");
	}

	@Test(priority = 30)
	public void verifyFirstNameValidation() {
		driver.navigate().refresh();
		swimmers.addSwimmer("dfdsfd", "dhfdshg@gmail.com", "", "Vijay", "Nichi123", "Nichi123", "9901395048",
				"Bangalore");
		String error = driver.findElement(swimmers.FirstNameValidation).getText();
		Assert.assertEquals(error, "This field is required!");
	}

	@Test(priority = 32)
	public void verifyLastnameValidation() {
		driver.navigate().refresh();
		swimmers.addSwimmer("djhfgdsh", "dhfdshg@gmail.com", "Arun", "", "Nichi123", "Nichi123", "9901395048",
				"Bangalore");
		String error = driver.findElement(swimmers.LastNameValidation).getText();
		Assert.assertEquals(error, "This field is required!");
	}

	@Test(priority = 34)
	public void verifyPasswordValidation() {
		driver.navigate().refresh();
		swimmers.addSwimmer("djhfgdsh", "dhfdshg@gmail.com", "Arun", "sfsfa", "", "Nichi123", "9901395048",
				"Bangalore");
		String error = driver.findElement(swimmers.PasswordValidation).getText();
		Assert.assertEquals(error, "This field is required!");

	}

	@Test(priority = 36)
	public void verifyPasswordValidationError1() {
		driver.navigate().refresh();
		swimmers.addSwimmer("djhfgdsh", "dhfdshg@gmail.com", "Arun", "dggs", "Nich", "Nichi123", "9901395048",
				"Bangalore");
		String error = driver.findElement(swimmers.PasswordValidation).getText();
		Assert.assertEquals(error, "Password must contain at least 8 characters!");
	}

	@Test(priority = 38)
	public void verifyConfirmPasswordValidation() {
		driver.navigate().refresh();
		swimmers.addSwimmer("djhfgdsh", "dhfdshg@gmail.com", "Arun", "", "Nichi123", "", "9901395048", "Bangalore");
		String error = driver.findElement(swimmers.ConfirmPasswordValidation).getText();
		Assert.assertEquals(error, "This field is required!");
	}

	@Test(priority = 40)
	public void verifyConfirmPasswordValidation1() {
		driver.navigate().refresh();
		swimmers.addSwimmer("djhfgdsh", "dhfdshg@gmail.com", "Arun", "ddgsgdsg", "Nichi123", "Nich", "9901395048",
				"Bangalore");
		String error = driver.findElement(swimmers.ConfirmPasswordValidation).getText();
		Assert.assertEquals(error, "Password must contain at least 8 characters!");
	}

	@Test(priority = 42)
	public void verifyNotMatchingPasswordValidation() {
		driver.navigate().refresh();
		swimmers.addSwimmer("djhfgdsh", "dhfdshg@gmail.com", "Arun", "ddgsgdsg", "Nichi123", "Nichdfdsf", "9901395048",
				"Bangalore");
		String error = driver.findElement(swimmers.PasswordMatchingValidation).getText();
		Assert.assertEquals(error, "Password Not matching!");
	}

	@Test(priority = 44)
	public void verifyPhoneNumberVaidation() {
		driver.navigate().refresh();
		swimmers.addSwimmer("djhfgdsh", "dhfdshg@gmail.com", "Arun", "ddgsgdsg", "Nichi123", "Nichi123", "",
				"Bangalore");
		String error = driver.findElement(swimmers.PhoneNumberValidation).getText();
		Assert.assertEquals(error, "This field is required!");
	}

	@Test(priority = 46)
	public void verifyINvalidPhoneNumberValidation() {
		driver.navigate().refresh();
		swimmers.addSwimmer("djhfgdsh", "dhfdshg@gmail.com", "Arun", "ddgsgdsg", "Nichi123", "Nichi123", "98656",
				"Bangalore");
		String error = driver.findElement(swimmers.PhoneNumberValidation).getText();
		Assert.assertEquals(error, "Phone number format Ex:- 7022939501");
	}

	@Test(priority = 48)
	public void verifyLocationValidation() {
		driver.navigate().refresh();
		swimmers.addSwimmer("djhfgdsh", "dhfdshg@gmail.com", "Arun", "ddgsgdsg", "Nichi123", "Nichi123", "9865669852",
				"");
		String error = driver.findElement(swimmers.LocationValidation).getText();
		Assert.assertEquals(error, "This field is required!");
	}

}
