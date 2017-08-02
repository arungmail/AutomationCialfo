package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BasePackage.DriverClass;

public class Meets extends DriverClass{
	public By AddResult    = By.linkText("Add Results");
	public By Meets 		= By.linkText("Meets");
	public By Swimmers 		= By.linkText("Swimmers");
	public By SelectMeet 	= By.xpath("//span[@title='Select Meet']");
	public By SelectEvent	= By.xpath("//span[@title='Select Event']");
	public By SelectHeat	= By.xpath("//span[@title='Select Heat']");
	public By SelectDistance	= By.xpath("//span[@title='Select Distance']");
	public By SelectGroup	= By.xpath("//span[@title='Select Group']");
	public By SelectGender	= By.xpath("//span[@title='Select Gendar']");
	public By SelectDate	= By.id("result_event_date");
	public By SelectSearchSwimmer = By.xpath("//span[@title='Search Swimmer']");
	public By EnterPosition  	= By.xpath("//input[@id='select_result_position1']");
	public By EnterTmings		= By.xpath("//input[@id='result_timings1']");
	public By Achiived 			= By.xpath("//span[@aria-labelledby='select2-select_result_achieve1-container']");
	public By ponits 			= By.xpath("//input[@id='result_points1']");
	public By Comments 			= By.xpath("//input [@id='result_comment1']");
	public By Represented		= By.xpath("//span[@title='Represented to ']");
	public By AddMeetButton		= By.xpath("html/body/div/app-root/app-meets/div[1]/section[2]/div/div/div/div[2]/div/div/div/div[2]/div[1]/div/div/button");
	public By SearchMeet 		= By.xpath("//input[@type='search']");
	public By PreviousButtoninMeets  = By.id("meettable_previous");
	public By NextButton             = By.id("meettable_next");
	public By MeetName 					= By.xpath("//input[@formcontrolname='name']");
	public By SelectLocation 			= By.xpath("html/body/div/app-root/app-meets/div[1]/section[2]/div/div/div/div[2]/div/div/div/div[2]/div[2]/form/div[1]/div[2]/span/span[1]/span/span[1]");
	public By MeetStartsDate 			= By.xpath("//input[@id='meet_start_date']");
	public By MeetEndDate				= By.xpath("//input[@id='meet_end_date']");
	public By MeetInformation 			= By.xpath("//input[@formcontrolname='info']");
	public By SelectCourse				= By.xpath("//span[@title='Select Course']");
	public By SubmitButton				= By.xpath("(//button[@id='register_btn'])[4]");
	public By BackButton 				= By.xpath("(//button[@id='meet_back_btn'])[1]");
	public By Resetbutton 				= By.xpath("(//button[@id='register_btn'])[2]");
	public By SubmitButtonInResults 	= By.xpath("(//button[@id='register_btn'])[1]");
	public By AddSwimmersButton 		= By.xpath("html/body/div/app-root/app-meets/div[1]/section[2]/div/div/div/div[2]/div/div/div/div[3]/div[2]/div/div/button");
	public By ScreennameInAddSwiimer				= By.xpath("//input[@placeholder='Screen Name']");
	public By FirstNameInAddSwiimer 				= By.xpath("//input[@placeholder='First Name']");
	public By FirstNameValidationError				= By.id("meet_first_name_validation");
	public By LastNameInAddSwiimer                  = By.xpath("//input[@placeholder='Last Name']");
	public By LastNameValidationError				= By.id("last_name_validation");
	public By LocationInAddSwiimer 					= By.xpath("//input[@placeholder='Location']");
	public By LocationValidationError				= By.id("location_validation");
	public By DOBInAddSwiimer 						= By.xpath("//input[@placeholder='Date of Birth']");
    public By DOBValidationError					= By.id("dob_validation");
	public By SelectStateInAddSwiimer 				= By.xpath("//span[@title='Select State']");
	public By StateValidationError					= By.id("state_validation");
	public By StateListinSwimmer					= By.xpath("//ul[@id='select2-8oli-results']");
	public By EmailInAddSwiimer 					= By.xpath("//input[@placeholder='Email']");
	public By EmailIdValidationError 				= By.xpath("meet_email_validation");
	public By MobileInAddSwiimer 					= By.xpath("//input[@placeholder='Mobile']");
	public By MobileNoValidationError				= By.id("mobile_validation");
	public By ClubInAddSwiimer 						= By.xpath("//input[@placeholder='Club']");
	public By ClubValidationError					= By.id("club_validation");
	public By UniversityInAddSwiimer 				= By.xpath("//input[@placeholder='University']");
	public By UniversityValidationError				= By.id("university_validation");
	public By SchoolInAddSwiimer					= By.xpath("//input[@placeholder='School / College']");
	public By SchoolValidayionError 				= By.id("school_validation");
	public By GenderinAddSwiimer 		           = By.xpath("//span[@title='Select Gender']");
	public By GenderList 							= By.xpath("//ul[@id='select2-9gi2-results']");
	public By GenderValidationError 				= By.id("gender_validation");
	public By SwimindiaRankingInAddSwiimer 			= By.xpath("//span[@title='Select SwimIndia Ranking']");
	public By SwimindiaRankingList					= By.xpath("//ul[@id='select2-t025-results']");
	public By RankingValidationError				= By.id("ranking_validation");
	public By SummeryInAddSwiimer 					= By.xpath("//input[@placeholder='Summery']");
	public By SummeryValidationError				= By.id("summery_validation");
	public By SearchSwimmerInSwimmerPage			= By.xpath("(//input[@placeholder=''])[2]");
	public By SubmitButtonInAddSwiimer 				= By.xpath("html/body/div/app-root/app-meets/div[1]/section[2]/div/div/div/div[2]/div/div/div/div[3]/div[1]/form/div[6]/div[2]/button");
	public boolean Swimmerstatus;
	public By SwimmerTable = By.id("swimmertable");
	public By MeetsTable = By.id("meettable");
	public boolean meetStatus;
	
	
	
