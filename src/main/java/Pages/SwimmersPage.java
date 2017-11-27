package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import BasePackage.DriverClass;
import BasePackage.Utility;

public class SwimmersPage extends DriverClass {

	Utility util = new Utility();

	public By BatchSelection = By.xpath("//span[@id='select2-ygdm-container']");
	public By Searcharea = By.xpath("//input[@class='select2-search__field']");

	public By EntrySelection = By.xpath("//select[@name='swimmertable_length']");
	public By Homebredcrumbs = By.xpath("html/body/div[1]/app-root/app-player/div/section[1]/ol/li[1]/a");

	public By Assign = By.xpath("//button[@class='btn btn-primary pull-right'][2]");

	//public By BatchSelectionInTranferPlayer = By.xpath(".//*[@id='myModal']/div/div/div[2]/div/div/span/span[1]/span");
	public By SubmitButton = By.xpath("//button[@class='btn btn-primary align_top']");
	public By CloseButton = By.xpath("//button[@class='btn btn-default align_top']");
	public By ErrorValidation = By.id("error_validation");
	public By Successvalidation = By.id("success_validation");
	public By SwimmersTable = By.xpath(".//*[@id='swimmertable']/tbody");
	public By SwimmersRow = By.tagName("tr");
	public By SwimmersColoumn = By.tagName("td");
	public By DataEmptyMessage = By.xpath("//td[@class='dataTables_empty']");
	public By BatchList = By.xpath("//ul[@id='select2-w2wc-results']");
	//public By BatchSelectionInTranferSwimmerpage 	= By.xpath("//span[@title='Select Batch']");
	//public By BatchResultsInTransferSwimmerpage  = By.xpath("//span[@class='select2-results']");
	//public By SubmitButonInTransferSwimmerPage = By.xpath("(//button[@type='button'])[5]");

	public By CoachSelection  = By.xpath("//span[@id='select2-f9d0-container']");
	public By CoachList = By.xpath("//ul[@id='select2-hoyp-results']");
	public By CoachSelectionInAssignSwimmerPage = By.xpath("//span[@id='select2-209h-container']");
	public By CoachSearchinAssignSwimmerPage = By.xpath("//input[@class='select2-search__field']");
	public By BatchSelectionInAssigSwimmerPage = By.xpath("//span[@id='select2-p5kz-container']");
	
	public By CoachListInAssignSwimmerPage = By.xpath("//ul[@id='select2-p5kz-results']");
	public By BatchListInAssignSwimmerPage = By.xpath("//span[@class='select2-results']");
	public By TransferButtonInAssignpage = By.xpath("");
	public By AddSwimmerButton = By.xpath("//button[@class='btn btn-primary pull-right'][1]	");


	public By ScreenName = By.xpath("//input[@formcontrolname='name']");
	public By SwimmerSearch = By.xpath("//div[@id='swimmertable_filter']/label/input");
	
    public By EmailId = By.xpath("//input[@formcontrolname='email']");
    public By Firstname = By.xpath("//input[@formcontrolname='first_name']");
    public By Lastname = By.xpath("//input[@formcontrolname='last_name']");
    public By Password = By.xpath("//input[@formcontrolname='password']");
    public By ConfirmPassword = By.xpath("//input[@formcontrolname='confirmpassword']");
    public By Location = By.xpath("//input[@formcontrolname='location']");
    public By Year = By.id("year");
    public By Month = By.id("month");
    public By Day = By.id("day");
    public By RegisterButton = By.id("register_btn");
    public By NameValidation = By.id("name_validation");
    public By EmailValidation = By.id("email_validation");
    public By FirstNameValidation = By.id("first_name_validation" );
    public By LastNameValidation = By.id("last_name_validation" );
    public By PasswordValidation = By.id("password_validation");
    public By ConfirmPasswordValidation = By.id("confirmpassword_validation");
    public By PhoneNumberValidation = By.id("location_validation");
    public By DOBValidation = By.id("error_validation" );
    public By AvailablePhonenumbervalidation = By.id("available_phone_error_validation");
    public By PasswordMatchingValidation = By.id("error_validation");
    public By PhoneNumber = By.xpath("//input[@placeholder='Phone Number']");
    
    
    
    
    		
    
    
    
			
	
	
