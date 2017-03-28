package TestCialfoNew;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import BasePackage.DriverClass;
import Pages.LoginForm;
import Pages.RegisterForm;
import junit.framework.Assert;

public class TestRegister extends DriverClass {
	LoginForm login 	= new LoginForm();
	RegisterForm reg 	= new RegisterForm();
	BaseClass base = new BaseClass();
	
	@AfterMethod
	public void clickGoTOSignpage(){
		driver.get("http://192.168.1.206:4200/login");
	}
	/*@BeforeMethod
	public void openHomePage () throws IOException{
		base.launchAUTApplication();
		
	*/
	
	@Test(priority=1)
	public void validRegistration () throws InterruptedException{
		login.clickOnRegister();
		reg.enterUserName("Arun pananagattu123hgjghgh");
		reg.enterEmail("auto35655@mailinator.com");
		reg.enterFirstname("Arun");
		reg.enterLastName("auto");
		reg.enterPhoneNumber("919901395048");
		reg.enterPassword("Nichi123");
		reg.reEnterPassword("Nichi123");
		reg.enterLocation("Cochin");		
		reg.selectYear("1990");
		reg.selectMonth("Apr");
		reg.selectDate("28");
		reg.selectRole("Coach");
		reg.selectRole("Female");
		reg.clickRegisterButton();
		Thread.sleep(500);
		String ActualUrl = driver.getCurrentUrl();
		String ExpectedUrl = "http://192.168.1.206:4200/login";
		Assert.assertEquals(ExpectedUrl, ActualUrl);	
	}
	@Test(priority=2)
	public void emptyUserNamevalidationchecks () throws InterruptedException
	{
		login.clickOnRegister();
		reg.enterUserName("");
		reg.enterEmail("auto1@mailinator.com");
		reg.enterFirstname("Arun");
		reg.enterLastName("auto");
		reg.enterPhoneNumber("919901395048");
		reg.enterPassword("Nichi123");
		reg.reEnterPassword("Nichi123");
		reg.enterLocation("Cochin");		
		reg.selectYear("1990");
		reg.selectMonth("Apr");
		reg.selectDate("28");
		reg.selectRole("Coach");
		reg.selectRole("Female");
		reg.clickRegisterButton();
		String Actual = reg.UsernamegetErrorvalidation();
		Assert.assertEquals(Actual,"This field is required!");
		
	}
	@Test(priority=3)
	public void emptyEmailIDChecks(){

		login.clickOnRegister();
		reg.enterUserName("Arun pananagattu1");
		reg.enterEmail("");
		reg.enterFirstname("Arun");
		reg.enterLastName("auto");
		reg.enterPhoneNumber("919901395048");
		reg.enterPassword("Nichi123");
		reg.reEnterPassword("Nichi123");
		reg.enterLocation("Cochin");		
		reg.selectYear("1990");
		reg.selectMonth("Apr");
		reg.selectDate("28");
		reg.selectRole("Coach");
		reg.selectRole("Female");
		reg.clickRegisterButton();
		String Actual = reg.emailErrorvalidation();
		Assert.assertEquals(Actual,"This field is required!");
		
	}
	
	@Test(priority=4)
	public void invalidEmailIdvalidationChecks ()
	{
		login.clickOnRegister();
		reg.enterUserName("Arun pananagattu1");
		reg.enterEmail("gsdfgsdgsdgs");
		reg.enterFirstname("Arun");
		reg.enterLastName("auto");
		reg.enterPhoneNumber("919901395048");
		reg.enterPassword("Nichi123");
		reg.reEnterPassword("Nichi123");
		reg.enterLocation("Cochin");		
		reg.selectYear("1990");
		reg.selectMonth("Apr");
		reg.selectDate("28");
		reg.selectRole("Coach");
		reg.selectRole("Female");
		reg.clickRegisterButton();
		String Actual = reg.emailErrorvalidation();
		Assert.assertEquals(Actual,"Invalid email address!");
		
	}
	 
	@Test(priority=5)
	public void existingEmailIDValidationChecks()
	{

		login.clickOnRegister();
		reg.enterUserName("Arun");
		reg.enterEmail("arun@mailinator.com");
		reg.enterFirstname("Arun");
		reg.enterLastName("auto");
		reg.enterPhoneNumber("919901395048");
		reg.enterPassword("Nichi123");
		reg.reEnterPassword("Nichi123");
		reg.enterLocation("Cochin");		
		reg.selectYear("1990");
		reg.selectMonth("Apr");
		reg.selectDate("28");
		reg.selectRole("Coach");
		reg.selectRole("Female");
		reg.clickRegisterButton();
		String Actual = reg.existingEmailId();
		Assert.assertEquals(Actual,"Email you are entered not available");
		
	}
	@Test(priority=6)
	public void emptyFirstnameValidationChecks()
	{
		login.clickOnRegister();
		reg.enterUserName("Arun pananagattu1");
		reg.enterEmail("sdfdfd@gmail.com");
		reg.enterFirstname("");
		reg.enterLastName("auto");
		reg.enterPhoneNumber("919901395048");
		reg.enterPassword("Nichi123");
		reg.reEnterPassword("Nichi123");
		reg.enterLocation("Cochin");		
		reg.selectYear("1990");
		reg.selectMonth("Apr");
		reg.selectDate("28");
		reg.selectRole("Coach");
		reg.selectRole("Female");
		reg.clickRegisterButton();
		String Actual = reg.firstNameErrorvalidation();
		Assert.assertEquals(Actual,"This field is required!");
		
	}
	@Test(priority=7)
	public void emptyLastNameValidationChecks()
	{
		login.clickOnRegister();
		reg.enterUserName("Arun pananagattu1");
		reg.enterEmail("Arun@fhfdhfdh.com");
		reg.enterFirstname("fdgdf");
		reg.enterLastName("");
		reg.enterPhoneNumber("919901395048");
		reg.enterPassword("Nichi123");
		reg.reEnterPassword("Nichi123");
		reg.enterLocation("Cochin");		
		reg.selectYear("1990");
		reg.selectMonth("Apr");
		reg.selectDate("28");
		reg.selectRole("Coach");
		reg.selectRole("Female");
		reg.clickRegisterButton();
		String Actual = reg.lastnameErrorvalidation();
		Assert.assertEquals(Actual,"This field is required!");
		
	}
	
