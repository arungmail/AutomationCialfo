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
	public boolean swimmerstatus;
	public String swimmernames;
	
public boolean status;
	
	
	
	@Test
	
	public void  hdhd (){
		LoginForm.enterEmailId(input.club);
		LoginForm.enterPassword(input.ClubPassword);
		LoginForm.clickSignButton();
		driver.findElement(dash.PendingUsers).click();
		WebElement filter = driver.findElement(pending.FilterDropDown);
		WebElement role = driver.findElement(pending.FilterByRole);
		util.selectValueByValue(filter, "inactive");
		util.selectValueByValue(role, "Player");
		pending.getSwimmersFromTable("Auto");
		/*LoginForm.enterEmailId(input.club);
		LoginForm.enterPassword(input.ClubPassword);
		LoginForm.clickSignButton();
		driver.findElement(dash.PendingUsers).click();
		WebElement filter = driver.findElement(pending.FilterDropDown);
		WebElement role = driver.findElement(pending.FilterByRole);
		util.selectValueByValue(filter, "inactive");
		util.selectValueByValue(role, "Player");
		WebElement table = driver.findElement(pending.SwimmersTable);
		List <WebElement> row = table.findElements(pending.Row);
		row.size();
		
		for (int i=0;i<row.size();i++){
			List<WebElement> col = row.get(i).findElements(pending.Col);
			for (int j = 0; j < col.size(); j++) {
				String swimmernames = col.get(j).getText();
				System.err.println(swimmernames);
				
				if (swimmernames.contentEquals("autoswimmer1@mailinator.com")){
					System.out.println("pass");
					
				}
				else {
					System.out.println("false");
				}
				
				if (swimmernames.equals(input.UnApprovedCoach1EmailID)){
					swimmerstatus = true;
					//return swimmerstatus;
				}
				else {
					swimmerstatus = false;
					//return swimmerstatus;
				}
			
		
		}
		}
		return swimmerstatus;	
	}
	

		return swimmerstatus;
		
		driver.findElement(dash.PendingUsers).click();
		WebElement filter = driver.findElement(pending.FilterDropDown);
		WebElement role = driver.findElement(pending.FilterByRole);
		util.selectValueByValue(filter, "inactive");
		util.selectValueByValue(role, "Player");
		WebElement table = driver.findElement(By.xpath(".//*[@id='swimmertable']/tbody"));
		List <WebElement> row = table.findElements(By.tagName("tr"));
		row.size();
		for (int i=0;i<row.size();i++){
			List <WebElement>  col = row.get(i).findElements(By.tagName("td"));
			col.size();
			for (int j =0;j<col.size();j++){
				String cv = col.get(j).getText();
				System.out.println(cv);
				if (cv.equals("autoswimmer1@mailinator.com")){
					status = true;
					
					}
				else 
					status = false; ;
				}
			
			}
		return status;
			
			
		}
		
		
		driver.findElement(dash.PendingUsers).click();
		WebElement filter = driver.findElement(pending.FilterDropDown);
		WebElement role = driver.findElement(pending.FilterByRole);
		util.selectValueByValue(filter, "inactive");
		util.selectValueByValue(role, "Player");
		pending.usersIsListedOrNot(input.UnApprovedSwimmer1EmailID);
		boolean swimmerStatus = pending.usersIsListedOrNot(input.UnApprovedSwimmer1EmailID);
		Assert.assertEquals(swimmerStatus, true);
			}
		}
		*/
	}
	
}


	

