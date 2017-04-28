package TestCialfoNew;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import BasePackage.DriverClass;
import BasePackage.Utility;
import Pages.BatchList;
import Pages.DashBoard;
import Pages.LoginForm;

public class BatchTest extends DriverClass{
	LoginForm login = new LoginForm();
	DashBoard dash = new DashBoard();
	BatchList batch = new BatchList();
	Utility util = new Utility();
	
	@Test
	public void addingBatch()
	{
		login.enterEmailId("swimlife@gmail.com");
		login.enterPassword("12345678");
		login.clickSignButton();
		dash.clickOnManageBatch();
		batch.clickOnAddbacthButton();
		//batch.enterBacthname("Autommation bActch One");
	   /* WebElement coachSelection = (WebElement) batch.CoachSelection;
	    WebElement swimmerSelection = (WebElement) batch.PlayerSelection;
	    util.selectValueByVisibleText(coachSelection,"coach1");
	    util.selectValueByVisibleText(swimmerSelection, "swimmer2");*/
		batch.selectCoach();
	    
	    
		
	}

}
