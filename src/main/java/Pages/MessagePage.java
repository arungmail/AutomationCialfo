package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import BasePackage.DriverClass;

public class MessagePage extends DriverClass {

	public By ComposeButton = By.xpath("//a[@routerlink='/message/compose']");
	public By InBox = By.xpath("html/body/div[1]/app-root/app-message-conversation/div/section[2]/div/div[1]/div/app-message-sidemenu/div/div[2]/ul/li[1]/a");
	public By Sent = By.xpath("//a[@routerlink='/message/sent']");
	//public By To = By.xpath("//li[@class='select2-search select2-search--inline']");
	public By To = By.xpath("html/body/div[1]/app-root/app-message-compose/div/section[2]/div/div[2]/div/form/div[1]/div[2]/span[1]/span[1]/span");
	public By UserList = By.className("select2-results__options");
	public By Subject = By.id("compose_subject");
	public By Body = By.xpath("//body[@class='form-control wysihtml5-editor']/p");
	public By SendButton = By.xpath("//button[@type='submit']");
	public By SuccessAlert = By.id("success-alert");
	public By CommentValidation = By.id("common_validation");
	public By UserVllidation = By.xpath("//span[@id='compose_select_user_validation']");
	public By SubjecctValidation = By.xpath("//span[@id='compose_select_subject_validation']");
	public By Inboxtable = By.xpath("//table[@class='table table-hover table-striped' ]");
	public String receiver;
	public String subjects;
	public boolean status = false;

	public void clickOnComposeButton() {
		driver.findElement(ComposeButton).click();
	}

	public void clickOnInBox() {
		driver.findElement(InBox).click();
	}
	
	//Get user status
	public boolean userStatus (String user) throws InterruptedException{
		driver.findElement(To).clear();
		driver.findElement(To).click();
		driver.findElement(To).sendKeys(user);
		Thread.sleep(2000);
		WebElement usersList = driver.findElement(UserList);
		List<WebElement> allusers = usersList.findElements(By.tagName("li"));
		allusers.size();
		for (WebElement users : allusers) {
			String username = users.getText();
			if (username.equalsIgnoreCase(user)) {
				boolean status = true;
			}
			
		}
		return status;

	}
	
	
	//Select User
	public void selectUserFromList(String user) throws InterruptedException {
		//driver.findElement(To).clear();
		driver.findElement(To).click();
		driver.findElement(To).sendKeys(user);
		Thread.sleep(2000);
		WebElement usersList = driver.findElement(UserList);
		List<WebElement> allusers = usersList.findElements(By.tagName("li"));
		allusers.size();
		for (WebElement users : allusers) {
			String username = users.getText();
			if (username.equalsIgnoreCase(user)) {
				users.click();
				
                 break;
			}
			
		}

	}

	public void enterSubJect(String subject) {
		driver.findElement(Subject).click();
		driver.findElement(Subject).sendKeys(subject);
	}

	public void enterBody(String body) {
		driver.findElement(Body).clear();
		driver.findElement(Body).sendKeys(body);
	}

	public void clickOnSendButton() {
		driver.findElement(SendButton).click();
	}

	
	//Ask doubt to Bhuvan
	public String getEmailSubJectInInBoxTable(String subject) {
		driver.findElement(InBox).click();
		WebElement table = driver.findElement(Inboxtable);
		List<WebElement> inboxRow = table.findElements(By.tagName("tr"));
		inboxRow.size();
		List<String> subjectsname = new ArrayList<String>();
		// List<String> batchname = new ArrayList<String>();
		for (int i = 0; i < inboxRow.size(); i++) {
			List<WebElement> InboxCol = inboxRow.get(i).findElements(By.tagName("td"));
			InboxCol.size();
			for (int j = 0; j < InboxCol.size(); j++) {
				String subjects = InboxCol.get(j).getText();
				//System.out.println(subjects);
				if (subjects.equals(subject)) {
					System.out.println("pASSS");
					return subjects;
				}
			}
			
			break;
		}
		
		
		return subjects;
	}

	public String getReceiverNameBasedOnSubject(String subject) {
		driver.findElement(InBox).click();
		WebElement table = driver.findElement(Inboxtable);
		List<WebElement> inboxRow = table.findElements(By.tagName("tr"));
		inboxRow.size();
		List<String> subjectsname = new ArrayList<String>();
		// List<String> batchname = new ArrayList<String>();
		for (int i = 0; i < inboxRow.size(); i++) {
			List<WebElement> InboxCol = inboxRow.get(i).findElements(By.tagName("td"));
			InboxCol.size();
			for (int j = 0; j < InboxCol.size(); j++) {
				String subjects = InboxCol.get(j).getText();
				System.out.println(subjects);
				if (subjects.contentEquals(subject)) {
					System.out.println("Pass");
					// subjectsname.add(subjects);
					String xpath1 = "html/body/div[1]/app-root/app-message-conversation/div/section[2]/div/div[2]/div/div[2]/div[2]/table/tbody/tr[";
					String xpath2 = "]/td[2]";
					String receiver = driver.findElement(By.xpath(xpath1+i+xpath2)).getText();
					//String expectedReceiver = receiverName;
					//Assert.assertEquals(receiver, expectedReceiver);
					
				}
				
			}
			break;
		}
		return receiver;
	}
	
	public void enterMessageBody (String contentTotype,WebElement element){
		List <WebElement> iframe = driver.findElements(By.tagName("iframe"));
		System.out.println(iframe.size());
		//Switching to iframe
		//driver.switchTo().frame(By.xpath("//iframe[@class='wysihtml5-sandbox']"));
		element = driver.findElement(By.xpath("html/body/p"));
		element.sendKeys(contentTotype);
	}
	
	
}
