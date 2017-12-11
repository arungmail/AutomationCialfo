package TestCialfoNew;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.DriverClass;
import BasePackage.Utility;
import Pages.DashBoard;
import Pages.LoginForm;
import Pages.ProfilePage;

public class ProfileEditTest extends DriverClass {
	LogInTest log = new LogInTest();
	DashBoard dash = new DashBoard();
	ProfilePage profile = new ProfilePage();
	Utility util = new Utility();
	InputValues input = new InputValues();

	@Test(priority = 1)
	public void enterValuesInPersonalInfoAndCheckSucessMessage() throws InterruptedException {
		LoginForm.enterEmailId(input.club);
		LoginForm.enterPassword(input.ClubPassword);
		LoginForm.clickSignButton();
		Thread.sleep(5000);
		dash.clickOnProfileNameOnTop();
		Thread.sleep(500);
		profile.clickOnProfile();
		Thread.sleep(500);
		profile.clickOnAccount();
		profile.enterFirstname("Samsung ");
		profile.enterLastName("SwimClub");
		profile.entermobileno("9901395048");
		profile.clickOnSaveChanges();
		Thread.sleep(2000);
		String actualSeccesmessage = profile.checkSucsessMessage();
		// String actualSeccesmessage =
		// driver.findElement(By.xpath(".//*[@id='success_validation']")).getText();
		System.out.println(actualSeccesmessage);
		String expectedSuccessMessage = "Details updated successfully";
		Assert.assertEquals(actualSeccesmessage, expectedSuccessMessage);
		
	}

	@Test(priority = 2)
	public void verifyProfileNameinOverviewpage() {
		driver.navigate().refresh();
		driver.findElement(profile.Overview).click();
		String actualprofileName = profile.getClubnameinOverViewPage();
		String expectedprofileNmae = "Samsung SwimClub";
		Assert.assertEquals(actualprofileName, expectedprofileNmae);
	}

	@Test(priority = 3)
	public void profileNameInTopRightSide() {
		String actualProfilenameonToRightSide = dash.getProfilenameOnTopRightSide();
		System.out.println(actualProfilenameonToRightSide);
		String expctedProfilenameonToRightSide = "Samsung SwimClub";
		Assert.assertEquals(actualProfilenameonToRightSide, expctedProfilenameonToRightSide);
	}
	@Test(priority = 4)
	public void profileNameInSecondaryMenu() {
		String actualProfileNameOnSecondaryMenu = dash.getProfilenameOnSecondarymenu();
		System.out.println(actualProfileNameOnSecondaryMenu);
		String expectedProfileNameOnSecondaryMenu = "Samsung SwimClub";
		Assert.assertEquals(actualProfileNameOnSecondaryMenu, expectedProfileNameOnSecondaryMenu);
	}

