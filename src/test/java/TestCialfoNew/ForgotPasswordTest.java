package TestCialfoNew;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import BasePackage.DriverClass;
import BasePackage.Utility;
import Pages.ForgotpasswordForm;
import Pages.LoginForm;

public class ForgotPasswordTest extends DriverClass{
	LoginForm login 			      = new LoginForm();
	ForgotpasswordForm   forgot       = new ForgotpasswordForm();
	Utility util 					  = new Utility();
	

	@AfterMethod
	public void openSignpage(){
		driver.get("http://192.168.1.206:4200/login");
	}
	
	@Test(priority=1)
	public void ValidForgotPassword () throws InterruptedException
	{
		login.clickOnForgotPassword();
		forgot.enterForgotPassword("arun@mailinator.com");
		forgot.clickSubmitButton();
		//Thread.sleep(5000);
		try {
			String actualError = forgot.getForgotPasswordSucessMessage();
			Assert.assertEquals(actualError,"Reset link sent to your mail.Please check!");	
		}
		catch (Exception e ){
			System.out.println("Sucessmessage not found");
			
		}
			
	}
	@Test(priority=2)
	public void newmailIDValidationError() throws InterruptedException
	{
		
			login.clickOnForgotPassword();
			forgot.enterForgotPassword("ajhfgafhag@gmail.com");
			forgot.clickSubmitButton();
			Thread.sleep(500);
			//util.explicitTimeout(forgot.getEmailIdValidationError());
			forgot.getEmailIdValidationError();
			String actualError= forgot.getEmailIdValidationError();
			Assert.assertEquals(actualError, "Sorry, Cialfo doesn't recognize this email.");
			forgot.clickOnSignIn();
	}
	@Test (priority=3)
	public void invalidEmailIdvalidationError () throws InterruptedException
	{
		login.clickOnForgotPassword();
		forgot.enterForgotPassword("ajhfgafhag@g");
		forgot.clickSubmitButton();
		Thread.sleep(500);
		String actualError= forgot.getEmailIdValidationError();
		System.out.println(actualError);
		Assert.assertEquals(actualError, "Invalid email address!");
		forgot.clickOnSignIn();
	}
	@Test (priority=4)
	public void emptyEmailValidationError () throws InterruptedException
	{
		login.clickOnForgotPassword();
		forgot.enterForgotPassword("");
		forgot.clickSubmitButton();	
		Thread.sleep(500);
		String actualError= forgot.getEmailIdValidationError();
		Assert.assertEquals(actualError, "This field is required!");
		
		forgot.clickOnSignIn();
	}

}
