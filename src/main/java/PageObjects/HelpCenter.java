/**
 * @author Saquib Kazi
 * 
 * This Class will store HelpCenter elements and its functionality
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

public class HelpCenter {
	
	// Initializing Required PageObjects
	HomePage home = new HomePage();
	MyAccount account = new MyAccount();
	
	// Initializing WebDriver
	WebDriver driver;
	
	// Help Center Button
	public By HelpCenter = By.id("more");
	
	// check order history page
	public By orderHistory = By.xpath("//*[@id=\"container\"]/div/main/div/div/div/div[2]/div/div[3]/div/div[4]/h2");
	
	// Help With Orders button
	public By helpWithOrders = By.xpath("//*[@id=\"container\"]/div/main/div/div/div/div[2]/div/div[2]/ul/li[1]/a");
	
	// General Queries button
	public By Queries = By.xpath("//*[@id=\"container\"]/div/main/div/div/div/div[2]/div/div[2]/ul/li[2]/a");
	
	// Legal button
	public By legal = By.xpath("//*[@id=\"container\"]/div/main/div/div/div/div[2]/div/div[2]/ul/li[3]/a");
	
	// FAQS button
	public By faqs = By.xpath("//*[@id=\"container\"]/div/main/div/div/div/div[2]/div/div[2]/ul/li[4]/a");
	
	// Feedback button
	public By feedback = By.xpath("//*[@id=\"container\"]/div/main/div/div/div/div[2]/div/div[2]/ul/li[5]/a");
	
	// Check Displayed Text in Help Center
	public By checkText = By.xpath("//*[@id=\"accordion0\"]/span");
	
	// Check FeedBack Page Text
	public By checkFeedback = By.xpath("//*[@id=\"container\"]/div/main/div/div/div/div[2]/div/h2");
	
	// Check My Account Page
	public By checkMyAccount = By.id("account");
	
	// Initiating WebDriver and passing it to testcase and PageObjects
	public WebDriver launchBrowser() {
		WebDriver driverInstance = BrowserFactory.startBrowser("chrome");
		this.driver = driverInstance;
		home.driver = driverInstance;
		account.driver = driverInstance;
		return driverInstance;
	}
	
	// Verify Login / Sign Up Hyperlink
	public boolean verifyLoginAndSignUp() {
		return home.verifyLoginAndSignUp();
	}
	
	
	public void LoginPreCondition() throws InterruptedException, EncryptedDocumentException, IOException {
		
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
	public boolean verifyMyAccount() {
		return driver.findElement(home.MyAccount).isDisplayed();
	}
	
	public void clickHelpCenter() {
		driver.findElement(HelpCenter).click();
	}
	
	public String orderHelpPage() {
		String verifyPage = driver.findElement(orderHistory).getText();
		return verifyPage;
	}
	
	public void clickHelpWithOrder() {
		driver.findElement(helpWithOrders).click();
	}
	
	public void clickGeneralQueries() {
		driver.findElement(Queries).click();
	}
	
	public void clickLegal() {
		driver.findElement(legal).click();
	}
	
	public void clickFAQS() {
		driver.findElement(faqs).click();
	}
	
	public void clickFeedback() {
		driver.findElement(feedback).click();
	}
	
	public String checkPageText() {
		String check = driver.findElement(checkText).getText();
		return check;	
	}
	
	public String checkFeedBackPage() {
		String check = driver.findElement(checkFeedback).getText();
		return check;
	}
	
	public void clickMyAccount() {
		account.clickMyAccount();
	}
	
	public void exitBrowser() {
		driver.quit();
	}
}
