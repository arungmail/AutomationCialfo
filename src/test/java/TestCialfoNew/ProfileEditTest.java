package TestCialfoNew;

import org.testng.Assert;

import BasePackage.DriverClass;
import BasePackage.Utility;
import Pages.DashBoard;
import Pages.ProfilePage;

public class ProfileEditTest extends DriverClass {
	LogInTest log		= new LogInTest ();
	DashBoard dash		= new DashBoard ();
	ProfilePage profile = new ProfilePage();
	Utility util 		= new Utility();

	
    public void enterValuesInPersonalInfoAndCheckSucessMessage() throws InterruptedException{
    	log.normalLogin();
    	dash.clickOnProfileNameOnTop();
    	Thread.sleep(500);
    	profile.clickOnProfile();
    	Thread.sleep(500);
    	profile.clickOnAccount();
    	profile.enterFirstname("Samsung ");
    	profile.enterLastName("SwimClub");
    	profile.entermobileno("919901395048");
    	profile.enterLandline("sdjksdkjhdjks");
    	util.selectradioButton("Male","lable");
    	util.selectradioButton("Player","lable");
    	profile.selectDOBInProfilePage("1980","march","31");
    	profile.clickOnSaveChanges();
    	String actualSeccesmessage = profile.checkSucsessMessage();
    	String expectedSuccessMessage = "Details updated successfully";
    	Assert.assertEquals(actualSeccesmessage, expectedSuccessMessage);	
    	/*String actualProfilenameonToRightSide = dash.getProfilenameOnTopRightSide();
    	String expctedProfilenameonToRightSide = "Samsung SwimClub";
    	Assert.assertEquals(actualProfilenameonToRightSide, expctedProfilenameonToRightSide);*/	
    }
    
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
    public void verifyFirstNamevalidationError(){
    	if (driver.findElement(profile.Account).isSelected()){	
    	}
    	else{
    		driver.findElement(profile.Account).click(); 
    }
    	profile.clickOnPersonalInfo();
    	profile.enterFirstname("");
    	profile.clickOnSaveChanges();
    	String actualError = profile.checkFirstNameValidationError();
    	String expctecdError = "This field is required!";
    	Assert.assertEquals(actualError, expctecdError);
    }
    public void verifyLastNameValidationError()
    {
    	profile.enterFirstname("Samsung");
    	profile.enterLastName("");
    	profile.clickOnSaveChanges();
    	String actualError = profile.checkLastNameValidationError();
    	String expctecdError = "This field is required!";
    	Assert.assertEquals(actualError, expctecdError);
    }
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
    }
    public void enterAddressAndSave()
    {
    	if (driver.findElement(profile.Account).isSelected()){	
    	}
    	else{
    		driver.findElement(profile.Account).click(); 
    }
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


}
