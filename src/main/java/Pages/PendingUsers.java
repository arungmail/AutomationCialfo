package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BasePackage.DriverClass;
import junit.framework.Assert;

public class PendingUsers extends DriverClass{
	public By FilterDropDown = By.xpath("//select[@class='form-control']");
	public By SwimmersTable  = By.xpath("//table[@id='swimmertable']");
	public By Row 				= By.tagName("tr");
	public By Col				= By.tagName("td");
	boolean swimmerstatus ;
	
	public void approveSwimmerSBasedOnName(String name) {
		WebElement table = driver.findElement(SwimmersTable);
		List <WebElement> row = table.findElements(Row);
		row.size();
		for (int i=0;i<row.size();i++){
			List<WebElement> col = row.get(i).findElements(Col);
			for (int j = 0; j < col.size(); j++) {
				String swimmernames = col.get(j).getText();
				System.err.println(swimmernames);
				if (swimmernames.equals(name)){
					String xpath1 = ".//*[@id='swimmertable']/tbody/tr[";
					String xpath2 = "]/td[5]";
					WebElement actionStatus = driver.findElement(By.xpath(xpath1+i+xpath2));
					List <WebElement> actions = actionStatus.findElements(By.xpath("//i[@title='Approve']"));
					driver.findElement(By.xpath("//i[@title='Approve']")).click();	
					break;
				}
					
				}
			
			
		}
			
		
		
	}
	
	public void rejectSwimmersBasedOnSwimmerName (String name)
	{
		WebElement table = driver.findElement(SwimmersTable);
		List <WebElement> row = table.findElements(Row);
		row.size();
		for (int i=0;i<row.size();i++){
			List<WebElement> col = row.get(i).findElements(Col);
			for (int j = 0; j < col.size(); j++) {
				String swimmernames = col.get(j).getText();
				System.err.println(swimmernames);
				if (swimmernames.equals(name)){
					String xpath1 = ".//*[@id='swimmertable']/tbody/tr[";
					String xpath2 = "]/td[5]";
					WebElement actionStatus = driver.findElement(By.xpath(xpath1+i+xpath2));
					List <WebElement> actions = actionStatus.findElements(By.xpath("//i[@title='Reject']"));
					driver.findElement(By.xpath("//i[@title='Reject']")).click();
					break;
				}
					
				}
			
			
		}
	}
	public String getSwimmersFromTable(String name){
		WebElement table = driver.findElement(SwimmersTable);
		List <WebElement> row = table.findElements(Row);
		row.size();
		List<String> swimmername = new ArrayList<String>();
		for (int i=0;i<row.size();i++){
			List<WebElement> col = row.get(i).findElements(Col);
			for (int j = 0; j < col.size(); j++) {
				String swimmernames = col.get(j).getText();
				System.err.println(swimmernames);
				if (swimmernames.equals(name)){
					swimmername.add(name);
					break;
				}
					
				}
			
			
		}
		return name;
	}
	
	public boolean swimmerIsListedOrnot (String name)
	{
		WebElement table = driver.findElement(SwimmersTable);
		List <WebElement> row = table.findElements(Row);
		row.size();
		
		for (int i=0;i<row.size();i++){
			List<WebElement> col = row.get(i).findElements(Col);
			for (int j = 0; j < col.size(); j++) {
				String swimmernames = col.get(j).getText();
				System.err.println(swimmernames);
				
				if (swimmernames.equals(name)){
					swimmerstatus = true;
					return swimmerstatus;
				}
				else {
					swimmerstatus = false;
					return swimmerstatus;
				}
			
		
		}
		}

		return swimmerstatus;
		
	}
}
	/*	
		boolean swimmerstustus = false;
		return swimmerstustus;*/
		
				

