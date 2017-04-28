package TestCialfoNew;

import org.testng.annotations.Test;

import BasePackage.DriverClass;
import Pages.CoachesPage;
import Pages.DashBoard;
import Pages.LoginForm;

public class CoachesTest extends DriverClass{
	LoginForm login = new LoginForm();
	DashBoard dash	= new DashBoard();
	CoachesPage coach = new CoachesPage();
	
	
     @Test
	public void checkSwimmerAddedOrnot()
	{
		login.enterEmailId("swimlife@gmail.com");
		login.enterPassword("12345678");
		login.clickSignButton();
		dash.clickOnCoach();
		coach.getCoachNameFromtable("yyyyyy");
		
	}
}
