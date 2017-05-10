package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BasePackage.DriverClass;
import BasePackage.Utility;

public class RegisterForm extends DriverClass {
	Utility util = new Utility();

	private By Username = By.xpath("//input[@placeholder='User Name']");
	private By Email = By.xpath("html/body/div[1]/app-root/app-signup/body/div/div[2]/form/div[1]/div[2]/div/input");
	private By Firstname = By.xpath("//input[@placeholder='First Name']");
	private By Lastname = By.xpath("//input[@placeholder='Last Name']");
	private By PhoneNumber = By.xpath("//input[@placeholder='Phone Number']");
	private By Password = By.xpath("(//input[@type='password'])[1]");
	private By ReenterPassword = By.xpath("(//input[@type='password'])[2]");
	private By YearDropDown = By.id("year");
	private By MonthDropdown = By.id("month");
	private By DayDropDown = By.id("day");
	private By TermandCondition = By
			.xpath("html/body/div[1]/app-root/app-signup/body/div/div[2]/form/div[6]/div[1]/div/label/div/ins");
	private By RegisterButton = By.id("register_btn");
	private By Location = By.xpath("//input[@placeholder='Location']");
	private By UsenamevalidationError = By.xpath("//p[@id='name_validation']");
	private By EmailIdvalidation = By.xpath("//p[@id='email_validation']");
	private By ExistingEmailId = By.xpath("//p[@id='error_validation']");
	private By FirstnameValidation = By.xpath("//p[@id='first_name_validation']");
	private By LastnameValdiation = By.xpath("//p[@id='last_name_validation']");
	private By PhoneNumberValidation = By.xpath("//p[@id='phone_validation']");
	private By passwordValidation = By.xpath("//p[@id='password_validation']");
	private By ConfirmPaaswordValidation = By.xpath("//p[@id='confirmpassword_validation']");
	private By LocationValidation = By.xpath("//p[@id='location_validation']");
	private By DOBValidation = By.xpath("//p[@id='error_validation']");
	private By Missmatchpass = By.xpath("//p[@id='error_validation']");
	private By ClubDropDown = By.xpath("//span[@role='presentation']");

	private By AlreadyHaveAnMember = By.partialLinkText("I already have a membership");

	public void enterUserName(String value) {
		driver.findElement(Username).sendKeys(value);
	}

	public void enterEmail(String value) {
		driver.findElement(Email).sendKeys(value);
	}

	public void enterFirstname(String value) {
		driver.findElement(Firstname).sendKeys(value);
	}

	public void enterLastName(String value) {
		driver.findElement(Lastname).sendKeys(value);
	}

	public void enterPhoneNumber(String value) {
		driver.findElement(PhoneNumber).sendKeys(value);
	}

	public void enterPassword(String value) {
		driver.findElement(Password).sendKeys(value);
	}

	public void reEnterPassword(String value) {
		driver.findElement(ReenterPassword).sendKeys(value);
	}

	public void selectDate(String value) {
		WebElement day = driver.findElement(DayDropDown);
		day.click();
		util.selectValueByVisibleText(day, value);
	}

	public void selectMonth(String value) {
		WebElement Month = driver.findElement(MonthDropdown);
		Month.click();
		util.selectValueByVisibleText(Month, value);
	}

	public void selectYear(String value) {
		WebElement Year = driver.findElement(YearDropDown);
		Year.click();
		util.selectValueByVisibleText(Year, value);
	}

	public void selectRole(String valueToSelect) {

		// Selecting radio button As per string
		// WebElement element =
		// driver.findElement(By.xpath("html/body/div[1]/app-root/app-signup/body/div/div[2]/form/div[5]/div[1]/div/div/label[1]"));
		List<WebElement> allOptions = driver.findElements(By.tagName("label"));
		for (WebElement option : allOptions) {
			// System.out.println("Option value "+option.getText());
			if (valueToSelect.equals(option.getText())) {
				option.click();
				break;
			}
		}

	}

	public void enterLocation(String value) {
		driver.findElement(Location).sendKeys(value);
	}

	public void termsAndCondition() {
		driver.findElement(TermandCondition).click();
	}

	public void clickRegisterButton() {
		driver.findElement(RegisterButton).click();

	}

	public void selectClubFromDropdownlist(String clubname) {
		WebElement element = driver.findElement(ClubDropDown);
		element.click();
		util.selectValueByVisibleText(element, clubname);
	}

	// Returning Username validation error
	public String UsernamegetErrorvalidation() {

		String error = driver.findElement(UsenamevalidationError).getText();
		System.out.println(error);
		return error;
	}

	// Returning Invalid Email error
	public String emailErrorvalidation() {

		String error = driver.findElement(EmailIdvalidation).getText();
		System.out.println(error);
		return error;
	}

	// Returning Firstname validation error
	public String firstNameErrorvalidation() {

		String error = driver.findElement(FirstnameValidation).getText();
		System.out.println(error);
		return error;
	}

	public String lastnameErrorvalidation() {

		String error = driver.findElement(LastnameValdiation).getText();
		System.out.println(error);
		return error;
	}

	public String phoneNumberErrorvalidation() {

		String error = driver.findElement(PhoneNumberValidation).getText();
		System.out.println(error);
		return error;
	}

	public String passwordvaldiation() {

		String error = driver.findElement(passwordValidation).getText();
		System.out.println(error);
		return error;
	}

	public String confirmationErrorvalidation() {

		String error = driver.findElement(ConfirmPaaswordValidation).getText();
		System.out.println(error);
		return error;
	}

	public String locationErrorvalidation() {

		String error = driver.findElement(LocationValidation).getText();
		System.out.println(error);
		return error;
	}

	public String dOBErrorvalidation() {

		String error = driver.findElement(DOBValidation).getText();
		System.out.println(error);
		return error;
	}

	public String missmatchtErrorvalidation() {

		String error = driver.findElement(Missmatchpass).getText();
		System.out.println(error);
		return error;
	}

	public String existingEmailId() {
		String error = driver.findElement(ExistingEmailId).getText();
		System.out.println(error);
		return error;
	}

	public void cllickOnAlreadyAHaveAnMembership() {
		driver.findElement(AlreadyHaveAnMember).click();
	}

}
