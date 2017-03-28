package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BasePackage.DriverClass;
import BasePackage.Utility;

public class LoginForm extends DriverClass
{
   Utility util = new Utility();

	
	private By email 			= By.xpath("(//input[@placeholder='Email'])[1]");
	private By Password 		= By.id("password");
	private By RememberMe		= By.xpath("//ins[@class='iCheck-helper']");
	private By SignInButton		= By.xpath("(//button[@type='submit'])[1]");
	private By Forgotpassword	= By.partialLinkText("I forgot my password");
	private By CreateNewAccount	= By.partialLinkText("Register a new membership");
	private By FaceBookLogin 	= By.xpath("html/body/div/app-root/app-login/body/div/div[2]/div/a[1]");
	private By GooglePlus		= By.xpath("html/body/div[1]/app-root/app-login/body/div/div[2]/div/a[2]");
	private By InvaliErrorEmail	= By.xpath("//p[@id='email_validation']");
	private By WrongPassword    = By.xpath("//p[@id='error_validation']");
	
	
    
	public void enterEmailId(String value)
	{
		driver.findElement(email).sendKeys(value);
	}
	public void enterPassword(String pass)
	{
		driver.findElement(Password).sendKeys(pass);
	}
	
	public void selectRememberMeCheckBox(){
		WebElement element = driver.findElement(RememberMe);
		util.selectCheckBoxIfSelectedAlready(element);
	}
	public void clickSignButton()
	{
		driver.findElement(SignInButton).click();
	}
	public void clickOnForgotPassword()
	{
		driver.findElement(Forgotpassword).click();
	}
	public void clickOnRegister()
	{
		driver.findElement(CreateNewAccount).click();
	}
	public String signInEmailvalidationError (){
		String error = driver.findElement(InvaliErrorEmail).getText();
		System.out.println(error);
		return error;	
	}
	public String signInPasswordValidationError()
	{
		String error = driver.findElement(WrongPassword).getText();
		System.out.println(error);
		return error;
	}
	
}
