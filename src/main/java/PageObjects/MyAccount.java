/**
 * @author Saquib Kazi
 * 
 * This Class will store My Account Page elements and login functionality
 * 
 */

package PageObjects;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Helper.BrowserFactory;
import Helper.readexcel;

public class MyAccount {
	
	// Initializing Required PageObjects
	HomePage home = new HomePage();
	
	// Initialing WebDriver Element
	WebDriver driver;
	
	// Payments Section in SideBar
	public By Payments = By.xpath("//*[@id=\"container\"]/div/main/div/div/div/div[2]/div[2]/ul/li[1]/a");
	
	// Page heading
	public By checkPageHeading = By.xpath("//h1");
	
	// Saved Addresses Section
	public By savedAddress = By.xpath("//a[contains(text(),\'Saved addresses\')]");
	
	// Offers link on My Account Page
	public By offersLink = By.linkText("OFFERS");
	
	// Promo Codes Text on Offers Page
	public By promo = By.xpath("//*[@id=\"id0\"]");
	
	// Initiating WebDriver and passing it to testcase and PageObjects
	public WebDriver launchBrowser() {
		WebDriver driverInstance = BrowserFactory.startBrowser("chrome");
		this.driver = driverInstance;
		home.driver = driverInstance;
		return driverInstance;
	}
	
	
	public void MyAccountPreCondition() throws InterruptedException, EncryptedDocumentException, IOException {
		
		// Driver will wait till the element is located
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.presenceOfElementLocated(home.LoginAndSignUp));
		
		// Get Username And Password from excel		
		readexcel excel = new readexcel();
		String username = excel.getUsername();
		String password = excel.getPassword();
		
		// Precondition will start after element is loaded
		Thread.sleep(5000);
		home.clickLoginAndSignUp();
		Thread.sleep(5000);
		home.clickLoginViaPassword();
		Thread.sleep(5000);
		home.enterusername(username);
		Thread.sleep(5000);
		home.enterPassword(password);
		Thread.sleep(5000);
		home.clickLogin();
		Thread.sleep(5000);
	}
	
	// Verify Login / Sign Up Hyperlink
	public boolean verifyLoginAndSignUp() {
		return home.verifyLoginAndSignUp();
	}
	
	// Verify Login / Sign Up Hyperlink
	public boolean verifyMyAccount() {
		return driver.findElement(home.MyAccount).isDisplayed();
	}
	
	public void clickMyAccount() {
		driver.findElement(home.MyAccount).click();
	}
	
	public void clickPayments() {
		driver.findElement(Payments).click();
	}
	
	public String checkPage() {
		String Heading = driver.findElement(checkPageHeading).getText();
		return Heading;
	}
	
	public void clickAddresse() {
		driver.findElement(savedAddress).click();
	}
	
	public void clickOffersLink() {
		driver.findElement(offersLink).click();
	}
	
	public String checkPromoText() {
		String checkText = driver.findElement(promo).getText();
		return checkText;
	}
	
	
	public void exitBrowser() {
		driver.quit();
	}
}
