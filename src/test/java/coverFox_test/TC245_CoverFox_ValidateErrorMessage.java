package coverFox_test;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import coverFox_Base.Base;
import coverFox_POM.CoverFox_AddressDetails;
import coverFox_POM.CoverFox_HealthPlan;
import coverFox_POM.CoverFox_HomePage;
import coverFox_POM.CoverFox_MemberDetails;
import coverFox_POM.CoverFox_ResultsPage;
import coverFox_utility.Common_Methods;

public class TC245_CoverFox_ValidateErrorMessage extends Base {
	String filePath = "C:\\Users\\VRUSHALI\\eclipse-workspace\\AutomationSelenium\\ExcelData\\Test.xlsx";
	String sheetName = "Sheet2";
	CoverFox_HomePage homePage;
	CoverFox_HealthPlan healthPlan;
	CoverFox_MemberDetails memberDetailsPage;
	CoverFox_AddressDetails addressDetailsPage;
	CoverFox_ResultsPage resultsPage;
	String pincode;
	String mobNum;
	int pincodeNum;
	int mobNum1;

	@BeforeTest
	public void launchBrowser() throws IOException {
		lauchBrowser();
	}

	@BeforeClass
	public void enterDetails() throws EncryptedDocumentException, IOException, InterruptedException {
		homePage = new CoverFox_HomePage(driver);
		healthPlan = new CoverFox_HealthPlan(driver);
		memberDetailsPage = new CoverFox_MemberDetails(driver);
		addressDetailsPage = new CoverFox_AddressDetails(driver);
		resultsPage = new CoverFox_ResultsPage(driver);
		homePage.clickOnGenderButton();
		Thread.sleep(1000);
		healthPlan.clickOnNextButton();
		Thread.sleep(1000);
		memberDetailsPage.selectAge(Common_Methods.readDataFromExcel(filePath, sheetName, 0, 0));//
		Thread.sleep(1000);
		memberDetailsPage.clickOnNextButton();
		Thread.sleep(1000);
		pincode = Common_Methods.readDataFromExcel(filePath, sheetName, 0, 1);
		addressDetailsPage.enterPincode(pincode);//
		pincodeNum = Integer.parseInt(pincode);
		mobNum = Common_Methods.readDataFromExcel(filePath, sheetName, 0, 2);
		mobNum1 = Integer.parseInt(mobNum);
		addressDetailsPage.enterMobNum(mobNum);//
		Thread.sleep(1000);
		addressDetailsPage.clickOnContinueButton();
		Thread.sleep(3000);

	}

	@Test
	public void validatePincode() {
		if (pincodeNum < 6 || pincodeNum > 6) {
			Reporter.log("Entered Wrong Pincode", true);
		} else {
			Reporter.log("Correct pincode");
		}

	}

	@Test
	public void validateMobNum() {

		if (mobNum1 < 10 || pincodeNum > 10) {
			Reporter.log("Entered Wrong Mobile Number", true);
		} else {
			Reporter.log("Correct mobile number");
		}
	}

	@Test
	public void validateErrorMessage() {
		String actualErrorMsg = addressDetailsPage.errorMessageText();
		String expectedErrorMsg = "Please enter a valid pincode";
		boolean msgIsDisplayed = addressDetailsPage.msgElementIsDisplayed();

		Assert.assertTrue(msgIsDisplayed, "Error Message is not diplayed,TC Failed");
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Both message are not equal,TC FAILED");

	}
}