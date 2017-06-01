package TestCialfoNew;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
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
import Pages.PendingUsers;
import Pages.SwimmersPage;

public class MyTest extends DriverClass{
	LoginForm login = new LoginForm();
	DashBoard dash= new DashBoard();
	BatchList batch = new BatchList();
	Utility util = new Utility();
	SwimmersPage swimmers = new SwimmersPage ();
	InputValues input = new InputValues ();
	PendingUsers pending = new PendingUsers();
	
	
	
	
	public void checkCoach(){
		login.enterEmailId("swimlife@gmail.com");
		login.enterPassword("12345678");
		login.clickSignButton();
		dash.clickOnCoach();
		WebElement table =  driver.findElement(By.xpath("//table [@id='example']"));
		List <WebElement> row = driver.findElements(By.tagName("tr"));
		row.size();
		for (int i=0;i<row.size();i++){	
			List <WebElement> col = row.get(i).findElements(By.tagName("td"));
			col.size();	
		List <String> coachnames = new ArrayList <String>();
			for (int j=0;j<col.size();j++){
				String cv = col.get(j).getText();
				if(cv.contentEquals("one coach")){
					coachnames.add(cv);
					Assert.assertEquals(cv,"onc coach");
				}
					
			        
				//Assert.assertEquals(cv,"one Coach");
					//String status = System.out.println("Coach1");
					/*String xp1 = "html/body/div[1]/div[5]/div[2]/div/div/table/tbody/tr[";
					String xp2 = "]/td[6]";
					driver.findElement(By.xpath(xp1+i+xp2)).click();*/	
				System.out.println(cv);
				
			}
			
		}
			
			
			
		}
	/*@Test
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
	
	*/
	
	
	/*@Test 
	public void wwww() throws InterruptedException
	{
		login.enterEmailId("swimlife@gmail.com");
		login.enterPassword("12345678");
		login.clickSignButton();
		dash.clickOnManageBatch();
	WebElement batchtable = driver.findElement(By.xpath("//table[@id='batcheslist']"));
	List <WebElement> batchRow = driver.findElements(By.tagName("tr"));
	batchRow.size();
	
	for (int i=0;i<batchRow.size();i++){
		List <WebElement> swimcol = batchRow.get(i).findElements(By.tagName("td"));
		swimcol.size();
		System.out.println(swimcol.size());
		 
		for (int j=0;j< swimcol.size();j++){
			String swimmernames = swimcol.get(j).getText();
			System.err.println(swimmernames);
			if (swimmernames.equalsIgnoreCase("First bacth")){
				String xpath1 = ".//*[@id='batcheslist']/tbody/tr[";
				String xpath2 = "]/td[1]/input";
				driver.findElement(By.xpath(xpath1+i+xpath2)).click();
				Thread.sleep(500);
				
				
			}
			
			
		}
		
	}*/
	//}
	
	
	public void swimmertest () throws InterruptedException
	{

		login.enterEmailId("swimlife@gmail.com");
		login.enterPassword("12345678");
		login.clickSignButton();
		dash.clickOnSwimmers();
		swimmers.search("Opera1");
		Thread.sleep(5000);
		WebElement swimmerstable = driver.findElement(swimmers.SwimmersTable);
		List <WebElement> swimRow = driver.findElements(swimmers.SwimmersRow);
		swimRow.size();
		
		for (int i=0;i<swimRow.size();i++){
			List <WebElement> swimcol = swimRow.get(i).findElements(swimmers.SwimmersColoumn);
			swimcol.size();
			 
			for (int j=0;j< swimcol.size();j++){
				String swimmernames = swimcol.get(j).getText();
				System.err.println(swimmernames);
				if (swimmernames.equalsIgnoreCase("Opera1")){
					String xpath1 = ".//*[@id='swimmertable']/tbody/tr[";
					String xpath2 = "]/td[1]";

                   driver.findElement(By.xpath(xpath1+i+xpath2)).click();
                   Thread.sleep(500);
					/*String expectedResult  = "one Coach";
					Assert.assertEquals(actualCoachname, expectedResult);*/
					
				}
				
			}
		}
		
	}
	
