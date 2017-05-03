package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BasePackage.DriverClass;
import BasePackage.Utility;
import junit.framework.Assert;

public class BatchList extends DriverClass{
	Utility util = new Utility();
	private By Brecrumbs			= By.xpath("html/body/div[1]/app-root/app-manage-batch/div/section[1]/ol/li[1]/a");
	private By AddButton 			= By.xpath("html/body/div[1]/app-root/app-manage-batch/div/section[3]/div/div/div/div/div[1]/button[1]");
    private By Tranfer				= By.xpath("html/body/div[1]/app-root/app-manage-batch/div/section[3]/div/div/div/div/div[1]/button[2]");
    public By BatchTable			= By.xpath("//table[@id='batcheslist']");
    public By BatchRow				= By.tagName("tr");
    public By BacthColumn			= By.tagName("td");
    private By BatchName			= By.id("batch_name");
    public By CoachSelection 		= By.xpath(".//*[@id='coachModal']/div/div/div[2]/div/div/span/span[1]/span/span[2]");
    public By PlayerSelection		= By.xpath("html/body/div[1]/app-root/app-manage-batch/div/section[2]/div/div/div/div/form/div[1]/div[3]/div/span/span[1]/span");
    private By CreatebatchButton 	= By.xpath("//button[@type='submit']");
    private By namevalidation 		= By.id("name_validation");
    private By Commenvalidation 	= By.id("common_validation");
    public By SubmitButton 		    = By.xpath("(//button[@type='button'])[6]");
    public By CoachSearchinputBox  = By.xpath("(//input[@type='search'])[3]");
    public By Search  			=   By.xpath("(//input[@type='search'])[2]");
    
    
    public void clickOnBredCrumbs()
    {
    	driver.findElement(Brecrumbs).click();
    }
    public void clickOnSubmitButton(){
    	driver.findElement(SubmitButton).click();
    }
    
    
    public void clickOnAddbacthButton ()
    {
    	driver.findElement(AddButton).click();
    }
    public void clickOnTranferButton ()
    {
    	driver.findElement(Tranfer).click();
    }
    public void enterBacthname (String name)
    {
    	driver.findElement(BatchName).sendKeys(name);
    }
    public void clickOnCreateButton ()
    {
    	driver.findElement(CreatebatchButton).click();
    }
    public String getBatchnamevalidation(){
    	String error = driver.findElement(namevalidation).getText();
    	System.out.println(error);
    	return error;
    }
    public String  getSuccessmessage ()
    {
    	String successMessage = driver.findElement(Commenvalidation).getText();
    	System.out.println(successMessage);
    	return successMessage;
    }
    /*public void selectCoach()
    {
    	WebElement coach = driver.findElement(CoachSelection);
    	coach.click();
    	driver.findElement(By.xpath("//*[contains(@id,'rajajicoach')]")).click();
    	driver.findElement(S)
    	//List<WebElement> listItems = coach.findElements(By.tagName("li"));
    	listItems.size();
    	for (int i=0;i<lifstItems.size();i++){
    		WebElement name = listItems.get(i);
    		name.getText();
    		System.out.println(name);
    		if (name.equals("coach1")){
    			name.click();
    			
    		}
    	
    	//List <String> coachesName = new ArrayList <String>();
    	//listItems.get(0).click();
    	
    		
    	
    	
    }
    public void selectSwimmer(String name)
    {
    	WebElement swimmer = driver.findElement(PlayerSelection);
    	swimmer.click();
    	util.selectValueByVisibleText(swimmer, name);
    	
    }*/
    
    public void getBatchFromList(String batchNameInList)
    {
    	WebElement table = driver.findElement(BatchTable);
    	List <WebElement> tablerow = driver.findElements(BatchRow);
    	tablerow.size();
    	for (int i = 0;i<tablerow.size();i++){
    	  List <WebElement> tableColoumn = tablerow.get(i).findElements(BacthColumn);
    	  tableColoumn.size();
    	  List <String> batchname = new ArrayList <String>();
    	  for (int j=0;j<tableColoumn.size();j++){
    		  String name =  tableColoumn.get(j).getText();
    		  System.out.println(name);
    		  if (name.equals(batchNameInList)){
    			 
    			  batchname.add(name);
    			  //break;
    			  Assert.assertEquals(batchNameInList, name);
    			  break;
    			 	  
    		  }
    		  
    		  
    	  }
    	}
    	
    }
    public void selectCheckBoxbasedOnBatchName(String batchname)
	{
		WebElement batchtable = driver.findElement(BatchTable);
		List <WebElement> batchRow = driver.findElements(BatchRow);
		batchRow.size();
		
		for (int i=0;i<batchRow.size();i++){
			List <WebElement> swimcol = batchRow.get(i).findElements(BacthColumn);
			swimcol.size();
			 
			for (int j=0;j< swimcol.size();j++){
				String swimmernames = swimcol.get(j).getText();
				System.out.println(swimmernames);
				if (swimmernames.equalsIgnoreCase(batchname)){
					String xpath1 = ".//*[@id='batcheslist']/tbody/tr[";
					String xpath2 = "]/td[1]/input";
					driver.findElement(By.xpath(xpath1+j+xpath2)).click();
					
					
				}
				
				
			}
			break;
		}
	}
		public void searchBatch(String searchkey)
		{
			driver.findElement(Search).sendKeys(searchkey);
		}

}