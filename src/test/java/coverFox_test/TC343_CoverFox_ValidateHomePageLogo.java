package coverFox_test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import coverFox_Base.Base;
import coverFox_POM.CoverFox_HomePage;

public class TC343_CoverFox_ValidateHomePageLogo extends Base{
	
	CoverFox_HomePage homePage;	
	
	@BeforeClass
	public void launchBrowser() throws IOException
	{
		lauchBrowser();
	}
	
	@BeforeMethod
	  public void enterDetails() 
	  {  
		  homePage = new  CoverFox_HomePage(driver);
	  }
	
  @Test
  public void validateLogoIspresent() 
  {
	  boolean logo = homePage.coverfoxLogo();
	  Assert.assertTrue(logo,"CoverFox logo is not Present, TC Failed");
  }
  
  @AfterMethod
  public void closingBrowser()
  {
	  closeBrowser();
  }
}
