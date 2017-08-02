package Pages;

import java.util.List;

import org.apache.bcel.generic.RETURN;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BasePackage.DriverClass;

public class Atendance extends DriverClass{
	
	public By BatchSelection = By.xpath("(//span[@class='select2-selection__arrow'])[19]");
	public By BatchList     = By.id("select2-9zfz-results");
	public By Genarate      = By.xpath("html/body/div/app-root/app-attendance/div/section[2]/div/div/div/div[1]/div[2]/div[2]/button");
	public By Search        = By.xpath("//input[@placeholder='Search']");
	public By MonthDetails  = By.xpath("//h3[@class='box-title']");
	public By BackNavigation = By.xpath("(//button[@type='button'])[1]");
	public By ForwardNavigation = By.xpath("(//button[@type='button'])[2]");
	
	public boolean batchStatus;
	
	public void selectBatchFromBatchList (String batchName){
		WebElement list = driver.findElement(BatchList);
		List <WebElement> allList = driver.findElements(By.tagName("li"));
		for (WebElement batchNames : allList){
			System.out.println(batchNames.getText());
			if (batchNames.getText().equals(batchName)){
				batchNames.click();
			}
		}
	}
	public boolean batchIsDisplayedOrNot(String batchName){
		WebElement list = driver.findElement(BatchList);
		List <WebElement> allList = driver.findElements(By.tagName("li"));
		for (WebElement batchNames : allList){
			System.out.println(batchNames.getText());
			if (batchNames.getText().equals(batchName)){
				batchStatus = true;
			}
			else {
				batchStatus = false;
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
