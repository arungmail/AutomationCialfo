package TestCialfoNew;

import org.testng.annotations.AfterMethod;

import BasePackage.BaseClass;
import BasePackage.DriverClass;
import BasePackage.Utility;
import Pages.LoginForm;
import Pages.RegisterForm;

public class BulkRegistration extends DriverClass{
	
		LoginForm login 	= new LoginForm();
		RegisterForm reg 	= new RegisterForm();
		BaseClass base = new BaseClass();
		Utility util = new Utility();
		
	@AfterMethod
	public void clickGoTOSignpage(){
			driver.get("http://192.168.1.206:4200/login");
}
	public void playerregistration () throws InterruptedException{
		login.clickOnRegister();
		reg.enterUserName("Arun pananagattu123hfdhdfd");
		reg.enterEmail("auto356556gg@mailinator.com");
		reg.enterFirstname("Arun");
		reg.enterLastName("auto");
		reg.enterPhoneNumber("919901395048");
		reg.enterPassword("Nichi123");
		reg.reEnterPassword("Nichi123");
		reg.enterLocation("Cochin");		
		reg.selectYear("1990");
		reg.selectMonth("Apr");
		reg.selectDate("28");
		//reg.selectRole("Player");
		//reg.selectRole("Male");
		reg.selectClubFromDropdownlist("Banashankari Club ( Bangalore )");
		util.selectradioButton("Female","label");
		util.selectradioButton("Player","label");
		reg.clickRegisterButton();
		Thread.sleep(500);
	}
}
		
		
		
