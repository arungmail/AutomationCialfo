package BasePackage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import Pages.LoginForm;
import TestCialfoNew.InputValues;

public class BaseClass extends DriverClass{
	InputValues input = new InputValues ();
	
	DriverClass driverclass = new DriverClass();
	
	
	/*
	@BeforeTest
	

	public void checkWebSiteLogedinOrnot () throws InterruptedException{
		System.out.println("test");
		boolean checks = driver.findElement(By.xpath("//i[@class='fa fa-map-marker']")).isDisplayed();
		if (checks==false){
			LoginForm.enterEmailId(input.club);
	  		LoginForm.enterPassword(input.ClubPassword);
	  		LoginForm.clickSignButton(); 
	  		Thread.sleep(500);
		}
		
	}*/
	@BeforeSuite
	// Launching Application 
	public void launchAUTApplication () throws IOException
	{
		driverclass.launchBrowser(driverclass.getValuesFromPropertiesFile("BrowserName"));			
		//driver.manage().window().maximize();
	}
	
	@AfterSuite
	//Closing Application 
	public void cleanUp()
	{
		driver.close();	
    }
	
}
