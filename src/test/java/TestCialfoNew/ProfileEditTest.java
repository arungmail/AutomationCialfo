package TestCialfoNew;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.DriverClass;
import BasePackage.Utility;
import Pages.DashBoard;
import Pages.ProfilePage;

public class ProfileEditTest extends DriverClass {
	LogInTest log		= new LogInTest ();
	DashBoard dash		= new DashBoard ();
	ProfilePage profile = new ProfilePage();
	Utility util 		= new Utility();

	
	@Test(priority=1)
    public void enterValuesInPersonalInfoAndCheckSucessMessage() throws InterruptedException{
			driver.get("http://192.168.1.206:4200/login");
	    	log.normalLogin();
	    	dash.clickOnProfileNameOnTop();
	    	Thread.sleep(500);
	    	profile.clickOnProfile();
	    	Thread.sleep(500);
	    	profile.clickOnAccount();
    	profile.enterFirstname("Samsung ");
    	profile.enterLastName("SwimClub");
    	profile.entermobileno("919901395048");
    	profile.enterLandline("8086251295");
    	//util.selectradioButton("Female","lable");
    	//util.selectradioButton("Player","lable");
    	profile.selectDOBInProfilePage("1980","March","24");
    	profile.clickOnSaveChanges();
    	String actualSeccesmessage = profile.checkSucsessMessage();
    	String expectedSuccessMessage = "Details updated successfully";
    	Assert.assertEquals(actualSeccesmessage, expectedSuccessMessage);	
    	String actualProfilenameonToRightSide = dash.getProfilenameOnTopRightSide();
    	String expctedProfilenameonToRightSide = "Samsung SwimClub";
    	Assert.assertEquals(actualProfilenameonToRightSide, expctedProfilenameonToRightSide);	
    }
    
	@Test(priority=2)
    public void verifyProfileNameinOverviewpage(){
    	driver.navigate().refresh();
    	if (driver.findElement(profile.Overview).isSelected()){	
    	}
    	else{
    		driver.findElement(profile.Account).click(); 		
    	}
    	String actualprofileName = profile.getClubnameinOverViewPage();
    	String expectedprofileNmae = "Samsung SwimClub";
    	Assert.assertEquals(actualprofileName, expectedprofileNmae);
    			
    }
	@Test(priority=3)
    public void profileNameInTopRightSide(){
    	driver.navigate().refresh();
    	if (driver.findElement(profile.Account).isSelected()){	
    	}
    	else{
    		driver.findElement(profile.Account).click(); 		
    	}
    	String actualProfilenameonToRightSide = dash.getProfilenameOnTopRightSide();
    	System.out.println(actualProfilenameonToRightSide);
    	String expctedProfilenameonToRightSide = "Samsung SwimClub";
    	Assert.assertEquals(actualProfilenameonToRightSide, expctedProfilenameonToRightSide);
    }
	@Test(priority=4)
    public void profileNameInSecondaryMenu ()
    {
    	if (driver.findElement(profile.Account).isSelected()){	
    	}
    	else{
    		driver.findElement(profile.Account).click(); 		
    	}
    	String actualProfileNameOnSecondaryMenu = dash.getProfilenameOnSecondarymenu();
    	System.out.println(actualProfileNameOnSecondaryMenu);
    	String expectedProfileNameOnSecondaryMenu = "Samsung SwimClub";
    	Assert.assertEquals(actualProfileNameOnSecondaryMenu, expectedProfileNameOnSecondaryMenu);
     }
	
