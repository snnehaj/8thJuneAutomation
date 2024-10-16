package coverFox_test;


import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import coverFox_Base.Base;
import coverFox_POM.CoverFox_AddressDetails;
import coverFox_POM.CoverFox_HealthPlan;
import coverFox_POM.CoverFox_HomePage;
import coverFox_POM.CoverFox_MemberDetails;
import coverFox_POM.CoverFox_ResultsPage;
import coverFox_utility.Common_Methods;



public class TC123_CoverFox_ValidateBanner extends Base{
	String filePath=System.getProperty("user.dir")+"\\ExcelData\\Test.xlsx";
	String sheetName="Sheet2";
	CoverFox_HomePage homePage;	
	CoverFox_HealthPlan healthPlan;
	CoverFox_MemberDetails memberDetailsPage;
	CoverFox_AddressDetails addressDetailsPage;
	CoverFox_ResultsPage resultsPage;
	String pincode;
	String mobNum;
	
	public static Logger logger;
	
	@BeforeClass
	public void launchBrowser() throws IOException
	{
		lauchBrowser();
		logger = Logger.getLogger("8thJuneCoverFox");
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Opening Application");
	}
	
  @BeforeMethod
  public void enterDetails() throws EncryptedDocumentException, IOException, InterruptedException
  {  
	  homePage = new  CoverFox_HomePage(driver);
	  healthPlan = new CoverFox_HealthPlan(driver);
	  memberDetailsPage = new CoverFox_MemberDetails(driver);
	  addressDetailsPage = new CoverFox_AddressDetails (driver);
	  resultsPage = new CoverFox_ResultsPage(driver);
	  homePage.clickOnGenderButton();
	  logger.info("Clicking on gender button");
	  Thread.sleep(1000);
	  healthPlan.clickOnNextButton();
	  logger.info("Clicking on next button");
	  Thread.sleep(1000);
	  memberDetailsPage.selectAge(Common_Methods.readDataFromExcel(filePath, sheetName, 0, 0));//
	  logger.info("Handling Age");
	  Thread.sleep(1000);
	  memberDetailsPage.clickOnNextButton();
	  logger.info("Clicking on next button");
	  Thread.sleep(1000);
	  pincode =Common_Methods.readDataFromExcel(filePath, sheetName, 0, 1);
	  addressDetailsPage.enterPincode(pincode);//
	  logger.info("Entering pincode");
	  mobNum=Common_Methods.readDataFromExcel(filePath, sheetName, 0, 2);
	  addressDetailsPage.enterMobNum(mobNum);//
	  logger.info("Entering mobile number");
	  Thread.sleep(1000);
	  addressDetailsPage.clickOnContinueButton();
	  logger.info("Clicking on continue button");
	  Thread.sleep(3000);
  }
  
  @Test
  public void validatePolicyCount() 
  {   
	  int bannerCount = resultsPage.allBannerCount();
	  int textCount = resultsPage.resultTextCount();
	  logger.info("Validating result");
	  Assert.assertEquals(bannerCount, textCount,"Count is not eqaul, TC FAILED");
	  Reporter.log("Changes made in Common_methods config file", true);
  }
  
  
  
  @AfterMethod
  public void closingBrowser()
  {   logger.info("Closing application");
	  closeBrowser();
  }
}
