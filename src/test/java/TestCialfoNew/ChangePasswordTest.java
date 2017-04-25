package TestCialfoNew;

import org.testng.annotations.Test;

import BasePackage.DriverClass;
import Pages.DashBoard;
import Pages.LoginForm;
import Pages.ProfilePage;
import junit.framework.Assert;

public class ChangePasswordTest extends DriverClass{
	LoginForm login1 		= new LoginForm();
	LogInTest login 		= new LogInTest();
	DashBoard dash 			= new DashBoard ();
	ProfilePage	 profile	= new ProfilePage();
	
	@Test(priority=1)
	public void checkPasswordChangesSucessMesssage ()
	{
		login.normalLogin();
		dash.clickOnProfileNameOnTop();
		profile.clickOnProfile();
		profile.clickOnAccount();
		profile.clickOnChangepassword();
		profile.enterNewPassword("Nichi123");
		profile.enterConfirmpassword("Nichi123");
		profile.clickOnChangePasswordButton();
		String actualChangePasswordSecessMeg = profile.checkSucsessMessage();
		String expectedChangePasswordSucessMessage = "Password updated successfully";
		Assert.assertEquals(expectedChangePasswordSucessMessage, actualChangePasswordSecessMeg);
		dash.clickOnProfileNameOnTop();
		profile.clickOnLogOutButton();
			
	}
	@Test(priority=2)
	public void verigyLoginWithNewPassword() throws InterruptedException
	{
		login1.enterEmailId("swimlife@gmail.com");
		login1.enterPassword("Nichi123");
		login1.clickSignButton();
		Thread.sleep(500);
		Assert.assertEquals(dash.profileNameIsVisibleOrNot(), true);
		dash.clickOnProfileNameOnTop();
		profile.clickOnLogOutButton();
	}
	@Test(priority=3)
	public void verifyLoginWithOldpassword()
	{
		login1.enterEmailId("swimlife@gmail.com");
		login1.enterPassword("12345678");
		login1.clickSignButton();
		String actualError   	= login1.signInPasswordValidationError();
		String expectedError 	= "Wrong username or password. Try again.";
		driver.navigate().refresh();
	}
	@Test(priority=4)
	public void newandConfirmPasswordvaldiation()
	{
		login.normalLogin();
		dash.clickOnProfileNameOnTop();
		profile.clickOnProfile();
		profile.clickOnAccount();
		profile.clickOnChangepassword();
		profile.enterNewPassword("Nichi123");
		profile.enterConfirmpassword("sdgsdgsdgsdgsdg");
		profile.clickOnChangePasswordButton();
		String actualvalidationError		= profile.checkConfirmpasswordValidationError();
		String expectedValidationError		= "Password must contain characters, including uppercase, lowercase letters and numbers!";
		Assert.assertEquals(expectedValidationError, actualvalidationError);
		dash.clickOnProfileNameOnTop();
		profile.clickOnLogOutButton();
	}
	
	
	

}
