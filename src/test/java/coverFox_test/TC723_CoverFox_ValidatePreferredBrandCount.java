package coverFox_test;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
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

public class TC723_CoverFox_ValidatePreferredBrandCount extends Base {
	String filePath = "C:\\Users\\VRUSHALI\\eclipse-workspace\\AutomationSelenium\\ExcelData\\Test.xlsx";
	String sheetName = "Sheet2";
	CoverFox_HomePage homePage;
	CoverFox_HealthPlan healthPlan;
	CoverFox_MemberDetails memberDetailsPage;
	CoverFox_AddressDetails addressDetailsPage;
	CoverFox_ResultsPage resultsPage;
	String pincode;
	String mobNum;

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
		mobNum = Common_Methods.readDataFromExcel(filePath, sheetName, 0, 2);
		addressDetailsPage.enterMobNum(mobNum);//
		Thread.sleep(1000);
		addressDetailsPage.clickOnContinueButton();
		Thread.sleep(3000);
		resultsPage.selectBrand();
		Thread.sleep(2000);
	}

	

	@Test
	public void validateBannerOfAllPreferredBrand() {
		int starBannerCount = resultsPage.starBannerCount();
		System.out.println(starBannerCount);
		int textbannerCount = resultsPage.resultTextCount();
		System.out.println(textbannerCount);
		Assert.assertEquals(starBannerCount, textbannerCount, "All Banners are not of Star Brand,TC Failed");
	}

	@AfterTest
	public void closingBrowser() {
		closeBrowser();
	}
}
