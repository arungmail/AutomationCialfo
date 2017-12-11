package TestCialfoNew;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import BasePackage.DriverClass;
import Pages.CoachesPage;
import Pages.DashBoard;
import Pages.LoginForm;
import Pages.SwimmersPage;
import junit.framework.Assert;

public class CoachesTest extends DriverClass{
	LoginForm login = new LoginForm();
	DashBoard dash	= new DashBoard();
	CoachesPage coach = new CoachesPage();
	InputValues input = new InputValues ();
	SwimmersPage swimmers = new SwimmersPage();
	
	@Test(priority=1)
	public void checkTitleOfCoachPage () throws InterruptedException
	{
		dash.clickOnCoach();
		Thread.sleep(500);
		String actualCoachPageTitle = driver.findElement(By.xpath("html/body/div[1]/app-root/app-coach/div/section[1]/h1")).getText();
		String expectedResultTitle = "Coaches";
		Assert.assertEquals(expectedResultTitle, actualCoachPageTitle);
	}
	
	
	@Test(priority=4)
	public void verifySearch()
	{
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(input.Coach1Name);
		String actuLCoachName = driver.findElement(By.linkText(input.Coach1Name)).getText();
		String expectedCoach = input.Coach1Name;
		Assert.assertEquals(expectedCoach, actuLCoachName);
	}
	@Test(priority=5)
     public void coachRedirectingToCoachProfilePage () throws InterruptedException
     {
    	 dash.clickOnCoach();
    	 driver.findElement(By.linkText(input.Coach1Name)).click();
    	 Thread.sleep(500);
    	 String actualCoachProfileName = driver.findElement(By.xpath(".//*[@id='tab_1_1']/div/div[2]/div[1]/div[1]/h1")).getText();
    	 String expectedCoachname = input.Coach1Name;
    	 Assert.assertEquals(expectedCoachname, actualCoachProfileName);
    	 Thread.sleep(500);
    	 dash.logingOut();
    	 
     }
	
	//All validations
	
	@Test(priority = 22)
	public void verifyUserNameValidation() {
		dash.clickOnCoach();
		driver.findElement(coach.AddCoachButton).click();
		coach.addCoach("", "dhfdshg@gmail.com", "Arun", "Vijay", "Nichi123", "Nichi123", "9901395048",
				"Bangalore");
		String error = driver.findElement(swimmers.NameValidation).getText();
		Assert.assertEquals(error, "This field is required!");
	}

	@Test(priority = 24)
	public void verifyEmailValidation() {
		driver.navigate().refresh();
		// driver.findElement(swimmers.AddSwimmerButton).click();
		coach.addCoach("dfds", "", "Arun", "Vijay", "Nichi123", "Nichi123", "9901395048", "Bangalore");
		String error = driver.findElement(swimmers.EmailValidation).getText();
		Assert.assertEquals(error, "This field is required!");
	}

	@Test(priority = 26)
	public void verifyInvalidEmailID() {
		driver.navigate().refresh();
		coach.addCoach("hfgd", "dhfdshg", "Arun", "Vijay", "Nichi123", "Nichi123", "9901395048", "Bangalore");
		String error = driver.findElement(swimmers.EmailValidation).getText();
		Assert.assertEquals(error, "Invalid email address!");
	}

	@Test(priority = 28)
	public void verifyExistingEmailIDValidation() {
		driver.navigate().refresh();
		coach.addCoach("hfgd", input.Swimmer1EmailID, "Arun", "Vijay", "Nichi123", "Nichi123", "9901395048",
				"Bangalore");
		String error = driver.findElement(swimmers.EmailValidation).getText();
		Assert.assertEquals(error, "Email you have entered already exist");
	}

	@Test(priority = 30)
	public void verifyFirstNameValidation() {
		driver.navigate().refresh();
		coach.addCoach("dfdsfd", "dhfdshg@gmail.com", "", "Vijay", "Nichi123", "Nichi123", "9901395048",
				"Bangalore");
		String error = driver.findElement(swimmers.FirstNameValidation).getText();
		Assert.assertEquals(error, "This field is required!");
	}

