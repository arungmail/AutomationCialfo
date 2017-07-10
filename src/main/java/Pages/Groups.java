package Pages;

import BasePackage.DriverClass;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class Groups extends DriverClass{
	

	public By GroupCreationButton 	= By.xpath("//i[@class='fa fa-plus']");
	public By GroupList 			= By.xpath("//div[@class='row']");
	public By GroupNames 			= By.xpath("//span[@class='info-box-text']");
	public By GroupMemberCount 		= By.xpath("//span[@class='info-box-number']");
	public By GroupContacts			= By.xpath("//button[@title='Contacts']");
	public By GroupDetails 			= By.xpath("//button[@title='Detail']");
	public By SendButton 			= By.xpath("//button[@type='input']");
	public By GroupnameInAddGroup 	= By.id("batch_name");
	public By SwimmerSearchFiedl 	= By.xpath("//ul[@class='select2-selection__rendered']");
	public By SwimmerList 			= By.xpath("//ul[@id='select2-5rxa-results']");
	public By BackButton 			= By.xpath("(//button[@class='btn btn-info pull-right'])[1]");
	public By CreateButton 			= By.xpath("(//button[@class='btn btn-info pull-right'])[2]");
	public By NameValidation 		= By.id("name_validation");
	public By PlayerValidation 		= By.id("player_validation");
	public By PaginationList 		= By.xpath("//ul[@class='pagination pagination-sm pull-right']");
	public boolean groupNamesStatus;
	public String memberCount;

	// Returning groupStatus
	public boolean checkGroupName(String groupName) {
		WebElement groups = driver.findElement(GroupList);
		List<WebElement> groupNames = groups.findElements(GroupNames);
		groupNames.size();
		for (int i = 0; i < groupNames.size(); i++) {
			String name = groupNames.get(i).getText();
			
			if (name.equals(groupName)) {
				return groupNamesStatus = true;
			} else {
				return groupNamesStatus = false;
			}

		}
		return groupNamesStatus;
	}

	// Returning MemberCOunt
	public String checkGroupMemberCount(String groupname) {
		WebElement groups = driver.findElement(GroupList);
		List<WebElement> groupCount = driver.findElements(GroupMemberCount);
		groupCount.size();
		for (int i = 0; i < groupCount.size(); i++) {
			String count = groupCount.get(i).getText();
			if (memberCount.equals(groupname)) {
				return count;

			}

		}
		return memberCount;
	}

	// CLick on message Edit box
	public void enterMessageOnGroup(String groupName, String sendKeys) {
		WebElement groups = driver.findElement(GroupList);
		List<WebElement> groupBox = groups.findElements(By.tagName("div"));
		groupBox.size();
		for (int i = 0; i < groupBox.size(); i++) {
			String name = groupBox.get(i).getText();
			if (name.equals(groupName)) {
				WebElement editBoxes = groupBox.get(i).findElement(By.xpath("//input[@name='message']"));
				editBoxes.click();
			}

			/*
			 * if (name.equals(groupName)){ String xpath1 =
			 * "html/body/div[1]/app-root/app-manage-group/div/section[3]/div[2]/div[";
			 * String xpath2 = "]/div[2]/div[3]/div/input";
			 * driver.findElement(By.xpath("xpath1+i+xpath2")).click();
			 * driver.findElement(By.xpath("xpath1+i+xpath2")).sendKeys(sendKeys
			 * );
			 * 
			 * }
			 */
		}
	}

	// Click on Send Button
	public void clickOnSendButton(String groupName) {
		WebElement groups = driver.findElement(GroupList);
		List<WebElement> groupNames = groups.findElements(GroupNames);
		groupNames.size();
		for (int i = 0; i < groupNames.size(); i++) {
			String name = groupNames.get(i).getText();
			if (name.equals(groupName)) {
				String xpath1 = "html/body/div[1]/app-root/app-manage-group/div/section[3]/div[2]/div[";
				String xpath2 = "]/div[2]/div[3]/div/input";
				WebElement textField = driver.findElement(By.xpath("xpath1+i+xpath2"));
				List<WebElement> sendButton = textField.findElements(By.xpath("//button[@type='input']"));
				textField.click();
				break;

			}
		}

	}
     // Select Swimmers from swimmerList
	public void selectSwimmerFromSwimmersList(String swimmerName) throws InterruptedException {
		WebElement swimmetTextField = driver.findElement(SwimmerSearchFiedl);
		swimmetTextField.click();
		Thread.sleep(500);
		List<WebElement> swimmerNames = driver.findElements(SwimmerList);
		for (WebElement name : swimmerNames) {
			System.out.println(name.getText());
			if (name.getText().equals(swimmerName)) {
				name.click();
				break;

			}
		}
	}
	//Get Name Validation
	public String getNamevalildationMessage (){
		String nameValidation = driver.findElement(NameValidation).getText();
		return nameValidation;
	}
	//GetSwimmervalidation
	public String getPlayerValidationMessage(){
		String playerValidation = driver.findElement(PlayerValidation).getText();
		return playerValidation;
	}
	//Click on Create Button 
	public void clickOnCreateButton (){
		driver.findElement(CreateButton).click();
	}
	//Click on Pagination 
	public void clickOnPagination(String value){
		WebElement page = driver.findElement(PaginationList);
		List <WebElement>  pagination = page.findElements(By.tagName("li"));
		pagination.size();
		for (WebElement paginationName :pagination){
			System.out.println(paginationName.getText());
			if (paginationName.getText().equals(value)){
				paginationName.click();	
				break;
			}	
		}	
	}
}
