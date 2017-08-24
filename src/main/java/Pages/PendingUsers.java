package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BasePackage.DriverClass;
import junit.framework.Assert;

public class PendingUsers extends DriverClass{
	public By FilterDropDown = By.xpath("(//select[@class='form-control'])[1]");
	public By FilterByRole  = By.xpath("(//select[@class='form-control'])[2]");
	public By SwimmersTable  = By.xpath(".//*[@id='swimmertable']/tbody");
	public By Row 				= By.tagName("tr");
	public By Col				= By.tagName("td");
	public boolean swimmerstatus ;
	public String swimmernames;
	
	public void approveOrRejectSwimmerSBasedOnName(String name,String action) {
		WebElement table = driver.findElement(SwimmersTable);
		List <WebElement> row = table.findElements(Row);
		row.size();
		for (int i=0;i<row.size();i++){
			List<WebElement> col = row.get(i).findElements(Col);
			for (int j = 0; j < col.size(); j++) {
				String swimmernames = col.get(j).getText();
				System.out.println(swimmernames);
				if (swimmernames.equals(name)){
					String xpath1 = "html/body/div[1]/app-root/app-approve/div/section[2]/div/div/div/div/div[3]/table/tbody/tr[";
					String xpath2 = "]/td[5]";
					WebElement actionStatus = driver.findElement(By.xpath(xpath1+i+xpath2));
					/*List <WebElement> actions = actionStatus.findElements(By.xpath("//i[@title='Approve']"));
					driver.findElement(By.xpath("//i[@title='Approve']")).click();	*/
					if (action.equals("Approve")){
						actionStatus.findElement(By.xpath("//i[@title='Approve']")).click();
						break;
					}
					else {
						actionStatus.findElement(By.xpath("//i[@title='Reject']")).click();
					}
				}
					
				}
			
			
		}
			
		
		
	}
	/*
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
			
			
		}*/
//	}
	public String getSwimmersFromTable(String name){
		WebElement table = driver.findElement(SwimmersTable);
		List <WebElement> row = table.findElements(Row);
		row.size();
		List<String> swimmername = new ArrayList<String>();
		for (int i=0;i<row.size();i++){
			List<WebElement> col = row.get(i).findElements(Col);
			for (int j = 0; j < col.size(); j++) {
				String swimmernames = col.get(j).getText();
				System.out.println(swimmernames);
				if (swimmernames.equals(name)){
					//swimmername.add(name);
					return name;
					
					//break;	
				}
				//break;
				}
			//break;
		
		}
		
		return name;
		
	}
	
	public boolean usersIsListedOrNot(String name)
	{


		//boolean swimmerstatus = false;


		WebElement table = driver.findElement(SwimmersTable);
		List <WebElement> row = table.findElements(Row);
		row.size();
		//List<String> swimmername = new ArrayList<String>();
		for (int i=0;i<row.size();i++){
			List<WebElement> col = row.get(i).findElements(Col);
			for (int j = 0; j < col.size(); j++) {
				String swimmernames = col.get(j).getText();
				System.out.println(swimmernames);
				if (swimmernames.equals(name)){
					//swimmername.add(name);

					 swimmerstatus = true;
					 break;
				}
			    
			}	
	}
		return swimmerstatus;

	}
}
	/*	
		boolean swimmerstustus = false;
		return swimmerstustus;*/

	

		
				

