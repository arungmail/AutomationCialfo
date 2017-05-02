package TestCialfoNew;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.DriverClass;
import BasePackage.Utility;
import Pages.DashBoard;
import Pages.LoginForm;
import Pages.SwimmersPage;

public class SwimmersTest extends DriverClass {
	LoginForm login = new LoginForm ();
	DashBoard dash = new DashBoard ();
	Utility util =new Utility ();
	SwimmersPage swimmers = new SwimmersPage ();
	
	@Test
	public void checkAddedBatchIsListedOrNot()
	{
		login.enterEmailId("swimlife@gmail.com");
		login.enterPassword("12345678");
		login.clickSignButton();
		dash.clickOnSwimmers();
		//boolean name = util.selectValueByVisibleText(swimmers.batchname, "Automation Batch 1");
		boolean batchlist = swimmers.checkBatchNameIsListedOrNot("Automation Batch 1");
		Assert.assertEquals(batchlist, true);
		
	}
	
	public void checkSwimmersAreListedOrNot()
	{
		login.enterEmailId("swimlife@gmail.com");
		login.enterPassword("12345678");
		login.clickSignButton();
		dash.clickOnSwimmers();
		WebElement bactlist = driver.findElement(swimmers.BatchSelection);
		util.selectValueByVisibleText(bactlist, "Automation Batch 1");
		try {
			String actualSwimmername = driver.findElement(By.linkText("Ipadone edited")).getText();
			String expctedSwimmername = "Ipadone edited";
			Assert.assertEquals(actualSwimmername, expctedSwimmername);
		}
		catch (Exception e) {
			System.out.println(e+"Swimmers Not Fount");
				
		}
		
	}
		
	public void checkCoachNameIsMatchingOrNot()
	{
		login.enterEmailId("swimlife@gmail.com");
		login.enterPassword("12345678");
		login.clickSignButton();
		dash.clickOnSwimmers();
		WebElement bactlist = driver.findElement(swimmers.BatchSelection);
		util.selectValueByVisibleText(bactlist, "Automation Batch 1");
		swimmers.getmatchingCoachNameforSwimmers("Ipadone edited ", "rajaji rcoach1");
	}
		
	public void searchSwimmers ()
	{
		login.enterEmailId("swimlife@gmail.com");
		login.enterPassword("12345678");
		login.clickSignButton();
		dash.clickOnSwimmers();
		swimmers.search("sngbdjgbsd");
		WebElement error = driver.findElement(swimmers.DataEmptyMessage);
		String actualError = util.getErrorMessage(error);
		String expectedError = "No data available in table";
		Assert.assertEquals(actualError, expectedError);
		
	}
	public void simmerAfterSearch()
	{
		login.enterEmailId("swimlife@gmail.com");
		login.enterPassword("12345678");
		login.clickSignButton();
		dash.clickOnSwimmers();
		swimmers.search("Opera1");
		String actulaSwimmername = driver.findElement(By.linkText("Opera1")).getText();
		String expectedSwimmername = "Opera1";
		Assert.assertEquals(actulaSwimmername, expectedSwimmername);
	}
		
	}
	
	

