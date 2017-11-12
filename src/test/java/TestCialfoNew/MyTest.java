package TestCialfoNew;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.DriverClass;
import BasePackage.Utility;
import Pages.Atendance;
import Pages.BatchList;
import Pages.DashBoard;
import Pages.LoginForm;
import Pages.PendingUsers;
import Pages.RegisterForm;
import Pages.SwimmersPage;


public class MyTest extends DriverClass{
	LoginForm login = new LoginForm();
	DashBoard dash= new DashBoard();
	BatchList batch = new BatchList();
	Utility util = new Utility();
	SwimmersPage swimmers = new SwimmersPage ();
	InputValues input = new InputValues ();
	PendingUsers pending = new PendingUsers();
	Atendance att = new Atendance ();
	public boolean swimmerstatus;
	public String swimmernames;
	RegisterForm reg = new RegisterForm ();
	private String batchName;
	

           
       
       public void vvvv() throws InterruptedException{
            	LoginForm.enterEmailId(input.club);
          		LoginForm.enterPassword(input.ClubPassword);
          		LoginForm.clickSignButton();
          		Thread.sleep(5000);
            	driver.findElement(By.xpath("html/body/div/app-root/app-side-menu/aside/section/ul/li[3]/a/span")).click();
            	Thread.sleep(5000);
            	System.out.println("sdfsd");
            	driver.findElement(By.xpath("html/body/div[1]/app-root/app-attendance/div/section[2]/div/div/div/div[1]/div[1]/div/span/span[1]/span")).click();
            	Thread.sleep(5000);
            	att.selectBatchFromBatchList("Sunday batch");
            	Thread.sleep(5000);
            	WebElement table = driver.findElement(By.xpath("html/body/div/app-root/app-attendance/div/section[2]/div/div/div/div[2]/table/tbody"));
            	List <WebElement>  row = driver.findElements(By.tagName("tr"));
            	for (int i=0;i<row.size();i++){
            		List <WebElement> col = row.get(i).findElements(By.tagName("th"));
            		col.size();
            		for (int j =0;j<col.size();j++){
            			List<WebElement> head = row.get(i).findElements(By.tagName("td"));
            			System.out.println(head.size());
            			for (int h =0;j<head.size();h++){
            				String names = col.get(h).getText();
            				System.out.println(names);
            			}
            				
            			}
            				
            			
            		}
            		
            	}
         @Test   	
            	
       public void hhhhh () throws InterruptedException{
        	LoginForm.enterEmailId(input.club);
       		LoginForm.enterPassword(input.ClubPassword);
       		LoginForm.clickSignButton();
       		Thread.sleep(5000);
     		dash.clickOnManageBatch();
     		batch.getBatchFromList("Sunday batch");
     		Assert.assertEquals(batch.getBatchFromList("sgsd"), "Sunday batch");
        	 
         }
}


	

