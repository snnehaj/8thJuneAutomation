package coverFox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFox_HomePage 
{
     @FindBy(xpath = "//div[text()='Female']") private WebElement gender;
     @FindBy(xpath = "//img[@alt='Coverfox.com']") private WebElement coverfoxLogo;
     
     public CoverFox_HomePage(WebDriver driver)
     { 
    	 PageFactory.initElements(driver, this);
     }
     
     public void clickOnGenderButton()
     {   Reporter.log("Clicking Gender Button",true);
    	 gender.click();
     }
     
     public boolean coverfoxLogo()
     {
    	 boolean a = coverfoxLogo.isDisplayed();
    	 return a;
     }
     
     
}
