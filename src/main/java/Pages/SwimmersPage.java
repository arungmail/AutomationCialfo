package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import BasePackage.DriverClass;
import BasePackage.Utility;

public class SwimmersPage extends DriverClass {

	Utility util = new Utility();

	public By BatchSelection = By.xpath("(//span[@class='select2-selection__rendered'])[2]");
	public By Searchbutton = By.xpath("//input[@type='search']");
	public By EntrySelection = By.xpath("//select[@name='swimmertable_length']");
	public By Homebredcrumbs = By.xpath("html/body/div[1]/app-root/app-player/div/section[1]/ol/li[1]/a");
	public By TranferButton = By.xpath("(//button[@type='button'])[1]");
	public By BatchSelectionInTranferPlayer = By.xpath(".//*[@id='myModal']/div/div/div[2]/div/div/span/span[1]/span");
	public By SubmitButton = By.xpath(".//*[@id='myModal']/div/div/div[3]/button[2]");
	public By CloseButton = By.xpath(".//*[@id='myModal']/div/div/div[3]/button[1]'");
	public By ErrorValidation = By.id("error_validation");
	public By Successvalidation = By.id("success_validation");
	public By SwimmersTable = By.xpath("//table[@id='swimmertable']");
	public By SwimmersRow = By.tagName("tr");
	public By SwimmersColoumn = By.tagName("td");
	public By DataEmptyMessage = By.xpath("//td[@class='dataTables_empty']");
	public By batchresults = By.xpath("//span[@class='select2-results']");
	public By BatchSelectionInTranferSwimmerpage 	= By.xpath("//span[@title='Select Batch']");
	public By BatchResultsInTransferSwimmerpage  = By.xpath("//span[@class='select2-results']");
	public By SubmitButonInTransferSwimmerPage = By.xpath("(//button[@type='button'])[5]");
	// public WebElement batchname = driver.findElement(BatchSelection);

	public void batchSelection(WebElement element, String batchName) throws InterruptedException {
		WebElement batchlist = driver.findElement(batchresults);
		List<WebElement> batches = batchlist.findElements(By.tagName("li"));
		for (WebElement webElement : batches) {
			System.out.println(webElement.getText());
			if (webElement.getText().equalsIgnoreCase(batchName)) {
				// Thread.sleep(500);
				webElement.click();
				break;

			}

		}

	}

	public void getCoachNameFromTable(String actual, String expected) {

		WebElement table = driver.findElement(SwimmersTable);
		List<WebElement> row = driver.findElements(SwimmersRow);
		row.size();
		for (int i = 0; i < row.size(); i++) {
			List<WebElement> col = row.get(i).findElements(SwimmersColoumn);
			col.size();
			List<String> swimmersName = new ArrayList<String>();
			for (int j = 0; j < col.size(); j++) {
				String name = col.get(j).getText();
				if (name.equals(actual)) {
					swimmersName.add(name);
					Assert.assertEquals(name, expected);

					// String status = System.out.println("Coach1");
					/*
					 * String xp1 =
					 * "html/body/div[1]/div[5]/div[2]/div/div/table/tbody/tr[";
					 * String xp2 = "]/td[6]";
					 * driver.findElement(By.xpath(xp1+i+xp2)).click();
					 */
				}
				System.out.println(name);

			}
		}

	}
	/*
	 * public checkBatchNameIsListedOrNot(String name) { WebElement batchList =
	 * driver.findElement(BatchSelection); WebElement name2 =
	 * driver.findElement(By.xpath(
	 * ".//*[@id='select2-5dzp-result-kei1-590876017b31794b2a5bfe32']")); return
	 * name2; }
	 */

	public void getmatchingCoachNameforSwimmers(String swimmername, String expectedCoachName) {
		WebElement swimmerstable = driver.findElement(SwimmersTable);
		List<WebElement> swimRow = driver.findElements(SwimmersRow);
		swimRow.size();

		for (int i = 0; i < swimRow.size(); i++) {
			List<WebElement> swimcol = swimRow.get(i).findElements(SwimmersColoumn);
			swimcol.size();

			for (int j = 0; j < swimcol.size(); j++) {
				String swimmernames = swimcol.get(j).getText();
				System.err.println(swimmernames);
				if (swimmernames.equalsIgnoreCase(swimmername)) {
					String xpath1 = ".//*[@id='swimmertable']/tbody/tr[";
					String xpath2 = "]/td[9]";
					String actualCoachname = driver.findElement(By.xpath(xpath1 + i + xpath2)).getText();
					String expectedResult = expectedCoachName;
					Assert.assertEquals(actualCoachname, expectedResult);

				}

			}
		}

	}

	public void getmatchingBatch(String swimmername, String batchName) {
		WebElement swimmerstable = driver.findElement(SwimmersTable);
		List<WebElement> swimRow = driver.findElements(SwimmersRow);
		swimRow.size();

		for (int i = 0; i < swimRow.size(); i++) {
			List<WebElement> swimcol = swimRow.get(i).findElements(SwimmersColoumn);
			swimcol.size();

			for (int j = 0; j < swimcol.size(); j++) {
				String swimmernames = swimcol.get(j).getText();
				System.err.println(swimmernames);
				if (swimmernames.equalsIgnoreCase(swimmername)) {
					String xpath1 = ".//*[@id='swimmertable']/tbody/tr[";
					String xpath2 = "]/td[8]";
					String actualbatchname = driver.findElement(By.xpath(xpath1 + i + xpath2)).getText();
					String expectedResult = batchName;
					Assert.assertEquals(actualbatchname, expectedResult);

				}

			}
		}

	}

	public void search(String searchKey) {
		WebElement searchButton = driver.findElement(Searchbutton);
		searchButton.click();
		searchButton.sendKeys(searchKey);
	}

	public void clickCheckBoxBasedOnSwimmersName(String swimmername) {
		WebElement swimmerstable = driver.findElement(SwimmersTable);
		List<WebElement> swimRow = driver.findElements(SwimmersRow);
		swimRow.size();

		for (int i = 0; i < swimRow.size(); i++) {
			List<WebElement> swimcol = swimRow.get(i).findElements(SwimmersColoumn);
			swimcol.size();

			for (int j = 0; j < swimcol.size(); j++) {
				String swimmernames = swimcol.get(j).getText();
				System.err.println(swimmernames);
				if (swimmernames.equalsIgnoreCase(swimmername)) {
					String xpath1 = ".//*[@id='swimmertable']/tbody/tr[";
					String xpath2 = "]/td[1]/input";
					driver.findElement(By.xpath(xpath1 + i + xpath2)).click();

				}

			}
		}
	}

	public void clickOnTranferButton() {
		driver.findElement(TranferButton).click();

	}

}
