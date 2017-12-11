package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BasePackage.DriverClass;
import BasePackage.Utility;
import junit.framework.Assert;

public class CoachesPage extends DriverClass {
	
	Utility util = new Utility();

	private By CoachTable = By.xpath("//table[@id='example']");
	private By CoachRow = By.tagName("tr");
	private By CoachColomn = By.tagName("td");
	private By ShowEntries = By.xpath("//select[@name='example_length']");
	private By CSVDwonlaod = By.xpath(".//*[@id='example_wrapper']/div[1]/a[1]/span");
	private By ExcelDownload = By.xpath(".//*[@id='example_wrapper']/div[1]/a[2]");
	private By PDFDownload = By.xpath(".//*[@id='example_wrapper']/div[1]/a[3]/span");
	private By SearchButton = By.xpath("//input[@type='search']");
	private By ShowingEntries = By.id("example_info");
	public By ScreenName = By.xpath("//input[@formcontrolname='name']");
	 public By EmailId = By.xpath("//input[@formcontrolname='email']");
	 public By AddCoachButton = By.xpath("//button[@class='btn btn-primary pull-right']");
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

	/*public void getCoachNameFromtable(String expectedCoach) {
		WebElement table = driver.findElement(CoachTable);
		List<WebElement> row = driver.findElements(CoachRow);
		row.size();

		for (int i = 0; i < row.size(); i++) {
			List<WebElement> col = row.get(i).findElements(CoachColomn);
			col.size();
			List<String> coachesName = new ArrayList<String>();
			for (int j = 0; j < col.size(); j++) {
				String name = col.get(j).getText();
				if (name.equals(expectedCoach)) {
					coachesName.add(name);
					Assert.assertEquals(name, expectedCoach);
				}
				System.out.println(name);
			}
		}

	}*/

	public boolean coachStatusInCoachesPage (String coach){
		driver.findElement(SearchButton).sendKeys(coach);
		boolean coachName = driver.findElement(By.linkText(coach)).isDisplayed();
		return coachName;
	}
	
	public void addCoach (String screenName, String email, String firstname,String lastName, String password,String confirmPassword, String phNo, String location  ){
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
	
}