	@Test(priority = 5)
	public void verifyPersonalInfoIsUpdatedOrNot() {
		driver.findElement(profile.Overview).click();
		String personalInfoValues = profile.getPersonalInfoAttributes()[0] + ","
				+ profile.getPersonalInfoAttributes()[1] + "," + profile.getPersonalInfoAttributes()[2];
		System.out.println(personalInfoValues);
		String expctedvalues = "Samsung,SwimClub,919901395048,8086251295";
	}
	@Test(priority = 9)
	public void enterAddressAndSave() throws InterruptedException {
		profile.clickOnAddress();
		profile.enterStreetName("Street1");
		profile.enterlandmark("Knonanakunte Cross");
		profile.enterCity("Bangalore");
		profile.enterState("Karnataka");
		profile.enterZip("680665");
		profile.enterCoutry("Indian");
		driver.findElement(By.xpath(".//*[@id='tab_5-5']/form/div[7]/a[1]")).click();
		// String actualSuccessmessage = profile.checkSucsessMessage();
		Thread.sleep(3000);
		String actualSuccessmessage = driver
				.findElement(By.xpath("//div[@class='alert alert-success msg-alerts succesmsg success_reset_pwd']"))
				.getText();
		System.out.println(actualSuccessmessage);
		String expectedSuccessmessage = "Address updated successfully";
		Assert.assertEquals(actualSuccessmessage, expectedSuccessmessage);
	}
	// @Test(priority=10)
	public void checkStreetUpdatedOrNot() {
		String adressValues = profile.getAddressAttributes()[0] + "," + profile.getAddressAttributes()[1] + ","
				+ profile.getAddressAttributes()[2] + "," + profile.getAddressAttributes()[3] + ","
				+ profile.getAddressAttributes()[4] + "," + profile.getAddressAttributes()[5];
		System.out.println(adressValues);
		String expectedStreet = "Street1,Knonanakunte Cross,Bangalore,Karnataka,680665,Indian";
		Assert.assertEquals(adressValues, expectedStreet);
		dash.clickOnProfileNameOnTop();
		profile.clickOnLogOutButton();

	}
	@Test(priority = 12)
	public void verifyFirstNamevalidationError() throws InterruptedException {
		// profile.clickOnPersonalInfo();
		// profile.enterFirstname("");
		driver.navigate().refresh();
		dash.clickOnSwimmers();
		dash.clickOnProfileNameOnTop();
		profile.clickOnAccount();
		profile.enterFirstname("Samsung");
		profile.enterLastName("");
		driver.findElement(profile.LastNameInPersonalInfo).clear();
		profile.clickOnSaveChanges();
		String actualError = profile.checkFirstNameValidationError();
		String expctecdError = "This field is required!";
		Assert.assertEquals(actualError, expctecdError);
	}
	@Test(priority = 13)
	public void verifyLastNameValidationError() {
		profile.enterFirstname("Samsung");
		profile.enterLastName("");
		profile.clickOnSaveChanges();
		String actualError = profile.checkLastNameValidationError();
		String expctecdError = "This field is required!";
		Assert.assertEquals(actualError, expctecdError);
	}
	@Test(priority = 14)
	public void verifyMobileNumbervalidationError() {
		profile.enterFirstname("Samsung");
		profile.enterLastName("Swimming Club");
		profile.entermobileno("");
		profile.clickOnSaveChanges();
		String actualError = profile.checkmobileNoValidationError();
		String expctecdError = "This field is required!";
		Assert.assertEquals(actualError, expctecdError);
	}
	@Test(priority = 15)
	public void verifyStreetvalidationError() {
		profile.clickOnAddress();
		profile.enterStreetName("");
		driver.findElement(By.xpath(".//*[@id='tab_5-5']/form/div[7]/a[1]")).click();
		String actualErrormessage = profile.streetvalidationError();
		String expectdErrorMessage = "This field is required!";
		Assert.assertEquals(actualErrormessage, expectdErrorMessage);
	}
	@Test(priority = 16)
	public void verifyLandmarkValiadtionError() {
		profile.enterStreetName("Street1");
		profile.enterlandmark("");
		driver.findElement(By.xpath(".//*[@id='tab_5-5']/form/div[7]/a[1]")).click();
		String actualErrormessage = profile.streetvalidationError();
		String expectdErrorMessage = "This field is required!";
		Assert.assertEquals(actualErrormessage, expectdErrorMessage);
	}
	@Test(priority = 17)
	public void verifyCityValidationError() {
		profile.enterStreetName("Street1");
		profile.enterlandmark("konanakkunte cross");
		profile.enterCity("");
		driver.findElement(By.xpath(".//*[@id='tab_5-5']/form/div[7]/a[1]")).click();
		String actualErrormessage = profile.streetvalidationError();
		String expectdErrorMessage = "This field is required!";
		Assert.assertEquals(actualErrormessage, expectdErrorMessage);
	}
	@Test(priority = 18)
	public void verifyStateValidationError() {
		profile.enterStreetName("Street1");
		profile.enterlandmark("konanakkunte cross");
		profile.enterCity("bangalore");
		profile.enterState("");
		driver.findElement(By.xpath(".//*[@id='tab_5-5']/form/div[7]/a[1]")).click();
		String actualErrormessage = profile.streetvalidationError();
		String expectdErrorMessage = "This field is required!";
		Assert.assertEquals(actualErrormessage, expectdErrorMessage);
	}
	@Test(priority = 19)
	public void verifyZipValidationError() {

		profile.enterStreetName("Street1");
		profile.enterlandmark("konanakkunte cross");
		profile.enterCity("bangalore");
		profile.enterState("Karnataka");
		profile.enterZip("");
		driver.findElement(By.xpath(".//*[@id='tab_5-5']/form/div[7]/a[1]")).click();
		String actualErrormessage = profile.streetvalidationError();
		String expectdErrorMessage = "This field is required!";
		Assert.assertEquals(actualErrormessage, expectdErrorMessage);
	}
	@Test(priority = 20)
	public void verifyCountryValidationError() {
		profile.enterStreetName("Street1");
		profile.enterlandmark("konanakkunte cross");
		profile.enterCity("bangalore");
		profile.enterState("Karnataka");
		profile.enterZip("Karnataka");
		profile.enterCoutry("");
		driver.findElement(By.xpath(".//*[@id='tab_5-5']/form/div[7]/a[1]")).click();
	}

}
