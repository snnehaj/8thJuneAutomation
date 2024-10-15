package coverFox_POM;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;



public class CoverFox_AddressDetails
{
  @FindBy(className = "mp-input-text") private WebElement pincodeField;
  @FindBy(id  = "want-expert") private WebElement mobNumField;
  @FindBy(className = "next-btn") private WebElement continueButton;
  @FindBy(xpath = "//div[text()=' Please enter a valid pincode ']") private WebElement errorMessage;
  
  public CoverFox_AddressDetails(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
	  
  }
  
  public void enterPincode (String pincode)
  {    Reporter.log("Entering pincode", true);
	  pincodeField.sendKeys(pincode);
  }
  
  public void enterMobNum (String mobNum)
  { Reporter.log("Entering mobNum", true);  
	  mobNumField.sendKeys(mobNum);
  }
  
  public void clickOnContinueButton()
  {   Reporter.log("Clicking on continue button", true);
	  continueButton.click();
  }
  
  public boolean msgElementIsDisplayed()
  {
	 boolean a = errorMessage.isDisplayed();
	 return a;
	  
  }
  public String errorMessageText()
  {
	  String textMsg = errorMessage.getText();
	  return textMsg;
	
  }
  
  
}
