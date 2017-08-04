package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BasePackage.DriverClass;
import BasePackage.Utility;

public class DashBoard extends DriverClass {
	
	Utility util = new Utility ();
	

	public By ProfileNameinSecondarymenu = By.xpath(".//*[@id='profile_name']/p");
	public By profilenameInTopRightSide = By.xpath("html/body/div[1]/app-root/app-header-menu/header/nav/div/ul/li[4]/a/span");
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
	public By MeetTable  = By.xpath("//table[@class='table no-margin']");
	
	
	
	

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
	public void selectLocation(String location) throws InterruptedException
	{
		
		driver.findElement(ChangeLocationButton).click();
		util.handleWindow();
		driver.findElement(By.xpath("html/body/div[1]/app-root/app-header-menu/header/nav/div/ul/li[1]/ul[2]/li[2]/ul/li[4]/a/span")).click();
		WebElement allLocation = driver.findElement(ChangeLocationList);
		Thread.sleep(500);
		List <WebElement> alllocationList = allLocation.findElements(By.tagName("li"));
		for (WebElement webElement : alllocationList){
			System.out.println(webElement.getText());
			if (webElement.getText().equalsIgnoreCase("Citi Nest Sports Centre, Indiranagar")){
				Thread.sleep(500);
				webElement.click();
				break;
			}
			else {
				System.out.println("zdgdsg");
			}
			driver.findElement(By.id("sfgdfgsdf")).click();
		}
		
		
		
	}
	
	public void selectUserFromQuickMessage (String name,String name1){
		driver.findElement(By.xpath("//li[@class='select2-search select2-search--inline']")).click();
		List <WebElement> Alllist = driver.findElements(By.xpath("//span[@class='select2-results']"));
		for (WebElement lists : Alllist){
			System.out.println(lists.getText());
			if (lists.getText().equals(name)){
				lists.click();
				continue;	
				}
			if (lists.equals(name1)){
				lists.click();
				break;
				
			}
		}
		
	}
	
	//Get Meet name from meet table 
	public String getMeetsNameFromtable (String meetName){
		WebElement table = driver.findElement(MeetTable);
		List <WebElement> row = table.findElements(By.tagName("tr"));
		row.size();
		for (int i =0;i < row.size();i++){
			List <WebElement> col = row.get(i).findElements(By.tagName("td"));
			for (int j=0;j<col.size();j++){
				String meetNames = col.get(i).getText();
				if (meetNames.equals(meetName)){	
					return meetNames;
				}	
			}
		}
		return meetName;
	}
}
