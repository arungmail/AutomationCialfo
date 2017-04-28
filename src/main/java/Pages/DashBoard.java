package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BasePackage.DriverClass;

public class DashBoard extends DriverClass{
	
	public By ProfileNameinSecondarymenu 					= By.xpath(".//*[@id='profile_name']/p");
	public By profilenameInTopRightSide 					= By.xpath("html/body/div[1]/app-root/app-header-menu/header/nav/div/ul/li[4]/a/span");
	private By Dashboard									= By.partialLinkText("dashboard");
	private By Attendanace 									= By.partialLinkText("attendance");
	private By Swimmers										= By.partialLinkText("swimmer");
	private By Coach										= By.partialLinkText("Coach");
	private By ManageGroup									= By.partialLinkText("manage-group");
	private By ManageBatch									= By.xpath("html/body/div/app-root/app-side-menu/aside/section/ul/li[7]/a/span");
	private By Message 										= By.partialLinkText("message");
	
	
	public void clickOnProfileNameOnTop()
	{
		driver.findElement(profilenameInTopRightSide).click();
	}
	
	public String getProfilenameOnTopRightSide()
	{
		String profilename = driver.findElement(ProfileNameinSecondarymenu).getText();
		System.out.println(profilename);
		return profilename;		
	}
	
	public String getProfilenameOnSecondarymenu()
	{
		String profilename = driver.findElement(ProfileNameinSecondarymenu).getText();
		System.out.println(profilename);
		return profilename;		

	}
	public boolean profileNameIsVisibleOrNot()
	{
		boolean profilename = driver.findElement(profilenameInTopRightSide).isDisplayed();
		return true;
	}
	public void clickOnCoach(){
		driver.findElement(Coach).click();
	}
	public void clickOnManageBatch()
	{
		driver.findElement(ManageBatch).click();
		
	}
}