	public String actualbatchname;

	public String coachName;

	public boolean coachStatus = false;

	public boolean batchStatus = false ;

	public String attendancePercentage;
	// public WebElement batchname = driver.findElement(BatchSelection);

	
	//batch Selection 
	public void batchSelection(String batchName) throws InterruptedException {
		//WebElement batchlist = driver.findElement(batchresults);
		driver.findElement(BatchSelection).click();
		driver.findElement(Searcharea).sendKeys(batchName);
		Thread.sleep(500);
		WebElement batchList = driver.findElement(BatchList);
		List<WebElement> batches = batchList.findElements(By.tagName("li"));
		for (WebElement webElement : batches) {
			System.out.println(webElement.getText());	
			if (webElement.getText().equalsIgnoreCase(batchName)) {
				// Thread.sleep(500);
				webElement.click();
				break;

			}

		}
	}
		
	//Coach Selection
		public void coachSelection (String coachName) throws InterruptedException{
			driver.findElement(CoachSelection).click();
			Thread.sleep(500);
			driver.findElement(Searcharea).sendKeys(coachName);
			WebElement coachesList = driver.findElement(CoachList);
			List <WebElement> coaches = coachesList.findElements(By.tagName("li"));
			for (WebElement coachesnames : coaches){
				System.out.println(coachesnames.getText());
				if (coachesnames.getText().equals(coachName)){
					coachesnames.click();
					break;
					
				}
				
		}

	}

		//Check batch Status 
		public boolean checkBatchStatus (String batchName) throws InterruptedException{
			//WebElement batchlist = driver.findElement(batchresults);
			driver.findElement(BatchSelection).click();
			driver.findElement(Searcharea).sendKeys(batchName);
			Thread.sleep(500);
			WebElement batchList = driver.findElement(BatchList);
			List<WebElement> batches = batchList.findElements(By.tagName("li"));
			for (WebElement webElement : batches) {
				System.out.println(webElement.getText());	
				if (webElement.getText().equalsIgnoreCase(batchName)) {
					batchStatus = true;
					break;
				}
			}
			return this.batchStatus;
			
		}
		
		
		//Check Coach Status
		public boolean checkCoachStatus (String coachName) throws InterruptedException{
			driver.findElement(CoachSelection).click();
			Thread.sleep(500);
			driver.findElement(Searcharea).sendKeys(coachName);
			WebElement coachesList = driver.findElement(CoachList);
			List <WebElement> coaches = coachesList.findElements(By.tagName("li"));
			for (WebElement coachesnames : coaches){
				System.out.println(coachesnames.getText());
				if (coachesnames.getText().equals(coachName)){
					coachStatus = true;
					break;
				}
					
			}
			return this.coachStatus;
		}
	
