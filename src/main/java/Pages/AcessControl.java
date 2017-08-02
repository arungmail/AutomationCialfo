package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BasePackage.DriverClass;

public class AcessControl extends DriverClass{
	
	public By Search = By.id("example_filter");
	public By CoachTable = By.id("example");
	
	
	
	public void clickOnActionBasedOnCoachName (String coachName) throws InterruptedException{
		driver.findElement(Search).sendKeys("adaa");
		Thread.sleep(500);
		WebElement table = driver.findElement(CoachTable);
		List <WebElement> row = driver.findElements(By.tagName("tr"));
		row.size();
		for (int i=0;i<row.size();i++){
			List<WebElement> col = row.get(i).findElements(By.tagName("td"));
			col.size();
			for (int j =0;j< col.size();j++ ){
				String coachNames = col.get(j).getText();
				if (coachNames.equals(coachName)){
					String xp1 = "html/body/div[1]/app-root/app-access-control-list/div/section[2]/div/div/div/div[2]/div/table/tbody/tr[";
					String xp2 = "]/td[5]/a/i";
					WebElement actionCol = driver.findElement(By.xpath(xp1+i+xp2));
					driver.findElement(By.xpath("//i[@class='fa fa-key']")).click();
					break;
				}
				
			}
			
		}
	
	}

}
