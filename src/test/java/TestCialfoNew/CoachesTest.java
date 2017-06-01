package TestCialfoNew;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import BasePackage.DriverClass;
import Pages.CoachesPage;
import Pages.DashBoard;
import Pages.LoginForm;
import junit.framework.Assert;

public class CoachesTest extends DriverClass{
	LoginForm login = new LoginForm();
	DashBoard dash	= new DashBoard();
	CoachesPage coach = new CoachesPage();
	InputValues input = new InputValues ();
	
	@Test(priority=1)
	public void checkTitleOfCoachPage () throws InterruptedException
	{
		login.enterEmailId(input.club);
		login.enterPassword(input.ClubPassword);
		login.clickSignButton();
		dash.clickOnCoach();
		Thread.sleep(500);
		String actualCoachPageTitle = driver.findElement(By.xpath("html/body/div[1]/app-root/app-coach/div/section[1]/h1")).getText();
		String expectedResultTitle = "Coach";
		Assert.assertEquals(expectedResultTitle, actualCoachPageTitle);
	}
	
	@Test(priority=2)
	public void checkCoachPageSubTitle()
	{
		
		String actualCoachPageSubTitle = driver.findElement(By.xpath("//h3[@class='box-title']")).getText();
		String expctedCoachPageSubTitle = "Coach List";
		Assert.assertEquals(expctedCoachPageSubTitle, actualCoachPageSubTitle);
	}
	
	@Test(priority=4)
	public void verifySearch()
	{
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(input.coach);
		String actuLCoachName = driver.findElement(By.linkText(input.coach)).getText();
		String expectedCoach = input.coach;
		Assert.assertEquals(expectedCoach, actuLCoachName);
		
	}
	@Test(priority=5)
     public void coachRedirectingToCoachProfilePage () throws InterruptedException
     {
    	 dash.clickOnCoach();
    	 driver.findElement(By.linkText(input.coach)).click();
    	 Thread.sleep(500);
    	 String actualCoachProfileName = driver.findElement(By.xpath("//h1[@class='font-green sbold uppercase']")).getText();
    	 String expectedCoachname = input.coach;
    	 Assert.assertEquals(expectedCoachname, actualCoachProfileName);
    	 Thread.sleep(500);
    	 dash.logingOut();
    	 
     }
}
