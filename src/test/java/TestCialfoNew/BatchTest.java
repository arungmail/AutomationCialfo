package TestCialfoNew;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.DriverClass;
import BasePackage.Utility;
import Pages.BatchList;
import Pages.DashBoard;
import Pages.LoginForm;
import Pages.SwimmersPage;

public class BatchTest extends DriverClass{
	LoginForm login = new LoginForm();
	DashBoard dash = new DashBoard();
	BatchList batch = new BatchList();
	Utility util = new Utility();
	SwimmersPage swimmers = new SwimmersPage ();
	
	
	/*@Test(priority=1)
	public void addingBatch() throws InterruptedException
	{
		login.enterEmailId("swimlife@gmail.com");
		login.enterPassword("12345678");
		login.clickSignButton();
		dash.clickOnManageBatch();
		batch.clickOnAddbacthButton();
		//batch.enterBacthname("Autommation bActch One");
	    WebElement coachSelection = (WebElement) batch.CoachSelection;
	    WebElement swimmerSelection = (WebElement) batch.PlayerSelection;
	    util.selectValueByVisibleText(coachSelection,"coach1");
	    util.selectValueByVisibleText(swimmerSelection, "swimmer2");
		batch.enterBacthname("Automation Batch 1");
		driver.findElement(batch.CoachSelection).click();
		driver.findElement(By.xpath("//*[contains(@id,'rajajicoach')]")).click();
		Thread.sleep(5000);
		driver.findElement(batch.PlayerSelection).click();
		driver.findElement(By.xpath("//*[contains(@id,'Ipadswimmer')]")).click();
		batch.clickOnCreateButton();
		String actualSuccessMessage = batch.getSuccessmessage();
		String expectedSucesMessage = "Batch Added Successfully";
		Assert.assertEquals(actualSuccessMessage, expectedSucesMessage);   	
	}
	@Test(priority=2)
	public void addedbatchIsListedOrNot() throws InterruptedException
	{
		login.enterEmailId("swimlife@gmail.com");
		login.enterPassword("12345678");
		login.clickSignButton();
		dash.clickOnManageBatch();
		Thread.sleep(5000);
		batch.getBatchFromList("Automation Batch 1");
	}*/
	/*@Test
	public void getDriverInstance(){*/
		
	
	@Test(priority=3)
	public void checkBatchNamevalidation() throws InterruptedException
	{
		login.enterEmailId("swimlife@gmail.com");
		login.enterPassword("12345678");
		login.clickSignButton();
		dash.clickOnManageBatch();
		batch.clickOnAddbacthButton();
		batch.enterBacthname("");
		driver.findElement(batch.CoachSelection).click();
		driver.findElement(By.xpath("//*[contains(@id,'rajajicoach')]")).click();
		Thread.sleep(5000);
		driver.findElement(batch.PlayerSelection).click();
		driver.findElement(By.xpath("//*[contains(@id,'Ipadswimmer')]")).click();
		batch.clickOnCreateButton();
		String actualSuccessMessage = batch.getBatchnamevalidation();
		String expectedSucesMessage = "This field is required!";
		Assert.assertEquals(actualSuccessMessage, expectedSucesMessage); 
	}
	
	
}
