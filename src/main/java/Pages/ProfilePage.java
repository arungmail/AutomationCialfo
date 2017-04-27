package Pages;

import java.awt.List;
import java.util.ArrayList;

import org.openqa.selenium.By;

import BasePackage.DriverClass;
import BasePackage.Utility;

public class ProfilePage extends DriverClass{
	Utility util  = new Utility ();

  public  By    Profile 						= By.linkText("Profile");
  public  By    Account							= By.linkText("Account");
  private By    PersonalInfo					= By.xpath(".//*[@id='tab_1_3']/div/div[1]/ul/li[1]/a");
  private By	ChangeProfileImage				= By.xpath(".//*[@id='tab_1_3']/div/div[1]/ul/li[2]/a");
  private By	ChangePasswrd					= By.xpath(".//*[@id='tab_1_3']/div/div[1]/ul/li[3]/a");
  private By 	Address							= By.xpath(".//*[@id='tab_1_3']/div/div[1]/ul/li[4]/a");
  private By	FirstNameInPersonalInfo			= By.id("first_name");
  private By    FirstNameValidation 			= By.id("first_name_validation");
  private By	LastNameInPersonalInfo			= By.id("last_name");
  private By    LastNameValidation 				= By.id("last_name_validation");
  private By    Mobile							= By.id("mobile");
  private By    Mobilevalidation				= By.id("mobile_validation");
  private By    Landline						= By.id("landline");
  private By    Landlinevalidation				= By.id("landline_validation");
  private By    SaveChanges						= By.linkText("Save Changes");
  private By    Cancel							= By.linkText("Cancel");
  private By	NewpasswordInChangePassword		= By.id("password");
  private By	NewPasswordValidation 			= By.id("password_validation");
  private By    ConfirmPasswordValidation		= By.id("confirmpassword_validation");
  private By    ConfirmPasswordInChangepassword = By.id("confirmpassword");
  private By    ChangePasswordButton			= By.xpath(".//*[@id='tab_3-3']/form/div[3]/a[1]");
  private By    StreetInAddress					= By.id("street");
  private By    Streetvalidation 				= By.id("street_validation");
  private By    LandmarkInAddress				= By.id("landmark");
  private By    LandmarkValidation				= By.id("landmark_validation");
  private By    CityInAddress					= By.id("city");
  private By    Cityvalidation 					= By.id("city_validation");
  private By    StateInAddress					= By.id("state");
  private By    StateValidation					= By.id("state_validation");
  private By    ZipCodeInAddress				= By.id("zip");
  private By	Zipvalidation 					= By.id("zip_validation");
  private By    CountryInAddress				= By.id("country");
  private By    CountryValidation 				= By.id("country_validation");
  private By    PersonalInfoSucessvalidation	= By.id("success_validation");
  private By    YearDropDown					= By.id("year");
  private By    MonthDropDown					= By.id("month");
  private By    DayDropDown						= By.id("day");
  public  By    Overview						= By.linkText("Overview");
  private By 	MobileNumberinOverviewPage      = By.xpath(".//*[@id='tab_1_1']/div/div[1]/ul/li[2]/a");
  private By    EmailIdInOverviewPage			= By.xpath(".//*[@id='tab_1_1']/div/div[1]/ul/li[3]/a");
  public  By    ProfleNameInOverViewpage		= By.xpath(".//*[@id='tab_1_1']/div/div[2]/div[1]/div[1]/h1");
  public  By 	LogOutbutton 						= By.xpath("html/body/div[1]/app-root/app-header-menu/header/nav/div/ul/li[4]/ul/li[2]/div[2]/a");
  
  
  
