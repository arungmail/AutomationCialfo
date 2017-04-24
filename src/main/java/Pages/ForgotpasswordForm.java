package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BasePackage.DriverClass;
import BasePackage.Utility;

public class ForgotpasswordForm extends DriverClass {
	
	Utility util = new Utility();
	
	private By EmailForgotPassword 			= By.id("forgot_email");
	private By SignButtonInForgotPassword	= By.partialLinkText("Sign In");
	private By EmptyEmailValidationError	= By.id("forgot_email_validation");
	private By EmailMeButton 				= By.xpath("(//button[@type='submit'])[1]");
	private By Forgotpasswordsuccessmessage = By.xpath("//*[contains(text(),'Reset link send to your mail')]");			
			
	public void enterForgotPassword(String value)
	{
		driver.findElement(EmailForgotPassword).clear();
		driver.findElement(EmailForgotPassword).sendKeys(value);
	}
	public String getEmailIdValidationError()
	{
		//WebElement errormessage = driver.findElement(EmptyEmailValidationError);
		//util.explicitTimeout(errormessage);
		String error = driver.findElement(EmptyEmailValidationError).getText();
		System.out.println(error);
		return error;
	}
	public void clickOnSignIn()
	{
		driver.findElement(SignButtonInForgotPassword).click();
	}	
	public void clickSubmitButton()
	{
		driver.findElement(EmailMeButton).click();
	}
	public String getForgotPasswordSucessMessage()
	{
		String sucessmsg = driver.findElement(Forgotpasswordsuccessmessage).getText();
		System.out.println(sucessmsg);
		return sucessmsg;
	}

}