	public void sdfhdhasf() throws InterruptedException
	{

		login.enterEmailId("swimlife@gmail.com");
		login.enterPassword("12345678");
		login.clickSignButton();	
	
	dash.clickOnManageBatch();
	//batch.searchBatch("Automation");
	batch.selectCheckBoxbasedOnBatchName("Children Morning batch 10 AM To 11 AM");
	Thread.sleep(500);
	batch.clickOnTranferButton();
	Thread.sleep(500);
	String paranetwindowhandle = driver.getWindowHandle();	
	System.out.println(paranetwindowhandle);
	driver.switchTo().window(paranetwindowhandle);
	driver.findElement(batch.CoachSelection).click();
	Thread.sleep(5000);;
	WebElement coachlist = driver.findElement(By.xpath("html/body/span/span/span[2]"));
	List <WebElement> coaches  = coachlist.findElements(By.tagName("li"));
	for (WebElement webElement : coaches){
		System.out.println(webElement.getText());
		if (webElement.getText().equalsIgnoreCase("Murali")){
			webElement.click();
		   break;
			
		}
		
	}
	/*driver.findElement(batch.CoachSearchinputBox).sendKeys("Coach3");
	Thread.sleep(500);*/
	driver.findElement(By.xpath(".//*[@id='coachModal']/div/div/div[3]/button[2]")).click();
	
	/*String paranetwindowhandle = driver.getWindowHandle();	
	System.out.println(paranetwindowhandle);
	driver.switchTo().window(paranetwindowhandle);
	driver.findElement(batch.CoachSelection).click();
	Thread.sleep(500);;
	driver.findElement(batch.CoachSearchinputBox).sendKeys("Coach3");
	Thread.sleep(500);
	driver.findElement(By.xpath("//li[@role='treeitem']")).click();
	
	batch.clickOnSubmitButton();
	Thread.sleep(500);
	batch.getSuccessmessage();
	System.out.println(batch.getSuccessmessage());*/
	
	
}
	
	
	/*@Test
	public void checkAddedBatchIsListedOrNot() throws InterruptedException
	{
		login.enterEmailId("swimlife@gmail.com");
		login.enterPassword("12345678");
		login.clickSignButton();
		dash.clickOnSwimmers();
		//boolean name = util.selectValueByVisibleText(swimmers.batchname, "Automation Batch 1");
		boolean batchlist = swimmers.checkBatchNameIsListedOrNot("Automation Batch 1");
		Assert.assertEquals(batchlist, true);
		driver.findElement(swimmers.BatchSelection).click();
		//driver.findElement(By.xpath("html/body/span/span/span[1]/input")).sendKeys("Week End Batch");
		String paranetwindowhandle = driver.getWindowHandle();	
		System.out.println(paranetwindowhandle);
		driver.switchTo().window(paranetwindowhandle);
		WebElement batchlist = driver.findElement(By.xpath("html/body/span/span/span[2]"));
		swimmers.batchSelection(batchlist,"Week End Batch");
	    driver.findElement(By.xpath("html/body/div[1]/app-root/app-manage-group/div/section[3]/div[1]/div[4]/div/div/span[2]")).click();

		List <WebElement> batches  = batchlist.findElements(By.tagName("li"));
		for (WebElement webElement : batches){
			System.out.println(webElement.getText());
			if (webElement.getText().equalsIgnoreCase("Week End Batch")){
				//Thread.sleep(500);
				webElement.click();
				break;
				
				
			}
			
		}
	
		driver.findElement(By.xpath("html/body/div[1]/app-root/app-manage-group/div/section[3]/div[1]/div[4]/div/div/span[2]")).click();
	}
	*/


public void addingBatch() throws InterruptedException
{
	login.enterEmailId("swimlife@gmail.com");
	login.enterPassword("12345678");
	login.clickSignButton();
	dash.clickOnManageBatch();
	batch.clickOnAddbacthButton();
	batch.enterBacthname("Automation Batch 1");
	driver.findElement(batch.CoachSelection).click();
	Thread.sleep(500);
	WebElement coachlist = driver.findElement(batch.CoachResult);
	batch.selectCoachFromCoachList(coachlist,"Murali");
	//driver.findElement(By.xpath("//*[contains(@id,'rajajicoach')]")).click();
	Thread.sleep(5000);
	driver.findElement(batch.PlayerSelection).click();
	WebElement swimmersLilst = driver.findElement(batch.SwimmersResult);
	batch.selectSwimmersFromCoachList(swimmersLilst, "Divya");
	
	batch.clickOnCreateButton();
	
}

public void tranferBatch() throws InterruptedException
{
	login.enterEmailId("swimlife@gmail.com");
	login.enterPassword("12345678");
	login.clickSignButton();
	dash.clickOnManageBatch();
	//batch.searchBatch("Automation");
	batch.selectCheckBoxbasedOnBatchName("Sunday Batch on 6PM to 7 PM");
	batch.clickOnTranferButton();
	Thread.sleep(500);
	String paranetwindowhandle = driver.getWindowHandle();	
	System.out.println(paranetwindowhandle);
	driver.switchTo().window(paranetwindowhandle);
	driver.findElement(batch.CoachSelectionInTranferBatch).click();
	Thread.sleep(500);
	WebElement coachresult = driver.findElement(batch.CoachResult);
	
	batch.selectCoachFromCoachList(coachresult,"RajKumar");
	
	
	batch.clickOnSubmitButton();
	Thread.sleep(500);
	batch.getSuccessmessage();
	System.out.println(batch.getSuccessmessage());
	
}
@Test 

public void testt () throws InterruptedException
{
	login.enterEmailId(input.club);
	login.enterPassword(input.ClubPassword);
	login.clickSignButton();
	Thread.sleep(500);
	driver.findElement(dash.ChangeLocationButton).click();
	util.handleWindow();
	driver.findElement(By.xpath("html/body/div[1]/app-root/app-header-menu/header/nav/div/ul/li[1]/ul[2]/li[2]/ul/li[4]/a/span")).click();
	WebElement allLocation = driver.findElement(dash.ChangeLocationList);
	List <WebElement> alllocationList = allLocation.findElements(By.tagName("li"));
	for (WebElement webElement : alllocationList){
		System.out.println(webElement.getText());
		if (webElement.getText().equalsIgnoreCase("St. Joseph Indian High School, Vittal Mallya Road")){
			Thread.sleep(500);
			webElement.click();
			break;
		}
		else {
			System.out.println("zdgdsg");
		}
		driver.findElement(By.id("sfgdfgsdf")).click();
	}
	
	
			
}


}

	

