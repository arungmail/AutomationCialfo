package Pages;

import BasePackage.DriverClass;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class Groups extends DriverClass{
	

	public By GroupCreationButton 	= By.xpath("//i[@class='fa fa-plus']");
	public By GroupList 			= By.xpath("//div[@class='row']");
	public By GroupNames 			= By.xpath("//span[@class='info-box-text showing-dots-name']");
	public By GroupMemberCount 		= By.xpath("//span[@class='info-box-number']");
	public By GroupContacts			= By.xpath("//button[@title='Members']");
	public By GroupDetails 			= By.xpath("//button[@title='Detail']");
	public By SendButton 			= By.xpath("//button[@type='input']");
	public By GroupnameInAddGroup 	= By.id("batch_name");
	public By SwimmerSearchFied 	= By.xpath("//ul[@class='select2-selection__rendered']");
	public By SwimmerList 			= By.xpath("//ul[@id='select2-8vc5-results']");
	public By BackButton 			= By.xpath("(//button[@class='btn btn-info pull-right'])[1]");
	public By CreateButton 			= By.xpath("(//button[@class='btn btn-info pull-right'])[2]");
	public By NameValidation 		= By.id("name_validation");
	public By PlayerValidation 		= By.id("player_validation");
	public By PaginationList 		= By.xpath("//ul[@class='pagination pagination-sm pull-right']");
	public By Search = By.xpath("//input[@placeholder='Search']");
	public By ContactList  = By.xpath("//ul[@class='contacts-list']");
	public By NameInContactList = By.xpath("//span[@class='contacts-list-name']");
	public By TextField   = By.xpath("//input[@name='message']");
	
	public boolean membersStatus;
	public String memberCount;
	
	//Select swimmers on Add group
	public void selectSwimmersonAddGroup (String name){
		driver.findElement(SwimmerSearchFied).sendKeys(name);
		WebElement result = driver.findElement(SwimmerList);
		List <WebElement> allnames = result.findElements(By.tagName("li"));
		for (WebElement all : allnames){
		System.out.println(all.getText());
		    if (all.getText().equals(name)){
			all.click();
			break;
		    }
		}
		
	}
	
	//Search Group
	public void searchGroup (String searchKey){
		driver.findElement(Search).click();
		driver.findElement(Search).clear();
		driver.findElement(Search).sendKeys(searchKey);		
	}

	// Returning groupStatus
	public boolean checkGroupName(String groupName) {
		searchGroup(groupName);
		boolean status = driver.findElement(GroupNames).isDisplayed();
		return status;
		
	}

	// Returning MemberCOunt
	public String getGroupMemberCount(String groupName) {
		searchGroup(groupName);
		String name = driver.findElement(GroupNames).getText();
		if (name.equals(groupName)){
			String memberCount = driver.findElement(GroupMemberCount).getText();
			System.out.println(memberCount);
			//return memberCount;
		}
		return memberCount;

	}

	// CLick on message Edit box
	public void enterMessageOnGroup(String groupName, String sendKeys) {
		searchGroup(groupName);
		String name = driver.findElement(GroupNames).getText();
		if (name.equals(groupName)){
			driver.findElement(TextField).sendKeys(sendKeys);
			driver.findElement(SendButton).click();
		}
		else {
			System.out.println("Group Not found");
		}
	}

	/*// Click on Send Button
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

	}*/
     // Select Swimmers from swimmerList
	public void selectMembersFromContactList(String groupName, String memberName) throws InterruptedException {
		searchGroup(groupName);
		String name = driver.findElement(GroupNames).getText();
		if (name.equals(memberName)){
			driver.findElement(GroupContacts).click();
			WebElement list = driver.findElement(ContactList);
			List <WebElement> membersInfo = list.findElements(By.tagName("li"));
			membersInfo.size();
			for (int i=0;i<membersInfo.size();i++){
				List <WebElement> allnames = membersInfo.get(i).findElements(NameInContactList);
				allnames.size();
				for (int j = 0;j<allnames.size();j++){
					String names = allnames.get(j).getText();
					System.out.println(names);
					if (allnames.get(j).getText().equals(memberName)){
						allnames.get(j).click();
						//allnames.get(j).click();
						
					}
					
				}
				
				
			}
			
		}
		
		
	}
	//Get status of members 
	public boolean statusOfMembersFromContactList(String groupName, String memberName) throws InterruptedException {
		searchGroup(groupName);
		String name = driver.findElement(GroupNames).getText();
		if (name.equals(memberName)){
			driver.findElement(GroupContacts).click();
			WebElement list = driver.findElement(ContactList);
			List <WebElement> membersInfo = list.findElements(By.tagName("li"));
			membersInfo.size();
			for (int i=0;i<membersInfo.size();i++){
				List <WebElement> allnames = membersInfo.get(i).findElements(NameInContactList);
				allnames.size();
				for (int j = 0;j<allnames.size();j++){
					String names = allnames.get(j).getText();
					System.out.println(names);
					if (allnames.get(j).getText().equals(memberName)){
					return membersStatus;
						
					}
					
				}
				
				
			}
			
		}
		return membersStatus;
		
		
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