	public void clickOnSwimmer(){
		driver.findElement(AddSwimmersButton).click();
	}

	public void addSwimmerfields(String Screenname,String firstname,String lastname,String location,String email, String Mobilenumber, String club, String university, String college, String summery){
		driver.findElement(ScreennameInAddSwiimer).sendKeys(Screenname);
		driver.findElement(FirstNameInAddSwiimer).sendKeys(firstname);
		driver.findElement(LastNameInAddSwiimer).sendKeys(lastname);
		driver.findElement(LocationInAddSwiimer).sendKeys(location);
		driver.findElement(EmailInAddSwiimer).sendKeys(email);
		driver.findElement(MobileInAddSwiimer).sendKeys(Mobilenumber);
		driver.findElement(ClubInAddSwiimer).sendKeys(club);
		driver.findElement(UniversityInAddSwiimer).sendKeys(university);
		driver.findElement(SchoolInAddSwiimer).sendKeys(college);
		driver.findElement(SummeryInAddSwiimer).sendKeys(summery);			
	}
		

	public void selectItemFromSpanlist(By list, String value)
	{
		//WebElement clickItem = driver.findElement(element);
		List <WebElement> listitem = driver.findElements(list);
		for (WebElement alllist : listitem){
			System.out.println(alllist.getText());
			if (alllist.getText().equals(value)){
				alllist.click();
				break;
			}
			
		}
		
	}
	
	//public void 

	public String getValidationError(WebElement element)
	{
		WebElement validation = driver.findElement((By) element);
		String actual = validation.getText();
		return actual;
	}
	
	public void clickOnSubMitButton()
	{
		driver.findElement(SubmitButtonInAddSwiimer).click();
	
	}
	
	//
	public boolean getSwimmerStatus (String value) throws InterruptedException{
		driver.findElement(SearchSwimmerInSwimmerPage).sendKeys("sdfsdfd");
		Thread.sleep(500);
		WebElement table = driver.findElement(By.xpath("//id[@id='swimmertable']"));
		List <WebElement> row = table.findElements(By.tagName("tr"));
		row.size();
		for (int i=0;i<row.size();i++){
			List<WebElement> col = row.get(i).findElements(By.tagName("td"));
			col.size();
			for (int j=0;j<col.size();j++){
				String swimmersname = col.get(j).getText();
				if (Swimmerstatus = swimmersname.equals(value)){
					return Swimmerstatus = true;
				}
					else {
						return Swimmerstatus = false;
					}				 
				}
			break;
			}
			
		return Swimmerstatus;		
	}	
	
	

	public void editAndDelete (String swimmerName, String ediDeletevalue) throws InterruptedException{
		driver.findElement(SearchSwimmerInSwimmerPage).sendKeys("sdfsdfd");
		Thread.sleep(500);
		WebElement table = driver.findElement(SwimmerTable);
		List <WebElement> row = table.findElements(By.tagName("tr"));
		row.size();
		for (int i=0;i<row.size();i++){
			List<WebElement> col = row.get(i).findElements(By.tagName("td"));
			col.size();
			for (int j=0;j<col.size();j++){
				String swimmersname = col.get(j).getText();
				if (Swimmerstatus = swimmersname.equals(swimmerName)){	
					String xpa1 = "html/body/div[1]/app-root/app-meets/div[1]/section[2]/div/div/div/div[2]/div/div/div/div[3]/div[2]/div/div/div[2]/table/tbody/tr[";
					String xpa2 = "1]/td[7]";
					WebElement action = driver.findElement(By.xpath(xpa1+i+xpa2));
					if (ediDeletevalue.endsWith("edit"))
					action.findElement(By.xpath("//a[@class='edit_swimmer']")).click();
					//WebElement delete = driver.findElement(By.xpath(xpa1+i+xpa2));
					else {
					action.findElement(By.xpath("//a[@class='delete_swimmer']"));
					break;
					}
				}
			}
		}
	}
	
	public boolean getMeetStatus (String meetsName){
		driver.findElement(SearchMeet).sendKeys("dgdsg");
		WebElement meetsTable = driver.findElement(MeetsTable);
		List <WebElement> row = meetsTable.findElements(By.tagName("tr"));
		row.size();
		for (int i=0;i<row.size();i++){
			List<WebElement> col = row.get(i).findElements(By.tagName("td"));
			col.size();
			for (int j=0;j<col.size();j++){
				String meetsNames =col.get(j).getText();
				if (meetsNames.equals(meetsName)){
					meetStatus = true;
				}
				else {
					meetStatus = false;
				}
					
				}
				
			}
		return meetStatus;
		
	}				
}




