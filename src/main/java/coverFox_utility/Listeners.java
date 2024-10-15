package coverFox_utility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import coverFox_Base.Base;

public class Listeners extends Base implements ITestListener
{
    @Override
    public void onTestStart(ITestResult result) {
    	Reporter.log(result.getName()+" test is running",true);
        
    }
    
    @Override
    public void onTestSuccess(ITestResult result) {
    	try {
			Common_Methods.takeScreenshot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Reporter.log("Screenshot taken",true);
    }
    
    @Override
    public void onTestFailure(ITestResult result) {
    	try {
			Common_Methods.takeScreenshot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Reporter.log("Screenshot taken",true);
    	
    	
    }
}
