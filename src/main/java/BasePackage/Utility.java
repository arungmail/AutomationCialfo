package BasePackage;

import java.io.File;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.jna.platform.FileUtils;

public class Utility extends DriverClass{
	
	//Select item from drop down by index number 
	public void selectvalueByIndex(WebElement element, int no)
	{
		Select select = new Select (element);
		select.selectByIndex(no);
	}
	//Select item from drop down by visible text 
	public void selectValueByVisibleText(WebElement element, String valueToSet)
	{
	Select select = new Select (element);
	select.selectByVisibleText(valueToSet);	
	}
	public boolean checkValueIsVisibleOrNot (WebElement element, String valueToVisible)
	{
		Select select = new Select (element);
		select.selectByVisibleText(valueToVisible);
		return true;
	}
	
	//Select item from drop down by value
	public void selectValueByValue(WebElement element, String valueToSet)
	{
		Select select = new Select(element);
		select.selectByValue(valueToSet);
	}
	// Get Alert text from alert message 
	public void getTextOfAlert()
	{
		Alert alert = driver.switchTo().alert();
		alert.getText();
		System.out.println("Alert message"+ alert.getText());
	}
	//Accept Alert message
	public void acceptAlert()
	{
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	//Dismiss alert message 
	public void dissmisAlert()
	{
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	//Select a Checkbox, if it is not selected already
		public void selectCheckBoxIfSelectedAlready(WebElement element)
		{
			try {
				if (element.isSelected())
			{
				System.out.print("Checkbox: " + element + "is already selected");
			}
			else {
				element.click();}
				}
			catch (Exception e){
				System.out.print("Unable to deselect checkbox: "+element);
			}		
		}
		
		//Deselect a check box if it is selected Already 
		public void deSelectCheckBoxIfSelectedAlready(WebElement element)
		{
			try {
				if(element.isSelected())
				{
					element.click();
				}
				else {
					System.out.println("Checkbox: "+element+"is already deselected");
				}
			}
				catch (Exception e){
					System.out.println("Unable to deselect checkbox: "+element);
				}
			}
		//Mouse over action 
		public void mouseOver(WebElement element)
		{
			Actions action = new Actions (driver);
			action.moveToElement(element).build().perform();	
		}
		//Drag and Drop source to Destination 
		public void dragAndDrop(WebElement element1,WebElement element2)
		{
			Actions action = new Actions(driver);
			action.dragAndDrop(element1, element2).build().perform();
		}
		
		public void selectradioButton(String valueToSelect, String tagname )
		{
			List<WebElement> allOptions = driver.findElements(By.tagName(tagname));
			for (WebElement option : allOptions) {
				   System.out.println("Option value "+option.getText());
				        if (valueToSelect.equals(option.getText())) {
				            option.click();
				            break;
				        }
			}
		}
		/*public void takeScreenShot(WebDriver driver,String screenshotName)
		{
			 
			try 
			{
			TakesScreenshot ts=(TakesScreenshot)driver;
			 
			File source=ts.getScreenshotAs(OutputType.FILE);
			 
			FileUtils.copyFile(source new File("c:\\username\\screenshot.png"));
			 
			System.out.println("Screenshot taken");
			} 
			catch (Exception e)
			{
			 
			System.out.println("Exception while taking screenshot "+e.getMessage());
			} 
		}*/
		
		public WebElement explicitTimeout(WebElement elementToBeLoaded)
		{
			WebDriverWait wait = new WebDriverWait(driver,60);
			WebElement element = wait.until(ExpectedConditions.visibilityOf(elementToBeLoaded));
			return element;	
		}
		public String getErrorMessage (WebElement element)
		{
			String error = driver.findElement((By) element).getText();
			return error;
		}
		public void handleWindow ()
		{
			String paranetwindowhandle = driver.getWindowHandle();
			System.out.println(paranetwindowhandle);
			driver.switchTo().window(paranetwindowhandle);
		}
		
		public void scrollingToBottomofAPage() {
			 ((JavascriptExecutor) driver)
	         .executeScript("window.scrollTo(0, document.body.scrollHeight)");
		}
		
		public void scrollDiv(WebElement element, int count){
			JavascriptExecutor jsExec = (JavascriptExecutor) driver;
			jsExec.executeScript("element.scrollDown += count");
		}
		
}

