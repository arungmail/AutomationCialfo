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
import org.testng.annotations.Test;

import BasePackage.DriverClass;
import BasePackage.Utility;
import Pages.BatchList;
import Pages.DashBoard;
import Pages.LoginForm;
import Pages.SwimmersPage;

public class SwimmersTest extends DriverClass {
	LoginForm login = new LoginForm();
	DashBoard dash = new DashBoard();
	Utility util = new Utility();
	SwimmersPage swimmers = new SwimmersPage();
	BatchList batch = new BatchList();
	DriverClass driverclass = new DriverClass();
	InputValues input = new InputValues ();
	
	
	
	@Test
	
	
	/*public void checkAddedBatchIsListedOrNot()
	{
		login.enterEmailId(input.club);
		login.enterPassword(input.ClubPassword);
		login.clickSignButton();
		dash.clickOnSwimmers();
		driver.findElement(swimmers.BatchSelection).click();
		List <String> batchname = new ArrayList <String>(); 
		WebElement batchlist = driver.findElement(By.xpath("html/body/span/span/span[2]"));
		List <WebElement> batches  = batchlist.findElements(By.tagName("li"));
		for (WebElement webElement : batches)
		{
			System.out.println(webElement.getText());
			if (webElement.getText().equalsIgnoreCase("Week End Batch"))
			{
				//Thread.sleep(500);
				batchname.add("Week End Batch");
				Assert.assertEquals(webElement, "Week End Batch");
				break;
			}
		}
		
	}*/
	
	
	
	public void simmerAfterSearch() throws InterruptedException
	{
		login.enterEmailId(input.club);
		login.enterPassword(input.ClubPassword);
		login.clickSignButton();
		dash.clickOnSwimmers();
		swimmers.search(input.swimmer2);
		Thread.sleep(5000);
		
		String actulaSwimmername = driver.findElement(By.linkText(input.swimmer2)).getText();
		System.out.println(actulaSwimmername);
		String expectedSwimmername = input.swimmer2;
		Assert.assertEquals(actulaSwimmername, expectedSwimmername);
	}
	
	public void searchInvalidSwimmers () throws InterruptedException
	{
		driver.navigate().refresh();
		dash.clickOnSwimmers();
		swimmers.search("sngbdjgbsd");
		Thread.sleep(5000);
		WebElement error = driver.findElement(swimmers.DataEmptyMessage);
		String actualError = util.getErrorMessage(error);
		String expectedError = "No data available in table";
		Assert.assertEquals(actualError, expectedError);
		
	}
	

/*public void tranferSwimmersToBatch () throws InterruptedException
{
	driver.navigate().refresh();
	driver.findElement(swimmers.BatchSelection).click();
	WebElement batchResult = driver.findElement(swimmers.batchresults);
	swimmers.batchSelection(batchResult, "");
	try 
	{
	swimmers.clickCheckBoxBasedOnSwimmersName("Divya");
	driver.findElement(swimmers.BatchResultsInTransferSwimmerpage);
	WebElement batchResult1 = driver.findElement(swimmers.BatchResultsInTransferSwimmerpage);
	batch.selectCoachFromCoachList(batchResult1, "cvf");
	driver.findElement(swimmers.SubmitButonInTransferSwimmerPage).click();
	
	
	}
	catch(Exception e){
		System.out.println("swimmer not found");
	}
	
}*/
	

public void checkSwimmersisdiaplayingAfterSwimmertranfer() throws InterruptedException
{
	driver.navigate().refresh();
	dash.clickOnSwimmers();
	driver.findElement(swimmers.BatchSelection).click();
	WebElement batchList3 = driver.findElement(swimmers.batchresults);
	swimmers.batchSelection(batchList3, "");
	String actulaSwimmer = driver.findElement(By.linkText("Divya")).getText();
	
	String expectedSwimmer = "Divya";
	Assert.assertEquals(actulaSwimmer, expectedSwimmer);
	
}
public void checkbatchnameIsMatchingOrNot()
{
	swimmers.getmatchingBatch("Divya", "");
}
public void checkCoachIsmatchingOrNot()
{
	//swimmers.getmatchingCoachNameforSwimmers(swimmername, expectedCoachName);
	//swimmers.getmatchingCoachNameforSwimmers((driverclass.getValuesFromPropertiesFile("BrowserName"), "fdgf"));
}
}


	
	
  


