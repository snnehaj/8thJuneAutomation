package coverFox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class CoverFox_MemberDetails 

{
@FindBy(id = "Age-You") private WebElement ageDropDown;
@FindBy(className = "next-btn") private WebElement nextButton;


public CoverFox_MemberDetails(WebDriver driver) 
{
	PageFactory.initElements(driver, this);
}

public void selectAge(String age)
{   Reporter.log("Selecting Age",true);
	Select sc = new Select(ageDropDown);
	sc.selectByValue(age+"y");
	
	}

public void clickOnNextButton()
{  Reporter.log("Clicking on Next Button",true);
	nextButton.click();
	}


}
