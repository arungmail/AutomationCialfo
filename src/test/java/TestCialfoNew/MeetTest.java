package TestCialfoNew;

import BasePackage.DriverClass;
import BasePackage.Utility;
import Pages.Atendance;
import Pages.BatchList;
import Pages.DashBoard;
import Pages.LoginForm;
import Pages.Meets;
import Pages.SwimmersPage;


public class MeetTest extends DriverClass{

	LoginForm login = new LoginForm();
	DashBoard dash = new DashBoard();
	BatchList batch = new BatchList();
	Utility util = new Utility();
	SwimmersPage swimmers = new SwimmersPage();
	InputValues input = new InputValues();
	Atendance att = new Atendance();
	Meets meets = new Meets ();
	
	public void addSwimmer (){
		dash.clickOnMeets();
		driver.findElement(meets.Swimmers).click();
		driver.findElement(meets.AddSwimmersButton).click();
		driver.findElement(meets.ScreennameInAddSwiimer).clear();
		driver.findElement(meets.ScreennameInAddSwiimer).sendKeys("Test");
		driver.findElement(meets.FirstNameInAddSwiimer).clear();
		driver.findElement(meets.FirstNameInAddSwiimer).sendKeys(input.MeetsSwimmerFirstName);
		driver.findElement(meets.LastNameInAddSwiimer).clear();
		driver.findElement(meets.LastNameInAddSwiimer).sendKeys(input.MeetSwimmerSecondName);
		driver.findElement(meets.LocationInAddSwiimer).clear();
		driver.findElement(meets.LocationInAddSwiimer).sendKeys("Bangalore");
		driver.findElement(meets.DOBInAddSwiimer).click();
		meets.selectDateFromCalendar(input.Calendardate);
		driver.findElement(meets.SelectStateInAddSwiimer).click();
		meets.selectItemFromSpanlist(meets.StateListinSwimmer, "Kerala");
		driver.findElement(meets.EmailInAddSwiimer).clear();
		driver.findElement(meets.EmailInAddSwiimer).sendKeys(input.MeetSwimmerEmailId);
		driver.findElement(meets.MobileInAddSwiimer).clear();
		driver.findElement(meets.MobileInAddSwiimer).sendKeys("9901356897");
		driver.findElement(meets.ClubInAddSwiimer).clear();
		driver.findElement(meets.ClubInAddSwiimer).sendKeys("sdfasd");
		driver.findElement(meets.UniversityInAddSwiimer).clear();
		driver.findElement(meets.UniversityInAddSwiimer).sendKeys("hdfg");
		driver.findElement(meets.SchoolInAddSwiimer).clear();
		driver.findElement(meets.SchoolInAddSwiimer).sendKeys("asfdasfs");
		driver.findElement(meets.GenderinAddSwiimer).click();
		meets.selectItemFromSpanlist(meets.GenderList, "Male");
		driver.findElement(meets.SummeryInAddSwiimer).sendKeys("fasfas");
		meets.clickOnSubMitButton();
	}
	public void swimmervalidations (){
		driver.findElement(meets.Swimmers).click();
		driver.findElement(meets.AddSwimmersButton).click();
		driver.findElement(meets.ScreennameInAddSwiimer).clear();
		driver.findElement(meets.ScreennameInAddSwiimer).sendKeys("Test");
		driver.findElement(meets.FirstNameInAddSwiimer).clear();
		//driver.findElement(meets.FirstNameInAddSwiimer).sendKeys(input.MeetsSwimmerFirstName);
		driver.findElement(meets.LastNameInAddSwiimer).clear();
		//driver.findElement(meets.LastNameInAddSwiimer).sendKeys(input.MeetSwimmerSecondName);
		driver.findElement(meets.LocationInAddSwiimer).clear();
		driver.findElement(meets.LocationInAddSwiimer).sendKeys("Bangalore");
		driver.findElement(meets.DOBInAddSwiimer).click();
		meets.selectDateFromCalendar(input.Calendardate);
		driver.findElement(meets.SelectStateInAddSwiimer).click();
		meets.selectItemFromSpanlist(meets.StateListinSwimmer, "Kerala");
		driver.findElement(meets.EmailInAddSwiimer).clear();
		//driver.findElement(meets.EmailInAddSwiimer).sendKeys(input.MeetSwimmerEmailId);
		driver.findElement(meets.MobileInAddSwiimer).clear();
		//driver.findElement(meets.MobileInAddSwiimer).sendKeys("9901356897");
		driver.findElement(meets.ClubInAddSwiimer).clear();
		driver.findElement(meets.ClubInAddSwiimer).sendKeys("sdfasd");
		driver.findElement(meets.UniversityInAddSwiimer).clear();
		driver.findElement(meets.UniversityInAddSwiimer).sendKeys("hdfg");
		driver.findElement(meets.SchoolInAddSwiimer).clear();
		driver.findElement(meets.SchoolInAddSwiimer).sendKeys("asfdasfs");
		driver.findElement(meets.GenderinAddSwiimer).click();
		meets.selectItemFromSpanlist(meets.GenderList, "Male");
		driver.findElement(meets.SummeryInAddSwiimer).sendKeys("fasfas");
		meets.clickOnSubMitButton();
	}
	public void addSwimmersWithmanditoryField (){
		driver.findElement(meets.AddResult).click();
		driver.findElement(meets.Swimmers).click();
		driver.findElement(meets.AddSwimmersButton).click();
		//driver.findElement(meets.ScreennameInAddSwiimer).clear();
		//driver.findElement(meets.ScreennameInAddSwiimer).sendKeys("Test");
		driver.findElement(meets.FirstNameInAddSwiimer).clear();
		driver.findElement(meets.FirstNameInAddSwiimer).sendKeys(input.MeetsSwimmer2FirstName);
		driver.findElement(meets.LastNameInAddSwiimer).clear();
		driver.findElement(meets.LastNameInAddSwiimer).sendKeys(input.MeetSwimmer2SecondName);
		//driver.findElement(meets.LocationInAddSwiimer).clear();
		//driver.findElement(meets.LocationInAddSwiimer).sendKeys("Bangalore");
		//driver.findElement(meets.DOBInAddSwiimer).click();
		//meets.selectDateFromCalendar(input.Calendardate);
		//driver.findElement(meets.SelectStateInAddSwiimer).click();
		//meets.selectItemFromSpanlist(meets.StateListinSwimmer, "Kerala");
		driver.findElement(meets.EmailInAddSwiimer).clear();
		driver.findElement(meets.EmailInAddSwiimer).sendKeys(input.MeetSwimmer2EmailId);
		driver.findElement(meets.MobileInAddSwiimer).clear();
		driver.findElement(meets.MobileInAddSwiimer).sendKeys("9901356897");
		//driver.findElement(meets.ClubInAddSwiimer).clear();
		//driver.findElement(meets.ClubInAddSwiimer).sendKeys("sdfasd");
		//driver.findElement(meets.UniversityInAddSwiimer).clear();
		//driver.findElement(meets.UniversityInAddSwiimer).sendKeys("hdfg");
		//driver.findElement(meets.SchoolInAddSwiimer).clear();
		//driver.findElement(meets.SchoolInAddSwiimer).sendKeys("asfdasfs");
		driver.findElement(meets.GenderinAddSwiimer).click();
		meets.selectItemFromSpanlist(meets.GenderList, "Male");
		//driver.findElement(meets.SummeryInAddSwiimer).sendKeys("fasfas");
		meets.clickOnSubMitButton();
	}
	
	
}
