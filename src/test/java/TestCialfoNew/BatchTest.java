package TestCialfoNew;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.DriverClass;
import BasePackage.Utility;
import Pages.BatchList;
import Pages.DashBoard;
import Pages.LoginForm;
import Pages.SwimmersPage;

public class BatchTest extends DriverClass {
	LoginForm login = new LoginForm();
	DashBoard dash = new DashBoard();
	BatchList batch = new BatchList();
	Utility util = new Utility();
	SwimmersPage swimmers = new SwimmersPage();

	@Test(priority = 1)
	public void addingBatch() throws InterruptedException {
		login.enterEmailId("swimlife@gmail.com");
		login.enterPassword("12345678");
		login.clickSignButton();
		dash.clickOnManageBatch();
		batch.clickOnAddbacthButton();
		batch.enterBacthname("Sunday Batch on 6PM to 7 PM");
		driver.findElement(batch.CoachSelection).click();
		Thread.sleep(500);
		WebElement coachlist = driver.findElement(batch.CoachResult);
		batch.selectCoachFromCoachList(coachlist, "Murali");
		// driver.findElement(By.xpath("//*[contains(@id,'rajajicoach')]")).click();
		Thread.sleep(5000);
		driver.findElement(batch.PlayerSelection).click();
		WebElement swimmersLilst = driver.findElement(batch.SwimmersResult);
		batch.selectSwimmersFromCoachList(swimmersLilst, "Divya");
		batch.clickOnCreateButton();
		String SuccessMessage = batch.getSuccessmessage();
		Assert.assertEquals(SuccessMessage, "Batch Added Sucessfully");
	}

	@Test(priority = 2)
	public void checkBatchIsAddedOrNot() {
		batch.getBatchFromList("");
	}

	@Test(priority = 3)
	public void checkCoachIsmatchingorNotInBatchesPage() throws InterruptedException {
		/*
		 * login.enterEmailId("swimlife@gmail.com");
		 * login.enterPassword("12345678"); login.clickSignButton();
		 * dash.clickOnManageBatch(); batch.searchBatch("Automation");
		 * Thread.sleep(500);
		 */
		WebElement batchestable = driver.findElement(batch.BatchTable);
		List<WebElement> batchRow = driver.findElements(batch.BatchRow);
		batchRow.size();

		for (int i = 0; i < batchRow.size(); i++) {
			List<WebElement> batchCol = batchRow.get(i).findElements(batch.BacthColumn);
			batchCol.size();

			for (int j = 0; j < batchCol.size(); j++) {
				String batchesNames = batchCol.get(j).getText();
				System.err.println(batchesNames);
				if (batchesNames.equalsIgnoreCase("Sunday Batch on 6PM to 7 PM")) {
					String xpath1 = ".//*[@id='batcheslist']/tbody/tr[";
					String xpath2 = "]/td[5]";
					String actualCoachname = driver.findElement(By.xpath(xpath1 + i + xpath2)).getText();
					// Add coachname for Asert
					String expectedResult = "Murali Master";
					Assert.assertEquals(actualCoachname, expectedResult);

				}

			}
		}
	}

	@Test(priority = 4)
	public void searchBatchInbatchesPage() throws InterruptedException {
		/*
		 * login.enterEmailId("swimlife@gmail.com");
		 * login.enterPassword("12345678"); login.clickSignButton();
		 */
		// dash.clickOnManageBatch();
		driver.navigate().refresh();
		batch.searchBatch("Sunday Batch on 6PM to 7 PM");
		Thread.sleep(500);
		batch.getBatchFromList("Sunday Batch on 6PM to 7 PM");
	}

	@Test(priority = 5)
	public void checkBatchNamevalidation() throws InterruptedException {
		/*
		 * login.enterEmailId("swimlife@gmail.com");
		 * login.enterPassword("12345678"); login.clickSignButton();
		 */
		// dash.clickOnManageBatch();
		driver.navigate().refresh();
		batch.clickOnAddbacthButton();
		batch.enterBacthname("");
		driver.findElement(batch.CoachSelection).click();
		/*
		 * driver.findElement(By.xpath("//*[contains(@id,'rajajicoach')]")).
		 * click(); Thread.sleep(5000);
		 * driver.findElement(batch.PlayerSelection).click();
		 * driver.findElement(By.xpath("//*[contains(@id,'Ipadswimmer')]")).
		 * click();
		 */
		batch.clickOnCreateButton();
		Thread.sleep(500);
		String actualSuccessMessage = batch.getBatchnamevalidation();
		String expectedSucesMessage = "This field is required!";
		Assert.assertEquals(actualSuccessMessage, expectedSucesMessage);
	}

	@Test(priority = 5)
	public void checkCoachNameisMatchingOrNotInSwimmersPage() throws InterruptedException {

		/*
		 * login.enterEmailId("swimlife@gmail.com");
		 * login.enterPassword("12345678"); login.clickSignButton();
		 */
		dash.clickOnSwimmers();
		swimmers.search("Divya");
		Thread.sleep(500);
		WebElement swimmertable = driver.findElement(swimmers.SwimmersTable);
		List<WebElement> swimRow = driver.findElements(swimmers.SwimmersRow);
		swimRow.size();

		for (int i = 0; i < swimRow.size(); i++) {
			List<WebElement> swimcol = swimRow.get(i).findElements(swimmers.SwimmersColoumn);
			swimcol.size();

			for (int j = 0; j < swimcol.size(); j++) {
				String swimmernames = swimcol.get(j).getText();
				System.err.println(swimmernames);
				if (swimmernames.equalsIgnoreCase("Divya")) {
					String xpath1 = ".//*[@id='swimmertable']/tbody/tr[";
					String xpath2 = "]/td[9]";
					String actualCoachname = driver.findElement(By.xpath(xpath1 + i + xpath2)).getText();
					String expectedResult = "Murali Master";
					Assert.assertEquals(actualCoachname, expectedResult);

				}

			}
		}

	}

