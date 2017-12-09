package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BasePackage.DriverClass;
import BasePackage.Utility;

public class DashBoard extends DriverClass {
	
	Utility util = new Utility ();
	

	public By ProfileNameinSecondarymenu = By.xpath("//div[@id='profile_name']/p");
	public By profilenameInTopRightSide = By.xpath("//span[@class='hidden-xs']");
	private By Dashboard = By.xpath("//li[@id='dashboard']/a/span");
	public By Attendanace = By.xpath("//li[@id='attendance']/a/span");
	public By Swimmers = By.xpath("//li[@id='swimmers']/a/span");
	public By Coaches = By.xpath("//li[@id='coaches']/a/span");
	public By ManageGroup = By.xpath("//li[@id='groups']/a/span");
	private By ManageBatch = By.xpath("//li[@id='batches']/a/span");
	public By Message = By.xpath("//li[@id='messages']/a/span");
	public By PendingUsers = By.xpath("//li[@id='pending']/a/span");
	public By ChangeLocationButton = By.xpath("(//li[@class='dropdown messages-menu'])[1]");
	public By ChangeLocationList	= By.xpath("//ul[@class='menu']");
	public By MeetTable  = By.xpath("//table[@class='table no-margin']");
	public By ACL   = By.xpath("//li[@id='acl']/a/span");
	
	
	public void clickOnDashBoard (){
		driver.findElement(Dashboard).click();
	}
	
	public void clickOnGroups (){
		driver.findElement(ManageGroup).click();
	}

	public void clickOnProfileNameOnTop() {
		driver.findElement(profilenameInTopRightSide).click();
	}
	
	public void clickOnMessage (){
		driver.findElement(Message).click();
	}
	public void clickOnAttendance(){
		driver.findElement(Attendanace).click();
	}

	public void logingOut() throws InterruptedException {
		driver.findElement(profilenameInTopRightSide).click();
		driver.findElement(By.xpath("(//a[@class='btn btn-default btn-flat'])[2]")).click();
		Thread.sleep(500);
	}

	public String getProfilenameOnTopRightSide() {
		String profilename = driver.findElement(profilenameInTopRightSide).getText();
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
		driver.findElement(Coaches).click();
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
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).click();
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
