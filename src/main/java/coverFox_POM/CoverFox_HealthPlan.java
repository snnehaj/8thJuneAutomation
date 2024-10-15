package coverFox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFox_HealthPlan 

{

	@FindBy(className = "next-btn") private WebElement nextButton;
	
	public CoverFox_HealthPlan(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnNextButton()
	{   Reporter.log("Clicking on NextButton",true);
		nextButton.click();
	}
	
}
