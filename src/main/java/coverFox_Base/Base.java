package coverFox_Base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

import coverFox_utility.Common_Methods;

public class Base 

{ 
	protected static WebDriver driver;
      public void lauchBrowser() throws IOException
      {   Reporter.log("Launching Browser"+true);
    	  ChromeOptions co = new ChromeOptions();
          co.addArguments("-disable-notifications");
    	  driver = new ChromeDriver(co);
    	  driver.manage().window().maximize();
    	  driver.get(Common_Methods.readDataFromPropertyFile("url"));
    	  
    	  
      }
      
      public void closeBrowser()
      {   Reporter.log("Closing Browser"+true);
    	  driver.quit();
      }
}
