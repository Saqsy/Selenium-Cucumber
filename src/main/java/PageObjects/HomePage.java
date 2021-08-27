/**
 * @author Saquib Kazi
 * 
 * This Class will store Home Page elements and login functionality
 * 
 */


package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Helper.BrowserFactory;

public class HomePage {
	
	// Initialing WebDriver Element
	WebDriver driver;

	// Login & SignUp HyperLink
	public By LoginAndSignUp = By.xpath("/html/body/app-root/div/div/app-home-page/app-header/div[1]/div/div/div[2]/div[2]/div[2]");
	
	// LoginViaPassword tab
	By LoginViaPassword = By.xpath("/html/body/ngb-modal-window/div/div/app-login-modal/div/div[1]/div/div[2]/div");
	
	// Username Field
	By username = By.name("email");
	
	// Password Field
	By password = By.name("password");
	
	// Submit Button
	By LoginButton = By.xpath("/html/body/ngb-modal-window/div/div/app-login-modal/div/div[2]/form/div/div[4]/div[3]/button");
	
	// My Account Button
	public By MyAccount = By.xpath("//div[2]/div[3]");
	
	// Invalid Credentials Message
	public By errorMsg = By.xpath("/html/body/ngb-modal-window/div/div/app-login-modal/div/div[2]/form/div/div[2]/label");
	
	
	// Initiating WebDriver and passing it to testcase and PageObjects
	public WebDriver launchBrowser() {
		WebDriver driverInstance = BrowserFactory.startBrowser("chrome");
		this.driver = driverInstance;
		return driverInstance;
	}
	
	// Verify Login / Sign Up Hyperlink
	public boolean verifyLoginAndSignUp() {
		
		return driver.findElement(LoginAndSignUp).isDisplayed();
	}
	
	// Click Login / SignUp HyperLink
	public void clickLoginAndSignUp() {
		
		driver.findElement(LoginAndSignUp).click();
	}
	
	// Verify to Login Via Password tab
	public boolean verifyLoginViaPassword() {
		return driver.findElement(LoginViaPassword).isDisplayed();
	}
	
	// Switch to Login Via Password tab
	public void clickLoginViaPassword() {
		driver.findElement(LoginViaPassword).click();
	}
	
	// Enter Username
	public void enterusername(String MobileNumber) {
		driver.findElement(username).sendKeys(MobileNumber);
	}
	
	// Verify Username field
	public boolean verifyusernameField() {
		return driver.findElement(username).isDisplayed();
	}
	
	// Enter Password
	public void enterPassword(String pass) {
		driver.findElement(password).sendKeys(pass);
	}
	
	// Verify Password field
	public boolean verifyPasswordField() {
		return driver.findElement(password).isDisplayed();
	}
	
	// Click Login Button
	public void clickLogin() {
		driver.findElement(LoginButton).click();
	}
	
	// Verify Login Button
	public boolean verifyLoginButton() {
		return driver.findElement(LoginButton).isDisplayed();
	}
	
	// Quit Driver
	public void exitBrowser() {
		driver.quit();
	}
}