	@Test(priority=5)
	public void verifyPersonalInfoIsUpdatedOrNot()
	{
		String personalInfoValues = profile.getPersonalInfoAttributes()[0]+","+profile.getPersonalInfoAttributes()[1]+","+profile.getPersonalInfoAttributes()[2]+","+profile.getPersonalInfoAttributes()[3];
		System.out.println(personalInfoValues);
		String expctedvalues = "Samsung,SwimClub,919901395048,8086251295";
	}
	/*@Test(priority=5)
    public void verifyFirstNamevalidationError() throws InterruptedException{
		driver.navigate().refresh();
    	if (driver.findElement(profile.Account).isSelected()){	
    	}
    	else{
    		driver.findElement(profile.Account).click(); 
    }
    	driver.get("http://192.168.1.206:4200/login");
    	log.normalLogin();
    	dash.clickOnProfileNameOnTop();
    	Thread.sleep(500);
    	profile.clickOnProfile();
    	Thread.sleep(500);
    	profile.clickOnAccount();
    	profile.clickOnPersonalInfo();
    	profile.enterFirstname("");
    	profile.clickOnSaveChanges();
    	String actualError = profile.checkFirstNameValidationError();
    	String expctecdError = "This field is required!";
    	Assert.assertEquals(actualError, expctecdError);
    }
	@Test(priority=6)
    public void verifyLastNameValidationError()
    {
		driver.navigate().refresh();
		profile.clickOnAccount();
    	profile.enterFirstname("Samsung");
    	profile.enterLastName("");
    	profile.clickOnSaveChanges();
    	String actualError = profile.checkLastNameValidationError();
    	String expctecdError = "This field is required!";
    	Assert.assertEquals(actualError, expctecdError);
    }
	@Test(priority=7)
    public void verifyMobileNumbervalidationError()
    {
    	profile.enterFirstname("Samsung");
    	profile.enterLastName("Swimming Club");
    	profile.entermobileno("");
    	profile.clickOnSaveChanges();
    	String actualError = profile.checkmobileNoValidationError();
    	String expctecdError = "This field is required!";
    	Assert.assertEquals(actualError, expctecdError);
    }
	@Test(priority=8)
    public void verifyLandlinevalidation()
    {
    	profile.enterFirstname("Samsung");
    	profile.enterLastName("Swimming Club");
    	profile.entermobileno("919901395048");
    	profile.enterLandline("");
    	profile.clickOnSaveChanges();
    	String actualError = profile.checkmobileNoValidationError();
    	String expctecdError = "This field is required!";
    	Assert.assertEquals(actualError, expctecdError);
    }*/
	@Test(priority=9)
    public void enterAddressAndSave()
    {
    	if (driver.findElement(profile.Account).isSelected()){	
    	}
    	else{
    		driver.findElement(profile.Account).click(); 
    }
    	profile.clickOnAddress();
    	profile.enterStreetName("Street1");
    	profile.enterlandmark("Knonanakunte Cross");
    	profile.enterCity("Bangalore");
    	profile.enterState("Karnataka");
    	profile.enterZip("680665");
    	profile.enterCoutry("Indian");
    	profile.clickOnSaveChanges();
    	String actualSuccessmessage = profile.checkSucsessMessage();
    	String expectedSuccessmessage = "Address updated successfully";
    	Assert.assertEquals(actualSuccessmessage, expectedSuccessmessage); 	
    	
    }
	@Test(priority=10)
	public void checkStreetUpdatedOrNot()
	{
		if (driver.findElement(profile.Account).isSelected()){	
    	}
    	else{
    		driver.findElement(profile.Account).click(); 
    }
    	profile.clickOnAddress();
    	String adressValues =  profile.getAddressAttributes()[0]+","+profile.getAddressAttributes()[1]+","+profile.getAddressAttributes()[2]+","+profile.getAddressAttributes()[3]+","+profile.getAddressAttributes()[4]+","+profile.getAddressAttributes()[5];
    	System.out.println(adressValues);
    	String expectedStreet = "Street1,Knonanakunte Cross,Bangalore,Karnataka,680665,Indian";
    	Assert.assertEquals(adressValues, expectedStreet); 
    	dash.clickOnProfileNameOnTop();
		profile.clickOnLogOutButton();
    	
	}
	/*@Test(priority=10)
    public void verifyStreetvalidationError ()
    {
    	profile.enterStreetName("");
    	profile.clickOnSaveChanges();
    	String actualErrormessage = profile.streetvalidationError();
    	String expectdErrorMessage = "This field is required!";
    	Assert.assertEquals(actualErrormessage, expectdErrorMessage);
    }
	@Test(priority=11)
    public void verifyLandmarkValiadtionError()
    {
    	profile.enterStreetName("Street1");
    	profile.enterlandmark("");
    	String actualErrormessage = profile.streetvalidationError();
    	String expectdErrorMessage = "This field is required!";
    	Assert.assertEquals(actualErrormessage, expectdErrorMessage);	
    }
	@Test(priority=12)
    public void verifyCityValidationError()
    {
    	profile.enterStreetName("Street1");
    	profile.enterlandmark("konanakkunte cross");
    	profile.enterCity("");
    	String actualErrormessage = profile.streetvalidationError();
    	String expectdErrorMessage = "This field is required!";
    	Assert.assertEquals(actualErrormessage, expectdErrorMessage);
    }
	@Test(priority=13)
    public void verifyStateValidationError()
    {
    	profile.enterStreetName("Street1");
    	profile.enterlandmark("konanakkunte cross");
    	profile.enterCity("bangalore");
    	profile.enterState("");
    	String actualErrormessage = profile.streetvalidationError();
    	String expectdErrorMessage = "This field is required!";
    	Assert.assertEquals(actualErrormessage, expectdErrorMessage);
    	
    }
	@Test(priority=14)
    public void verifyZipValidationError()
    {

    	profile.enterStreetName("Street1");
    	profile.enterlandmark("konanakkunte cross");
    	profile.enterCity("bangalore");
    	profile.enterState("Karnataka");
    	profile.enterZip("");
    	String actualErrormessage = profile.streetvalidationError();
    	String expectdErrorMessage = "This field is required!";
    	Assert.assertEquals(actualErrormessage, expectdErrorMessage);
    }
	@Test(priority=15)
    public void verifyCountryValidationError()
    {
    	profile.enterStreetName("Street1");
    	profile.enterlandmark("konanakkunte cross");
    	profile.enterCity("bangalore");
    	profile.enterState("Karnataka");
    	profile.enterZip("Karnataka");
    	profile.enterCoutry("");
    }*/


}
