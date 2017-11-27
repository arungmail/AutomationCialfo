package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import BasePackage.DriverClass;

public class MessagePage extends DriverClass {

	public By ComposeButton = By.xpath("//a[@routerlink='/message/compose']");
	public By InBox = By.xpath("(//a[@href='/message/inbox'])[4]");
	public By Sent = By.xpath("//a[@routerlink='/message/sent']");
	public By To = By.xpath("//input[@placeholder='To:']");
	public By UserList = By.xpath("//span[@class='select2-results']");
	public By Subject = By.id("compose_subject");
	public By Body = By.xpath("//body[@class='form-control wysihtml5-editor']");
	public By SendButton = By.xpath("//button[@type='submit']");
	public By SuccessAlert = By.id("success-alert");
	public By CommentValidation = By.id("common_validation");
	public By Inboxtable = By.xpath("//table[@class='table table-hover table-striped' ]");
	private String receiver;

	public void clickOnComposeButton() {
		driver.findElement(ComposeButton).click();
	}

	public void clickOnInBox() {
		driver.findElement(InBox).click();
	}

	public void selectUserFromList(String user) {
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
		driver.findElement(Subject).sendKeys(subject);
	}

	public void enterBody(String body) {
		driver.findElement(Body).sendKeys(body);

	}

	public void clickOnSendButton() {
		driver.findElement(SendButton).click();
	}

	
	//Ask doubt to Bhuvan
	public String getEmailSubJectInInBoxTable(String subject) {
		WebElement table = driver.findElement(Inboxtable);
		List<WebElement> inboxRow = table.findElements(By.tagName("tr"));
		inboxRow.size();
		List<String> subjectsname = new ArrayList<String>();
		// List<String> batchname = new ArrayList<String>();
		for (int i = 0; i < inboxRow.size(); i++) {
			List<WebElement> inboxCol = inboxRow.get(i).findElements(By.tagName("td"));
			inboxCol.size();
			for (int j = 0; j < inboxCol.size(); j++) {
				String subjects = inboxCol.get(j).getText();
				System.out.println(subjects);
				if (subjects.contentEquals(subject)) {
					//subjectsname.add(subjects);
					///Assert.assertEquals(subjects, subject);
					//return subjectsname;	
					break;
				}

			}
		}
		return subject;
	}

	public String getReceiverNameBasedOnSubject(String subject) {
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
					// subjectsname.add(subjects);
					String xpath1 = "html/body/div[1]/app-root/app-message-conversation/div/section[2]/div/div[2]/div/div[2]/div[2]/table/tbody/tr[";
					String xpath2 = "]/td[3]";
					String receiver = driver.findElement(By.xpath(xpath1 + i + xpath2)).getText();
					//String expectedReceiver = receiverName;
					//Assert.assertEquals(receiver, expectedReceiver);
					break;

				}
			}
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
