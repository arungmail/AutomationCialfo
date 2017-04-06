package BasePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class DriverClass {
	public static WebDriver driver;
	
	
	
	//Taking value from property file 
	public static String getValuesFromPropertiesFile(String key) throws IOException
	{
		String  filepath = System.getProperty("user.dir")+"\\src\\main\\java\\Config\\cialfover1.0.properties";
	    Properties prop = new Properties();
	    FileInputStream fis = new FileInputStream (filepath);
	    prop.load(fis);
	    return prop.getProperty(key);	
	}	
	//Selecting browser 
	public void launchBrowser(String BrowserName) throws IOException
	{
		switch (BrowserName)
		{
		case "FF":
			driver = new FirefoxDriver();
			break;
		case "Chrome":
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "Opera":
			System.setProperty("webdriver.opera.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\operadriver.exe");
			driver = new OperaDriver();
			break;						
		}
		
		//
		//launching baseUrl
		driver.get(getValuesFromPropertiesFile("url"));
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}
}
