package Pages;

import java.util.List;

import org.apache.bcel.generic.RETURN;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BasePackage.DriverClass;

public class Atendance extends DriverClass{
	
	public By BatchSelection = By.xpath("html/body/div/app-root/app-attendance/div/section[2]/div/div/div/div[1]/div[1]/div/span/span[1]/span/span[2]/b");
	public By BatchList     = By.id("select2-ieon-results");
	public By Genarate      = By.xpath("html/body/div/app-root/app-attendance/div/section[2]/div/div/div/div[1]/div[2]/div[2]/button");
	public By Search        = By.xpath("//input[@placeholder='Search']");
	public By SearchBatch   = By.xpath("//input[@class='select2-search__field']");
	public By MonthDetails  = By.xpath("//h3[@class='box-title']");
	public By BackNavigation = By.xpath("(//button[@type='button'])[1]");
	public By ForwardNavigation = By.xpath("(//button[@type='button'])[2]");
	
	public boolean batchStatus = false;
	
	public void selectBatchFromBatchList (String batchName){
		driver.findElement(BatchSelection).click();
		driver.findElement(SearchBatch).clear();
		driver.findElement(SearchBatch).sendKeys(batchName);
		WebElement list = driver.findElement(BatchList);
		List <WebElement> allList = list.findElements(By.tagName("li"));
		for (WebElement batchNames : allList){
			System.out.println(batchNames.getText());
			if (batchNames.getText().equals(batchName)){
				batchNames.click();
				break;
			}
		}
	}
	public boolean batchIsDisplayedOrNot(String batchName){
		driver.findElement(BatchSelection).click();
		driver.findElement(SearchBatch).clear();
		driver.findElement(SearchBatch).sendKeys(batchName);
		WebElement list = driver.findElement(BatchList);
		List <WebElement> allList = driver.findElements(By.tagName("li"));
		for (WebElement batchNames : allList){
			System.out.println(batchNames.getText());
			if (batchNames.getText().equals(batchName)){
				batchStatus = true;
				break;
			}
			
		}
		return batchStatus;
	}
	public String getMontheDetails (){
		String monthdetails = driver.findElement(MonthDetails).getText();
		return monthdetails;
	}
	public void clickOngenerateAttendance(){
		driver.findElement(Genarate).click();
	}
	
}
