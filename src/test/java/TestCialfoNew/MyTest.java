package TestCialfoNew;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.DriverClass;
import Pages.DashBoard;
import Pages.LoginForm;

public class MyTest extends DriverClass{
	LoginForm login = new LoginForm();
	DashBoard dash= new DashBoard();
	
	@Test
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
	}


