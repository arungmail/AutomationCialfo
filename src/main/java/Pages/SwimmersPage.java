package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import BasePackage.DriverClass;
import BasePackage.Utility;

public class SwimmersPage extends DriverClass{
	
	Utility util = new Utility ();
	
	public By BatchSelection			= By.xpath("//span[@title='Select Batch']");
	private By Searchbutton 			= By.xpath("//input[@type='search']");
	private By EntrySelection 			= By.xpath("//select[@name='swimmertable_length']");
	private By Homebredcrumbs			= By.xpath("html/body/div[1]/app-root/app-player/div/section[1]/ol/li[1]/a");
	private By TranferButton			= By.xpath("(//button[@type='button'])[1]");
	private By BatchSelectionInTranferPlayer = By.xpath("//span[@title='Select Batch']");
	private By SubmitButton				= By.xpath(".//*[@id='myModal']/div/div/div[3]/button[2]");
	private By CloseButton 				= By.xpath(".//*[@id='myModal']/div/div/div[3]/button[1]'");
	private By ErrorValidation 			= By.id("error_validation");
	private By Successvalidation 		= By.id("success_validation");
	private By SwimmersTable			= By.xpath("//table[@id='swimmertable']");
	private By SwimmersRow				= By.tagName("tr");
	private By SwimmersColoumn			= By.tagName("td");
	public By DataEmptyMessage 			= By.xpath("//td[@class='dataTables_empty']");
	public WebElement batchname = driver.findElement(BatchSelection);
	
	
	
	public void getCoachNameFromTable (String actual,String expected)
	{
	
		WebElement table =  driver.findElement(SwimmersTable);
		List <WebElement> row = driver.findElements(SwimmersRow);
		row.size();
		for (int i=0;i<row.size();i++){	
			List <WebElement> col = row.get(i).findElements(SwimmersColoumn);
			col.size();	
		List <String> swimmersName = new ArrayList <String>();
			for (int j=0;j<col.size();j++){
				String name = col.get(j).getText();
				if(name.equals(actual)){
					swimmersName.add(name);
					Assert.assertEquals(name,expected);
				
					//String status = System.out.println("Coach1");
					/*String xp1 = "html/body/div[1]/div[5]/div[2]/div/div/table/tbody/tr[";
					String xp2 = "]/td[6]";
					driver.findElement(By.xpath(xp1+i+xp2)).click();*/	
				}
				System.out.println(name);
			
			}
		}
	
	}
	public boolean checkBatchNameIsListedOrNot(String name)
	{
		WebElement batchList = driver.findElement(BatchSelection);
		boolean name2 = util.checkValueIsVisibleOrNot(batchList, name);
		return name2;
	}
	
	
	public void getmatchingCoachNameforSwimmers (String name, String expectedName)
	{
		WebElement coachtable = driver.findElement(SwimmersTable);
		List <WebElement> coachRow = driver.findElements(SwimmersRow);
		coachRow.size();
		
		for (int i=0;i<coachRow.size();i++){
			List <WebElement> coachCol = coachRow.get(i).findElements(SwimmersColoumn);
			coachCol.size();
			 
			for (int j=0;j< coachCol.size();j++){
				String swimmername = coachCol.get(j).getText();
				if (swimmername.equalsIgnoreCase(name)){
					String xpath1 = ".//*[@id='swimmertable']/tbody/tr/td[";
					String xpath2 = "]/a";
					String actualCoachname = driver.findElement(By.xpath(xpath1+i+xpath2)).getText();
					String expectedResult  = expectedName;
					Assert.assertEquals(actualCoachname, expectedResult);
					
				}
				
			}
		}
		
	}
	public void search(String searchKey)
	{
		WebElement searchButton = driver.findElement(Searchbutton);
		searchButton.click();
		searchButton.sendKeys(searchKey);
	}
	

}
