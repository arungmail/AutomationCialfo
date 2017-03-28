package TestCialfoNew;

import BasePackage.DriverClass;
import Pages.LoginForm;
import junit.framework.Assert;

public class LogInTest extends DriverClass {
	LoginForm login = new LoginForm();
	
	
	public void validLogin(){
		login.enterEmailId("sdfsdsdf");
		login.enterPassword("dskjsdjksjkd");
		login.clickSignButton();
	}
	public void emailErrorValidationChecks(){
		login.enterEmailId("sdfsdsdf");
		login.enterPassword("dskjsdjksjkd");
		login.clickSignButton();
		String error = login.signInEmailvalidationError();
		Assert.assertEquals("Invalid email address!", error);
	}
	public void passwordErrorValidationChecks ()
	{
		login.enterEmailId("sdfsdsdf@gmail.com");
		login.enterPassword("dskjsdjksjkd");
		login.clickSignButton();
		String error = login.signInEmailvalidationError();
		Assert.assertEquals("Wrong username or password. Try again.", error);
	}
	
	
	

}