	/*public void getCoachNameFromTable(String swimmerName) {

		WebElement table = driver.findElement(SwimmersTable);
		List<WebElement> row = driver.findElements(SwimmersRow);
		row.size();
		for (int i = 0; i < row.size(); i++) {
			List<WebElement> col = row.get(i).findElements(SwimmersColoumn);
			col.size();
			List<String> swimmersName = new ArrayList<String>();
			for (int j = 0; j < col.size(); j++) {
				String name = col.get(j).getText();
				if (name.equals(actual)) {
					swimmersName.add(name);
					Assert.assertEquals(name, expected);

					// String status = System.out.println("Coach1");
					
					 * String xp1 =
					 * "html/body/div[1]/div[5]/div[2]/div/div/table/tbody/tr[";
					 * String xp2 = "]/td[6]";
					 * driver.findElement(By.xpath(xp1+i+xp2)).click();
					 
				}
				System.out.println(name);

			}
		}

	}
	
	 * public checkBatchNameIsListedOrNot(String name) { WebElement batchList =
	 * driver.findElement(BatchSelection); WebElement name2 =
	 * driver.findElement(By.xpath(
	 * ".//*[@id='select2-5dzp-result-kei1-590876017b31794b2a5bfe32']")); return
	 * name2; }
	 */

	
	//get CoachName
	public String getmatchingCoachNameforSwimmers(String swimmername) {
		WebElement swimmerstable = driver.findElement(SwimmersTable);
		List<WebElement> swimRow = driver.findElements(SwimmersRow);
		swimRow.size();

		for (int i = 0; i < swimRow.size(); i++) {
			List<WebElement> swimcol = swimRow.get(i).findElements(SwimmersColoumn);
			swimcol.size();

			for (int j = 0; j < swimcol.size(); j++) {
				String swimmernames = swimcol.get(j).getText();
				System.err.println(swimmernames);
				if (swimmernames.equalsIgnoreCase(swimmername)) {

					String xpath1 = "//table[@id='swimmertable']/tbody/tr[@class='even'][";

					String xpath11 = ".//*[@id='swimmertable']/tbody/tr[";
					String xpath2 = "]/td[5]";

					String coachName = driver.findElement(By.xpath(xpath11 + i + xpath2)).getText();
					/*
					 * String expectedResult = expectedCoachName;
					 * Assert.assertEquals(actualCoachname, expectedResult);
					 */
					break;
				}

			}
		}
		return this.coachName;

	}

	// Get Batch
	public String getmatchingBatch(String swimmername) {
		WebElement swimmerstable = driver.findElement(SwimmersTable);
		List<WebElement> swimRow = driver.findElements(SwimmersRow);
		swimRow.size();

		for (int i = 0; i < swimRow.size(); i++) {
			List<WebElement> swimcol = swimRow.get(i).findElements(SwimmersColoumn);
			swimcol.size();

			for (int j = 0; j < swimcol.size(); j++) {
				String swimmernames = swimcol.get(j).getText();
				System.err.println(swimmernames);
				if (swimmernames.equalsIgnoreCase(swimmername)) {
					String xpath1 = "//table[@id='swimmertable']/tbody/tr[@class='odd'][html/body/div[1]/app-root/app-player/div/section[2]/div/div/div/div[2]/div[2]/table/tbody/tr[";
					String xpath2 = "]/td[9]";
					String actualbatchname = driver.findElement(By.xpath(xpath1 + i + xpath2)).getText();
					break;

				}

			}
		}
		return this.actualbatchname;

	}

	//Search swimmer
	public void search(String searchKey) {
		WebElement searchButton = driver.findElement(SwimmerSearch);
		searchButton.click();
		searchButton.sendKeys(searchKey);
	}

	public void clickCheckBoxBasedOnSwimmersName(String swimmername) {
		WebElement swimmerstable = driver.findElement(SwimmersTable);
		List<WebElement> swimRow = driver.findElements(SwimmersRow);
		swimRow.size();

		for (int i = 0; i < swimRow.size(); i++) {
			List<WebElement> swimcol = swimRow.get(i).findElements(SwimmersColoumn);
			swimcol.size();

			for (int j = 0; j < swimcol.size(); j++) {
				String swimmernames = swimcol.get(j).getText();
				System.out.println(swimmernames);
				if (swimmernames.equalsIgnoreCase(swimmername)) {
					String xpath1 = ".html/body/div/app-root/app-player/div/section[2]/div/div/div/div[2]/div[2]/table/tbody/tr[";
					String xpath2 = "]/td[1]/input";
					driver.findElement(By.xpath(xpath1 + i + xpath2)).click();
					break;
				}

			}
		}
	}

