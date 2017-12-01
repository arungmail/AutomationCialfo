package TestCialfoNew;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.DriverClass;
import BasePackage.Utility;
import Pages.BatchList;
import Pages.CoachesPage;
import Pages.DashBoard;
import Pages.LoginForm;
import Pages.ProfilePage;
import Pages.SwimmersPage;

public class SwimmersTest extends DriverClass {
	LoginForm login = new LoginForm();
	DashBoard dash = new DashBoard();
	Utility util = new Utility();
	SwimmersPage swimmers = new SwimmersPage();
	BatchList batch = new BatchList();
	DriverClass driverclass = new DriverClass();
	InputValues input = new InputValues();
	CoachesPage coach = new CoachesPage ();
	ProfilePage profile = new ProfilePage ();
	
	
	
	
	
	public void refreshandclickOnSwimmers () throws InterruptedException{
		driver.navigate().refresh();
		dash.clickOnSwimmers();
		Thread.sleep(5000);
		
	}
	@Test(priority=10)
	
	//TC 1 - Adding swimmer
	public void addSwimmer () throws InterruptedException{
		LoginForm.enterEmailId(input.club);
  		LoginForm.enterPassword(input.ClubPassword);
  		LoginForm.clickSignButton(); 
  		Thread.sleep(5000);
	}
		/*driver.navigate().refresh();
		dash.clickOnSwimmers();
		driver.findElement(swimmers.AddSwimmerButton).click();
		swimmers.addSwimmer("Arun", input.Swimmer1EmailID, "Sel", "SwimmerOne", "Nichi123", "Nichi123", "8753659888", "Bangalore");	
	}
	
	@Test(priority=10)
	
	//TC 2 - Add swimmer validation 
	public void addSwimmerValidationError (){
		driver.findElement(swimmers.AddSwimmerButton).click();
			
	}
	*/
	//TC 3 - Verifying swimmer in Unassignd List
	
	 @Test(priority=11)
	public void verifySwimmerInUnassignedList () throws InterruptedException{
		 dash.clickOnSwimmers();
		 //driver.findElement(By.xpath("/html/body/div/app-root/app-player/div/section[2]/div/div/div/div[1]/div[2]/div[1]/span/span[1]/span/span[2]")).click();
		swimmers.batchSelection("Un Assigned");
		swimmers.search(input.Swimmer1EmailID);
		boolean swiimerStatus = swimmers.getBooleanvalue(input.Swimmer1EmailID);
		Assert.assertEquals(swiimerStatus, true);
	}
	
	//TC 4 - Add Coach
	public void addCoach (){
		dash.clickOnCoach();
        driver.findElement(coach.AddCoachButton).click();
        coach.addCoach("coach", input.Coach1EmailID, "Sel", "CoachOne", "Nichi123", "Nichi123", "8977445566", "Bangalore");
		
	}
	
	//TC 5- Verify Added Coaches in Coaches Page 
	public void verifyAddedCoachInCoachesPage (){
		dash.clickOnCoach();
		boolean coachStatus = coach.coachStatusInCoachesPage(input.Coach1EmailID);
		Assert.assertEquals(coachStatus, true);
	}
	
	//TC 6 Verify Coaches in Swimmers coach selection page 
	public void verifyCoachInSwimmersCoachSelectionPage () throws InterruptedException{
		swimmers.checkCoachStatus(input.Coach1Name);
		Assert.assertEquals(swimmers.checkCoachStatus(input.Coach1Name), true);
	}
	
	// TC 7 - Verify coach name in unassign swimmer
	public void verifyCoachNameforUnAssignedSwimmer (){
		dash.clickOnSwimmers();
		String coachName = swimmers.getmatchingCoachNameforSwimmers(input.Swimmer1EmailID);
		Assert.assertEquals(coachName, "");
	}
	
	public void verifyBatchname (){
		String batchname = swimmers.getmatchingBatch(input.Swimmer1EmailID);
		Assert.assertEquals(batchname, "Un Assigned");
	}
	
	//TC 8 - Verify Attendance Percentage of UnAssignswimmer
	public void verifyAttendanePecenatgeofUnAssignedSwimmer (){
		String per = swimmers.getAtendancePercentage(input.Swimmer1EmailID);
		Assert.assertEquals(per, "0.0%");
		
	}
	
	//TC - 9 Verify Swimmers Profile
	public void verifySwimmerProfileFromSwimmersPage (){
		dash.clickOnSwimmers();
		driver.findElement(By.partialLinkText(input.Swimmer1Name)).click();
		String profileName = driver.findElement(profile.ProfleNameInOverViewpage).getText();
		System.out.println(profileName);
		Assert.assertTrue(profileName.contains(input.Swimmer1Name));
	}
	
	//TC - 10 Verify Swimmers email id in Profile page 
	public void verifySwimmersEmailIdInProfilePage (){
		String emailId = driver.findElement(By.linkText(input.Swimmer1EmailID)).getText();
		Assert.assertEquals(emailId, input.Swimmer1EmailID);
	}
	
	//TC - 11  Verify coach Profile 
	public void verifyCoachProfileFromSwimmersPage (){
		dash.clickOnSwimmers();
		driver.findElement(By.linkText(input.Coach1Name)).click();
		String coachname = driver.findElement(profile.ProfleNameInOverViewpage).getText();
		Assert.assertEquals(coachname, input.Coach1Name);
	}

}
