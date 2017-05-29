package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BasePackage.DriverClass;
import BasePackage.Utility;
import junit.framework.Assert;

public class BatchList extends DriverClass {
	Utility util = new Utility();
	private By Brecrumbs = By.xpath("(//a[@routerlink='/dashboard'])[3]");
	private By AddButton = By.xpath("(//button[@type='button'])[2]");
	private By Tranfer = By.xpath("(//button[@type='button'])[3]");
	public By BatchTable = By.xpath("//table[@id='batcheslist']");
	public By BatchRow = By.tagName("tr");
	public By BacthColumn = By.tagName("td");
	private By BatchName = By.id("batch_name");
	public By CoachSelection = By.xpath("(//span[@title=' Select Coach'])[1]");
	public By PlayerSelection = By.xpath("(//span[@role='combobox'])[3]");
	private By CreatebatchButton = By.xpath("//button[@type='submit']");
	private By namevalidation = By.xpath("//p[@id='name_validation']");
	private By Commenvalidation = By.xpath("//p[@id='common_validation']");
	public By SubmitButton = By.xpath("(//button[@type='button'])[6]");
	public By CoachSearchinputBox = By.xpath("(//input[@type='search'])[3]");
	public By Search = By.xpath("(//input[@type='search'])[2]");
	public By CoachResult = By.xpath("//span[@class='select2-results']");
	public By SwimmersResult = By.xpath("//span[@class='select2-results']");
	public By CoachSelectionInTranferBatch = By.xpath("(//span[@title=' Select Coach'])[2]");

	// public void clickOnCoachSelection

	public void clickOnBredCrumbs() {
		driver.findElement(Brecrumbs).click();
	}

	public void clickOnSubmitButton() {
		driver.findElement(SubmitButton).click();
	}

	public void clickOnAddbacthButton() {
		driver.findElement(AddButton).click();
	}

	public void clickOnTranferButton() {
		driver.findElement(Tranfer).click();
	}

	public void enterBacthname(String name) {
		driver.findElement(BatchName).sendKeys(name);
	}

	public void clickOnCreateButton() {
		driver.findElement(CreatebatchButton).click();
	}

	public String getBatchnamevalidation() {
		String error = driver.findElement(namevalidation).getText();
		System.out.println(error);
		return error;
	}

	public String getSuccessmessage() {
		String successMessage = driver.findElement(Commenvalidation).getText();
		System.out.println(successMessage);
		return successMessage;
	}
	/*
	 * public void selectCoach() { WebElement coach =
	 * driver.findElement(CoachSelection); coach.click();
	 * driver.findElement(By.xpath("//*[contains(@id,'rajajicoach')]")).click();
	 * driver.findElement(S) //List<WebElement> listItems =
	 * coach.findElements(By.tagName("li")); listItems.size(); for (int
	 * i=0;i<lifstItems.size();i++){ WebElement name = listItems.get(i);
	 * name.getText(); System.out.println(name); if (name.equals("coach1")){
	 * name.click();
	 * 
	 * }
	 * 
	 * //List <String> coachesName = new ArrayList <String>();
	 * //listItems.get(0).click();
	 * 
	 * 
	 * 
	 * 
	 * } public void selectSwimmer(String name) { WebElement swimmer =
	 * driver.findElement(PlayerSelection); swimmer.click();
	 * util.selectValueByVisibleText(swimmer, name);
	 * 
	 * }
	 */

	public void getBatchFromList(String batchNameInList) {
		WebElement table = driver.findElement(BatchTable);
		List<WebElement> tablerow = driver.findElements(BatchRow);
		tablerow.size();
		for (int i = 0; i < tablerow.size(); i++) {
			List<WebElement> tableColoumn = tablerow.get(i).findElements(BacthColumn);
			tableColoumn.size();
			List<String> batchname = new ArrayList<String>();
			for (int j = 0; j < tableColoumn.size(); j++) {
				String name = tableColoumn.get(j).getText();
				System.out.println(name);
				if (name.equals(batchNameInList)) {

					batchname.add(name);
					// break;
					Assert.assertEquals(batchNameInList, name);
					break;

				}

			}
		}

	}

	public void selectCheckBoxbasedOnBatchName(String batchname) throws InterruptedException {
		WebElement batchtable = driver.findElement(BatchTable);
		List<WebElement> batchRow = driver.findElements(BatchRow);
		batchRow.size();

		for (int i = 0; i < batchRow.size(); i++) {
			List<WebElement> swimcol = batchRow.get(i).findElements(BacthColumn);
			swimcol.size();

			for (int j = 0; j < swimcol.size(); j++) {
				String swimmernames = swimcol.get(j).getText();

				System.out.println(swimmernames);
				if (swimmernames.equalsIgnoreCase(batchname)) {

					String xpath1 = ".//*[@id='batcheslist']/tbody/tr[";
					String xpath2 = "]/td[1]/input";
					driver.findElement(By.xpath(xpath1 + i + xpath2)).click();
					Thread.sleep(500);

				}

			}

		}
	}

	public void searchBatch(String searchkey) {
		driver.findElement(Search).sendKeys(searchkey);
	}

	public void selectCoachFromCoachList(WebElement element, String coachName) {
		List<WebElement> coaches = element.findElements(By.tagName("li"));
		for (WebElement webElement : coaches) {
			System.out.println(webElement.getText());
			if (webElement.getText().equalsIgnoreCase(coachName)) {
				webElement.click();
				break;

			}

		}
	}

	public void selectSwimmersFromCoachList(WebElement element, String swimmerName) {
		List<WebElement> swimmers = element.findElements(By.tagName("li"));
		for (WebElement webElement : swimmers) {
			System.out.println(webElement.getText());
			if (webElement.getText().equalsIgnoreCase(swimmerName)) {
				webElement.click();
				break;

			}

		}
	}

	public boolean coachesFromCoachList(WebElement element, String swimmerName) {
		boolean coachstatus = false;
		List<WebElement> swimmers = element.findElements(By.tagName("li"));

		for (WebElement webElement : swimmers) {
			System.out.println(webElement.getText());

			if (webElement.getText().equals(swimmerName)) {
				coachstatus = true;
			} else {
				coachstatus = false;
			}
		}
		return coachstatus;
	}

	public boolean SwimmersFromCoachList(WebElement element, String swimmerName) {
		boolean swimmerstatus = false;
		List<WebElement> swimmers = element.findElements(By.tagName("li"));

		for (WebElement webElement : swimmers) {
			System.out.println(webElement.getText());

			if (webElement.getText().equals(swimmerName)) {
				swimmerstatus = true;
			} else {
				swimmerstatus = false;
			}
		}
		return swimmerstatus;
	}

	public boolean checkSwimmersAreDisplayedOrNot(WebElement element, String swimmerName){
		List<WebElement> swimmers = element.findElements(By.tagName("li"));
		for (WebElement webElement : swimmers) {
			System.out.println(webElement.getText());
			boolean swimmer;
			if (webElement.getText().equals(swimmerName)) {
				swimmer = true;

			}
			else {
				swimmer = false;
			}

		}
		
		return .swimmer;
	}
}
