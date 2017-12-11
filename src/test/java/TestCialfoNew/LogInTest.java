package TestCialfoNew;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import BasePackage.DriverClass;
import Pages.DashBoard;
import Pages.LoginForm;
import junit.framework.Assert;

public class LogInTest extends DriverClass {
	LoginForm login = new LoginForm();
	DashBoard dash 	=  new DashBoard();
	InputValues input = new InputValues ();
	

	/*@AfterMethod
	public void clickGoTOSignpage(){
		driver.get("http://192.168.1.206:4200/login");*/
	//}
	public void normalLogin(){
		login.enterEmailId(input.club);
		login.enterPassword(input.ClubPassword);
		login.clickSignButton();
	}

	
	@Test(priority=1)
	public void validClubLogin() throws InterruptedException{
		login.enterEmailId(input.club);
		login.enterPassword(input.ClubPassword);
		login.clickSignButton();
		Thread.sleep(5000);
		Assert.assertEquals(dash.profileNameIsVisibleOrNot(), true);
		dash.logingOut();
	}
	@Test(priority=2)
	public void emailErrorValidationChecks(){
		login.enterEmailId("sdfsdsdf");
		login.enterPassword("dskjsdjksjkd");
		login.clickSignButton();
		String error = login.signInEmailvalidationError();
		Assert.assertEquals("Invalid email address!", error);
	}
	@Test(priority=3)
	public void passwordErrorValidationChecks () throws InterruptedException
	{
		login.enterEmailId("club6@mailinator.com");
		login.enterPassword("Nichi12345");
		login.clickSignButton();
		Thread.sleep(5000);
		String error = login.signInPasswordValidationError();
		System.out.println(error);
		Assert.assertEquals("Incorrect Username/Password. Try Again.", error);
	}
	
	@Test(priority = 4)
	
	public void checkUnApprovedCoachLogin () throws InterruptedException{
		driver.navigate().refresh();
		login.enterEmailId(input.UpApprovedCoach);
		login.enterPassword("Nichi!23");
		login.clickSignButton();
		Thread.sleep(500);
		String actualError = login.errorvalidation();
		System.out.println(actualError);
		Assert.assertEquals("Account is not activated", actualError);	
	}
	
	@Test(priority = 5)
	public void checkUnApprovedSwimmerLogin () throws InterruptedException{
		driver.navigate().refresh();
		login.enterEmailId(input.Swimmer1EmailID);
		login.enterPassword("Nichi!23");
		login.clickSignButton();
		Thread.sleep(500);
		String actualError = login.errorvalidation();
		Assert.assertEquals("Account is not activated", actualError);
	}
}
