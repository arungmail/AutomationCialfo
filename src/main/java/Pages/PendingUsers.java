package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BasePackage.DriverClass;

public class PendingUsers extends DriverClass{
	public By FilterDropDown = By.xpath("//select[@class='form-control']");
	public By SwimmersTable  = By.xpath("//table[@id='swimmertable']");
	public By Row 				= By.tagName("tr");
	public By Col				= By.tagName("td");
	
	
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
				}
					
				}
			
			
		}
	}

}
