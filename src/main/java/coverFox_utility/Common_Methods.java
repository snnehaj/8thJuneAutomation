package coverFox_utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import coverFox_Base.Base;
import net.bytebuddy.utility.RandomString;

public class Common_Methods {
	
	public static String readDataFromExcel(String filePath, String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
	FileInputStream file = new FileInputStream(filePath);
	String value = WorkbookFactory.create(file).getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
	return value;
	}
	
	public static void takeScreenshot(WebDriver driver,String fileName) throws IOException
	{
		File Source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String randomString = RandomString.make();
	   
	    File dest = new File( System.getProperty("user.dir")+"\\screenShot\\"+"_"+fileName+randomString+".jpg");
	    FileHandler.copy(Source, dest);
	}
	
	public static String readDataFromPropertyFile(String key) throws IOException
	{
		Properties p =new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		p.load(file);
		String value =p.getProperty(key);
		return value;
	}
	

}
