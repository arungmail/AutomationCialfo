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
		driver.findElement(swimmers.BatchSelection).click();
		List <String> batchname = new ArrayList <String>(); 
		WebElement batchlist = driver.findElement(By.xpath("html/body/span/span/span[2]"));
		List <WebElement> batches  = batchlist.findElements(By.tagName("li"));
		for (WebElement webElement : batches){
			System.out.println(webElement.getText());
			if (webElement.getText().equalsIgnoreCase("Week End Batch")){
				//Thread.sleep(500);
				batchname.add("Week End Batch");
				Assert.assertEquals(webElement, "Week End Batch");
				break;
			}
		}
		
	}
		
	public void checkSwimmersAreListedOrNot() throws InterruptedException
	{
		login.enterEmailId("swimlife@gmail.com");
		login.enterPassword("12345678");
		login.clickSignButton();
		dash.clickOnSwimmers();
		
		swimmers.batchSelection(element, batchName);
		//driver.findElement(swimmers.BatchSelection).click();
		/*Thread.sleep(500);
		driver.findElement(By.xpath("html/body/div[1]/app-root/app-player/div/section[2]/div/div/div/div[1]/div[2]/span/span[1]/span/span[2]")).click();
		Thread.sleep(5000);
		
		WebElement list = driver.findElement(By.xpath(".//*[@id='select2-arzm-result-onox-5902100c4766635e749051f6']"));
		util.mouseOver(list);
		list.click();
		driver.findElement(By.xpath("html/body/span/span/span[1]/input")).sendKeys("Automation");
		driver.findElement(By.xpath(".//*[@id='select2-sw7l-result-paqh-590876017b31794b2a5bfe32']")).click();
		//util.selectValueByVisibleText(bactlist, "Automation Batch 1");
		try {
			String actualSwimmername = driver.findElement(By.linkText("Ipadone edited")).getText();
			String expctedSwimmername = "Ipadone edited";
			Assert.assertEquals(actualSwimmername, expctedSwimmername);
		}
		catch (Exception e) {
			System.out.println(e+"Swimmers Not Fount");
				
		}
		WebElement  tableresult = driver.findElement(By.xpath(".//*[@id='select2-arzm-results']"));
		List <WebElement> results = driver.findElements(By.tagName("li"));
		
		for (int i=0;i<results.size();i++){
			System.out.println(results.size());
			
		}
		*/
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
	
	
	public void searchSwimmers () throws InterruptedException
	{
		login.enterEmailId("swimlife@gmail.com");
		login.enterPassword("12345678");
		login.clickSignButton();
		dash.clickOnSwimmers();
		swimmers.search("sngbdjgbsd");
		Thread.sleep(5000);
		WebElement error = driver.findElement(swimmers.DataEmptyMessage);
		String actualError = util.getErrorMessage(error);
		String expectedError = "No data available in table";
		Assert.assertEquals(actualError, expectedError);
		
	}
	
	
	public void simmerAfterSearch() throws InterruptedException
	{
		login.enterEmailId("swimlife@gmail.com");
		login.enterPassword("12345678");
		login.clickSignButton();
		dash.clickOnSwimmers();
		swimmers.search("Opera1");
		Thread.sleep(5000);
		
		String actulaSwimmername = driver.findElement(By.linkText("Opera1")).getText();
		System.out.println(actulaSwimmername);
		String expectedSwimmername = "Opera1";
		Assert.assertEquals(actulaSwimmername, expectedSwimmername);
	}
	
	@Test
	public void checkCoachIsmatchingOrNot() throws InterruptedException
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
					String xpath2 = "]/td[9]";
					String actualCoachname = driver.findElement(By.xpath(xpath1+i+xpath2)).getText();
					String expectedResult  = "one Coach";
					Assert.assertEquals(actualCoachname, expectedResult);
					
				}
				
			}
		}
		
	}
	
	
	public void transfetrtheCoach () throws InterruptedException
	{
		login.enterEmailId("swimlife@gmail.com");
		login.enterPassword("12345678");
		login.clickSignButton();
		dash.clickOnSwimmers();
		//swimmers.clickCheckBoxBasedOnSwimmersName("Opera1");
		swimmers.clickOnTranferButton();
		Thread.sleep(500);
		//String MainWindow=driver.getWindowHandle();		
		
        // To handle all new opened window.				
          /*  Set <String> s1=driver.getWindowHandles();		
        Iterator<String> i1=s1.iterator();		
        		
        while(i1.hasNext())			
        {		
            String ChildWindow=i1.next();	
            System.out.println(ChildWindow);
            		
            if(!MainWindow.equalsIgnoreCase(ChildWindow))			
          {    		
                 
                    // Switching to Child window
                    driver.switchTo().window(ChildWindow);*/
                    //Thread.sleep(5000);
		/*
		String mainWinHander = driver.getWindowHandle();

		// code for clicking button to open new window is ommited

		//Now the window opened. So here reture the handle with size = 2
		Set<String> handles = driver.getWindowHandles();

		for(String handle : handles)
		{
		    if(!mainWinHander.equals(handle))
		    {
		        // Here will block for ever. No exception and timeout!
		    	WebDriver popup = driver.switchTo().window(handle);
		        // do something with popup
		        popup.close();
		    }
		}*/
		
		
/*String paranetwindowhandle = driver.getWindowHandle();	
System.out.println(paranetwindowhandle);
driver.switchTo().window(paranetwindowhandle);*/
		
		/*//Set wont allow Dublicate values 
		Set <String> allwindows = driver.getWindowHandles();
		
		//Closing all windows except parent window 
		for (String currentwindow : allwindows) {
			//driver.switchTo().window(paranetwindowhandle);
			if(!currentwindow.equalsIgnoreCase(paranetwindowhandle)){
				//driver.close();
				Thread.sleep(5000);
			*/
		
		driver.findElement(By.xpath(".//*[@id='myModal']/div/div/div[2]/div/div/span/span[1]/span/span[2]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys("Automation");
		//driver.findElement(By.xpath("(//li[@role='treeitem'])[3]")).click();
		driver.findElement(By.xpath("//li[@role='treeitem']")).click();
		
		
	//}
        //}
	}
}

	


	