	@Test(priority = 32)
	public void verifyLastnameValidation() {
		driver.navigate().refresh();
		coach.addCoach("djhfgdsh", "dhfdshg@gmail.com", "Arun", "", "Nichi123", "Nichi123", "9901395048",
				"Bangalore");
		String error = driver.findElement(swimmers.LastNameValidation).getText();
		Assert.assertEquals(error, "This field is required!");
	}

	@Test(priority = 34)
	public void verifyPasswordValidation() {
		driver.navigate().refresh();
		coach.addCoach("djhfgdsh", "dhfdshg@gmail.com", "Arun", "sfsfa", "", "Nichi123", "9901395048",
				"Bangalore");
		String error = driver.findElement(swimmers.PasswordValidation).getText();
		Assert.assertEquals(error, "This field is required!");

	}

	@Test(priority = 36)
	public void verifyPasswordValidationError1() {
		driver.navigate().refresh();
		coach.addCoach("djhfgdsh", "dhfdshg@gmail.com", "Arun", "dggs", "Nich", "Nichi123", "9901395048",
				"Bangalore");
		String error = driver.findElement(swimmers.PasswordValidation).getText();
		Assert.assertEquals(error, "Password must contain at least 8 characters!");
	}

	@Test(priority = 38)
	public void verifyConfirmPasswordValidation() {
		driver.navigate().refresh();
		coach.addCoach("djhfgdsh", "dhfdshg@gmail.com", "Arun", "", "Nichi123", "", "9901395048", "Bangalore");
		String error = driver.findElement(swimmers.ConfirmPasswordValidation).getText();
		Assert.assertEquals(error, "This field is required!");
	}

	@Test(priority = 40)
	public void verifyConfirmPasswordValidation1() {
		driver.navigate().refresh();
		coach.addCoach("djhfgdsh", "dhfdshg@gmail.com", "Arun", "ddgsgdsg", "Nichi123", "Nich", "9901395048",
				"Bangalore");
		String error = driver.findElement(swimmers.ConfirmPasswordValidation).getText();
		Assert.assertEquals(error, "Password must contain at least 8 characters!");
	}

	@Test(priority = 42)
	public void verifyNotMatchingPasswordValidation() {
		driver.navigate().refresh();
		coach.addCoach("djhfgdsh", "dhfdshg@gmail.com", "Arun", "ddgsgdsg", "Nichi123", "Nichdfdsf", "9901395048",
				"Bangalore");
		String error = driver.findElement(swimmers.PasswordMatchingValidation).getText();
		Assert.assertEquals(error, "Password Not matching!");
	}

	@Test(priority = 44)
	public void verifyPhoneNumberVaidation() {
		driver.navigate().refresh();
		coach.addCoach("djhfgdsh", "dhfdshg@gmail.com", "Arun", "ddgsgdsg", "Nichi123", "Nichi123", "",
				"Bangalore");
		String error = driver.findElement(swimmers.PhoneNumberValidation).getText();
		Assert.assertEquals(error, "This field is required!");
	}

	@Test(priority = 46)
	public void verifyINvalidPhoneNumberValidation() {
		driver.navigate().refresh();
		coach.addCoach("djhfgdsh", "dhfdshg@gmail.com", "Arun", "ddgsgdsg", "Nichi123", "Nichi123", "98656",
				"Bangalore");
		String error = driver.findElement(swimmers.PhoneNumberValidation).getText();
		Assert.assertEquals(error, "Phone number format Ex:- 7022939501");
	}

	@Test(priority = 48)
	public void verifyLocationValidation() {
		driver.navigate().refresh();
		coach.addCoach("djhfgdsh", "dhfdshg@gmail.com", "Arun", "ddgsgdsg", "Nichi123", "Nichi123", "9865669852",
				"");
		String error = driver.findElement(swimmers.LocationValidation).getText();
		Assert.assertEquals(error, "This field is required!");
	}


}
