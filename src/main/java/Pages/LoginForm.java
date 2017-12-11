package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BasePackage.DriverClass;
import BasePackage.Utility;

public class LoginForm extends DriverClass {
	static Utility util = new Utility();
	DashBoard dash = new DashBoard();

	public static By  email = By.xpath("(//input[@placeholder='Email'])[1]");
	public static By  Password = By.id("password");
	public static By  RememberMe = By.xpath("//ins[@class='iCheck-helper']");
	public static By  SignInButton = By.xpath("(//button[@type='submit'])[1]");
	public static By  Forgotpassword = By.partialLinkText("I forgot my password");
	public static By  CreateNewAccount = By.partialLinkText("Sign Up");
	public static By FaceBookLogin = By.xpath("html/body/div/app-root/app-login/body/div/div[2]/div/a[1]");
	public static By  GooglePlus = By.xpath("html/body/div[1]/app-root/app-login/body/div/div[2]/div/a[2]");
	public static By InvaliErrorEmail = By.xpath("//p[@id='email_validation']");
	public static By  WrongPassword = By.xpath(".//*[@id='error_validation']");
	public static By ErrorValidation = By.xpath(".//*[@id='error_validation']");

	public  static void enterEmailId(String value) {
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys(value);
	}

	public static void enterPassword(String pass) {
		driver.findElement(Password).sendKeys(pass);
	}

	public static void selectRememberMeCheckBox() {
		WebElement element = driver.findElement(RememberMe);
		util.selectCheckBoxIfSelectedAlready(element);
	}

	public static void clickSignButton() {
		driver.findElement(SignInButton).click();
	}

	public static void clickOnForgotPassword() {
		driver.findElement(Forgotpassword).click();
	}

	public static void clickOnRegister() {
		driver.findElement(CreateNewAccount).click();
	}

	public static  String signInEmailvalidationError() {
		String error = driver.findElement(InvaliErrorEmail).getText();
		System.out.println(error);
		return error;
	}

	public static String signInPasswordValidationError() {
		String error = driver.findElement(WrongPassword).getText();
		System.out.println(error);
		return error;
	}
	public static String errorvalidation (){
		String error = driver.findElement(ErrorValidation).getText();
		System.out.println(error);
		return error;
	}
	

}
