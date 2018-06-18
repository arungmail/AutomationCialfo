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


	public By BatchNameInSwimmersPage  = By.xpath("html/body/div[1]/app-root/app-player/div/section[2]/div/div/div/div[2]/div[2]/table/tbody/tr/td[9]");
	
	public By CoachNameinSwimmerspage = By.xpath("html/body/div[1]/app-root/app-player/div/section[2]/div/div/div/div[2]/div[2]/table/tbody/tr/td[10]/a");
	
	public By AttendanceInSwimmerPage  = By.xpath("html/body/div[1]/app-root/app-player/div/section[2]/div/div/div/div[2]/div[2]/table/tbody/tr/td[7]/a");
	
	public By Searchbutton = By.xpath("//input[@type='search']");
	
	public By BatchSelection = By.xpath("/html/body/div/app-root/app-player/div/section[2]/div/div/div/div[1]/div[2]/div[1]/span/span[1]/span/span[2]");
	
	public By Searcharea = By.xpath("//input[@class='select2-search__field']");
	
	public By EntrySelection = By.xpath("//div[@id='swimmertable_length']/label/select");
	
	public By Homebredcrumbs = By.xpath("html/body/div[1]/app-root/app-player/div/section[1]/ol/li[1]/a");
	
	public By TranferButton = By.xpath("//button[@id='assign_btn']");
	
	public By BatchSelectionInTranferPlayer = By.xpath("//span[@id='select2-4oqv-container']");
	
	public By SubmitButton = By.xpath("//button[@class='btn btn-primary align_top']");
	
	public By CloseButton = By.xpath("//button[@class='btn btn-default align_top']");
	
	public By ErrorValidation = By.id("error_validation");
	
	public By Successvalidation = By.id("success_validation");
	
	public By SwimmersTable = By.xpath("html/body/div[1]/app-root/app-player/div/section[2]/div/div/div/div[2]/div[2]/table");
	
	public By SwimmersRow = By.tagName("tr");
	
	
	public By SwimmersColoumn = By.tagName("td");
	public By DataEmptyMessage = By.xpath("//td[@class='dataTables_empty']");
	public By CheckBox = By.xpath("html/body/div[1]/app-root/app-player/div/section[2]/div/div/div/div[2]/div[2]/table/tbody/tr/td[1]/input");
	
	public By BatchList = By.className("select2-results__options");
	
	public By CoachSelection  = By.xpath("/html/body/div/app-root/app-player/div/section[2]/div/div/div/div[1]/div[2]/div[2]/span/span[1]/span/span[2]");
	
	public By CoachList = By.className("select2-results__options");
	public By CoachSelectionInAssignSwimmerPage = By.xpath("//*[@id='myModal']/div/div/div[2]/div/div[1]/span/span[1]/span/span[2]");
	
	
	public By CoachListInAssignSwimmerPage = By.className("select2-results__options");
	
	public By BatchSelectionInAssigSwimmerPage = By.xpath("//*[@id='myModal']/div/div/div[2]/div/div[2]/span/span[1]/span/span[2]");
	
	public By BatchListInAssignSwimmerPage = By.className("select2-results__options");
	
	public By TransferButtonInAssignpage = By.xpath("//button[@class='btn btn-primary align_top']");
	
	public By AddSwimmerButton = By.xpath("//button[@class='btn btn-primary pull-right'][1]	");
	public By ScreenName = By.xpath("//input[@formcontrolname='name']");
	public By SwimmerSearch = By.xpath("	");
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
    public By PhoneNumberValidation = By.id("phone_validation");
    public By DOBValidation = By.id("error_validation" );
    public By AvailablePhonenumbervalidation = By.id("available_phone_error_validation");
    public By PasswordMatchingValidation = By.id("error_validation");
    public By PhoneNumber = By.xpath("//input[@placeholder='Phone Number']");
    public By LocationValidation = By.id("location_validation");
    public By AttendancePercentageInReportpage = By.xpath(".//*[@id='swimmertable']/tbody/tr/td[6]");
    public By BatchNameInSwimmersreportpage = By.xpath(".//*[@id='swimmertable']/tbody/tr/td[8]");
    public By CoachNameInSwimmerReportPage = By.xpath(".//*[@id='swimmertable']/tbody/tr/td[9]");

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
		driver.findElement(Searcharea).clear();
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
			driver.findElement(Searcharea).clear();
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
			driver.findElement(Searcharea).clear();
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
			driver.findElement(Searcharea).clear();
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

					String xpath1 = ".//*[@id='swimmertable']/tbody/tr[";
					String xpath2 = "]/td[5]";

					String coachName = driver.findElement(By.xpath(xpath1 + i + xpath2)).getText();
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
					String xpath1 = "html/body/div[1]/app-root/app-player/div/section[2]/div/div/div/div[2]/div[2]/table/tbody/tr[";
					String xpath2 = "]/td[7]/a";
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
		searchButton.clear();
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
					String xpath1 = "html/body/div[1]/app-root/app-player/div/section[2]/div/div/div/div[2]/div[2]/table/tbody/tr[";
					String xpath2 = "]/td[1]/input";
					driver.findElement(By.xpath(xpath1+i+xpath2)).click();
					break;
				}

			}
		}
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
		driver.findElement(Searcharea).clear();
		driver.findElement(Searcharea).sendKeys(coachName);
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
		driver.findElement(Searcharea).clear();
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
		driver.findElement(Searcharea).clear();
		driver.findElement(Searcharea).sendKeys(coachName);
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
		driver.findElement(Searcharea).clear();
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
					String xp2 = "]/td[7]/a";
					String attendancePercentage = driver.findElement(By.xpath(xp1+i+xp2)).getText();
					WebElement attendance = driver.findElement(By.xpath(xp1+i+xp2));
					attendance.click();
					
					break;
				}
			}
		}
		return this.attendancePercentage;

		
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
		driver.findElement(Password).clear();
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
		driver.findElement(RegisterButton).click();
		
	}
	
	public void clickOnResultFromProfilePage (){
		WebElement table = driver.findElement(By.id("swimmertable"));
		List <WebElement> row = table.findElements(By.tagName("tr"));
		
		
	}
	
	public void clickOnSwimmerName (String email){
		

		WebElement table = driver.findElement(SwimmersTable);
		List<WebElement> row = driver.findElements(SwimmersRow);
		row.size();
		for (int i = 0; i < row.size(); i++) {
			List<WebElement> col = row.get(i).findElements(SwimmersColoumn);
			col.size();
			List<String> swimmersName = new ArrayList<String>();
			for (int j = 0; j < col.size(); j++) {
				String name = col.get(j).getText();
				if (name.equals(email)) {
					swimmersName.add(name);
					String xp1 = "html/body/div[1]/app-root/app-player/div/section[2]/div/div/div/div[2]/div[2]/table/tbody/tr[";
					String xp2 = "]/td[2]/a";
					WebElement  attendancePercentage = driver.findElement(By.xpath(xp1+i+xp2));
					attendancePercentage.click();
					break;
				}
			}
		}
		
	}
	

}
