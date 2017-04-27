package Pages;

import org.openqa.selenium.By;

import BasePackage.DriverClass;

public class SwimmersPage extends DriverClass{
	private By BatchSelection			= By.xpath("//span[@title='Select Batch']");
	private By Searchbutton 			= By.xpath("//input[@type='search']");
	private By EntrySelection 			= By.xpath("//select[@name='swimmertable_length']");
	private By Homebredcrumbs			= By.xpath("html/body/div[1]/app-root/app-player/div/section[1]/ol/li[1]/a");
	private By TranferButton			= By.xpath("(//button[@type='button'])[1]");
	private By BatchSelectionInTranferPlayer = By.xpath("//span[@title='Select Batch']");
	private By SubmitButton				= By.xpath(".//*[@id='myModal']/div/div/div[3]/button[2]");
	private By CloseButton 				= By.xpath(".//*[@id='myModal']/div/div/div[3]/button[1]'");
	private By ErrorValidation 			= By.id("error_validation");
	private By Successvalidation 		= By.id("success_validation");
	
	
	
	
	

}
