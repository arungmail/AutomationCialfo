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
	private By Assign = By.xpath("(//button[@type='button'])[3]");
	public By BatchTable = By.xpath("//table[@id='batcheslist']");
	public By BatchRow = By.tagName("tr");
	public By BacthColumn = By.tagName("td");
	private By BatchName = By.id("batch_name");
	public By CoachSelectionInCreateBatch = By.xpath("(//span[@class='select2-selection__arrow'])[3]");
	public By CoachListInCreateBatch = By.xpath("//span[@class='select2-results']");
	public By SwimmersSelectionInCrreateBatch = By.xpath("//span[@class='select2-selection select2-selection--multiple']");
	public By SwimmerListInCreateBatch = By.xpath("//ul[@id='select2-mrjk-results']");
	private By CreatebatchButton = By.xpath("//button[@type='submit']");
	private By namevalidation = By.xpath("//p[@id='name_validation']");
	private By Commenvalidation = By.xpath("//p[@id='common_validation']");
	public By SubmitButton = By.xpath("(//button[@type='button'])[6]");
	public By CoachSelectionInCoachAssign  = By.xpath("(//span[@class='select2-selection__arrow'])[4]");
	public By Search = By.xpath("(//input[@type='search'])[2]");
	public By CoachResultInCoachAssignPage = By.xpath("//span[@class='select2-results']");
	//public By SwimmersResult = By.xpath("//span[@class='select2-results']");
	public By CoachSelectionInAssignBatch = By.xpath("(//span[@title=' Select Coach'])[2]");
	public By CoachValidation 			= By.id("coachs_validation");
	public By SwimmerValdiation 		= By.id("swimmer_validation");
	public By AssignButtonInAssignPage   = By.xpath("");
	public String batchName;
	public Boolean coachStatus;
	public Boolean swimmerstatus;
	private String getCoachName;
	private String swimmersCount;
	

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

	public void clickOnAssign() {
		driver.findElement(Assign).click();
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
    //Get batches details from list
	public String getBatchFromList(String batchNameInList) {
		WebElement table = driver.findElement(BatchTable);
		List<WebElement> tablerow = driver.findElements(BatchRow);
		tablerow.size();
		for (int i = 0; i < tablerow.size(); i++) {
			List<WebElement> tableColoumn = tablerow.get(i).findElements(BacthColumn);
			tableColoumn.size();
			List<String> batchname = new ArrayList<String>();
			for (int j = 0; j < tableColoumn.size(); j++) {
				String batchName = tableColoumn.get(j).getText();
				System.out.println(batchName);
				if (batchName.equals(batchNameInList)) {
					return batchName;
				}
				break;
			}
		}
		return batchName;

	}

	//Select check box based on batch name 
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

					String xpath1 = "html/body/div[1]/app-root/app-manage-batch/div/section[3]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
					String xpath2 = "]/td[1]/input";
					driver.findElement(By.xpath(xpath1 + i + xpath2)).click();
					Thread.sleep(500);

				}

			}

		}
	}
    //Search batch 
	public void searchBatch(String searchkey) {
		driver.findElement(Search).sendKeys(searchkey);
	}

	//Select coach from create batch 
	public void selectCoachFromCreatebatch(String coachName) {
		WebElement cochesList = driver.findElement(CoachListInCreateBatch);
		List<WebElement> coaches = cochesList.findElements(By.tagName("li"));
		for (WebElement webElement : coaches) {
			System.out.println(webElement.getText());
			if (webElement.getText().equalsIgnoreCase(coachName)) {
				webElement.click();
				break;
			}

		}
	}
    
	//Select swimmers from  create batch 
	public void selectSwimmersFromCreateBatch(String swimmerName) {
		WebElement swimmersList = driver.findElement(SwimmerListInCreateBatch);
		List <WebElement>swimmers = swimmersList.findElements(By.tagName("li"));
		for (WebElement webElement : swimmers) {
			System.out.println(webElement.getText());
			if (webElement.getText().equalsIgnoreCase(swimmerName)) {
				webElement.click();
				break;

			}

		}
	}

	public boolean coachesStatusFromCreateBatch (String coachName) {
		
		WebElement cochesList = driver.findElement(CoachListInCreateBatch);
		List<WebElement> coaches = cochesList.findElements(By.tagName("li"));
		for (WebElement webElement : coaches) {
			System.out.println(webElement.getText());
			if (webElement.getText().equalsIgnoreCase(coachName)) {
				coachStatus = true;
			} else {
				coachStatus = false;
			}
		}
		return coachStatus;
		
	}

	public boolean SwimmersStatusFromCreateBatch(String swimmerName) {
		WebElement swimmersList = driver.findElement(SwimmerListInCreateBatch);
		List <WebElement>swimmers = swimmersList.findElements(By.tagName("li"));
		for (WebElement webElement : swimmers) {
			System.out.println(webElement.getText());
			if (webElement.getText().equalsIgnoreCase(swimmerName)) {
				swimmerstatus = true;
			} else {
				swimmerstatus = false;
			}
		}
		return swimmerstatus;
	}

	/*public boolean checkSwimmersAreDisplayedOrNot(WebElement element, String swimmerName){
		List<WebElement> swimmers = element.findElements(By.tagName("li"));
		for (WebElement webElement : swimmers) {
			System.out.println(webElement.getText());
			boolean swimmer = false;
			if (webElement.getText().equals(swimmerName)) {
				return swimmer;
			}
			else {
				return swimmer;
			}

		}
		
		boolean swimmer = false;
		return swic`c`mmer;
	}*/
	
	public String getCoachNameFromBatchesList (String swimmerName){
		WebElement batchTable = driver.findElement(BatchTable);
		List <WebElement> row = batchTable.findElements(BatchRow);
		row.size();
		for (int i =0 ;i<row.size();i++){
			List <WebElement> col = row.get(i).findElements(BacthColumn);
			for (int j=0;j<col.size();j++){
				String swimmernames = col.get(j).getText();
				if (swimmernames.equals(swimmerName)){
					String xp1 = "html/body/div[1]/app-root/app-manage-batch/div/section[3]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
					String xp2 = "]/td[5]";
					String getCoachName = driver.findElement(By.xpath(xp1+i+xp2)).getText();
					
				}
				
			}
			
		}
		return getCoachName;
	}
	
	public boolean coachStatusInAssignPage (String coachName){
		WebElement coachNamesList= driver.findElement(CoachResultInCoachAssignPage);
		List<WebElement> coaches = coachNamesList.findElements(By.tagName("li"));
		for (WebElement WebElement :coaches  ){
			System.out.println(WebElement.getText());
			if (WebElement.getText().equals(coachName)){
				coachStatus = true;
			}
			else {
				coachStatus = false;
			}
			
		}
		return coachStatus;
		
		
	}
	
	public void selectCoachesFromAssignpage (String coachName){
		WebElement coachNamesList= driver.findElement(CoachResultInCoachAssignPage);
		List<WebElement> coaches = coachNamesList.findElements(By.tagName("li"));
		for (WebElement WebElement :coaches  ){
			System.out.println(WebElement.getText());
			if (WebElement.getText().equals(coachName)){
				WebElement.click();
			}
			}
	}
	public void clickOnDowbLoadData (String downloadType){
		switch (downloadType){
		
		case "CSV":
			driver.findElement(By.xpath("(//span[@style='color:white;font-weight:bold;'])[1]"));
			break;
		case "Excel":
			driver.findElement(By.xpath("(//span[@style='color:white;font-weight:bold;'])[2]"));
		case "PDF":	
			driver.findElement(By.xpath("(//span[@style='color:white;font-weight:bold;'])[3]"));
		}
		
	}

	public String getSwimmersCount(String batchName){
		WebElement table = driver.findElement(BatchTable);
		List<WebElement> tablerow = driver.findElements(BatchRow);
		tablerow.size();
		for (int i = 0; i < tablerow.size(); i++) {
			List<WebElement> tableColoumn = tablerow.get(i).findElements(BacthColumn);
			tableColoumn.size();
			List<String> batchname = new ArrayList<String>();
			for (int j = 0; j < tableColoumn.size(); j++) {
				String batchNames = tableColoumn.get(j).getText();
				System.out.println(batchName);
				if (batchNames.equals(batchName)){
					String xp1 = "html/body/div[1]/app-root/app-manage-batch/div/section[3]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
					String xp2 = "]/td[3]";
					int swimmersCount = Integer.parseInt(driver.findElement(By.xpath(xp1+xp2)).getText());
				}
			}
		}
		return swimmersCount;
	}
	
	public void clickOnMessageIconBasedOnBatchName (){
		WebElement table = driver.findElement(BatchTable);
		List<WebElement> tablerow = driver.findElements(BatchRow);
		tablerow.size();
		for (int i = 0; i < tablerow.size(); i++) {
			List<WebElement> tableColoumn = tablerow.get(i).findElements(BacthColumn);
			tableColoumn.size();
			List<String> batchname = new ArrayList<String>();
			for (int j = 0; j < tableColoumn.size(); j++) {
				String batchNames = tableColoumn.get(j).getText();
				System.out.println(batchName);
				if (batchNames.equals(batchName)){
					String xp1 = "html/body/div[1]/app-root/app-manage-batch/div/section[3]/div/div/div/div/div[2]/div[2]/table/tbody/tr[html/body/div[1]/app-root/app-manage-batch/div/section[3]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
					String xp2 = "]/td[6]/i";
					
				}
			}
		}
	
	}
}

