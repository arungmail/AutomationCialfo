package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BasePackage.DriverClass;
import junit.framework.Assert;

public class CoachesPage extends DriverClass {

	private By CoachTable = By.xpath("//table[@id='example']");
	private By CoachRow = By.tagName("tr");
	private By CoachColomn = By.tagName("td");
	private By ShowEntries = By.xpath("//select[@name='example_length']");
	private By CSVDwonlaod = By.xpath(".//*[@id='example_wrapper']/div[1]/a[1]/span");
	private By ExcelDownload = By.xpath(".//*[@id='example_wrapper']/div[1]/a[2]");
	private By PDFDownload = By.xpath(".//*[@id='example_wrapper']/div[1]/a[3]/span");
	private By SearchButton = By.xpath("//input[@type='search']");
	private By ShowingEntries = By.id("example_info");

	public void getCoachNameFromtable(String expectedCoach) {
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

	}

}