	public void clickOnTranferButton() {
		driver.findElement(Assign).click();

	}

	public boolean getBooleanvalue(String value) {
		boolean status = driver.findElement(By.linkText(value)).isDisplayed();
		return status;

	}

	public String getStringvalue(String name) {
		String value = driver.findElement(By.linkText(name)).getText();
		return value;

	}

	public void selectCoachFromCoacheSelectionInAssignSwimmerPage(String coachName) throws InterruptedException {
		driver.findElement(CoachSelectionInAssignSwimmerPage).click();
		Thread.sleep(500);
		driver.findElement(CoachSearchinAssignSwimmerPage).sendKeys(coachName);
		WebElement coaches = driver.findElement(CoachListInAssignSwimmerPage);
		List<WebElement> coachList = coaches.findElements(By.tagName("li"));
		for (WebElement coachNames : coachList) {
			System.out.println(coachNames.getText());
			if (coachNames.getText().equals(coachName)) {
				coachNames.click();
				break;
			}
			

		}

	}

	public void selectBatchFromBatchesListInAssignSwimmerPage(String batchName) throws InterruptedException {
		driver.findElement(BatchSelectionInAssigSwimmerPage).click();
		Thread.sleep(500);
		driver.findElement(Searcharea).sendKeys(batchName);
		WebElement batches = driver.findElement(BatchListInAssignSwimmerPage);
		List<WebElement> batchList = batches.findElements(By.tagName("li"));
		for (WebElement batchNames : batchList) {
			System.out.println(batchNames.getText());
			if (batchNames.getText().equals(batchName)) {
				batchNames.click();
				break;
			}

		}

	}

	public boolean checkCoachStatusinAssignSwimmerPage(String coachName) throws InterruptedException {
		driver.findElement(CoachSelectionInAssignSwimmerPage).click();
		Thread.sleep(500);
		driver.findElement(CoachSearchinAssignSwimmerPage).sendKeys(coachName);
		WebElement coaches = driver.findElement(CoachListInAssignSwimmerPage);
		List<WebElement> coachList = coaches.findElements(By.tagName("li"));
		for (WebElement coachNames : coachList) {
			System.out.println(coachNames.getText());
			if (coachNames.getText().equals(coachName)) {
				coachStatus = true;
				break;
			}

		}
		return this.coachStatus;

	}

	public boolean checkBatchStatusAssignSwimmerPage(String batchName) throws InterruptedException {
		driver.findElement(BatchSelectionInAssigSwimmerPage).click();
		Thread.sleep(500);
		driver.findElement(Searcharea).sendKeys(batchName);
		WebElement batches = driver.findElement(BatchListInAssignSwimmerPage);
		List<WebElement> batchList = batches.findElements(By.tagName("li"));
		for (WebElement batchNames : batchList) {
			System.out.println(batchNames.getText());
			if (batchNames.getText().equals(batchName)) {
				batchStatus = true;
			}

		}
		return this.batchStatus;

	}
	public String getAnValidationError (By nameValidation2){
		String error = ((WebElement) nameValidation2).getText();
		return error;
	}
	
