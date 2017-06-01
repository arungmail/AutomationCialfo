package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BasePackage.DriverClass;

public class DashBoard extends DriverClass {

	public By ProfileNameinSecondarymenu = By.xpath(".//*[@id='profile_name']/p");
	public By profilenameInTopRightSide = By
			.xpath("html/body/div[1]/app-root/app-header-menu/header/nav/div/ul/li[4]/a/span");
	private By Dashboard = By.partialLinkText("dashboard");
	private By Attendanace = By.partialLinkText("attendance");
	private By Swimmers = By.xpath("html/body/div/app-root/app-side-menu/aside/section/ul/li[4]/a/span");
	private By Coach = By.partialLinkText("Coach");
	private By ManageGroup = By.partialLinkText("manage-group");
	private By ManageBatch = By.xpath("html/body/div/app-root/app-side-menu/aside/section/ul/li[7]/a/span");
	public By Message = By.xpath("html/body/div/app-root/app-side-menu/aside/section/ul/li[8]/a/span");
	public By PendingUsers = By.xpath("html/body/div/app-root/app-side-menu/aside/section/ul/li[12]/a/span");
	public By ChangeLocationButton = By.xpath("(//li[@class='dropdown messages-menu'])[1]");
	public By ChangeLocationList	= By.xpath("//ul[@class='menu']");
	
	
	

	public void clickOnProfileNameOnTop() {
		driver.findElement(profilenameInTopRightSide).click();
	}

	public void logingOut() throws InterruptedException {
		driver.findElement(profilenameInTopRightSide).click();
		driver.findElement(By.linkText("Sign out"));
		Thread.sleep(500);
	}

	public String getProfilenameOnTopRightSide() {
		String profilename = driver.findElement(ProfileNameinSecondarymenu).getText();
		System.out.println(profilename);
		return profilename;
	}

	public String getProfilenameOnSecondarymenu() {
		String profilename = driver.findElement(ProfileNameinSecondarymenu).getText();
		System.out.println(profilename);
		return profilename;

	}

	public boolean profileNameIsVisibleOrNot() {
		boolean profilename = driver.findElement(profilenameInTopRightSide).isDisplayed();
		return true;
	}

	public void clickOnCoach() {
		driver.findElement(Coach).click();
	}

	public void clickOnManageBatch() {
		driver.findElement(ManageBatch).click();

	}

	public void clickOnSwimmers() {
		driver.findElement(Swimmers).click();
	}
	public void selectLocation(String location)
	{
		driver.findElement(ChangeLocationButton).click();
		WebElement allLocation = driver.findElement(ChangeLocationList);
		List <WebElement> alllocationList = allLocation.findElements(By.tagName("li"));
		for (WebElement location1 :alllocationList ){
			System.out.println(location1.getText());
			if (location1.equals(location)){
				location1.click();
	
			}
			
		}
		
		
	}
}
