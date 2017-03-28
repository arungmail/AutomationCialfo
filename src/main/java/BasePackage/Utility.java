package BasePackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

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
		
}