	/*public void addingSwimmer (){
		driver.findElement(AddSwimmerButton).click();
		driver.findElement(ScreenName).sendKeys("Arun");
		driver.findElement(Firstname).sendKeys("Arun");
		driver.findElement(Lastname).sendKeys("asdsdas");
		driver.findElement(Password).sendKeys("Nichi12");
		driver.findElement(ConfirmPassword).sendKeys("Nichi123");
		driver.findElement(Location).sendKeys("Bangalore");
		util.selectValueByVisibleText(Year, "2016");
				
				
	}
*/
	public String getAtendancePercentage(String swimmerName) {

		WebElement table = driver.findElement(SwimmersTable);
		List<WebElement> row = driver.findElements(SwimmersRow);
		row.size();
		for (int i = 1; i < row.size(); i++) {
			List<WebElement> col = row.get(i).findElements(SwimmersColoumn);
			col.size();
			List<String> swimmersName = new ArrayList<String>();
			for (int j = 0; j < col.size(); j++) {
				String name = col.get(j).getText();
				System.out.println(name);
				if (name.equals(swimmerName)) {
					swimmersName.add(name);
					String xp1 = "html/body/div[1]/app-root/app-player/div/section[2]/div/div/div/div[2]/div[2]/table/tbody/tr[";
					String xp2 = "]/td[7]";
					String attendancePercentage = driver.findElement(By.xpath(xp1+i+xp2)).getText();
					/*WebElement attendance = driver.findElement(By.xpath(xp1+i+xp2));
					attendance.click();*/
					
					break;
				}
			}
		}
		return this.attendancePercentage;
		/*WebElement attendance = driver.findElement(By.xpath(xp1+i+xp2));
		attendance.click();*/
		
		
		
	}
	
	
	public void clickOnAttendance (String swimmerName){

		WebElement table = driver.findElement(SwimmersTable);
		List<WebElement> row = driver.findElements(SwimmersRow);
		row.size();
		for (int i = 0; i < row.size(); i++) {
			List<WebElement> col = row.get(i).findElements(SwimmersColoumn);
			col.size();
			List<String> swimmersName = new ArrayList<String>();
			for (int j = 0; j < col.size(); j++) {
				String name = col.get(j).getText();
				if (name.equals(swimmerName)) {
					swimmersName.add(name);
					String xp1 = "html/body/div[1]/app-root/app-player/div/section[2]/div/div/div/div[2]/div[2]/table/tbody/tr[";
					String xp2 = "]/td[7]";
					WebElement  attendancePercentage = driver.findElement(By.xpath(xp1+i+xp2));
					attendancePercentage.click();
					break;
				}
			}
		}
		
	}
	public void clickOnDowbLoadDatas (String downloadType){
		switch (downloadType){
		
		case "CSV":
			driver.findElement(By.xpath("(//span[@style='color:white;font-weight:bold;'])[1]")).click();
			break;
		case "Excel":
			driver.findElement(By.xpath("(//span[@style='color:white;font-weight:bold;'])[2]")).click();
		case "PDF":	
			driver.findElement(By.xpath("(//span[@style='color:white;font-weight:bold;'])[3]")).click();
		}
		
	}
	public void addSwimmer (String screenName, String email, String firstname,String lastName, String password,String confirmPassword, String phNo, String location  ){
		driver.findElement(ScreenName).clear();
		driver.findElement(ScreenName).sendKeys(screenName);
		driver.findElement(EmailId).clear();
		driver.findElement(EmailId).sendKeys(email);
		driver.findElement(Firstname).clear();
		driver.findElement(Firstname).sendKeys(firstname);
		driver.findElement(Lastname).clear();
		driver.findElement(Lastname).sendKeys(lastName);
		driver.findElement(Lastname).clear();
		driver.findElement(Password).sendKeys(password);
		driver.findElement(ConfirmPassword).clear();
		driver.findElement(ConfirmPassword).sendKeys(confirmPassword);
		driver.findElement(PhoneNumber).clear();
		driver.findElement(PhoneNumber).sendKeys(phNo);
		driver.findElement(Location).clear();
		driver.findElement(Location).sendKeys(location);
		WebElement year = driver.findElement(Year);
		WebElement month = driver.findElement(Month);
		WebElement day = driver.findElement(Day);
		util.selectValueByVisibleText(year, "2000");
		util.selectValueByVisibleText(month, "Mar");
		util.selectValueByVisibleText(day, "9");
		driver.findElement(RegisterButton);
		
	}
	
	public void clickOnResultFromProfilePage (){
		WebElement table = driver.findElement(By.id("swimmertable"));
		List <WebElement> row = table.findElements(By.tagName("tr"));
		
		
	}

}
