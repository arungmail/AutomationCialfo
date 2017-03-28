package BasePackage;

import java.io.IOException;
import org.testng.annotations.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass extends DriverClass{
	
	DriverClass driverclass = new DriverClass();
	
	@BeforeSuite
	// Launching Application 
	public void launchAUTApplication () throws IOException
	{
		driverclass.launchBrowser(driverclass.getValuesFromPropertiesFile("BrowserName"));			
		
	}
	
	@AfterSuite
	//Closing Application 
	public void cleanUp()
	{
		driver.close();	
    }
	
}
