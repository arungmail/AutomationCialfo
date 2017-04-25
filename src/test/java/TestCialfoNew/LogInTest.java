package TestCialfoNew;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import BasePackage.DriverClass;
import Pages.LoginForm;
import junit.framework.Assert;

public class LogInTest extends DriverClass {
	LoginForm login = new LoginForm();
	

	@AfterMethod
	public void clickGoTOSignpage(){
		driver.get("http://192.168.1.206:4200/login");
	}
	public void normalLogin(){
		login.enterEmailId("swimlife@gmail.com");
		login.enterPassword("12345678");
		login.clickSignButton();
		
	}
	
	@Test(priority=1)
	public void validLogin() throws InterruptedException{
		login.enterEmailId("auto356556gg@mailinator.com");
		login.enterPassword("Nichi123");
		login.clickSignButton();
		Thread.sleep(5000);
		String ActualUrl = driver.getCurrentUrl();
		String ExpectedUrl = "http://192.168.1.206:4200/dashboard";
		Assert.assertEquals(ExpectedUrl, ActualUrl);
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
	public void passwordErrorValidationChecks ()
	{
		login.enterEmailId("sdfsdsdf@gmail.com");
		login.enterPassword("jhjghgfff");
		login.clickSignButton();
		String error = login.signInPasswordValidationError();
		Assert.assertEquals(error,"Wrong username or password. Try again.");
	}
	
	
	

}
