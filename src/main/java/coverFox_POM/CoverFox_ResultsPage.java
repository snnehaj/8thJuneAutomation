package coverFox_POM;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFox_ResultsPage {
	@FindBy(xpath = "//div[contains(text(),'matching Health Insurance Plans')]")
	private WebElement resultText;
	@FindBy(className = "pcc-main")
	private List<WebElement> bannerElements;
	@FindBy(xpath = "//div[text()='Preferred brands']")
	private WebElement allPreferredBrands;
	@FindBy(xpath = "(//div[@class='checkbox-ui']//i)[13]")
	private WebElement starHealthBrand;
	@FindBy(xpath = "//img[@alt='Star Health Insurance']")
	private List<WebElement> allStarBanners;
	@FindBy(xpath = "//button[text()=' Apply ']")
	private WebElement applyButton;

	public CoverFox_ResultsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public int resultTextCount() {
		String stringCount = resultText.getText().substring(0,2);
		int textCount = Integer.parseInt(stringCount);
		return textCount;
	}

	public int allBannerCount() {
		int bannerCount = bannerElements.size();
		return bannerCount;
	}

	public void selectBrand() {
		Reporter.log("Selecting Brand");
		allPreferredBrands.click();
		starHealthBrand.click();
		applyButton.click();
	}

	public int starBannerCount() {
		int starLogoCount = allStarBanners.size();
		return starLogoCount;
	}
	
//	public void isDisplayed()
//	{
//		Iterator<WebElement> it = allStarBanners.iterator();
//		while(it.hasNext())
//		{
//			boolean a = it.next().isDisplayed();
//		}
//	}
}
