package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BasePackage.DriverClass;
import BasePackage.Utility;

public class BatchList extends DriverClass{
	Utility util = new Utility();
	private By Brecrumbs			= By.xpath("html/body/div[1]/app-root/app-manage-batch/div/section[1]/ol/li[1]/a");
	private By AddButton 			= By.xpath("html/body/div[1]/app-root/app-manage-batch/div/section[3]/div/div/div/div/div[1]/button[1]");
    private By Tranfer				= By.xpath("html/body/div[1]/app-root/app-manage-batch/div/section[3]/div/div/div/div/div[1]/button[2]");
    private By BatchTable			= By.xpath("//table[@id='batcheslist']");
    private By BatchRow				= By.tagName("tr");
    private By BacthColumn			= By.tagName("td");
    private By BatchName			= By.id("batch_name");
    public By CoachSelection 		= By.xpath("(//span[@title=' Select Coach'])[1]");
    public By PlayerSelection		= By.xpath("html/body/div[1]/app-root/app-manage-batch/div/section[2]/div/div/div/div/form/div[1]/div[3]/div/span/span[1]/span");
    private By CreatebatchButton 	= By.xpath("//button[@type='submit']");
    private By namevalidation 		= By.id("name_validation");
    private By Commenvalidation 	= By.id("common_validation");
    
    
    public void clickOnBredCrumbs()
    {
    	driver.findElement(Brecrumbs).click();
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
    public void selectCoach()
    {
    	WebElement coach = driver.findElement(CoachSelection);
    	coach.click();
    	List<WebElement> listItems = coach.findElements(By.tagName("li"));
    	listItems.size();
    	for (int i=0;i<listItems.size();i++){
    		String name = listItems.get(i).getText();
    		if (name.equals("coach1")){
    			
    		}
    	}
    		
    	//List <String> coachesName = new ArrayList <String>();
    	//listItems.get(0).click();
    	
    		
    	
    	
    }
    public void selectSwimmer(String name)
    {
    	WebElement swimmer = driver.findElement(PlayerSelection);
    	swimmer.click();
    	util.selectValueByVisibleText(swimmer, name);
    	
    }
    
}