  public void clickOnProfile()
  {
	  driver.findElement(Profile).click();
  }
  public void clickOnAccount()
  {
	  driver.findElement(Account).click();
  }
  public void clickOnPersonalInfo()
  {
	  driver.findElement(PersonalInfo).click();
  }
  public void enterFirstname(String value)
  {
	  driver.findElement(FirstNameInPersonalInfo).clear();
	  driver.findElement(FirstNameInPersonalInfo).sendKeys(value);
  }
  public void enterLastName(String value)
  {
	  driver.findElement(LastNameInPersonalInfo).clear();
	  driver.findElement(LastNameInPersonalInfo).sendKeys(value);
  }
  public void entermobileno(String value)
  {
	  driver.findElement(Mobile).clear();
	  driver.findElement(Mobile).sendKeys(value);
  }
  public void enterLandline(String value)
  {
	  driver.findElement(Landline).clear();
	  driver.findElement(Landline).sendKeys(value);
  }
  public void clickOnSaveChanges(){
	  driver.findElement(SaveChanges).click();
  }
  public String checkFirstNameValidationError()
  {
	  String error = driver.findElement(FirstNameValidation).getText();
	  System.out.println(error);
	  return error;  
  }
  public String checkLastNameValidationError()
  {
	  String error = driver.findElement(LastNameValidation).getText();
	  System.out.println(error);
	  return error;
  }
  public String checkmobileNoValidationError()
  {
	  String error = driver.findElement(Mobilevalidation).getText();
	  System.out.println(error);
	  return error;
  }
  public String checkLandLineValidationError ()
  {
	  String error = driver.findElement(Landlinevalidation).getText();
	  System.out.println(error);
	  return error;
  }
  public void clickOnChangepassword(){
	  driver.findElement(ChangePasswrd).click();
  }
  public void enterNewPassword(String value)
  {
	  driver.findElement(NewpasswordInChangePassword).clear();
	  driver.findElement(NewpasswordInChangePassword).sendKeys(value);
  }
  public void enterConfirmpassword(String value)
  {
	  driver.findElement(ConfirmPasswordInChangepassword).clear();
	  driver.findElement(ConfirmPasswordInChangepassword).sendKeys(value);
  }
  public void clickOnChangePasswordButton()
  {
	  driver.findElement(ChangePasswordButton).click();
  }
  public String checkNewPasswordValidationError ()
  {
	  String error = driver.findElement(NewpasswordInChangePassword).getText();
	  System.out.println(error);
	  return error;
  }
  public String checkConfirmpasswordValidationError ()
  {
	  String error = driver.findElement(ConfirmPasswordValidation).getText();
	  System.out.println(error);
	  return error;
  }
  public void clickOnAddress()
  {
	  driver.findElement(Address).click();
  }
  public void enterStreetName(String value)
  {
	  driver.findElement(StreetInAddress).clear();
	  driver.findElement(StreetInAddress).sendKeys(value);
  }
  public void enterlandmark(String value)
  {
	  driver.findElement(LandmarkInAddress).clear();
	  driver.findElement(LandmarkInAddress).sendKeys(value);
  }
  public void enterCity(String value)
  {
	  driver.findElement(CityInAddress).clear();
	  driver.findElement(CityInAddress).sendKeys(value);
  }
  public void enterState(String value)
  {
	  driver.findElement(StateInAddress).clear();
	  driver.findElement(StateInAddress).sendKeys(value);
  }
  public void enterZip(String value)
  {
	  driver.findElement(ZipCodeInAddress).clear();
	  driver.findElement(ZipCodeInAddress).sendKeys(value);
  }
  public void enterCoutry (String value)
  {
	  driver.findElement(CountryInAddress).clear();
	  driver.findElement(CountryInAddress).sendKeys(value);
  }
  public String streetvalidationError (){
	  String error = driver.findElement(Streetvalidation).getText();
	  System.out.println("Street validation error"+ error);
	  return error;
  }
  public String landmarkvalidationError ()
  {
	  String error = driver.findElement(Landlinevalidation).getText();
	  System.out.println("Landmark validation error"+error);
	  return error;
  }
  public String cityValidationError ()
  {
	  String error = driver.findElement(Cityvalidation).getText();
	  System.out.println("City validation error"+error);
	  return error;
  }
  public String  stateValidationError()
  {
	  String error = driver.findElement(StateValidation).getText();
	  System.out.println("State validation error"+error);
	  return error;  
  }
  public String  zipValidationError()
  {
	  String error = driver.findElement(Zipvalidation).getText();
	  System.out.println("Zip validation error"+error);
	  return error;  
  }
  public String  coutryValidationError()
  {
	  String error = driver.findElement(CountryValidation).getText();
	  System.out.println("Country validation error"+error);
	  return error;  
  }
  public String checkSucsessMessage()
  {
	  String error = driver.findElement(PersonalInfoSucessvalidation).getText();
	  System.out.println("Successmessage"+error);
	  return error;
  }
  public void selectDOBInProfilePage(String yearValue,String monthvalue,String dayvalue){
	  driver.findElement(YearDropDown).click();
	  driver.findElement(YearDropDown).sendKeys(yearValue);
	  driver.findElement(MonthDropDown).click();
	  driver.findElement(MonthDropDown).sendKeys(monthvalue);
	  driver.findElement(DayDropDown).click();
	  driver.findElement(DayDropDown).sendKeys(dayvalue);
  }
 public String checkMobilenumberinOverViewPage()
 {
	 String mobilenumber = driver.findElement(MobileNumberinOverviewPage).getText();
	 System.out.println(mobilenumber);
	 return mobilenumber;
 }
 public String getClubnameinOverViewPage ()
 {
	 String clubname = driver.findElement(ProfleNameInOverViewpage).getText();
	 System.out.println(clubname);
	 return clubname;
 }
 public String[] getAddressAttributes()
 {
	 String street 		= driver.findElement(StreetInAddress).getAttribute("value");
	 String landmark 	= driver.findElement(LandmarkInAddress).getAttribute("value");
	 String city		= driver.findElement(CityInAddress).getAttribute("value");
	 String state 		= driver.findElement(StateInAddress).getAttribute("value");
	 String zip			= driver.findElement(ZipCodeInAddress).getAttribute("value");
	 String country 	= driver.findElement(CountryInAddress).getAttribute("value");
	 String[] values    = new String[]{street,landmark,city,state,zip,country};
	 return values;
 }
 public String [] getPersonalInfoAttributes()
 {
	 String firstname 	= driver.findElement(FirstNameInPersonalInfo).getAttribute("value");
	 String lastname 	= driver.findElement(LastNameInPersonalInfo).getAttribute("value");
	 String mobilenumber=driver.findElement(Mobile).getAttribute("value");
	 String landline 	= driver.findElement(Landline).getAttribute("value");
	 String [] values	= new String []{firstname,lastname,mobilenumber,landline};
	 return values;
 }
  public void clickOnLogOutButton ()
  {
	  driver.findElement(LogOutbutton).click();
  }
}