	@Test(priority = 6)

	public void checkBatchNameIsMaatchingOrNotInSwimmersPage() throws InterruptedException {

		/*
		 * login.enterEmailId("swimlife@gmail.com");
		 * login.enterPassword("12345678"); login.clickSignButton();
		 */
		dash.clickOnSwimmers();
		swimmers.search("Divya");
		Thread.sleep(500);
		swimmers.getmatchingBatch("Divya", "Sunday Batch on 6PM to 7 PM");
		WebElement swimmerstable = driver.findElement(swimmers.SwimmersTable);
		List<WebElement> swimRow = driver.findElements(swimmers.SwimmersRow);
		swimRow.size();

		for (int i = 0; i < swimRow.size(); i++) {
			List<WebElement> swimcol = swimRow.get(i).findElements(swimmers.SwimmersColoumn);
			swimcol.size();

			for (int j = 0; j < swimcol.size(); j++) {
				String swimmernames = swimcol.get(j).getText();
				System.err.println(swimmernames);
				if (swimmernames.equalsIgnoreCase("Divya")) {
					String xpath1 = ".//*[@id='swimmertable']/tbody/tr[";
					String xpath2 = "]/td[8]";
					String actualCoachname = driver.findElement(By.xpath(xpath1 + i + xpath2)).getText();
					String expectedBatchname = "Sunday Batch on 6PM to 7 PM";
					Assert.assertEquals(actualCoachname, expectedBatchname);

				}

			}
		}
	}

	@Test(priority = 7)
	public void tranferCoach() throws InterruptedException {
		/*
		 * login.enterEmailId("swimlife@gmail.com");
		 * login.enterPassword("12345678"); login.clickSignButton();
		 */
		dash.clickOnManageBatch();
		// batch.searchBatch("Automation");
		batch.selectCheckBoxbasedOnBatchName("Sunday Batch on 6PM to 7 PM");
		batch.clickOnTranferButton();
		Thread.sleep(500);
		String paranetwindowhandle = driver.getWindowHandle();
		System.out.println(paranetwindowhandle);
		driver.switchTo().window(paranetwindowhandle);
		driver.findElement(batch.CoachSelectionInTranferBatch).click();
		Thread.sleep(500);
		WebElement coachresult = driver.findElement(batch.CoachResult);

		batch.selectCoachFromCoachList(coachresult, "RajKumar");

		batch.clickOnSubmitButton();
		Thread.sleep(500);
		batch.getSuccessmessage();
		System.out.println(batch.getSuccessmessage());

	}

	@Test(priority = 8)
	public void checkCoachnameInBatchespageAfterTranfer() {
		/*
												 * login.enterEmailId(
												 * "swimlife@gmail.com");
												 * login.enterPassword(
												 * "12345678");
												 * login.clickSignButton();
												 */
		driver.navigate().refresh();
		WebElement batchestable = driver.findElement(batch.BatchTable);
		List<WebElement> swimRow = driver.findElements(batch.BatchRow);
		swimRow.size();

		for (int i = 0; i < swimRow.size(); i++) {
			List<WebElement> swimcol = swimRow.get(i).findElements(batch.BacthColumn);
			swimcol.size();

			for (int j = 0; j < swimcol.size(); j++) {
				String batchesNames = swimcol.get(j).getText();
				System.err.println(batchesNames);
				if (batchesNames.equalsIgnoreCase("Sunday Batch on 6PM to 7 PM")) {
					String xpath1 = ".//*[@id='batcheslist']/tbody/tr[";
					String xpath2 = "]/td[5]";
					String actualCoachname = driver.findElement(By.xpath(xpath1 + i + xpath2)).getText();
					String expectedResult = "Raj Kumar";
					Assert.assertEquals(actualCoachname, expectedResult);

				}

			}
		}

	}

	@Test(priority = 9)
	public void checkCoachNameIsSwimmersPageAftertransfer() throws InterruptedException {

		/*
		 * login.enterEmailId("swimlife@gmail.com");
		 * login.enterPassword("12345678"); login.clickSignButton();
		 */
		dash.clickOnSwimmers();
		swimmers.search("Divya");
		Thread.sleep(500);
		WebElement swimmertable = driver.findElement(swimmers.SwimmersTable);
		List<WebElement> swimRow = driver.findElements(swimmers.SwimmersRow);
		swimRow.size();

		for (int i = 0; i < swimRow.size(); i++) {
			List<WebElement> swimcol = swimRow.get(i).findElements(swimmers.SwimmersColoumn);
			swimcol.size();

			for (int j = 0; j < swimcol.size(); j++) {
				String swimmernames = swimcol.get(j).getText();
				System.err.println(swimmernames);
				if (swimmernames.equalsIgnoreCase("Divya")) {
					String xpath1 = ".//*[@id='swimmertable']/tbody/tr[";
					String xpath2 = "]/td[9]";
					String actualCoachname = driver.findElement(By.xpath(xpath1 + i + xpath2)).getText();
					String expectedResult = "Raj Kumar";
					Assert.assertEquals(actualCoachname, expectedResult);

				}

			}
		}

	}
	/*
	 * @AfterMethod public void afterMathos(){
	 * driver.findElement(By.xpath("//a[@href='/dashboard']")).click(); }
	 */

}