	@Test(priority=8)
	public void emptyPhoneNoValidationChecks()
	{
		login.clickOnRegister();
		reg.enterUserName("Arun pananagattu1");
		reg.enterEmail("Arun@fhfdhfdh.com");
		reg.enterFirstname("fdgdf");
		reg.enterLastName("gsdgsd");
		reg.enterPhoneNumber("");
		reg.enterPassword("Nichi123");
		reg.reEnterPassword("Nichi123");
		reg.enterLocation("Cochin");		
		reg.selectYear("1990");
		reg.selectMonth("Apr");
		reg.selectDate("28");
		reg.selectRole("Coach");
		reg.selectRole("Female");
		reg.clickRegisterButton();
		String Actual = reg.phoneNumberErrorvalidation();
		Assert.assertEquals(Actual,"This field is required!");
		
	}
	

	@Test(priority=9)
	public void inValidMobileNOvalidationChecks ()
	{
		login.clickOnRegister();
		reg.enterUserName("Arun pananagattu1");
		reg.enterEmail("Arun@fhfdhfdh.com");
		reg.enterFirstname("fdgdf");
		reg.enterLastName("gsdgsd");
		reg.enterPhoneNumber("990139525255");
		reg.enterPassword("Nichi123");
		reg.reEnterPassword("Nichi123");
		reg.enterLocation("Cochin");		
		reg.selectYear("1990");
		reg.selectMonth("Apr");
		reg.selectDate("28");
		reg.selectRole("Coach");
		reg.selectRole("Female");
		reg.clickRegisterButton();
		String Actual = reg.phoneNumberErrorvalidation();
		Assert.assertEquals(Actual,"Phone number format Ex:- 917022939501");
		
	}
	
	@Test(priority=10)
	public void inValidPasswordErrorChecks ()
	{
		login.clickOnRegister();
		reg.enterUserName("Arun pananagattu1");
		reg.enterEmail("Arun@fhfdhfdh.com");
		reg.enterFirstname("fdgdf");
		reg.enterLastName("");
		reg.enterPhoneNumber("919901395048");
		reg.enterPassword("afafa");
		reg.reEnterPassword("Nichi123");
		reg.enterLocation("Cochin");		
		reg.selectYear("1990");
		reg.selectMonth("Apr");
		reg.selectDate("28");
		reg.selectRole("Coach");
		reg.selectRole("Female");
		reg.clickRegisterButton();
		String Actual = reg.passwordvaldiation();
		Assert.assertEquals(Actual,"Password must contain at least 8 characters!");
		
	}
	
	@Test(priority=11)
	public void missMatchPasswordvalidationChecks ()
	{
		login.clickOnRegister();
		reg.enterUserName("Arun pananagattu1");
		reg.enterEmail("Arun@fhfdhfdh.com");
		reg.enterFirstname("fdgdf");
		reg.enterLastName("");
		reg.enterPhoneNumber("919901395048");
		reg.enterPassword("Nichi123");
		reg.reEnterPassword("Nichi1234");
		reg.enterLocation("Cochin");		
		reg.selectYear("1990");
		reg.selectMonth("Apr");
		reg.selectDate("28");
		reg.selectRole("Coach");
		reg.selectRole("Female");
		reg.clickRegisterButton();
		String Actual = reg.missmatchtErrorvalidation();
		Assert.assertEquals(Actual,"Password do not match.");
		
	}
	
	@Test(priority=12)
	public void emptyLocationvalidationChecks()
	{
		login.clickOnRegister();
		reg.enterUserName("Arun pananagattu1");
		reg.enterEmail("Arun@fhfdhfdh.com");
		reg.enterFirstname("fdgdf");
		reg.enterLastName("gsdgsd");
		reg.enterPhoneNumber("919901395048");
		reg.enterPassword("Nichi123");
		reg.reEnterPassword("Nichi123");
		reg.enterLocation("");		
		reg.selectYear("1990");
		reg.selectMonth("Apr");
		reg.selectDate("28");
		reg.selectRole("Coach");
		reg.selectRole("Female");
		reg.clickRegisterButton();
		String Actual = reg.locationErrorvalidation();
		Assert.assertEquals(Actual,"This field is required!");
		
	}
}
